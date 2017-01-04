package com.taishi.flipprogressdialog;

import android.animation.ObjectAnimator;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;





/**
 * Created by yamasakitaishi on 2016/12/28.
 */

public class FlipProgressDialog extends DialogFragment {

	private int duration = 1000;
	private String orientation = "rotationX";
	private float startAngle = 0.0f;
	private float endAngle = 360.0f;

	private int backgroundColor = -1;
	private int borderColor = -1;
	private int cornerRadi = 8;

	public FlipProgressDialog() {
	}


	@Override
	public void show(FragmentManager manager, String tag) {
		super.show(manager, tag);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);


	}

	@Override
	public void onStart() {
		super.onStart();
		Window window = getDialog().getWindow();
		WindowManager.LayoutParams windowParams = window.getAttributes();
		windowParams.dimAmount = 0.0f;
		windowParams.flags |= WindowManager.LayoutParams.FLAG_DIM_BEHIND;
		window.setAttributes(windowParams);
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		final Context contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.NoDimDialogFragmentStyle);
		LayoutInflater localInflater = inflater.cloneInContext(contextThemeWrapper);
		View view = localInflater.inflate(R.layout.fragment_dialog, null, false);
//		getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

		getDialog().getWindow().setBackgroundDrawable(customView(view,backgroundColor,borderColor));



		// Let's create the missing ImageView
		ImageView image = null;
		if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
			image = new ImageView(getContext());
		}

		// Now the layout parameters, these are a little tricky at first
		FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
				FrameLayout.LayoutParams.MATCH_PARENT,
				FrameLayout.LayoutParams.MATCH_PARENT);

		image.setScaleType(ImageView.ScaleType.MATRIX);
		image.setImageResource(R.drawable.sample_droid);

//		image.setOnTouchListener(this);

		// Let's get the root layout and add our ImageView
		FrameLayout layout = (FrameLayout) view.findViewById(R.id.root);
		layout.addView(image, 0, params);

//		View v = view.findViewById(R.id.imageview);
		ObjectAnimator animation = ObjectAnimator.ofFloat(image, orientation, startAngle, endAngle);
		animation.setDuration(duration);
		animation.setRepeatCount(ObjectAnimator.INFINITE);
		animation.setInterpolator(new AccelerateDecelerateInterpolator());
		animation.start();

		return view;
	}

	public static void customView(View v, int backgroundColor, int borderColor) {
		GradientDrawable shape = new GradientDrawable();
		shape.setShape(GradientDrawable.RECTANGLE);
		shape.setCornerRadii(new float[] { 8, 8, 8, 8, 0, 0, 0, 0 });
		shape.setColor(backgroundColor);
		shape.setStroke(3, borderColor);
		v.setBackgroundDrawable(shape);
	}



}
