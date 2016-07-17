package vickypatel.ca.androidstarterkit.component;

import com.android.volley.RequestQueue;

import dagger.Component;
import vickypatel.ca.androidstarterkit.MainActivity;
import vickypatel.ca.androidstarterkit.extras.CustomScope;
import vickypatel.ca.androidstarterkit.extras.MyAppScope;
import vickypatel.ca.androidstarterkit.modules.NetworkModule;
import vickypatel.ca.androidstarterkit.network.VolleySingleton;

/**
 * Created by VickyPatel on 2016-07-05.
 */
@MyAppScope
@Component(modules = NetworkModule.class,
        dependencies = StorageComponent.class)
public interface NetworkComponent extends StorageComponent {

    /** downstream components need these exposed */
    RequestQueue requestQueue();
}
