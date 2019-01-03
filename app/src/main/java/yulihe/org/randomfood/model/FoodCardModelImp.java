package yulihe.org.randomfood.model;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import yulihe.org.randomfood.bean.FoodBean;
import yulihe.org.randomfood.net.OnDataCompleteListener;

/**
 * Created by yuli.he on 2017/8/16.
 */

public class FoodCardModelImp implements FoodCardModel {
    private String[] arr = {"https://hbimg.b0.upaiyun.com/34a9eab2d69d9de2367c3b30662fa3669e2c152bde915-zD3Lob_fw658",
            "https://hbimg.b0.upaiyun.com/b3d471ff88183db12a916d2811ee960a84d651c2efe99-Flym2p_fw658",
            "https://hbimg.b0.upaiyun.com/15ea33ce7355cff58846da52ee155dfa7e4f4da3a1e7a-zXgAtu_fw658",
            "https://hbimg.b0.upaiyun.com/7585d00684118df240763f492dc8c9aaf30c8a3cde77e-kHzMF2_fw658",
            "https://hbimg.b0.upaiyun.com/48d3c991f09bd309415d0a89ab1102e888ae8826e61d2-GwCdfv_fw658",
            "https://hbimg.b0.upaiyun.com/8493f5a72bb540a828e29c126a126360907f760ee2e4b-ObKiTL_fw658",
            "https://hbimg.b0.upaiyun.com/4c03e91b8f13d71d3d9c84bd8a1b3c657369e47c15b086-VtUBck_fw658",
            "https://hbimg.b0.upaiyun.com/84328c7314bee8ddee066b04d8ad2c014ee80133174f66-EYa4cW_fw658",
            "https://hbimg.b0.upaiyun.com/8c2dbf4c4881d5ac2f07498b45fc28f31597ac2f1cb8f2-zVC2vw_fw658",
            "https://hbimg.b0.upaiyun.com/af8fdaa76e24b31e1f53db766b88a3302f85d48116c256-bkf9Jl_fw658"};
    private List<FoodBean> list;
    private FoodBean foodBean;
    private Observable observable;

    @Override
    public void loadData(final OnDataCompleteListener listener) {
        list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            FoodBean bean = new FoodBean();
            bean.setId(i+"");
            bean.setName("food"+i);
            bean.setPrice(i+"yuan");
            bean.setDescription("nothing to show");
            bean.setImageUrl(arr[i]);
            list.add(bean);
        }
        listener.onSuccess(list);
        //key=nuirmzbnbtgm9kv4&location=shanghai&language=zh-Hans&unit=c
//        Map<String,String> map = new HashMap<>();
//        map.put("key","nuirmzbnbtgm9kv4");
//        map.put("location","shanghai");
//        map.put("language","zh-Hans");
//        map.put("unit","c");
//        observable = RetrofitFactory.getInstance().getWeather(map);
//        observable.compose(RxSchedulers.compose()).subscribe(new BaseObserver<List<ResultsBean>>(){
//            @Override
//            protected void onHandleSuccess(List<ResultsBean> weatherResultBean) {
//                listener.onSuccess(weatherResultBean);
//            }
//
//            @Override
//            protected void onHandleError(int code, String msg) {
//                super.onHandleError(code, msg);
//                listener.onError(msg);
//            }
//        });

    }

    public int addFood(){
        int i = 0;
        if(null != list){
            i = list.size();
            FoodBean bean = new FoodBean();
            bean.setId(i+"");
            bean.setName("food"+i);
            bean.setPrice(i+"yuan");
            bean.setDescription("nothing to show");
            int urlIndex = i%arr.length;
            bean.setImageUrl(arr[urlIndex]);
            list.add(0,bean);
        }
        return 0;
    }
    public int removeFood(){
        int i = 0;
        if(null != list && list.size()>i){
            list.remove(i);
        }
        return i;
    }
    @Override
    public List<FoodBean> getList() {
        return list;
    }

    @Override
    public void dispose() {
        if(observable != null){
            observable.unsubscribeOn(Schedulers.io());
        }
    }

    @Override
    public FoodBean getFoodCard() {
        return foodBean;
    }

    @Override
    public void setFoodCard(FoodBean foodBean) {
        this.foodBean = foodBean;
    }
}
