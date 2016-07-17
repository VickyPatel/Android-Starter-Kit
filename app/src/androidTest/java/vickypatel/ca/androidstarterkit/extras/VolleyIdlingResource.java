package vickypatel.ca.androidstarterkit.extras;

import android.support.test.espresso.IdlingResource;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;

import java.lang.reflect.Field;
import java.util.Set;

import vickypatel.ca.androidstarterkit.network.VolleySingleton;

/**
 * Created by VickyPatel on 2016-07-17.
 */
public final class VolleyIdlingResource implements IdlingResource {
    private static final String TAG = "VolleyIdlingResource";
    private final String resourceName;

    // written from main thread, read from any thread.
    private volatile ResourceCallback resourceCallback;

    private Field mCurrentRequests;
    private RequestQueue mVolleyRequestQueue;

    public VolleyIdlingResource(String resourceName) throws SecurityException, NoSuchFieldException {
        this.resourceName = resourceName;

        mVolleyRequestQueue = VolleySingleton.getInstance().getRequestQueue();

        mCurrentRequests = RequestQueue.class.getDeclaredField("mCurrentRequests");
        mCurrentRequests.setAccessible(true);
    }

    @Override
    public String getName() {
        return resourceName;
    }

    @Override
    public boolean isIdleNow() {
        try {
            Set<Request> set = (Set<Request>) mCurrentRequests.get(mVolleyRequestQueue);
            int count = set.size();
            if (set != null) {

                if (count == 0) {
                    Log.d(TAG, "Volley is idle now! with: " + count);
                    resourceCallback.onTransitionToIdle();
                } else {
                    Log.d(TAG, "Not idle... " + count);
                }
                return count == 0;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Log.d(TAG, "Eita porra.. ");
        return true;
    }

    @Override
    public void registerIdleTransitionCallback(ResourceCallback resourceCallback) {
        this.resourceCallback = resourceCallback;
    }

}