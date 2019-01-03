package yulihe.org.randomfood.view.fragment;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Toast;

import com.kogitune.activity_transition.ActivityTransitionLauncher;

import java.util.List;

import yulihe.org.randomfood.R;
import yulihe.org.randomfood.base.BaseFragment;
import yulihe.org.randomfood.bean.FoodBean;
import yulihe.org.randomfood.presenter.FoodCardPresenter;
import yulihe.org.randomfood.view.activity.FoodDetailsActivity;
import yulihe.org.randomfood.view.adapter.FoodCardRecyclerViewAdapter;
import yulihe.org.randomfood.view.viewinterface.FoodCardView;
import yulihe.org.randomfood.view.widget.RecyclerViewItemClickListener;
import yulihe.org.randomfood.view.widget.SwipeCardCallBack;
import yulihe.org.randomfood.view.widget.SwipeCardLayoutManager;

/**
 * Created by yuli.he on 2017/8/17.
 */

public class HomeFragment extends BaseFragment<FoodCardView, FoodCardPresenter> implements FoodCardView {
    private RecyclerView rcv;
    private FoodCardRecyclerViewAdapter adapter;
    @Override
    protected void initViews() {
        rcv = (RecyclerView) getView().findViewById(R.id.rcv_card);
        rcv.setLayoutManager(new SwipeCardLayoutManager(getContext()));
        getView().findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add();
            }
        });
        getView().findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remove();
            }
        });
        presenter.start();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_home;
    }

    @Override
    public void show() {

    }

    @Override
    public void showWeather(String location, String weather, String temp) {

    }

    @Override
    public void setFoodList(final List<FoodBean> list) {
        adapter = new FoodCardRecyclerViewAdapter(getContext(),list);
        rcv.setAdapter(adapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new SwipeCardCallBack(){

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                super.onSwiped(viewHolder, direction);
                int fromPosition = viewHolder.getLayoutPosition();
                list.remove(fromPosition);
                adapter.notifyItemRemoved(fromPosition);
//                adapter.notifyItemRangeRemoved(fromPosition,list.size()-fromPosition);
            }
        });
        itemTouchHelper.attachToRecyclerView(rcv);
        Toast.makeText(getContext(),"success",Toast.LENGTH_SHORT).show();
        rcv.addOnItemTouchListener(new RecyclerViewItemClickListener(getContext(), new RecyclerViewItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(), FoodDetailsActivity.class);
                intent.putExtra("data",list.get(position));
                ActivityTransitionLauncher.with(getActivity()).from(view.findViewById(R.id.iv)).launch(intent);
            }
        }));
    }

    @Override
    protected FoodCardPresenter createPresenter() {
        return new FoodCardPresenter();
    }

    public void add(){
        int i = presenter.addFood();
        adapter.notifyItemInserted(i);
    }
    public void remove(){
        int i = presenter.removeFood();
//        adapter.notifyItemInserted(i);
        adapter.notifyItemRemoved(i);
    }
}
