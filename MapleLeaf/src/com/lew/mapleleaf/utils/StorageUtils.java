package com.lew.mapleleaf.utils;

import android.os.Environment;

public class StorageUtils {

	// SDCard路径
	public static final String SD_PATH = Environment.getExternalStorageDirectory().getAbsolutePath();
	// 图片存储路径
	public static final String BASE_PATH = SD_PATH + "/zxtx/together/cache/";
	// 缓存图片路径
	public static final String BASE_IMAGE_CACHE = "/zxtx/together/cache/images/";
}
