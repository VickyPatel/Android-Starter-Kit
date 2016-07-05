package vickypatel.ca.androidstarterkit.component;

import dagger.Component;
import vickypatel.ca.androidstarterkit.MainActivity;
import vickypatel.ca.androidstarterkit.extras.CustomScope;
import vickypatel.ca.androidstarterkit.modules.NetworkModule;

/**
 * Created by VickyPatel on 2016-07-05.
 */
@CustomScope
@Component(modules = NetworkModule.class, dependencies = StorageComponent.class)
public interface NetworkComponent {
    void inject(MainActivity mainActivity);
}
