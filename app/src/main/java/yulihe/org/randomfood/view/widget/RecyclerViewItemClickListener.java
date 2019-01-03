package yulihe.org.randomfood.view.widget;

import android.content.Context;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by yuli.he on 2017/9/4.
 */

public class RecyclerViewItemClickListener implements RecyclerView.OnItemTouchListener {
    private GestureDetectorCompat gestureDetectorCompat;
    private OnItemClickListener onItemClickListener;
    private RecyclerView recyclerView;

    public RecyclerViewItemClickListener(Context context,OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
        gestureDetectorCompat = new GestureDetectorCompat(context,new OnGestureTapListener());
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        recyclerView = rv;
        if(gestureDetectorCompat.onTouchEvent(e)){
            return true;
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
    private class OnGestureTapListener extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            if(recyclerView != null){
                View childView = recyclerView.findChildViewUnder(e.getX(),e.getY());
                if(childView != null && onItemClickListener != null){
                    onItemClickListener.onItemClick(childView,recyclerView.getChildLayoutPosition(childView));
                    return true;
                }
            }

            return super.onSingleTapUp(e);
        }
    }
    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }
}
