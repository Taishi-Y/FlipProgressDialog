package com.taishi.flipanimationprogressdialog;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import com.taishi.flipprogressdialog.FlipProgressDialog;


public class MainActivity extends AppCompatActivity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		FlipProgressDialog flipProgressDialog = new FlipProgressDialog();
		flipProgressDialog.show(getFragmentManager(),"");


		Button button = (Button) findViewById(R.id.button);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
			// ダイアログを表示する
			FlipProgressDialog flipProgressDialog = new FlipProgressDialog();
			flipProgressDialog.show(getFragmentManager(),"");
			}
		});
	}

}
