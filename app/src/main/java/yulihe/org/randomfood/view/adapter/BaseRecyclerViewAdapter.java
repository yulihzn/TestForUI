package yulihe.org.randomfood.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
/**
 * Created by yuli.he on 2017/9/6.
 */

public abstract class BaseRecyclerViewAdapter<T,VH extends RecyclerView.ViewHolder>  extends RecyclerView.Adapter<VH> {
    protected List<T> list;
    protected Context context;

    public BaseRecyclerViewAdapter(Context context, List<T> list) {
        this.context = context;
        this.list = list;
    }

    public BaseRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(initItemViewResId(), parent, false);
        VH viewHolder = initViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
    }

    @Override
    public int getItemCount() {
        return list == null?0:list.size();
    }
    protected abstract VH initViewHolder(View view);
    protected abstract int initItemViewResId();
}
