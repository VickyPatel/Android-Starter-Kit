package vickypatel.ca.androidstarterkit.network;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import vickypatel.ca.androidstarterkit.extras.MyApplication;

/**
 * Created by VickyPatel on 2016-07-05.
 */
public class VolleySingleton {
    private static VolleySingleton volleySingleton;
    private RequestQueue requestQueue;

    private VolleySingleton() {
        requestQueue = Volley.newRequestQueue(MyApplication.getAppContext());
    }

    public static VolleySingleton getInstance() {
        if (volleySingleton == null) {
            return volleySingleton = new VolleySingleton();
        } else {
            return volleySingleton;
        }
    }

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }
}
