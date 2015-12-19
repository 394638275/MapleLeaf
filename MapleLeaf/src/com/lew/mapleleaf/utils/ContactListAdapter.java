package com.lew.mapleleaf.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.lew.mapleleaf.R;

public class ContactListAdapter extends BaseExpandableListAdapter {

	private List<String> namelists;

	private AsortByPinyin assort = new AsortByPinyin();

	private Context mContext;

	private LayoutInflater inflater;
	// 中文排序
	private LanguageComparator_CN cnSort = new LanguageComparator_CN();

	public ContactListAdapter(Context context, List<String> namelists) {
		super();
		this.mContext = context;
		this.namelists = namelists;
		this.inflater = LayoutInflater.from(context);
		if (namelists == null) {
			namelists = new ArrayList<String>();
		}
		// 排序
		sort();
	}

	public void sort() {
		// 分类
		for (String str : namelists) {
			assort.getHashList().add(str);
		}
		assort.getHashList().sortKeyComparator(cnSort);
		for (int i = 0, length = assort.getHashList().size(); i < length; i++) {
			Collections.sort((assort.getHashList().getValueListIndex(i)), cnSort);
		}

	}

	@Override
	public Object getChild(int group, int child) {
		return assort.getHashList().getValueIndex(group, child);
	}

	@Override
	public long getChildId(int group, int child) {
		return child;
	}

	@Override
	public View getChildView(int group, int child, boolean arg2, View contentView, ViewGroup arg4) {

		if (contentView == null) {
//			contentView = inflater.inflate(R.layout.contact_list_item, null);
		}
		// TextView textView = (TextView) contentView
		// .findViewById(R.id.contact_listview_item_name);
		// textView.setText(assort.getHashList().getValueIndex(group, child));
		return contentView;
	}

	@Override
	public int getChildrenCount(int group) {
		return assort.getHashList().getValueListIndex(group).size();
	}

	@Override
	public Object getGroup(int group) {
		return assort.getHashList().getValueListIndex(group);
	}

	@Override
	public int getGroupCount() {
		return assort.getHashList().size();
	}

	@Override
	public long getGroupId(int group) {
		return group;
	}

	@Override
	public View getGroupView(int group, boolean arg1, View contentView, ViewGroup arg3) {
//		if (contentView == null) {
//			contentView = inflater.inflate(R.layout.contact_list_group, null);
//			contentView.setClickable(true);
//		}
//		TextView textView = (TextView) contentView.findViewById(R.id.contact_list_group_name);
//		textView.setText(assort.getFirstChar(assort.getHashList().getValueIndex(group, 0)));

		return contentView;
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}

	@Override
	public boolean isChildSelectable(int group, int child) {
		return true;
	}

	public AsortByPinyin getAssort() {
		return assort;
	}
}
