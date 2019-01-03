package yulihe.org.randomfood.bean;

import java.util.List;

/**
 * Created by yuli.he on 2017/11/8.
 */

public class StoreBean {
    private String title;
    private List<GoodsBean> goodsBeans;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<GoodsBean> getGoodsBeans() {
        return goodsBeans;
    }

    public void setGoodsBeans(List<GoodsBean> goodsBeans) {
        this.goodsBeans = goodsBeans;
    }
}
