package passbolt.com.passbolt.activity;

import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import passbolt.com.passbolt.R;

public class Remote extends ActionBarActivity {
	
	boolean connected;
	ClientThread ct;
	int startX, startY;
	int counter;
	String DEFAULT_IP_KEY = "com.passbolt.ip_key";
	String DEFAULT_PORT_KEY = "com.passbolt.port_key";
    static final String DEBUGTAG = "VC";
    ListView listView;
    Context context;
    public static String global_ip;
    public static int global_port;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_remote);
		SharedPreferences prefs = getSharedPreferences("pass", MODE_PRIVATE);

		//ct = lientThreadFactory.getClientThread();

		counter = 0;
		if (this.connected == false) {
			if (prefs.contains(DEFAULT_IP_KEY)){
				if (prefs.contains(DEFAULT_PORT_KEY)){
					connect(prefs.getString(DEFAULT_IP_KEY, ""), prefs.getInt(DEFAULT_PORT_KEY, 0));
				}
			}
			else {
				DialogFragment fragment = new ConnectDialog();
				fragment.show(getFragmentManager(), "connect");
			}
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.remote, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
		case R.id.action_settings:
			openSettings();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	
	private void openSettings() {
		Intent intent = new Intent(Remote.this, SettingsActivity.class);
		Remote.this.startActivity(intent);
	}
	
	@Override
	protected void onStop() {
		if (connected) {
			//ct.add("exit");
			connected = false;
		}
		super.onStop();
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// handle touch events on the touch screen.
		int dX, dY;
		
		if (event.getAction() == MotionEvent.ACTION_DOWN){
			// this happens when the user first touches the screen
			startX = (int)event.getX();
			startY = (int)event.getY();
		}
		else if (event.getAction() == MotionEvent.ACTION_MOVE){ // swipe
			// this happens after the user has thouched the screen and moved their
			//finger. The difference between the start position and this position
			// is used to move the cursor on the server. Every 4th event is used so that
			// the server isn't flooded with movement commands.
			
			counter++;
			dX = ((int)event.getX() - startX)/3;
			dY = ((int)event.getY() - startY)/3;
			if ((counter % 4) == 0) {
				Log.i("Remote", "mm:" + dX + ":" + dY);
				ct.add("mm:" + dX + ":" + dY);
			}
		}
		
		return true;
	}
	
	protected void connect (String ipAddr, int port) {
		//attempt to connect to the server
		try {
            global_ip = ipAddr;
            global_port = port;
            Log.d(DEBUGTAG, global_ip + "" + global_port + "poooooooooooooooooot");
			ct = new ClientThread(ipAddr, port);
			ct.start();
			Context context = getApplicationContext();
			CharSequence text = "Running!";
			int duration = Toast.LENGTH_SHORT;
			
			//alert the user that the client connected to the server
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	
		if (ct.client != null) {
			connected = true;
		}
	}
	
	protected void setDefault (String ipAddr, int port) {
		// set the default values for the ip address and port
		SharedPreferences prefs = getPreferences(MODE_PRIVATE);
		SharedPreferences.Editor editor = prefs.edit();
		editor.putString(DEFAULT_IP_KEY, ipAddr);
		editor.putInt(DEFAULT_PORT_KEY, port);
		editor.commit();
	}

	public void fbClick(View v) { // on button press, send rc command
        ct.add("fb,waterloopassbolt@gmail.com,waterloo321");
	}

    public void linkClick(View v) { // on button press, send rc command
        ct.add("link,waterloopassbolt@gmail.com,waterloo321");
    }
	
	public void writeText (View v) { // send a string of text to be typed
		EditText text = (EditText)findViewById(R.id.text);
		ct.add("wr");
		ct.add(text.getText().toString());
	}
}