package vickypatel.ca.androidstarterkit.modules;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import vickypatel.ca.androidstarterkit.extras.MyAppScope;
import vickypatel.ca.androidstarterkit.extras.MyApplication;

/**
 * Created by VickyPatel on 2016-07-05.
 */
@Module
public class StorageModule {

    private final MyApplication application;

    public StorageModule(MyApplication application){
        this.application = application;
    }

    @Singleton
    @Provides
    SharedPreferences provideDefaultSharedPreferences(){
        return PreferenceManager.getDefaultSharedPreferences(application);
    }
}
