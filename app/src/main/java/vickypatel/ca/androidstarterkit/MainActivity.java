package vickypatel.ca.androidstarterkit;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import javax.inject.Inject;

import vickypatel.ca.androidstarterkit.extras.MyApplication;

public class MainActivity extends AppCompatActivity {

    @Inject
    SharedPreferences defaultPreferences;

    public String TEST = "TEST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyApplication.getInstance().getStorageComponent().inject(this);

        SharedPreferences.Editor editor = defaultPreferences.edit();
        editor.putBoolean(TEST, true);
        editor.apply();
    }

    /**
     * Test Button onClick handler
     * @param view
     */
    public void testDagger(View view){
        boolean test = defaultPreferences.getBoolean(TEST, false);
        Toast.makeText(this, "Got From preferences " + test , Toast.LENGTH_LONG).show();
    }
}
