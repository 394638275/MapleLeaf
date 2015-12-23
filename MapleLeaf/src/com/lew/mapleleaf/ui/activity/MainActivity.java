package com.lew.mapleleaf.ui.activity;

import com.lew.mapleleaf.R;
import com.lew.mapleleaf.ui.fragments.MainPageFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends FragmentActivity {
	private FrameLayout mContainer;
	private RadioGroup mBottomBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		initData();
	}

	private void initView() {
		mContainer = (FrameLayout) findViewById(R.id.fragment_container);
		mBottomBar = (RadioGroup) findViewById(R.id.rg_tab_menu);

		mBottomBar.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.rb_tab_main_page:
					MainPageFragment fragment = new MainPageFragment();
					replaceFragment(R.id.fragment_container, fragment);
					break;

				case R.id.rb_tab_discover:

					break;

				case R.id.rb_tab_topic:

					break;

				case R.id.rb_tab_mine:

					break;

				default:
					break;
				}
			}
		});
	}

	private void initData() {

	}

	public void replaceFragment(int id_content, Fragment fragment) {
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		transaction.replace(id_content, fragment);
		transaction.commit();
	}
}
