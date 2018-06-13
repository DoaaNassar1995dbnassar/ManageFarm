package co.neprass.managefarm;

import android.app.Application;
import android.content.Context;

/**
 * Created by AL-Qema on 11/06/18.
 */

public class ApplicationClass extends Application {

    private static ApplicationClass mInstance;
    private static Context context;
    private SQLDatabase sqlDatabase ;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        sqlDatabase = new SQLDatabase(context);

        mInstance = this;

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
//        MultiDex.install(this);
    }

    public static synchronized ApplicationClass getInstance() {
        if (mInstance == null) {
            return mInstance = new ApplicationClass();
        } else
            return mInstance;
    }


    public static Context getAppContext() {
        return ApplicationClass.context;
    }
     public  SQLDatabase getData(){
        return sqlDatabase ;
     }

}
