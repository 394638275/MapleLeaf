package com.lew.mapleleaf.utils;

import android.annotation.SuppressLint;
import android.os.Environment;

import com.lew.mapleleaf.BuildConfig;

public final class Constants {
	
	public static final String SINA_WEIBO_APP_KEY = "1659960096";
	public static final String WEI_XIN_APP_ID;
	public static final String QQ_APP_ID = "1104728590";
	
	public static final String IM_SERVER_ID = "zanjiahao-guanjia1";

	
	//生产环境
	public static final boolean DEV = true;
	public static final String EASEMOB_DEV_PREFIX = "zanjiahaodev";
	public static final String EASEMOB_PREFIX = "zanjiahao";
	
	
	public static final int HTTP_CONN_TIME_OUT = 60000; // HTTP 连接超时时间
	public static final int HTTP_READ_TIME_OUT = 60000; // HTTP 读取数据超时时间
	
	
	static{
		if(BuildConfig.DEBUG){
			WEI_XIN_APP_ID = "wx9cfe89c4c0ac3bf8";
		}else{
			WEI_XIN_APP_ID = "wx87fe73413a892f34";
		}
	}

	public static final class URL {

//		public static final String API_SERVER = "http://api.zanjiahao.com";
		public static final String API_SERVER = "http://api.dev.zanjiahao.com";
//		public static final String API_SERVER = "http://192.168.5.72";
//		public static final String API_SERVER = "http://api.zjh.com";
		public static final String WEB_SERVER = "http://webapp.dev.zanjiahao.com";
//		public static final String WEB_SERVER = "http://192.168.5.72:8090";
		public static final String COMET_HOST = "http://chat.dev.zanjiahao.com/sub";
//		public static final String COMET_PORT = "8100";
		
		public static final String SERVER_VERSION = "v1";
		public static final String API_SERVER_VERSION = API_SERVER + "/" + SERVER_VERSION;
		
		public static final String WUYE_FEE = WEB_SERVER+"/wuye/fee";
		public static final String WUYE_REPAIR = WEB_SERVER + "/wuye/repair";
		public static final String REWARD_HISTORY = WEB_SERVER + "/wuye/repair";
		public static final String EMPLOYEE_LIST = WEB_SERVER + "/wuye/star/lists";
		public static final String WUYE_STAR_COMMENT = WEB_SERVER + "/wuye/star/comment";
		
		public static final String API_LOGIN = API_SERVER_VERSION + "/user/login";
		public static final String API_VERIFYCODE = API_SERVER_VERSION + "/user/verification";
		public static final String API_REGISTER = API_SERVER_VERSION + "/user/register";
		public static final String API_GETCITY = API_SERVER_VERSION + "/public/city";
		public static final String API_CHANGEPASSWORD = API_SERVER_VERSION + "/user/password";
		public static final String API_GETCONTACT = API_SERVER_VERSION + "/getContact";
		public static final String API_GET_ARTICLE_SUMMARY = API_SERVER_VERSION + "/getArticleSummary";
		public static final String API_GET_ARTICLE_LIST = API_SERVER_VERSION + "/getArticleList";
		public static final String API_CHECKUPDATE = API_SERVER_VERSION + "/public/version";
		public static final String GROUP_CATEGORY = API_SERVER_VERSION + "/group/category";
		public static final String GROUP_ARTICLE_LIST = API_SERVER_VERSION + "/group/article/list";
		public static final String GROUP_ARTICLE = API_SERVER_VERSION + "/group/article";
		public static final String GROUP_ARTICLE_COMMENT = API_SERVER_VERSION + "/group/article/comment";
		public static final String VILLAGE = API_SERVER_VERSION + "/village";
		public static final String VILLAGE_BIND = API_SERVER_VERSION + "/village/binding";
		public static final String GROUP_ARTICLE_PRAISE = API_SERVER_VERSION + "/group/article/praise";
		public static final String API_USER = API_SERVER_VERSION + "/user";
		public static final String HOUSEKEEP_MENU = API_SERVER_VERSION + "/housekeep/menu";
		public static final String SWITCH_VILLAGE = API_SERVER_VERSION + "/user/userHasVillage";
		public static final String BIND_COTTAGE = API_SERVER_VERSION + "/village/binding/cottage";
		public static final String DELETE_COTTAGE = API_SERVER_VERSION + "/user/cottage/remove";
		public static final String VILLAGE_BUILDING = API_SERVER_VERSION + "/village/building";
		public static final String VILLAGE_COTTAGE = API_SERVER_VERSION + "/village/cottage";
		public static final String USER_COTTAGE = API_SERVER_VERSION + "/user/cottage";
		public static final String USER_VILLAGE = API_SERVER_VERSION + "/user/village";
		public static final String HOUSEKEEP_REPAIR_LIST = API_SERVER_VERSION + "/housekeep/repair/list";
		public static final String HOUSEKEEP_REPAIR = API_SERVER_VERSION + "/housekeep/repair";
		public static final String IS_HAS_COTTAGE = API_SERVER_VERSION + "/user/index/isHasCottage";
		public static final String SERACH_BY_VILLAGE = API_SERVER_VERSION + "/user/index/serachByVillage";
		
		public static final String REVIEW = API_SERVER_VERSION + "/public/praise";
		public static final String REMOVE_REVIEW = API_SERVER_VERSION + "/public/praise/cancel";
		public static final String REVIEW_TAGS = API_SERVER_VERSION + "/public/praise/tags";
		public static final String GET_KEYS = API_SERVER_VERSION + "/door";
		public static final String GET_KEYS_HISTORY = API_SERVER_VERSION + "/door/index/apply_list";
		public static final String GIVE_GOOD = API_SERVER_VERSION + "/shangfaling/message/givegood";
		
