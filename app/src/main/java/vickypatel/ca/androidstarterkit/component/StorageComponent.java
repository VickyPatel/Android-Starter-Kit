package vickypatel.ca.androidstarterkit.component;

import javax.inject.Singleton;

import dagger.Component;
import vickypatel.ca.androidstarterkit.MainActivity;
import vickypatel.ca.androidstarterkit.modules.StorageModule;

/**
 * Created by VickyPatel on 2016-07-05.
 */
@Singleton
@Component(modules = StorageModule.class)
public interface StorageComponent {
    void inject(MainActivity mainActivity);
}
