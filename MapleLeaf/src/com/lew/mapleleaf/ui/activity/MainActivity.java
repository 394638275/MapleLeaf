package com.lew.mapleleaf.ui.activity;

import android.view.View;
import android.widget.TextView;

import com.lew.mapleleaf.R;
import com.lew.mapleleaf.base.BaseActivity;

public class MainActivity extends BaseActivity {
	private TextView text;
	@Override
	protected void initTitle() {
		super.initTitle();
		mTitleBar.setTitle("真是日了狗");
	}

	@Override
	protected int addContentRes() {
		return R.layout.activity_main;
	}

	@Override
	protected void initView() {
		text = (TextView) findViewById(R.id.text);
	}

	@Override
	protected void initData() {
		text.setText("日了狗");

	}
	
	@Override
	protected boolean setContentImmersive() {
		return true;
	}
	
	@SuppressWarnings("deprecation")
	public void changeCollor(View view) {
		text.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
		mTitleBar.setBackgroundColor(getResources().getColor(android.R.color.holo_purple));
		text.setText("我变了");
	}
}
