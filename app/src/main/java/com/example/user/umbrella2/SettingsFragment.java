package com.example.user.umbrella2;

import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;

public class SettingsFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

        Preference.OnPreferenceChangeListener onPreferenceChangeListener = (preference, newValue) -> {
            Preference.OnPreferenceChangeListener listener = (Preference.OnPreferenceChangeListener) getActivity();
            listener.onPreferenceChange(preference, newValue);
            return true;
        };
        ListPreference p = (ListPreference) getPreferenceManager().findPreference("unit_preference");
        p.setOnPreferenceChangeListener(onPreferenceChangeListener);
    }
}
