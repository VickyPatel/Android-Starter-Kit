package vickypatel.ca.androidstarterkit.modules;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import vickypatel.ca.androidstarterkit.adapters.DatabaseAdapter;
import vickypatel.ca.androidstarterkit.extras.CustomScope;

/**
 * Created by VickyPatel on 2016-07-07.
 */
@Module
public class DatabaseModule {
    Context context;
    public DatabaseModule(Context context){
        this.context = context;
    }

    @CustomScope
    @Provides
    DatabaseAdapter provideDatabaseAdapter(){
        return new DatabaseAdapter(context);
    }
}
