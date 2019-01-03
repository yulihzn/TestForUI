package yulihe.org.randomfood.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by zhengnan on 2019/1/3.
 */
public class OverScrollView extends HorizontalScrollView {
    Context context;
    public OverScrollView(Context context) {
        super(context);
        this.context = context;
    }

    public OverScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public OverScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;

    }
    private void init(Context context){
        TextView textView = new TextView(context);
        textView.setText("more");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2,-2);
        layoutParams.rightMargin = -150;
        textView.setLayoutParams(layoutParams);
        ((ViewGroup)this.getChildAt(0)).addView(textView);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        init(context);
    }

    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, 150, maxOverScrollY, isTouchEvent);
    }
}
