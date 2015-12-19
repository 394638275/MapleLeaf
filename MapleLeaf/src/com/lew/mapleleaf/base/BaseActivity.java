package com.lew.mapleleaf.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.lew.mapleleaf.R;
import com.lew.mapleleaf.ui.views.TitleBar;

public abstract class BaseActivity extends Activity {
	protected TitleBar mTitleBar;
	protected ImageView mCollectView;
	protected ViewGroup mRootView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_base);
		initTitle();
		addContent();
		initView();
		initData();
	}

	private void addContent() {
		mRootView = (ViewGroup) findViewById(R.id.main_content);
		View view = getLayoutInflater().inflate(addContentRes(), mRootView, false);
		mRootView.addView(view);
		int titleBarHeight = mTitleBar.getTitleBarHeight();
		view.setPadding(0, titleBarHeight, 0, 0);
		boolean isImmersive = setContentImmersive();
		if (isImmersive) {
			mTitleBar.setBackgroundResource(android.R.color.transparent);
		}
	};

	protected boolean setContentImmersive() {
		return false;
	}

	@SuppressLint("NewApi")
	protected void initTitle() {
		if (hasKitKat() && !hasLollipop()) {
			// 透明状态栏
			getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			// 透明导航栏
			// getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
		} else if (hasLollipop()) {
			Window window = getWindow();
			window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
					| WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
			window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
			// | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
					| View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
			window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			window.setStatusBarColor(Color.TRANSPARENT);
		}

		mTitleBar = (TitleBar) findViewById(R.id.title_bar);
		mTitleBar.setImmersive(true);
		mTitleBar.setBackgroundColor(Color.parseColor("#64b4ff"));
		mTitleBar.setLeftImageResource(R.drawable.title_back);
		mTitleBar.setLeftText("返回");
		mTitleBar.setLeftTextColor(Color.WHITE);
		mTitleBar.setLeftClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});

//		mTitleBar.setTitle("文章详情");
		mTitleBar.setTitleColor(Color.WHITE);
		mTitleBar.setSubTitleColor(Color.WHITE);
		mTitleBar.setDividerColor(Color.GRAY);
//		mTitleBar.setHeight(40 * 2);
//		mTitleBar.setActionTextColor(Color.WHITE);
//		mCollectView = (ImageView) mTitleBar.addAction(new TitleBar.ImageAction(R.drawable.collect) {
//			@Override
//			public void performAction(View view) {
//				Toast.makeText(BaseActivity.this, "点击了收藏", Toast.LENGTH_SHORT).show();
//				mCollectView.setImageResource(R.drawable.fabu);
//				mTitleBar.setTitle("文章详情\n朋友圈");
//			}
//		});
//
//		mTitleBar.addAction(new TitleBar.TextAction("发布") {
//			@Override
//			public void performAction(View view) {
//				Toast.makeText(BaseActivity.this, "点击了发布", Toast.LENGTH_SHORT).show();
//			}
//		});
	}

	protected abstract int addContentRes();

	protected abstract void initView();

	protected abstract void initData();

	protected boolean hasKitKat() {
		return Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
	}

	protected boolean hasLollipop() {
		return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
	}

}
