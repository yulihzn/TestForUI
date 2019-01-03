package yulihe.org.randomfood.view.widget;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by yuli.he on 2017/8/22.
 */

public class CardConfig {
    //屏幕最对同时显示几个item
    public static int  MAX_SHOW_COUNT;
    //没一级Scale相差0.05f，translation相差7dp左右
    public static  float SCALE_GAP;
    public static int TRANS_V_GAP;
    public static int TRANS_H_GAP;

    public static void initConfig(Context context){
        MAX_SHOW_COUNT=20;
        SCALE_GAP=0.01f;
        TRANS_V_GAP=(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,2,context.getResources().getDisplayMetrics());
        TRANS_H_GAP=(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,5,context.getResources().getDisplayMetrics());
    }
}
