package com.lew.mapleleaf.ui.fragments;

import java.util.ArrayList;

import android.database.SQLException;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lew.mapleleaf.R;
import com.lew.mapleleaf.base.BaseFragment;
import com.lew.mapleleaf.base.MapleleafApplication;
import com.lew.mapleleaf.beans.ChannelItem;
import com.lew.mapleleaf.beans.ChannelManage;
import com.lew.mapleleaf.db.SQLHelper;
import com.lew.mapleleaf.ui.views.ColumnHorizontalScrollView;
import com.lew.mapleleaf.utils.ScreenUtils;

public class MainPageFragment extends BaseFragment {
	private ColumnHorizontalScrollView mTitle;
	private LinearLayout mTitleContainer;
	private ViewPager mPager;
	private ArrayList<ChannelItem> mUserChannelList;
	/** 当前选中的栏目 */
	private int columnSelectIndex = 0;
	/** 左阴影部分 */
	public ImageView mShadowLeft;
	/** 右阴影部分 */
	public ImageView mShadowRight;
	private ImageView mMoreColums;
	private RelativeLayout mColum;
	/** 屏幕宽度 */
	private int mScreenWidth = 0;
	/** Item宽度 */
	private int mItemWidth = 0;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_main_page, container, false);
		mTitle = (ColumnHorizontalScrollView) view.findViewById(R.id.chs_news_keywords_title);
		mTitleContainer = (LinearLayout) view.findViewById(R.id.ll_main_page_title_content);
		mPager = (ViewPager) view.findViewById(R.id.vp_main_page_news_pager);
		mShadowLeft = (ImageView) view.findViewById(R.id.shade_left);
		mShadowRight = (ImageView) view.findViewById(R.id.shade_right);
		mMoreColums = (ImageView) view.findViewById(R.id.iv_more_columns);
		mColum = (RelativeLayout) view.findViewById(R.id.rl_column);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		initColumnData();
		initTabColumn();
		initFragment();
	}

	private void initColumnData() {
		try {
			SQLHelper helper = MapleleafApplication.getInstance().getSQLHelper();
			mUserChannelList = (ArrayList<ChannelItem>) ChannelManage.getManage(helper).getUserChannel();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	private void initTabColumn() {
		mTitleContainer.removeAllViews();
		int count = mUserChannelList.size();
		mScreenWidth = ScreenUtils.getScreenWidth(getActivity());
		mItemWidth = mScreenWidth / 7;
		mTitle.setParam(getActivity(), mScreenWidth, mTitleContainer, mShadowLeft, mShadowRight, mMoreColums, mColum);
		for (int i = 0; i < count; i++) {
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(mItemWidth, LayoutParams.WRAP_CONTENT);
			params.leftMargin = 5;
			params.rightMargin = 5;
			// TextView localTextView = (TextView) mInflater.inflate(R.layout.column_radio_item, null);
			TextView columnTextView = new TextView(getActivity());
			columnTextView.setTextAppearance(getActivity(), R.style.top_category_scroll_view_item_text);
			// localTextView.setBackground(getResources().getDrawable(R.drawable.top_category_scroll_text_view_bg));
			columnTextView.setBackgroundResource(R.drawable.radio_button_bg);
			columnTextView.setGravity(Gravity.CENTER);
			columnTextView.setPadding(5, 5, 5, 5);
			columnTextView.setId(i);
			columnTextView.setText(mUserChannelList.get(i).getName());
			columnTextView.setTextColor(getResources().getColorStateList(R.color.top_category_scroll_text_color_day));
			if (columnSelectIndex == i) {
				columnTextView.setSelected(true);
			}
			columnTextView.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					for (int i = 0; i < mTitleContainer.getChildCount(); i++) {
						View localView = mTitleContainer.getChildAt(i);
						if (localView != v)
							localView.setSelected(false);
						else {
							localView.setSelected(true);
							mPager.setCurrentItem(i);
						}
					}
					Toast.makeText(getActivity(), mUserChannelList.get(v.getId()).getName(), Toast.LENGTH_SHORT).show();
				}
			});
			mTitleContainer.addView(columnTextView, i, params);
		}
	}

	private void initFragment() {

	}
}
