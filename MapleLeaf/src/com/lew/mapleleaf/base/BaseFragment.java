package com.lew.mapleleaf.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.lew.mapleleaf.BuildConfig;
import com.lew.mapleleaf.utils.logger.LogLevel;
import com.lew.mapleleaf.utils.logger.Logger;

public class BaseFragment extends Fragment {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (BuildConfig.DEBUG) {
			Logger.init(getClass().getSimpleName()).setLogLevel(LogLevel.FULL).hideThreadInfo();
		} else {
			Logger.init(getClass().getSimpleName()).setLogLevel(LogLevel.NONE).hideThreadInfo();
		}
	}
}
