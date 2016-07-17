package vickypatel.ca.androidstarterkit.component;

import dagger.Component;
import vickypatel.ca.androidstarterkit.MainActivity;
import vickypatel.ca.androidstarterkit.extras.CustomScope;
import vickypatel.ca.androidstarterkit.modules.DatabaseModule;
import vickypatel.ca.androidstarterkit.modules.NetworkModule;
import vickypatel.ca.androidstarterkit.modules.StorageModule;

/**
 * Created by VickyPatel on 2016-07-07.
 *
 * @see <a href="http://square.github.io/dagger"></a>
 * Dagger Graph
 * <p/>
 * ******* App component (Database module)
 * ************** Depends on **************
 * ******* Network Component (Network module)
 * ************** Depends on **************
 * ******* Storage Component (storage module)
 */

/**
 * Include App Component in class if you need
 * {@link StorageModule} and
 * {@link NetworkModule} and
 * {@link DatabaseModule} methods
 */

@CustomScope
@Component(modules = DatabaseModule.class,
        dependencies = {NetworkComponent.class})
public interface AppComponent {
    /**
     * Declare activity or class where you want to use this App Component
     */
    void inject(MainActivity mainActivity);
}