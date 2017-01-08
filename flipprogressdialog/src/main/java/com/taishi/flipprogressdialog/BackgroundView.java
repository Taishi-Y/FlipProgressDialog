package com.taishi.flipprogressdialog;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.view.View;

/**
 * Created by yamasakitaishi on 2017/01/08.
 */

public class BackgroundView {

	public static Drawable setBackground(View v, int color, int borderColor, int r, int borderStroke) {
		GradientDrawable shape = new GradientDrawable();
		shape.setShape(GradientDrawable.RECTANGLE);
		shape.setCornerRadii(new float[] { r, r, r, r, r, r, r, r });
		shape.setColor(color);
		shape.setStroke(borderStroke, borderColor);
		return shape;
	}

	public int createTransparentColor(int color, float factor) {
		int alpha = Math.round(Color.alpha(color) * factor);
		int red = Color.red(color);
		int green = Color.green(color);
		int blue = Color.blue(color);
		Log.v("color", String.valueOf(Color.argb(alpha, red, green, blue)));
		return Color.argb(alpha, red, green, blue);
	}

}
