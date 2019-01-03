package yulihe.org.randomfood.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by yuli.he on 2017/8/17.
 */

public class FragmentSwitchHelper {
    private Fragment[] fragments;
    private int lastShowFragment = 0;
    private FragmentManager fragmentManager;
    private int layoutResId;

    public FragmentSwitchHelper(FragmentManager fragmentManager,int layoutResId,Fragment... fragments) {
        this.fragmentManager = fragmentManager;
        this.fragments = fragments;
        this.layoutResId = layoutResId;
        fragmentManager.beginTransaction()
                .add(layoutResId, fragments[lastShowFragment])
                .show(fragments[lastShowFragment])
                .commit();
    }

    /**
     * 切换Fragment
     *
     * @param index     需要显示的Fragment的索引
     */
    public void switchFragment(int index) {
        if (lastShowFragment == index||index>fragments.length-1) {
            return;
        }
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.hide(fragments[lastShowFragment]);
        if (!fragments[index].isAdded()) {
            transaction.add(layoutResId, fragments[index]);
        }
        transaction.show(fragments[index]).commitAllowingStateLoss();
        lastShowFragment = index;
    }
}
