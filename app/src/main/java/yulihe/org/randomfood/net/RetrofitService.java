package yulihe.org.randomfood.net;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import yulihe.org.randomfood.bean.FoodBean;
import yulihe.org.randomfood.bean.weather.WeatherResultBean;

/**
 * Created by yuli.he on 2017/8/16.
 */

public interface RetrofitService {
    @FormUrlEncoded
    @POST("getFoodList")
    Observable<BaseEntity<FoodBean>> getFoodList(
            @FieldMap Map<String,String> map
    );
    @GET("weather/now.json")
    Observable<BaseEntity<WeatherResultBean>> getWeather(
            @QueryMap Map<String,String> map
    );
}
