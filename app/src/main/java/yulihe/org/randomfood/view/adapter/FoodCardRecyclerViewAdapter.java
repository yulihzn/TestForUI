package yulihe.org.randomfood.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import yulihe.org.randomfood.R;
import yulihe.org.randomfood.bean.FoodBean;
import yulihe.org.randomfood.utils.ImageUtils;

/**
 * Created by yuli.he on 2017/8/18.
 */

public class FoodCardRecyclerViewAdapter extends BaseRecyclerViewAdapter<FoodBean,FoodCardRecyclerViewAdapter.ViewHolder> {
    public FoodCardRecyclerViewAdapter(Context context, List<FoodBean> list) {
        super(context, list);
    }

    public FoodCardRecyclerViewAdapter(Context context) {
        super(context);
    }

    @Override
    protected ViewHolder initViewHolder(View view) {
        return new ViewHolder(view);
    }

    @Override
    protected int initItemViewResId() {
        return R.layout.item_foodcard;
    }

    @Override
    public void onBindViewHolder(FoodCardRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.tv.setText(list.get(position).getName());
        ImageUtils.loadImage(context, list.get(position).getImageUrl(), holder.iv);
    }

    @Override
    public int getItemCount() {
        return list == null?0:list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        ImageView iv;

        public ViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv);
            iv = (ImageView) itemView.findViewById(R.id.iv);
        }
    }
}
