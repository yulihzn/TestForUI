package yulihe.org.randomfood.presenter;


import android.content.Context;
import android.content.Intent;

import java.util.List;

import yulihe.org.randomfood.base.BasePresenter;
import yulihe.org.randomfood.bean.FoodBean;
import yulihe.org.randomfood.model.FoodCardModelImp;
import yulihe.org.randomfood.net.OnDataCompleteListener;
import yulihe.org.randomfood.view.activity.FoodDetailsActivity;
import yulihe.org.randomfood.view.viewinterface.FoodCardView;

/**
 * Created by yuli.he on 2017/8/16.
 */

public class FoodCardPresenter extends BasePresenter<FoodCardView> {
    public FoodCardPresenter() {
        mModel = new FoodCardModelImp();
    }

    @Override
    public void start() {
        mModel.loadData(new OnDataCompleteListener<List<FoodBean>>() {
            @Override
            public void onSuccess(List<FoodBean> object) {
                getView().setFoodList(object);
            }
            @Override
            public void onError(String error) {

            }
        });
    }
    public void toDetails(Context activity, FoodBean foodBean){
        activity.startActivity(new Intent(activity, FoodDetailsActivity.class));
    }
    public int addFood(){
        return ((FoodCardModelImp)mModel).addFood();
    }public int removeFood(){
        return ((FoodCardModelImp)mModel).removeFood();
    }

}
