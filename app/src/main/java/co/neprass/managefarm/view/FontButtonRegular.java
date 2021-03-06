package co.neprass.managefarm.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

import static co.neprass.managefarm.Constants.FONTS_APP;


public class FontButtonRegular extends AppCompatButton {
    public FontButtonRegular(Context context) {
        super(context);
        Typeface face= Typeface.createFromAsset(getContext().getAssets(), FONTS_APP);
        this.setTypeface(face);
    }

    public FontButtonRegular(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface face= Typeface.createFromAsset(getContext().getAssets(), FONTS_APP);
        this.setTypeface(face);
    }

    public FontButtonRegular(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Typeface face= Typeface.createFromAsset(context.getAssets(), FONTS_APP);
        this.setTypeface(face);
    }

    protected void onDraw (Canvas canvas) {
        super.onDraw(canvas);


    }
}
