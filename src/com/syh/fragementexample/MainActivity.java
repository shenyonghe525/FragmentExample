package com.syh.fragementexample;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.Display;
import android.view.View;

public class MainActivity extends FragmentActivity {

	private FirstFragment firstFragment;
	private SecondFragment secondFragment;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		FragmentTransaction transaction = getSupportFragmentManager()
				.beginTransaction();
		firstFragment = (FirstFragment) getSupportFragmentManager()
				.findFragmentById(R.id.first_fragment);
		secondFragment = (SecondFragment) getSupportFragmentManager()
				.findFragmentById(R.id.second_fragment);
		Display display = getWindowManager().getDefaultDisplay();
		if (display.getWidth() > display.getHeight()) {
			System.out.println("横屏");
		} else {
			System.out.println("竖屏");
			//动态移除添加xml里面的fragment
			secondFragment.getView().setVisibility(View.GONE);
		}
		transaction.addToBackStack(null);
		// Commit the transaction
		transaction.commit();
		firstFragment.setTitle("OK");
	}
}
