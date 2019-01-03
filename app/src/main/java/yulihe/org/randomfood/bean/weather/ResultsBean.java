package yulihe.org.randomfood.bean.weather;

/**
 * Created by yuli.he on 2017/8/17.
 */

public class ResultsBean {
    /**
     * location : {"id":"WTW3SJ5ZBJUY","name":"上海","country":"CN","path":"上海,上海,中国","timezone":"Asia/Shanghai","timezone_offset":"+08:00"}
     * now : {"text":"多云","code":"4","temperature":"32"}
     * last_update : 2017-08-16T15:09:00+08:00
     */

    private LocationBean location;
    private NowBean now;
    private String last_update;

    public LocationBean getLocation() {
        return location;
    }

    public void setLocation(LocationBean location) {
        this.location = location;
    }

    public NowBean getNow() {
        return now;
    }

    public void setNow(NowBean now) {
        this.now = now;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }
}
