package vickypatel.ca.androidstarterkit.modules;

import com.android.volley.RequestQueue;

import dagger.Module;
import dagger.Provides;
import vickypatel.ca.androidstarterkit.extras.CustomScope;
import vickypatel.ca.androidstarterkit.extras.MyAppScope;
import vickypatel.ca.androidstarterkit.network.VolleySingleton;

/**
 * Created by VickyPatel on 2016-07-05.
 */
@Module
public class NetworkModule {

    @MyAppScope
    @Provides
    RequestQueue provideRequestQueue(){
        return VolleySingleton.getInstance().getRequestQueue();
    }
}
