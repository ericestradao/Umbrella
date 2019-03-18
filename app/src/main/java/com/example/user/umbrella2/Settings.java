package com.example.user.umbrella2;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.user.umbrella2.presenter.Presenter;

import static com.example.user.umbrella2.presenter.Presenter.contextOfApplication;

public class Settings extends AppCompatActivity implements Preference.OnPreferenceChangeListener {

    public static Context contextOfApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        contextOfApplication = getApplicationContext();
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String android_choice = sp.getString("zip_preference", "None selected");
        TextView tv = (TextView) findViewById(R.id.android_version);
        tv.setText(android_choice);
    }

    public static Context getContextOfApplication(){
        return contextOfApplication;
    }
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        TextView tv = (TextView) findViewById(R.id.android_version);
        tv.setText(newValue.toString());
        return true;
    }

}
