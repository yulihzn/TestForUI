package yulihe.org.randomfood.view.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import yulihe.org.randomfood.R;
import yulihe.org.randomfood.base.BaseFragment;
import yulihe.org.randomfood.base.BasePresenter;
import yulihe.org.randomfood.bean.GoodsBean;
import yulihe.org.randomfood.bean.StoreBean;
import yulihe.org.randomfood.view.adapter.StoreRecyclerViewAdapter;

/**
 * Created by yuli.he on 2017/8/17.
 */

public class MyFragment extends BaseFragment {
    private RecyclerView rcv;
    private StoreRecyclerViewAdapter adapter;
    @Override
    protected void initViews() {
        rcv = (RecyclerView) getView().findViewById(R.id.rcv);
        rcv.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        List<StoreBean> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            StoreBean storeBean = new StoreBean();
            List<GoodsBean> temps = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                GoodsBean goodsBean = new GoodsBean();
                temps.add(goodsBean);
            }
            storeBean.setGoodsBeans(temps);
            list.add(storeBean);
        }
        adapter = new StoreRecyclerViewAdapter(getActivity(),list);
        rcv.setAdapter(adapter);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_data;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }
}
