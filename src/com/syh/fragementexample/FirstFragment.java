package com.syh.fragementexample;

import java.util.Random;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FirstFragment extends Fragment implements OnClickListener {

	private TextView titleTv;
	private Button changeBtn, toastBtn;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View baseView = inflater.inflate(R.layout.fragment1, container, false);
		titleTv = (TextView) baseView.findViewById(R.id.fragement1_title);
		changeBtn = (Button) baseView.findViewById(R.id.fragment1_change_btn);
		toastBtn = (Button) baseView.findViewById(R.id.fragment1_toast_btn);
		changeBtn.setOnClickListener(this);
		toastBtn.setOnClickListener(this);
		return baseView;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.fragment1_change_btn:
			Random random = new Random();
			titleTv.setText("hello" + random.nextInt(100));
			break;

		case R.id.fragment1_toast_btn:
			Toast.makeText(getActivity(), "hello word!", Toast.LENGTH_SHORT)
					.show();
			break;
		}
	}

	public void setTitle(String title) {
		titleTv = (TextView) getActivity().findViewById(R.id.fragement1_title);
		titleTv.setText(title);
	}
}
