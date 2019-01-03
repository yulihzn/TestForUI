package yulihe.org.randomfood.realm;

import yulihe.org.randomfood.bean.FoodBean;

/**
 * Created by yuli.he on 2017/9/6.
 */

public class RealmConvertUtils {
    public static FoodBean convertFoodBean(FoodRealmBean foodRealmBean){
        if(foodRealmBean == null){
            return null;
        }
        FoodBean foodBean = new FoodBean();
        foodBean.setCreateTime(foodRealmBean.getCreateTime());
        foodBean.setDescription(foodRealmBean.getDescription());
        foodBean.setFlag(foodRealmBean.getFlag());
        foodBean.setId(foodRealmBean.getId());
        foodBean.setImageUrl(foodRealmBean.getImageUrl());
        foodBean.setName(foodRealmBean.getName());
        foodBean.setPrice(foodRealmBean.getPrice());
        foodBean.setType(foodRealmBean.getType());
        foodBean.setUpdateTime(foodRealmBean.getUpdateTime());
        return foodBean;
    }
}
