package yulihe.org.randomfood.presenter;

import yulihe.org.randomfood.base.BasePresenter;
import yulihe.org.randomfood.bean.FoodBean;
import yulihe.org.randomfood.model.FoodCardModel;
import yulihe.org.randomfood.model.FoodCardModelImp;
import yulihe.org.randomfood.view.viewinterface.FoodCardDetailsView;

/**
 * Created by yuli.he on 2017/9/4.
 */

public class FoodCardDetailsPresenter extends BasePresenter<FoodCardDetailsView> {
    public FoodCardDetailsPresenter() {
        mModel = new FoodCardModelImp();
    }

    @Override
    public void start() {
    }
    public void setFoodCardBean(FoodBean foodBean){
        ((FoodCardModel)mModel).setFoodCard(foodBean);
    }
    public FoodBean getFoodCardBean(){
        return ((FoodCardModel)mModel).getFoodCard();
    }
}
