package com.taishi.flipanimationprogressdialog;


import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;


import com.taishi.flipprogressdialog.FlipProgressDialog;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

	FlipProgressDialog flipProgressDialog;
	List<Integer> imageList;

	Button btnFlipY, btnFlipX, btnSlow, btnFast, btnDim, btnBorder,
			btnCircle,btnNoAlphaChange, btnFullRotate;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		flipProgressDialog = new FlipProgressDialog();

		btnFlipY = (Button) findViewById(R.id.btn_flip_y);
		btnFlipX = (Button) findViewById(R.id.btn_flip_x);
		btnSlow = (Button) findViewById(R.id.btn_slow);
		btnFast = (Button) findViewById(R.id.btn_fast);
		btnDim = (Button) findViewById(R.id.btn_dim);
		btnBorder = (Button) findViewById(R.id.btn_border);
		btnNoAlphaChange = (Button) findViewById(R.id.btn_no_alpha);
		btnFullRotate = (Button) findViewById(R.id.btn_full_rotate);
		btnCircle = (Button) findViewById(R.id.btncircle);



		btnFlipY.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				List<Integer> imageList = new ArrayList<Integer>();
				imageList.add(R.drawable.ic_favorite_border_white_24dp);
				imageList.add(R.drawable.ic_favorite_white_24dp);

				FlipProgressDialog flipY = new FlipProgressDialog();
				flipY.setImageList(imageList);
				flipY.setOrientation("rotationY");
				flipY.setBackgroundColor(Color.parseColor("#FF4081"));
				flipY.setBackgroundAlpha(0.2f);
				flipY.setCornerRadius(32);
				flipY.show(getFragmentManager(),"");
			}
		});

		btnFlipX.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				List<Integer> imageList = new ArrayList<Integer>();
				imageList.add(R.drawable.ic_hourglass_empty_white_24dp);
				imageList.add(R.drawable.ic_hourglass_full_white_24dp);

				FlipProgressDialog flipX = new FlipProgressDialog();
				flipX.setImageList(imageList);
				flipX.setOrientation("rotationX");
				flipX.setBackgroundColor(Color.parseColor("#000000"));
				flipX.setBackgroundAlpha(1.0f);
				flipX.show(getFragmentManager(),"");
			}
		});

		btnFast.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				List<Integer> imageList = new ArrayList<Integer>();
				imageList.add(R.drawable.ic_thumb_up_black_24dp);
				imageList.add(R.drawable.ic_thumb_down_black_24dp);

				FlipProgressDialog fast = new FlipProgressDialog();
				fast.setImageList(imageList);
				fast.setOrientation("rotationY");
				fast.setDuration(300);
				fast.setBackgroundColor(Color.parseColor("#FFFFFF"));
				fast.setBackgroundAlpha(0.3f);
				fast.show(getFragmentManager(),"");
			}
		});

		btnSlow.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				List<Integer> imageList = new ArrayList<Integer>();
				imageList.add(R.drawable.ic_directions_bike_white_24dp);
				imageList.add(R.drawable.ic_directions_bus_white_24dp);
				imageList.add(R.drawable.ic_directions_car_white_24dp);
				imageList.add(R.drawable.ic_directions_subway_white_24dp);
				imageList.add(R.drawable.ic_flight_white_24dp);

				FlipProgressDialog slow = new FlipProgressDialog();
				slow.setImageList(imageList);
				slow.setOrientation("rotationY");
				slow.setDuration(800);
				slow.setBackgroundColor(Color.parseColor("#20A362"));
				slow.setBackgroundAlpha(0.3f);
				slow.show(getFragmentManager(),"");
			}
		});

		btnDim.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				List<Integer> imageList = new ArrayList<Integer>();
				imageList.add(R.drawable.ic_thumb_up_black_24dp);
				imageList.add(R.drawable.ic_thumb_down_black_24dp);

				FlipProgressDialog dim = new FlipProgressDialog();
				dim.setImageList(imageList);
				dim.setOrientation("rotationY");

				dim.setDimAmount(0.8f);
				dim.setBackgroundColor(Color.parseColor("#FFFFFF"));
				dim.show(getFragmentManager(),"");
			}
		});

		btnBorder.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				List<Integer> imageList = new ArrayList<Integer>();
				imageList.add(R.drawable.ic_sentiment_very_dissatisfied_black_24dp);
				imageList.add(R.drawable.ic_sentiment_very_satisfied_black_24dp);

				FlipProgressDialog border = new FlipProgressDialog();
				border.setImageList(imageList);
				border.setOrientation("rotationY");
				border.setBorderStroke(10);
				border.setBorderColor(Color.parseColor("#02A8F3"));
				border.setBackgroundColor(Color.parseColor("#FFFFFF"));
				border.show(getFragmentManager(),"");
			}
		});

		btnNoAlphaChange.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				List<Integer> imageList = new ArrayList<Integer>();
				imageList.add(R.drawable.ic_sentiment_very_dissatisfied_black_24dp);
				imageList.add(R.drawable.ic_sentiment_very_satisfied_black_24dp);

				FlipProgressDialog noAlphaChange = new FlipProgressDialog();
				noAlphaChange.setImageList(imageList);
				noAlphaChange.setOrientation("rotationY");
				noAlphaChange.setMinAlpha(1.0f);

				noAlphaChange.setBackgroundColor(Color.parseColor("#FFFFFF"));
				noAlphaChange.show(getFragmentManager(),"");
			}
		});

		btnFullRotate.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				List<Integer> imageList = new ArrayList<Integer>();
				imageList.add(R.drawable.ic_sentiment_very_dissatisfied_black_24dp);
				imageList.add(R.drawable.ic_sentiment_very_satisfied_black_24dp);

				FlipProgressDialog fullRotate = new FlipProgressDialog();
				fullRotate.setImageList(imageList);
				fullRotate.setOrientation("rotationY");
				fullRotate.setEndAngle(360.0f);
				fullRotate.show(getFragmentManager(),"");
			}
		});

		btnCircle.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				List<Integer> imageList = new ArrayList<Integer>();
				imageList.add(R.drawable.ic_timer_white_24dp);
//				imageList.add(R.drawable.ic_sentiment_very_satisfied_black_24dp);

				FlipProgressDialog circle = new FlipProgressDialog();
				circle.setImageList(imageList);

				circle.setBackgroundColor(Color.parseColor("#FF1744"));
				circle.setCornerRadius(200);
				circle.setOrientation("rotationY");
				circle.show(getFragmentManager(),"");
			}
		});


	}
}
