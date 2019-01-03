package yulihe.org.randomfood.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import yulihe.org.randomfood.R;
import yulihe.org.randomfood.bean.FoodBean;
import yulihe.org.randomfood.bean.StoreBean;
import yulihe.org.randomfood.utils.ImageUtils;

/**
 * Created by yuli.he on 2017/8/18.
 */

public class StoreRecyclerViewAdapter extends BaseRecyclerViewAdapter<StoreBean,StoreRecyclerViewAdapter.ViewHolder> {
    public StoreRecyclerViewAdapter(Context context, List<StoreBean> list) {
        super(context, list);
    }

    public StoreRecyclerViewAdapter(Context context) {
        super(context);
    }

    @Override
    protected ViewHolder initViewHolder(View view) {
        return new ViewHolder(view);
    }

    @Override
    protected int initItemViewResId() {
        return R.layout.item_store;
    }

    @Override
    public void onBindViewHolder(StoreRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.tv.setText(list.get(position).getTitle());
        holder.rcv.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.HORIZONTAL));
        holder.rcv.setAdapter(new GoodsRecyclerViewAdapter(context,list.get(position).getGoodsBeans()));
    }

    @Override
    public int getItemCount() {
        return list == null?0:list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        RecyclerView rcv;

        public ViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv);
            rcv = (RecyclerView) itemView.findViewById(R.id.rcv);

        }
    }
}
