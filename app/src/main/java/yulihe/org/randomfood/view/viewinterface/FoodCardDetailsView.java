package yulihe.org.randomfood.view.viewinterface;

import yulihe.org.randomfood.base.BaseView;
import yulihe.org.randomfood.bean.FoodBean;

/**
 * Created by yuli.he on 2017/9/4.
 */

public interface FoodCardDetailsView extends BaseView {
    void show(FoodBean foodBean);
}
