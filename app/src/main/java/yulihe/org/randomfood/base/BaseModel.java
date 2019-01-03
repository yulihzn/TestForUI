package yulihe.org.randomfood.base;

import yulihe.org.randomfood.net.OnDataCompleteListener;

/**
 * Created by yuli.he on 2017/8/16.
 */

public interface BaseModel {
    void loadData(OnDataCompleteListener listener);
    void dispose();
}
