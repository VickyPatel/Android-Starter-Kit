package vickypatel.ca.androidstarterkit;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import vickypatel.ca.androidstarterkit.extras.MyApplication;

public class MainActivity extends AppCompatActivity {

    @Inject
    SharedPreferences defaultPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyApplication.getInstance().getStorageComponent().inject(this);

        SharedPreferences.Editor editor = defaultPreferences.edit();
        editor.putBoolean("Test", true);
        editor.apply();

    }
}
