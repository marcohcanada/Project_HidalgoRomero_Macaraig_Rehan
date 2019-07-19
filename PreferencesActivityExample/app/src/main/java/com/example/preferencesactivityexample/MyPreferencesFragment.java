package com.example.preferencesactivityexample;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by 991470628 : MARCO HIDALGO ROMERO
 * on 2019-07-12
 */
public class MyPreferencesFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.my_preferences);
    }
}
