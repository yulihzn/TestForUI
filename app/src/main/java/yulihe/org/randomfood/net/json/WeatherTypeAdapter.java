package yulihe.org.randomfood.net.json;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

import yulihe.org.randomfood.bean.weather.WeatherResultBean;

/**
 * Created by yuli.he on 2017/8/16.
 */

public class WeatherTypeAdapter extends TypeAdapter<WeatherResultBean>{
    @Override
    public void write(JsonWriter out, WeatherResultBean value) throws IOException {

    }

    @Override
    public WeatherResultBean read(JsonReader in) throws IOException {
        return null;
    }
}
