package vickypatel.ca.androidstarterkit.component;

import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Component;
import vickypatel.ca.androidstarterkit.modules.StorageModule;

/**
 * Created by VickyPatel on 2016-07-05.
 */
@Singleton
@Component(modules = StorageModule.class)
public interface StorageComponent {

    /**
     * downstream components need these exposed
     */
    SharedPreferences defaultSharedPreferences();

}
