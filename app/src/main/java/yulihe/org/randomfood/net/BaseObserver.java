package yulihe.org.randomfood.net;

import android.content.Context;
import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by yuli.he on 2017/8/16.
 */

public abstract class BaseObserver<T> implements Observer<BaseEntity<T>> {
    private static final String TAG = "BaseObserver";
    private Context mContext;
    protected BaseObserver(){
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(BaseEntity<T> value) {
        if(value.isSuccess()){
            T t = value.getResults();
            onHandleSuccess(t);
        }else {
            onHandleError(value.getCode(),value.getMsg());
        }
    }

    @Override
    public void onError(Throwable e) {
        Log.e(TAG, "error:" + e.toString());
    }

    @Override
    public void onComplete() {
        Log.d(TAG, "onComplete");
    }
    protected abstract void onHandleSuccess(T t);
    protected void onHandleError(int code,String msg){
        //TODO
    }
}
