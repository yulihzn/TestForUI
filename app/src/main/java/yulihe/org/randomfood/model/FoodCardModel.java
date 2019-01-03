package yulihe.org.randomfood.model;

import java.util.List;

import yulihe.org.randomfood.base.BaseModel;
import yulihe.org.randomfood.bean.FoodBean;

/**
 * Created by yuli.he on 2017/8/16.
 */

public interface FoodCardModel extends BaseModel{
    List<FoodBean> getList();
    FoodBean getFoodCard();
    void setFoodCard(FoodBean foodBean);
}
