package yulihe.org.randomfood.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by yuli.he on 2017/8/18.
 */

public class ImageUtils {
    public static void loadImage(Context context, String url, ImageView imageView) {
        if (TextUtils.isEmpty(url)) {
            return;
        }
        Glide.with(context).load(url).into(imageView);
    }
}
