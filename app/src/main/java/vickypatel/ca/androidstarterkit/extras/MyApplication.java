package vickypatel.ca.androidstarterkit.extras;

import android.app.Application;
import android.content.Context;

import vickypatel.ca.androidstarterkit.component.DaggerNetworkComponent;
import vickypatel.ca.androidstarterkit.component.DaggerStorageComponent;
import vickypatel.ca.androidstarterkit.component.NetworkComponent;
import vickypatel.ca.androidstarterkit.component.StorageComponent;
import vickypatel.ca.androidstarterkit.modules.NetworkModule;
import vickypatel.ca.androidstarterkit.modules.StorageModule;

/**
 * Created by VickyPatel on 2016-07-05.
 */
public class MyApplication extends Application {

    private static MyApplication instance;
    private static StorageComponent storageComponent;
    private static NetworkComponent networkComponent;

    public static MyApplication getInstance() {
        return instance;
    }

    public static Context getAppContext() {
        return instance.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        storageComponent = DaggerStorageComponent
                .builder()
                .storageModule(new StorageModule(this))
                .build();

        networkComponent = DaggerNetworkComponent
                .builder()
                .storageComponent(storageComponent)
                .networkModule(new NetworkModule())
                .build();
    }

    public StorageComponent getStorageComponent() {
        return storageComponent;
    }

    public NetworkComponent getNetworkComponent() {
        return networkComponent;
    }
}
