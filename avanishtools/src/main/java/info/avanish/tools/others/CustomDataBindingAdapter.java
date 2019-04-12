package info.avanish.tools.others;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

import androidx.databinding.BindingAdapter;


/**
 * Created by Avanish Singh on 09/04/18.
 */

public class CustomDataBindingAdapter {


    @BindingAdapter(value = {"imageUrl", "imageName", "placeHolder", "centerCrop", "transformation"},
            requireAll = false)
    public static void loadImageWithGlide(ImageView imageView,
                                          String imageUrl,
                                          String imageName,
                                          Drawable placeHolder,
                                          boolean centerCrop,
                                          BitmapTransformation transformation) {
        if (imageView != null) {
            String fullImageUrl = null;
            if (!TextUtils.isEmpty(imageUrl)) {
                fullImageUrl = imageUrl;

            } else {
                //fullImageUrl = EndPoints.S3_BASE_URL + imageName;
            }


            DrawableTypeRequest<String> request = Glide.with(imageView.getContext()).load(fullImageUrl);

            if (placeHolder != null) {
                request.placeholder(placeHolder);
            }

            if (centerCrop) {
                request.centerCrop();

            }
            if (transformation != null) {
                request.transform(transformation);
            }

            request.into(imageView);
        }


    }

    @BindingAdapter("visibleGone")
    public static void showHide(View view, boolean show) {
        view.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @BindingAdapter("visibleInvisible")
    public static void visibleInvisible(View view, boolean show) {
        view.setVisibility(show ? View.VISIBLE : View.INVISIBLE);
    }


}
