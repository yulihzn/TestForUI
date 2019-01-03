package yulihe.org.randomfood.bean.weather;

/**
 * Created by yuli.he on 2017/8/17.
 */

public class NowBean {
    /**
     * text : 多云
     * code : 4
     * temperature : 32
     */

    private String text;
    private String code;
    private String temperature;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
}
