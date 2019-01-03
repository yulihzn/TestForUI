package yulihe.org.randomfood.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.view.View;

import yulihe.org.randomfood.R;
import yulihe.org.randomfood.base.BaseActivity;
import yulihe.org.randomfood.presenter.FoodCardPresenter;
import yulihe.org.randomfood.utils.FragmentSwitchHelper;
import yulihe.org.randomfood.view.fragment.MyFragment;
import yulihe.org.randomfood.view.fragment.HomeFragment;

public class HomeActivity extends BaseActivity {

    private HomeFragment homeFragment;
    private MyFragment myFragment;
    private FragmentSwitchHelper fragmentSwitchHelper;
    private BottomNavigationView navigation;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragmentSwitchHelper.switchFragment(0);
                    return true;
                case R.id.navigation_day:
                    startActivity(new Intent(HomeActivity.this,AddFoodActivity.class));
                    return true;
                case R.id.navigation_my:
                    fragmentSwitchHelper.switchFragment(1);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    protected void initViews() {
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        initFragments();
    }

    @Override
    protected void initToolBar() {
        toolbar.setTitle(R.string.app_name);
        toolbar.setNavigationIcon(R.mipmap.ic_launcher);
    }

    private void initFragments() {
        homeFragment = new HomeFragment();
        myFragment = new MyFragment();
        fragmentSwitchHelper = new FragmentSwitchHelper(getSupportFragmentManager(),R.id.content,homeFragment, myFragment);
    }

    @Override
    protected FoodCardPresenter createPresenter() {
        return new FoodCardPresenter();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_home;
    }

    @Override
    public void onClick(View v) {

    }
}
