package com.lew.mapleleaf.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import android.util.Log;
import android.widget.TextView;

public class LogUtils {

	public static final String DEFAULT_MODULE = "default_module";

	private static Boolean LOG_SWITCH = true; // 日志文件总开关
	private static Boolean LOG_WRITE_TO_FILE = true;// 日志写入文件开关
	// private static char LOG_TYPE = 'v';// 输入日志类型，w代表只输出告警信息等，v代表输出所有信息
	// public static String LOG_PATH_SDCARD_DIR = Constants.FILE.BASE_DIR + "/log_files";
	public static String LOG_PATH_SDCARD_DIR = Constants.FILE.LOG_DIR;
	private static int SDCARD_LOG_FILE_SAVE_DAYS = 0;// sd卡中日志文件的最多保存天数
	private static String LOG_FILE_NAME = "-log.txt";// 本类输出的日志文件名称
	private static SimpleDateFormat logSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());// 日志的输出格式
	private static SimpleDateFormat logfile = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());// 日志文件格式

	public static void w(String tag, Object msg) { // 警告信息
		log(DEFAULT_MODULE, tag, msg.toString(), 'w');
	}

	public static void e(String tag, Object msg) { // 错误信息
		log(DEFAULT_MODULE, tag, msg.toString(), 'e');
	}

	public static void d(String tag, Object msg) {// 调试信息
		log(DEFAULT_MODULE, tag, msg.toString(), 'd');
	}

	public static void i(String tag, Object msg) {//
		log(DEFAULT_MODULE, tag, msg.toString(), 'i');
	}

	public static void v(String tag, Object msg) {
		log(DEFAULT_MODULE, tag, msg.toString(), 'v');
	}

	public static void w(String tag, String text) {
		log(DEFAULT_MODULE, tag, text, 'w');
	}

	public static void e(String tag, String text) {
		log(DEFAULT_MODULE, tag, text, 'e');
	}

	public static void d(String tag, String text) {
		log(DEFAULT_MODULE, tag, text, 'd');
	}

	public static void i(String tag, String text) {
		log(DEFAULT_MODULE, tag, text, 'i');
	}

	public static void v(String tag, String text) {
		log(DEFAULT_MODULE, tag, text, 'v');
	}

	public static void w(String module, String tag, String text) {
		log(module, tag, text, 'w');
	}

	public static void e(String module, String tag, String text) {
		log(module, tag, text, 'e');
	}

	public static void d(String module, String tag, String text) {
		log(module, tag, text, 'd');
	}

	public static void i(String module, String tag, String text) {
		log(module, tag, text, 'i');
	}

	public static void v(String module, String tag, String text) {
		log(module, tag, text, 'v');
	}

	/**
	 * 根据tag, msg和等级，输出日志
	 * 
	 * @param tag
	 * @param msg
	 * @param level
	 * @return void
	 * @since v 1.0
	 */
	private static void log(String module, String tag, String msg, char level) {
		if (LOG_SWITCH) {
			if ('e' == level /* && ('e' == LOG_TYPE || 'v' == LOG_TYPE) */) { // 输出错误信息
				Log.e(tag, msg);
			} else if ('w' == level /* && ('w' == LOG_TYPE || 'v' == LOG_TYPE) */) {
				Log.w(tag, msg);
			} else if ('i' == level /* && ('d' == LOG_TYPE || 'v' == LOG_TYPE) */) {
				Log.i(tag, msg);
			} else if ('d' == level /* && ('d' == LOG_TYPE || 'v' == LOG_TYPE) */) {
				Log.d(tag, msg);
			} else {
				Log.v(tag, msg);
			}
			if (LOG_WRITE_TO_FILE)
				writeLogtoFile(module, String.valueOf(level), tag, msg);
		}
	}

	/**
	 * 打开日志文件并写入日志
	 * 
	 * @return
	 * **/
	private static void writeLogtoFile(String module, String mylogtype, String tag, String text) {// 新建或打开日志文件
		Date nowtime = new Date();
		String needWriteFiel = logfile.format(nowtime);
		String needWriteMessage = logSdf.format(nowtime) + "--" + mylogtype + ", " + tag + ": " + text;
		File file = new File(LOG_PATH_SDCARD_DIR, module + "-" + needWriteFiel + LOG_FILE_NAME);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter filerWriter = new FileWriter(file, true);// 后面这个参数代表是不是要接上文件中原来的数据，不进行覆盖
			BufferedWriter bufWriter = new BufferedWriter(filerWriter);
			bufWriter.write(needWriteMessage);
			bufWriter.newLine();
			bufWriter.close();
			filerWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void readLogFromFile(TextView view) {
		StringBuffer sb = new StringBuffer();
		Date nowtime = new Date();
		String needReadFile = logfile.format(nowtime);
		File file = new File(LOG_PATH_SDCARD_DIR, needReadFile + LOG_FILE_NAME);
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = "";
			while ((line = br.readLine()) != null) {
				sb.append(line);
				sb.append("\n");
			}
			br.close();

			view.clearFocus();
			view.setTextKeepState(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void clearTodayLog() {
		Date nowtime = new Date();
		String needWriteFiel = logfile.format(nowtime);
		String needWriteMessage = "";
		File file = new File(LOG_PATH_SDCARD_DIR, needWriteFiel + LOG_FILE_NAME);
		try {
			FileWriter filerWriter = new FileWriter(file, false);
			BufferedWriter bufWriter = new BufferedWriter(filerWriter);
			bufWriter.write(needWriteMessage);
			bufWriter.newLine();
			bufWriter.close();
			filerWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除制定的日志文件
	 * 
	 * */
	public static void delFile() {// 删除日志文件
		String needDelFiel = logfile.format(getDateBefore());
		File file = new File(LOG_PATH_SDCARD_DIR, needDelFiel + LOG_FILE_NAME);
		if (file.exists()) {
			file.delete();
		}
	}

	/**
	 * 得到现在时间前的几天日期，用来得到需要删除的日志文件名
	 * */
	private static Date getDateBefore() {
		Date nowtime = new Date();
		Calendar now = Calendar.getInstance();
		now.setTime(nowtime);
		now.set(Calendar.DATE, now.get(Calendar.DATE) - SDCARD_LOG_FILE_SAVE_DAYS);
		return now.getTime();
	}

}
