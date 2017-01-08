package com.taishi.flipanimationprogressdialog;


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

	Button btnFlipY, btnFlipX, btnSlow, btnFast;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		flipProgressDialog = new FlipProgressDialog();

		btnFlipY = (Button) findViewById(R.id.btn_flip_y);
		btnFlipX = (Button) findViewById(R.id.btn_flip_x);
		btnSlow = (Button) findViewById(R.id.btn_slow);
		btnFast = (Button) findViewById(R.id.btn_fast);



		btnFlipY.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				List<Integer> imageList = new ArrayList<Integer>();
				imageList.add(R.drawable.guitar);
				imageList.add(R.drawable.ic_android_black_24dp);

				FlipProgressDialog flipY = new FlipProgressDialog();
				flipY.setImageList(imageList);
				flipY.setOrientation("rotationY");
				flipY.show(getFragmentManager(),"");
			}
		});

		btnFlipX.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				FlipProgressDialog flipX = new FlipProgressDialog();
				flipX.setOrientation("rotationX");
				flipX.show(getFragmentManager(),"");
			}
		});

		btnFast.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				FlipProgressDialog fast = new FlipProgressDialog();
				fast.setDuration(200);
				fast.show(getFragmentManager(),"");
			}
		});

		btnSlow.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				FlipProgressDialog slow = new FlipProgressDialog();
				slow.setDuration(1000);
				slow.show(getFragmentManager(),"");
			}
		});


	}
}
