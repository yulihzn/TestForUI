package yulihe.org.randomfood.net;

import java.io.Serializable;

/**
 * Created by yuli.he on 2017/8/16.
 */

public class BaseEntity<E> implements Serializable{
    private int code;
    private String msg;
    private E results;

    public boolean isSuccess(){
        return code == 0;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public E getResults() {
        return results;
    }

    public void setResults(E results) {
        this.results = results;
    }
}
