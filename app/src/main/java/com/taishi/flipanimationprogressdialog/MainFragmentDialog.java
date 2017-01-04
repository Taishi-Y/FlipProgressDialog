package com.taishi.flipanimationprogressdialog;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
import android.widget.LinearLayout;

/**
 * Created by yamasakitaishi on 2016/12/28.
 */

public class MainFragmentDialog extends DialogFragment {

	public MainFragmentDialog() {
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

		// create ContextThemeWrapper from the original Activity Context with the custom theme
		final Context contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.NoDimDialogFragmentStyle);
		// clone the inflater using the ContextThemeWrapper
		LayoutInflater localInflater = inflater.cloneInContext(contextThemeWrapper);
		View view = localInflater.inflate(R.layout.main_fragment_dialog, null, false);
		getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));




		// Let's create the missing ImageView
		ImageView image = new ImageView(getContext());



		// Now the layout parameters, these are a little tricky at first
		FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
				FrameLayout.LayoutParams.MATCH_PARENT,
				FrameLayout.LayoutParams.MATCH_PARENT);

		image.setScaleType(ImageView.ScaleType.MATRIX);
		image.setImageResource(R.drawable.ic_android_black_24dp);

//		image.setOnTouchListener(this);

		// Let's get the root layout and add our ImageView
		FrameLayout layout = (FrameLayout) view.findViewById(R.id.root);
		layout.addView(image, 0, params);

		View v = view.findViewById(R.id.imageview);
		ObjectAnimator animation = ObjectAnimator.ofFloat(image, "rotationY", 0.0f, 180f);
		animation.setDuration(500);
		animation.setRepeatCount(ObjectAnimator.INFINITE);
		animation.setInterpolator(new AccelerateDecelerateInterpolator());
		animation.start();

		return view;
	}
}
