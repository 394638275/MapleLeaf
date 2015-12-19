package com.lew.mapleleaf.utils;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.lew.mapleleaf.R;

public class ToastUtils {

	private static ZJHToast mInstance;

//	public static void show(Context context, int resId, int duration) {
//		show(context, ZJHApplication.getInstance().getString(resId), duration);
//	}
//	
//	public static void show(Context context, int resId, int duration, Handler handler) {
//		show(context, ZJHApplication.getInstance().getString(resId), duration, handler);
//	}
//	
//	public static void show(Context context, int resId, Handler handler) {
//		show(context, ZJHApplication.getInstance().getString(resId), Toast.LENGTH_LONG, handler);
//	}
	
//	public static void show(Context context, int resId) {
//		show(context, resId, Toast.LENGTH_LONG);
//	}
//
//	public static void show(Context context, String content, int duration) {
//		show(context, content, duration, null);
//	}
	
	public static void show(final Context context, final String content, final int duration, final Handler handler) {
		if(handler == null){
			executeShow(context, content, duration);
		}else{
			handler.post(new Runnable() {
				@Override
				public void run() {
					executeShow(context, content, duration);
				}
			});
		}
	}
	
	private static void executeShow(Context context, String content, int duration){
		if (mInstance == null) {
			mInstance = new ZJHToast(context);
		}
		mInstance.setText(content);
		mInstance.setDuration(duration);
		if(!TextUtils.isEmpty(content == null ? "" : content.trim())){
			mInstance.show();
		}
	}
	
//	public static void show(Context context, String content) {
//		show(context, content, Toast.LENGTH_LONG);
//	}
//	
//	public static void show(Context context, String content, Handler handler) {
//		show(context, content, Toast.LENGTH_LONG, handler);
//	}

	private static class ZJHToast extends Toast {

		private TextView mTipTv;

		public ZJHToast(Context context) {
			super(context);
//			View view = LayoutInflater.from(context).inflate(R.layout.view_toast, null);
//			mTipTv = (TextView) view.findViewById(R.id.tip_tv);
//			setGravity(Gravity.CENTER, 0, 0);
//			setView(view);
		}

		@Override
		public void setText(CharSequence s) {
			mTipTv.setText(s);
		}

		@Override
		public void setText(int resId) {
			mTipTv.setText(resId);

		}

	}
}
