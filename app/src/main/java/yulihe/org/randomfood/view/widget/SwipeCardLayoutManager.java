package yulihe.org.randomfood.view.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by yuli.he on 2017/8/22.
 */

public class SwipeCardLayoutManager extends RecyclerView.LayoutManager{

    private Context context;

    public SwipeCardLayoutManager(Context context){
        CardConfig.initConfig(context);
    }
    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
    }
    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        Log.i("onLayoutChildren", "onLayoutChildren");
        //1.如何实现层叠效果--cardView.layout(l,t,r,b)
        //2.如何让8个条目中的4个展示在RecylerView里面
        //1在布局layout之前，将所有的子View先全部detach掉，然后放到Scrap集合里面缓存。
        detachAndScrapAttachedViews(recycler);
        //2)只将最上面4个view添加到RecylerView容器里面
        int itemCount=getItemCount();//8个
        int bottomPosition;
        if(itemCount<CardConfig.MAX_SHOW_COUNT){
            bottomPosition=0;

        }else{
            bottomPosition=itemCount-CardConfig.MAX_SHOW_COUNT;
        }
        for(int i=bottomPosition;i<itemCount;i++){
            View view=recycler.getViewForPosition(itemCount-i-1);
            addView(view);
            measureChildWithMargins(view,0,0);
            int widthSpace=getWidth()-getDecoratedMeasuredWidth(view);
            int heightSpace=getHeight()-getDecoratedMeasuredHeight(view);
            view.setRotation(0);
            //摆放cardView
            layoutDecorated(view,
                    widthSpace/2,
                    heightSpace/2,
                    widthSpace/2+getDecoratedMeasuredWidth(view),
                    heightSpace/2+getDecoratedMeasuredHeight(view));
            //层叠效果--Scale+TranslationY
            //层级的位置关系1/2/3/4
            int level=itemCount-i-1;
            if(level>=0){
                if(level<CardConfig.MAX_SHOW_COUNT){
                    view.setTranslationY(CardConfig.TRANS_V_GAP*level);
                    view.setTranslationX(CardConfig.TRANS_H_GAP*level);
                    view.setScaleX(1-CardConfig.SCALE_GAP*level);
                    view.setScaleY(1-CardConfig.SCALE_GAP*level);
                }
            }
        }



    }

}
