package yulihe.org.randomfood.view.widget;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;

/**
 * Created by yuli.he on 2017/8/22.
 */

public class SwipeCardCallBack extends ItemTouchHelper.SimpleCallback {
    private double deltaLength = 0;

    public SwipeCardCallBack(int dragDirs, int swipeDirs) {
        super(dragDirs, swipeDirs);
    }

    public SwipeCardCallBack() {
        super(0, ItemTouchHelper.LEFT | ItemTouchHelper.UP
                | ItemTouchHelper.RIGHT | ItemTouchHelper.DOWN);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

    }

    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        //监听话滑动的距离--控制动画的执行程度
        //灵界点
        double maxDistance = recyclerView.getWidth() * 0.5f;
        double distance = Math.sqrt(dX * dX);
        //动画执行的百分比
        double fraction = distance / maxDistance;
        if (fraction > 1) {
            fraction = 1;
        }
        boolean isDrag = false;
        if (Math.abs(fraction - deltaLength) > 0.005) {
            isDrag = true;
        }
        deltaLength = fraction;
        if (!isDrag) {
            return;
        }

        int itemcount = recyclerView.getChildCount();
        if (itemcount > 1) {
        }
        for (int i = 0; i < itemcount; i++) {
            //层数，层数和下标是反过来的
            int level = itemcount - i - 1;
            View view = recyclerView.getChildAt(i);
            view.setRotation((float) (0));
            if(level == 0){
                view.setRotation((float)(30*fraction));
            }
            if (level > 0) {
                if (level < CardConfig.MAX_SHOW_COUNT) {
                    view.setTranslationY((float)(CardConfig.TRANS_V_GAP*level-fraction *CardConfig.TRANS_V_GAP));
                    view.setTranslationX((float)(CardConfig.TRANS_H_GAP*level-fraction *CardConfig.TRANS_H_GAP));
                    view.setScaleX((float)(1-CardConfig.SCALE_GAP*level-CardConfig.SCALE_GAP*fraction));
                    view.setScaleY((float)(1-CardConfig.SCALE_GAP*level-CardConfig.SCALE_GAP*fraction));
                }
            }


        }
    }
}
