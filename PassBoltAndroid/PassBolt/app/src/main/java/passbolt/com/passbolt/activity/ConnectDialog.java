package passbolt.com.passbolt.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import passbolt.com.passbolt.R;

public class ConnectDialog extends DialogFragment {

	public interface ConnectDialogListener {
		public void connectClick(ConnectDialog dialog);
		public void cancelClick(ConnectDialog dialog);
	}
	
	EditText ipText;
	EditText portText;
	CheckBox setDefault;
	
	@Override
	public Dialog onCreateDialog (Bundle instance) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = getActivity().getLayoutInflater();
		View v = inflater.inflate(R.layout.connect_dialog, null);
		ipText = (EditText) v.findViewById(R.id.ip_addr);
		portText = (EditText) v.findViewById(R.id.port);
		setDefault = (CheckBox) v.findViewById(R.id.default_check);
		
		builder.setView(v)
			.setTitle("Enter:")
			.setPositiveButton(R.string.connect, new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					String ipAddr = ipText.getText().toString();
					String port = portText.getText().toString();
					Remote act = (Remote) getActivity();
					if (setDefault.isChecked())
						act.setDefault(ipAddr, Integer.parseInt(port));
					    act.connect(ipAddr, Integer.parseInt(port));
								
					dialog.dismiss();
				}
			})
			.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.dismiss();
				}
			});
		
		return builder.create();
	}
	
}
