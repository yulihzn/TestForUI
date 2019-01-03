package yulihe.org.randomfood.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import yulihe.org.randomfood.R;

/**
 * Created by yuli.he on 2017/8/17.
 */

public abstract class BaseFragment<V,T extends BasePresenter<V>> extends Fragment {
    protected T presenter;
    private View view;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(presenter == null){
            presenter = createPresenter();
        }
        if(presenter != null){
            presenter.attachView((V)this);
        }
        view = inflater.inflate(getLayoutRes(), container, false);
        initViews();
        return view;
    }
    protected abstract int getLayoutRes();
    protected abstract void initViews();
    protected abstract T createPresenter();
    @Nullable
    @Override
    public View getView() {
        if(super.getView() != null){
            return super.getView();
        }
        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if(presenter != null){
            presenter.detachView();
        }
    }
}
