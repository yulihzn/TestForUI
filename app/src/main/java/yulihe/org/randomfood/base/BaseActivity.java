package yulihe.org.randomfood.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import yulihe.org.randomfood.R;

/**
 * Created by yuli.he on 2017/8/15.
 */

public abstract class BaseActivity<V,T extends BasePresenter<V>> extends AppCompatActivity implements View.OnClickListener{
    protected T presenter;
    protected Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(presenter == null){
            presenter = createPresenter();
        }
        if(presenter != null){
            presenter.attachView((V)this);
        }
        setContentView(getLayoutRes());
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(null != toolbar){
            setSupportActionBar(toolbar);
            initToolBar();
        }
        initViews();

    }
    protected abstract void initViews();
    protected abstract T createPresenter();
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(presenter != null){
            presenter.detachView();
        }
    }
    protected abstract int getLayoutRes();
    protected abstract void initToolBar();
}
