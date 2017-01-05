package com.taishi.flipprogressdialog;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
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

import java.util.ArrayList;
import java.util.List;


/**
 * Created by yamasakitaishi on 2016/12/28.
 */

public class FlipProgressDialog extends DialogFragment {

	private int duration = 500;
	private String orientation = "rotationY";
	private float startAngle = 0.0f;
	private float endAngle = 180.0f;

	private int backgroundColor = adjustAlpha(-1,0.5f);
	private int borderColor = -1;
	private int r = 16;
	private int borderStroke = 0;

	private float dimAmount = 0.0f;

	private boolean canceledOnTouchOutside = true;


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
		windowParams.dimAmount = dimAmount;
		windowParams.flags |= WindowManager.LayoutParams.FLAG_DIM_BEHIND;
		window.setAttributes(windowParams);
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		//Can not dismiss when pressing outside the dialog
		getDialog().setCanceledOnTouchOutside(canceledOnTouchOutside);

		final Context contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.NoDimDialogFragmentStyle);
		LayoutInflater localInflater = inflater.cloneInContext(contextThemeWrapper);
		View view = localInflater.inflate(R.layout.fragment_dialog, null, false);

		getDialog().getWindow().setBackgroundDrawable(customView(view,backgroundColor,borderColor,r,borderStroke));


		// Let's create the missing ImageView
		ImageView image = null;
		if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
			image = new ImageView(getContext());
		}

		// Now the layout parameters, these are a little tricky at first
		FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
				FrameLayout.LayoutParams.MATCH_PARENT,
				FrameLayout.LayoutParams.MATCH_PARENT);

		image.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
		image.setImageResource(R.drawable.sample_droid);


		// Let's get the root layout and add our ImageView
		FrameLayout layout = (FrameLayout) view.findViewById(R.id.root);
		layout.addView(image, 0, params);


		animateAnimatorSetSample(image,360.0f,200);

		return view;
	}

	private void animateAnimatorSetSample( ImageView target, float degree, float distance ) {

		// AnimatorSetに渡すAnimatorのリストです
		List<Animator> animatorList= new ArrayList<Animator>();

		// alphaプロパティを0fから1fに変化させます
		PropertyValuesHolder alphaAnimator = PropertyValuesHolder.ofFloat("alpha", 0.9f, 0.8f );
//		ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat( target, "alpha", 1f, 0f );
		// 2秒かけて実行させます
//		alphaAnimator.setDuration( duration );
//
//		alphaAnimator.setRepeatCount(ObjectAnimator.INFINITE);

		// リストに追加します
//		animatorList.add( alphaAnimator );


		PropertyValuesHolder flipAnimator = PropertyValuesHolder.ofFloat(orientation, startAngle, endAngle);
//		ObjectAnimator flipAnimator = ObjectAnimator.ofFloat(target, orientation, startAngle, endAngle);
//		flipAnimator.setDuration(duration);
//		flipAnimator.setRepeatCount(ObjectAnimator.INFINITE);
//		flipAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
//		animatorList.add( flipAnimator );


		ObjectAnimator translationAnimator =
				ObjectAnimator.ofPropertyValuesHolder( target, alphaAnimator, flipAnimator);
		translationAnimator.setDuration(duration);
		translationAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
		translationAnimator.setRepeatCount(ObjectAnimator.INFINITE);
		animatorList.add(translationAnimator);


//		// 距離と半径から到達点となるX座標、Y座標を求めます
//		float toX = (float) ( distance * Math.cos( Math.toRadians( degree ) ) );
//		float toY = (float) ( distance * Math.sin( Math.toRadians( degree ) ) );
//
//		// translationXプロパティを0fからtoXに変化させます
//		PropertyValuesHolder holderX = PropertyValuesHolder.ofFloat( "translationX", 0f, toX );
//		// translationYプロパティを0fからtoYに変化させます
//		PropertyValuesHolder holderY = PropertyValuesHolder.ofFloat( "translationY", 0f, toY );
//		// rotationプロパティを0fから360に変化させます
//		PropertyValuesHolder holderRotaion = PropertyValuesHolder.ofFloat( "rotation", 0f, 360f );
//
		// targetに対してholderX, holderY, holderRotationを同時に実行します
//		ObjectAnimator translationXYAnimator =
//				ObjectAnimator.ofPropertyValuesHolder( target, holderX, holderY, holderRotaion );
//		// 2秒かけて実行させます
//		translationXYAnimator.setDuration( 2000 );
//		// リストに追加します
//		animatorList.add( translationXYAnimator );

		final AnimatorSet animatorSet = new AnimatorSet();
		// リストのAnimatorを順番に実行します
		animatorSet.playSequentially( animatorList );

		// アニメーションを開始します
		animatorSet.start();
	}

	public static Drawable customView(View v, int backgroundColor, int borderColor, int r, int borderStroke) {
		GradientDrawable shape = new GradientDrawable();
		shape.setShape(GradientDrawable.RECTANGLE);
		shape.setCornerRadii(new float[] { r, r, r, r, r, r, r, r });
		shape.setColor(backgroundColor);
		shape.setStroke(borderStroke, borderColor);
		return shape;
	}

	public int adjustAlpha(int color, float factor) {
		int alpha = Math.round(Color.alpha(color) * factor);
		int red = Color.red(color);
		int green = Color.green(color);
		int blue = Color.blue(color);
		return Color.argb(alpha, red, green, blue);
	}
}
