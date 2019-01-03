package yulihe.org.randomfood.view.viewinterface;

import java.util.List;

import yulihe.org.randomfood.base.BaseView;
import yulihe.org.randomfood.bean.FoodBean;

/**
 * Created by yuli.he on 2017/8/16.
 */

public interface FoodCardView extends BaseView {
    void showWeather(String location,String weather,String temp);
    void setFoodList(List<FoodBean> list);
}
