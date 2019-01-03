package yulihe.org.randomfood.net;

/**
 * Created by yuli.he on 2017/8/16.
 */

public interface OnDataCompleteListener<T> {
    void onSuccess(T object);
    void onError(String error);
}