		public static final String PAYMENT = WEB_SERVER + "/pay/app_pay";
		public static final String WUYE_PAYMENT = WEB_SERVER + "/pay/get_charge";
		public static final String REVIEWS_HISTORY = WEB_SERVER + "/wuye/reward";
		
//		public static final String CHAT_MESSAGE = "http://192.168.1.138/v1" + "/chat/message";
//		public static final String UPLOAD_FILE = "http://192.168.1.138/v1" + "/chat/message/upload";
		
		public static final String CHAT_MESSAGE = API_SERVER_VERSION + "/chat/message";
		public static final String UPLOAD_FILE = API_SERVER_VERSION + "/chat/message/upload";
		public static final String API_ONLINE = API_SERVER_VERSION + "/chat/online";
		
		public static final String APPLY_BLUETOOTHKEY = API_SERVER_VERSION + "/door";
		public static final String BLUETOOTH_KEY_APPLY_RECORD = API_SERVER_VERSION + "/door/index/apply_list";
		public static final String MAINPAGE_ADS = API_SERVER_VERSION + "/public/ads";
		
		public static final String EMPLOYEE = API_SERVER_VERSION + "/employee";
		public static final String EMPLOYEE_COMMENT = API_SERVER_VERSION +"/employee/comment";
		public static final String HOUSEKEEP_PASS = API_SERVER_VERSION + "/housekeep/pass";
		public static final String HOUSEKEEP_PASS_LIST = API_SERVER_VERSION + "/housekeep/pass/list";
		public static final String HOUSEKEEP_FEE_LIST = API_SERVER_VERSION + "/housekeep/fee/list";
		public static final String SHANGFALING_MESSAGE_CREATE = API_SERVER_VERSION + "/shangfaling/message/create";
		public static final String SHANGFALING_MESSAGE_LIST = API_SERVER_VERSION + "/shangfaling/message/list";
		public static final String SHANGFALING_MESSAGE_SINGLE = API_SERVER_VERSION + "/shangfaling/message";
		public static final String SHANGFALING_MESSAGE_FOLLOW = API_SERVER_VERSION + "/shangfaling/message/follow";
		public static final String SHANGFALING_PUBLISH_HISTORY = API_SERVER_VERSION + "/shangfaling/message/ulist";
		public static final String HELP_LIST = API_SERVER_VERSION + "/taojindi/help/list";
		public static final String CREAT_HELP = API_SERVER_VERSION + "/taojindi/help/create";
		public static final String REPLY_HELP = API_SERVER_VERSION + "/taojindi/help/reply";
		public static final String GET_REPLY_LIST = API_SERVER_VERSION + "/taojindi/help/replylist";
		public static final String CHOOSE_PERSON = API_SERVER_VERSION + "/taojindi/help/choose";
		
		public static final String PAYMENT_DETAIL = WEB_SERVER + "/wuye/fee/info/";
		public static final String DOOR_LOCK_RECORD = API_SERVER_VERSION + "/door/lock/record";
		public static final String LOTTERY_PAGE = WEB_SERVER + "/lottery";
		public static final String USER_WALLET = API_SERVER_VERSION+"/user/wallet";
		public static final String SECOND_AD_PAGE = WEB_SERVER + "/clickmoney/Index";
		public static final String EXPRESS_PAGE = WEB_SERVER + "/wuye/express/lists";
		
		public static final String TAOJINDI_HELP_PARTICANTED_LIST  = API_SERVER_VERSION+"/taojindi/help/particanted_list";
		
		
	}

	public static final class PREFS {

//		public static final String ACCOUNT = "user_id";
//		public static final String ENCODE_PASSWORD = "encode_password";
		public static final String USER_LOGIN_INFO = "user_login_info";
		public static final String USER_VILLAGE_INFO = "user_village_info";
//		public static final String TOKEN = "token";
		public static final String NOTICE_VOICE = "notice_voice";
		public static final String SEARCH_BY_PHONE = "search_by_phone";
		public static final String NEED_VERIFY = "need_verify";
		public static final String ALLOW_CHECK = "allow_check";
	}
	
	public static final class MODULE{
		public static final String USER = "user";
		public static final String IM = "im";
		public static final String BDPUSH = "bdpush";
		public static final String TAOJINGDI = "taojingdi";
	}

	public static final class TAG {
		public static final String LOCATION = "location";
		public static final String RECEIVE_MESSAGE = "receive_message";
		public static final String SEND_MESSAGE = "send_message";
		public static final String UPLOADFILE = "uploadFile";
		public static final String APPLY_FRIEND = "apply_friend";
	}

	@SuppressLint("SdCardPath")
	public static final class FILE {

		// SDCard路径
		public static final String SD_PATH = Environment.getExternalStorageDirectory().getAbsolutePath();
		// 咱家好主目录
		public static final String BASE_DIR = SD_PATH + "/zjh";
		// 缓存图片路径
		public static final String IMAGE_CACHE =  BASE_DIR+"/cache/images";
		// log目录
		public static final String LOG_DIR = BASE_DIR + "/log";
		// Apk目录
		public static final String APK_DIR = BASE_DIR + "/apk";
		public static final String APK_FILE = APK_DIR + "/zjh.apk";
		public static final String BASE_IMAGE = "file:///sdcard/zjh";
		
		public static final String CAPTURE_IMAGE_DIR = BASE_DIR + "/images/capture";
		
		public static final String VOICE_CACHE_DIR = BASE_DIR + "/cache/voice";
		
		public static final String MAP_SNAPSHOT_DIR = BASE_DIR + "/images/map";

	}

}
