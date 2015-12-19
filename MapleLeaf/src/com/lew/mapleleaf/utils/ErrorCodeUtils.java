package com.lew.mapleleaf.utils;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import android.text.TextUtils;

import com.lew.mapleleaf.R;

public class ErrorCodeUtils {
		
	public static final int parameter_error = 100001; 		//参数错误
	public static final int system_error = 100002; 			//系统错误
	public static final int operation_failed = 100003;		//操作错误
	public static final int verification_failure = 100004;	//验证码失效
	public static final int verification_error = 100005;	//验证码错误
	public static final int SignCode_no_eixt = 100006;		//签名不存在
	public static final int SignCode_error = 100007;		//签名错误
	
//	public static String buildConnectExceptionJson(){
//		JsonObject retValue = new JsonObject();
//		retValue.addProperty("errorCode", CONNECT_ERROR);
//		retValue.addProperty("msg", ZJHApplication.getInstance().getString(R.string.network_error));
//		return retValue.toString().trim();
//	}
//	
//	public static String buildSoketTimeOutJson(){
//		JsonObject retValue = new JsonObject();
//		retValue.addProperty("errorCode", INTERNAL_SERVER_ERROR);
//		retValue.addProperty("msg", ZJHApplication.getInstance().getString(R.string.connect_server_timeout));
//		return retValue.toString().trim();
//	}
//	
//	public static String buildInternalServerErrorJson(){
//		JsonObject retValue = new JsonObject();
//		retValue.addProperty("errorCode", SOCKET_TIMEOUT_ERROR);
//		retValue.addProperty("msg", ZJHApplication.getInstance().getString(R.string.internal_server_error));
//		return retValue.toString().trim();
//	}
//	
//	public static void handleCommonError(int errorCode){
//		
//	}
//	
//	public static CallbackInfo<Void> buildHttpErrorInfo(int statusCode, String errorMsg, Throwable error) {
//		CallbackInfo<Void> cbInfo = new CallbackInfo<Void>();
//		cbInfo.bError = true;
//		if (TextUtils.isEmpty(errorMsg)) {
//			if (error != null) {
//				if (error instanceof UnknownHostException) {
//					cbInfo.errorMsg = StringUtils.getString(R.string.network_error);
//				} else if (error instanceof SocketTimeoutException) {
//					cbInfo.errorMsg = StringUtils.getString(R.string.connect_server_timeout);
//				} else if (error instanceof ConnectException) {
//					cbInfo.errorMsg = StringUtils.getString(R.string.connect_server_timeout);
//				}
//			} else {
//				if (statusCode == 500) {
//					cbInfo.errorMsg = StringUtils.getString(R.string.internal_server_error);
//				} else {
//
//				}
//			}
//		} else {
//			cbInfo.errorMsg = errorMsg;
//		}
//		return cbInfo;
//	}

}
