package com.lew.mapleleaf.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkUtils {

	/**
	 * 判断是否有网络连接
	 */
	public static boolean isNetworkConnected(Context context) {
		if (context != null) {
			ConnectivityManager mConnectivityManager = (ConnectivityManager) context
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
			if (mNetworkInfo != null) {
				return mNetworkInfo.isAvailable();
			}
		}
		return false;
	}

	/**
	 * 判断WIFI网络是否可用
	 */
	public boolean isWifiConnected(Context context) {
		if (context != null) {
			ConnectivityManager mConnectivityManager = (ConnectivityManager) context
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo mWiFiNetworkInfo = mConnectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
			if (mWiFiNetworkInfo != null) {
				return mWiFiNetworkInfo.isAvailable();
			}
		}
		return false;
	}

	/**
	 * 判断MOBILE网络是否可用
	 */
	public boolean isMobileConnected(Context context) {
		if (context != null) {
			ConnectivityManager mConnectivityManager = (ConnectivityManager) context
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo mMobileNetworkInfo = mConnectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
			if (mMobileNetworkInfo != null) {
				return mMobileNetworkInfo.isAvailable();
			}
		}
		return false;
	}

	/**
	 * 获取当前网络连接的类型信息
	 */
	public static int getConnectedType(Context context) {
		if (context != null) {
			ConnectivityManager mConnectivityManager = (ConnectivityManager) context
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
			if (mNetworkInfo != null && mNetworkInfo.isAvailable()) {
				return mNetworkInfo.getType();
			}
		}
		return -1;
	}

//	public static String getIpAddress() {
//		// 获取wifi服务
//		WifiManager wifiManager = (WifiManager) ZJHApplication.getInstance().getSystemService(Context.WIFI_SERVICE);
//		// 判断wifi是否开启
//		if (!wifiManager.isWifiEnabled()) {
//			// wifiManager.setWifiEnabled(true);
//			LogUtils.i("conflict", "wifi is disable");
//		}
//		WifiInfo wifiInfo = wifiManager.getConnectionInfo();
//		int ipAddress = wifiInfo.getIpAddress();
//		String ip = intToIp(ipAddress);
//		return ip;
//	}

	private static String intToIp(int i) {

		return (i & 0xFF) + "." + ((i >> 8) & 0xFF) + "." + ((i >> 16) & 0xFF) + "." + (i >> 24 & 0xFF);
	}

	// public static String getOutIp()
	// {
	// URL infoUrl = null;
	// InputStream inStream = null;
	// String ipLine = "";
	// HttpURLConnection httpConnection = null;
	// try {
	// infoUrl = new URL("http://ip168.com/");
	// URLConnection connection = infoUrl.openConnection();
	// httpConnection = (HttpURLConnection) connection;
	// int responseCode = httpConnection.getResponseCode();
	// if (responseCode == HttpURLConnection.HTTP_OK) {
	// inStream = httpConnection.getInputStream();
	// BufferedReader reader = new BufferedReader(
	// new InputStreamReader(inStream, "utf-8"));
	// StringBuilder strber = new StringBuilder();
	// String line = null;
	// while ((line = reader.readLine()) != null)
	// strber.append(line + "\n");
	//
	// Pattern pattern = Pattern
	// .compile("((?:(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d))))");
	// Matcher matcher = pattern.matcher(strber.toString());
	// if (matcher.find()) {
	// ipLine = matcher.group();
	// }
	// }
	//
	// } catch (MalformedURLException e) {
	// e.printStackTrace();
	// } catch (IOException e) {
	// e.printStackTrace();
	// } finally {
	// try {
	// inStream.close();
	// httpConnection.disconnect();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
	// return ipLine;
	// }
}
