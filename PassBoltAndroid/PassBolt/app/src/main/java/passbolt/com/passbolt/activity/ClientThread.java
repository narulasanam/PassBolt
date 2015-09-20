package passbolt.com.passbolt.activity;

import android.util.Log;

import com.doowybbob.MRClient.Client;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.concurrent.ArrayBlockingQueue;

public class ClientThread extends Thread {

	Client client;
	String ipAddr;
	int port;
	
	ArrayBlockingQueue<String> buff;
	
	ClientThread (String ipAddr, int port) {
		this.ipAddr = ipAddr;
		this.port = port;
		buff = new ArrayBlockingQueue<String>(64);
	}
	
	public void add(String s) {
		buff.add(s);
	}
	
	@Override
	public void run() {
		try {
			this.client = new Client (ipAddr, port);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String cmd;
		while(true){
			if (!buff.isEmpty()) {
				cmd = buff.poll();
				try {
				if (cmd.contains("wr")) {
					client.sendText(buff.poll());
				}
				else {
					Log.i(Remote.DEBUGTAG, "the command is :"+cmd);
					client.send(cmd);
				}
				}
				catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
