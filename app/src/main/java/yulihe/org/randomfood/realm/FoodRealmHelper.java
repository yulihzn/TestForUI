package yulihe.org.randomfood.realm;

import android.content.Context;

import io.realm.Realm;

/**
 * Created by yuli.he on 2017/9/4.
 */

public class FoodRealmHelper {
    private static FoodRealmHelper instance;
    private FoodRealmHelper() {
    }
    public static FoodRealmHelper getInstance(){
        if(instance == null){
            instance = new FoodRealmHelper();
        }
        return instance;
    }
    public void init(Context context){
        Realm.init(context);
    }

}
