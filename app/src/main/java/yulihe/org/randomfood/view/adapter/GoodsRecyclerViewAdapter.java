package yulihe.org.randomfood.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import yulihe.org.randomfood.R;
import yulihe.org.randomfood.bean.GoodsBean;
import yulihe.org.randomfood.bean.StoreBean;

/**
 * Created by yuli.he on 2017/8/18.
 */

public class GoodsRecyclerViewAdapter extends BaseRecyclerViewAdapter<GoodsBean,GoodsRecyclerViewAdapter.ViewHolder> {
    public GoodsRecyclerViewAdapter(Context context, List<GoodsBean> list) {
        super(context, list);
    }

    public GoodsRecyclerViewAdapter(Context context) {
        super(context);
    }

    @Override
    protected ViewHolder initViewHolder(View view) {
        return new ViewHolder(view);
    }

    @Override
    protected int initItemViewResId() {
        return R.layout.item_goods;
    }

    @Override
    public void onBindViewHolder(GoodsRecyclerViewAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list == null?0:list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;

        public ViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.tv);
        }
    }
}
