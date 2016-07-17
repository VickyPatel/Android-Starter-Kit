package vickypatel.ca.androidstarterkit;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;

import javax.inject.Inject;

import vickypatel.ca.androidstarterkit.adapters.DatabaseAdapter;
import vickypatel.ca.androidstarterkit.extras.MyApplication;
import vickypatel.ca.androidstarterkit.modules.DatabaseModule;

public class MainActivity extends AppCompatActivity {

    public String TEST = "TEST";

    @Inject
    SharedPreferences defaultPreferences;
    @Inject
    RequestQueue requestQueue;
    @Inject
    DatabaseAdapter databaseAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyApplication.getInstance().getAppComponent().inject(this);

        SharedPreferences.Editor editor = defaultPreferences.edit();
        editor.putBoolean(TEST, true);
        editor.apply();
    }

    /**
     * Test Button onClick handler
     *
     * @param view
     */
    public void testDagger(View view) {
        /** get data from preference */
        boolean test = defaultPreferences.getBoolean(TEST, false);
//        Toast.makeText(this, "Got From preferences " + test, Toast.LENGTH_LONG).show();
        /** make server call with volley */
        makeJsonRequest();
    }

    private void makeJsonRequest() {
        String URL = "http://jsonplaceholder.typicode.com/comments";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                URL,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Failure", Toast.LENGTH_LONG).show();
                    }
                });
        requestQueue.add(jsonArrayRequest);
    }
}
