package yulihe.org.randomfood.application;

import android.app.Application;

import yulihe.org.randomfood.realm.FoodRealmHelper;

/**
 * Created by yuli.he on 2017/8/25.
 */

public class FoodApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FoodRealmHelper.getInstance().init(this);
    }
}
