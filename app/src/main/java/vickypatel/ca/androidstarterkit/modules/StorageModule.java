package vickypatel.ca.androidstarterkit.modules;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;

import dagger.Module;
import dagger.Provides;
import vickypatel.ca.androidstarterkit.extras.MyApplication;

/**
 * Created by VickyPatel on 2016-07-05.
 */
@Module
public class StorageModule {

    private final MyApplication application;

    public StorageModule(MyApplication context){
        application =  context;
    }

    @Provides
    SharedPreferences provideDefaultSharedPreferences(){
        return PreferenceManager.getDefaultSharedPreferences(application);
    }
}
