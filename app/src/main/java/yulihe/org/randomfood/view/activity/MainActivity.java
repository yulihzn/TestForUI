package yulihe.org.randomfood.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import yulihe.org.randomfood.R;
import yulihe.org.randomfood.base.BaseActivity;
import yulihe.org.randomfood.presenter.FoodCardPresenter;
import yulihe.org.randomfood.view.viewinterface.FoodCardView;

public class MainActivity extends BaseActivity<FoodCardView,FoodCardPresenter> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter.start();
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected int getLayoutRes() {
        return 0;
    }

    @Override
    protected void initToolBar() {

    }

    @Override
    protected FoodCardPresenter createPresenter() {
        return new FoodCardPresenter();
    }

    @Override
    public void onClick(View v) {

    }
}
