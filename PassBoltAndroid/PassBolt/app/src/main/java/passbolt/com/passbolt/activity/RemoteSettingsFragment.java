package passbolt.com.passbolt.activity;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import passbolt.com.passbolt.R;

public class RemoteSettingsFragment extends PreferenceFragment {

	@Override
	public void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.remote_preferences);
	}
	
}
