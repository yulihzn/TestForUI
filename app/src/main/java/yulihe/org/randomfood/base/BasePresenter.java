package yulihe.org.randomfood.base;

import java.lang.ref.WeakReference;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by yuli.he on 2017/8/15.
 */

public abstract class BasePresenter<T> {
    protected WeakReference<T> mViewRef;
    protected BaseModel mModel;

    public void attachView(T mView){
        mViewRef = new WeakReference<T>(mView);
    }
    public void detachView(){
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
        if(mModel != null){
            mModel.dispose();
        }
    }

    public T getView() {
        return mViewRef.get();
    }
    public BaseModel getModel() {
        return mModel;
    }
    public abstract void start();
}
