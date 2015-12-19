package com.lew.mapleleaf.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.text.TextUtils;

@SuppressWarnings("deprecation")
public class BitmapUtils {

	public static Bitmap getCompressedImage(String srcPath, int tw, int th) {
		return getCompressedImage(srcPath, tw, th, -1);
	}

	/**
	 * 方法概述：进入图片的大小与质量压缩，用于区分大小图片
	 */
	public static Bitmap getCompressedImage(String srcPath, int tw, int th,
			int size) {
		if (TextUtils.isEmpty(srcPath) || !new File(srcPath).exists()) {
			return null;
		}
		BitmapFactory.Options newOpts = new BitmapFactory.Options();
		newOpts.inPreferredConfig = Bitmap.Config.RGB_565;
		newOpts.inPurgeable = true;
		newOpts.inInputShareable = true;
		newOpts.inJustDecodeBounds = true;
		FileInputStream is = null;
		try {
			is = new FileInputStream(srcPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		if (is == null) {
			return null;
		}
		Bitmap bitmap = BitmapFactory.decodeStream(is, null, newOpts);
		newOpts.inJustDecodeBounds = false;
		int sw = 1;
		if (tw > 0) {
			sw = (int) newOpts.outWidth / tw;
		}
		int sh = 1;
		if (th > 0) {
			sh = (int) (newOpts.outHeight / th);
		}
		int s = sw > sh ? sw : sh;
		if (s <= 0) {
			s = 1;
		}
		newOpts.inSampleSize = s;
		bitmap = BitmapFactory.decodeFile(srcPath, newOpts);
		if (bitmap != null) {
			if (size > 0) {
				return qulityCompressImageSize2Bitmap(bitmap, size);
			} else {
				return bitmap;
			}
		}
		return null;
	}

	public static Bitmap getNonScaledCompressedImage(String srcPath, int tw,
			int th) {
		if (TextUtils.isEmpty(srcPath) || !new File(srcPath).exists()) {
			return null;
		}
		BitmapFactory.Options newOpts = new BitmapFactory.Options();
		newOpts.inPreferredConfig = Bitmap.Config.RGB_565;
		newOpts.inPurgeable = true;
		newOpts.inInputShareable = true;
		newOpts.inJustDecodeBounds = true;
		FileInputStream is = null;
		try {
			is = new FileInputStream(srcPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		if (is == null) {
			return null;
		}
		Bitmap bitmap = BitmapFactory.decodeStream(is, null, newOpts);
		newOpts.inJustDecodeBounds = false;
		int sw = 1;
		if (tw > 0) {
			sw = (int) newOpts.outWidth / tw;
		}
		int sh = 1;
		if (th > 0) {
			sh = (int) (newOpts.outHeight / th);
		}
		int s = sw > sh ? sw : sh;
		if (s <= 0) {
			s = 1;
		}
		newOpts.inSampleSize = s;
		bitmap = BitmapFactory.decodeFile(srcPath, newOpts);

		Matrix matrix = new Matrix();
		if (bitmap == null || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
			return null;
		}
		matrix.postScale((float) tw / bitmap.getWidth(),
				(float) th / bitmap.getHeight());
		Bitmap scaleBitmap = Bitmap.createBitmap(bitmap, 0, 0,
				bitmap.getWidth(), bitmap.getHeight(), matrix, false);
		if (scaleBitmap != bitmap) {
			bitmap.recycle();
			bitmap = null;
		}

		return scaleBitmap;
	}

	public static Bitmap decodeChatThumbnailPicture(String srcPath) {
		if (TextUtils.isEmpty(srcPath) || !new File(srcPath).exists()) {
			return null;
		}
		BitmapFactory.Options newOpts = new BitmapFactory.Options();
		newOpts.inJustDecodeBounds = true;
		Bitmap bitmap = BitmapFactory.decodeFile(srcPath, newOpts);
		int bw = newOpts.outWidth;
		int bh = newOpts.outHeight;
		int tw, th, sw = 1, sh = 1;
		if (bw < bh) {
			tw = 160;
			th = 291;
		} else {
			tw = 291;
			th = 160;
		}
		sw = (int) (bw / tw);
		sh = (int) (bh / th);
		int s = sw > sh ? sw : sh;
		if (s <= 0) {
			s = 1;
		}
		newOpts.inPreferredConfig = Bitmap.Config.RGB_565;
		newOpts.inPurgeable = true;
		newOpts.inInputShareable = true;
		newOpts.inSampleSize = s;
		newOpts.inJustDecodeBounds = false;
		bitmap = BitmapFactory.decodeFile(srcPath, newOpts);

		if (bitmap == null) {
			return null;
		}

		Matrix matrix = new Matrix();
		matrix.postScale((float) tw / bitmap.getWidth(),
				(float) th / bitmap.getHeight());
		Bitmap scaleBitmap = Bitmap.createBitmap(bitmap, 0, 0,
				bitmap.getWidth(), bitmap.getHeight(), matrix, false);
		if (scaleBitmap != bitmap) {
			bitmap.recycle();
			bitmap = null;
		}

		return scaleBitmap;
	}

	/**
	 * 方法概述：进入图片的大小与质量压缩，用于区分大小图片
	 */
	public static byte[] getCompressedImage2ByteArray(String srcPath, int tw,
			int th, int size) {
		if (TextUtils.isEmpty(srcPath)) {
			return null;
		}
		BitmapFactory.Options newOpts = new BitmapFactory.Options();
		newOpts.inPreferredConfig = Bitmap.Config.RGB_565;
		newOpts.inPurgeable = true;
		newOpts.inInputShareable = true;
		newOpts.inJustDecodeBounds = true;
		FileInputStream is = null;
		try {
			is = new FileInputStream(srcPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		if (is == null) {
			return null;
		}
		Bitmap bitmap = BitmapFactory.decodeStream(is, null, newOpts);
		newOpts.inJustDecodeBounds = false;
		int sw = 1;
		if (tw > 0) {
			sw = (int) newOpts.outWidth / tw;
		}
		int sh = 1;
		if (th > 0) {
			sh = (int) (newOpts.outHeight / th);
		}
		int s = sw > sh ? sw : sh;
		if (s <= 0) {
			s = 1;
		}
		newOpts.inSampleSize = s;
		bitmap = BitmapFactory.decodeFile(srcPath, newOpts);
		if (bitmap != null && size > 0) {
			return compressImageSize2ByteArray(bitmap, size);
		}
		return null;
	}

	/**
	 * 方法概述：图片质量压缩
	 */
	public static Bitmap qulityCompressImageSize2Bitmap(Bitmap image, int size) {
		if (image == null) {
			return image;
		}
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		image.compress(Bitmap.CompressFormat.JPEG, 100, baos);
		int qulity = 100;
		double radio = 2.0 / 3;
		int length = baos.toByteArray().length;
		while (length / 1000 > size && !(qulity < 0)) {
			baos.reset();
			image.compress(Bitmap.CompressFormat.JPEG, qulity, baos);
			length = baos.toByteArray().length;
			qulity = (int) (qulity * radio);
		}
		ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());
		Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null);
		return bitmap;
	}

	/**
	 * 方法概述：图片质量压缩
	 */
	public static byte[] compressImageSize2ByteArray(Bitmap image, int size) {
		if (image == null) {
			return null;
		}
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		image.compress(Bitmap.CompressFormat.JPEG, 100, baos);
		int options = 100;
		double radio = 2.0 / 3;
		while (baos.toByteArray().length / 1000 > size && options > 0) {
			baos.reset();
			image.compress(Bitmap.CompressFormat.JPEG, options, baos);
			options = (int) (options * radio);
		}
		return baos.toByteArray();
	}

	public static byte[] bmpToByteArray(final Bitmap bmp,
			final boolean needRecycle) {
		if (bmp == null) {
			return new byte[0];
		}
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		bmp.compress(CompressFormat.PNG, 100, output);
		if (needRecycle) {
			bmp.recycle();
		}
		byte[] result = output.toByteArray();
		try {
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void saveBmpToFile(Bitmap bm, File f) throws FileNotFoundException,
			IOException {
		if (f.exists()) {
			return;
		}

		FileOutputStream fos = new FileOutputStream(f);
		bm.compress(Bitmap.CompressFormat.JPEG, 100, fos);
		fos.close();
	}

	/**
	 * 根据原图和变长绘制圆形图片
	 * 
	 * @param source
	 * @param min
	 * @return
	 */
	// public static Bitmap createCircleImage(Bitmap source) {
	// int min = Math.min(source.getWidth(), source.getHeight());
	// final Paint paint = new Paint();
	// paint.setAntiAlias(true);
	// Bitmap target = Bitmap.createBitmap(min, min, Config.ARGB_8888);
	// Canvas canvas = new Canvas(target);
	// canvas.drawCircle(min / 2, min / 2, min / 2, paint);
	// paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
	// canvas.drawBitmap(source, 0, 0, paint);
	// return target;
	// }

//	public static Bitmap getCompressedImImage(String srcPath) {
//		if (TextUtils.isEmpty(srcPath) || !new File(srcPath).exists()) {
//			return null;
//		}
//		BitmapFactory.Options opts = new BitmapFactory.Options();
//		opts.inPreferredConfig = Bitmap.Config.RGB_565;
//		opts.inPurgeable = true;
//		opts.inInputShareable = true;
//		opts.inJustDecodeBounds = true;
//		Bitmap bitmapIn = BitmapFactory.decodeFile(srcPath, opts);
//		int tw = 0, th = 0;
//		if (opts.outWidth > opts.outHeight) {
//			tw = 388;
//			th = 240;
//		} else {
//			tw = 240;
//			th = 388;
//		}
//		int sw = (int) (opts.outWidth / tw);
//		int sh = (int) (opts.outHeight / th);
//		int s = sw > sh ? sw : sh;
//		if (s <= 0) {
//			s = 1;
//		}
//		opts.inJustDecodeBounds = false;
//		opts.inSampleSize = s;
//		bitmapIn = BitmapFactory.decodeFile(srcPath, opts);
//		final Bitmap compressBitmp = BitmapUtils
//				.qulityCompressImageSize2Bitmap(bitmapIn, 10);
//		Resources res = ZJHApplication.getInstance().getResources();
//		Bitmap bitmap_bg = BitmapFactory.decodeResource(res,
//				R.drawable.chatto_bg_normal);
//		final Bitmap bp = getImCropImage(bitmap_bg, compressBitmp);
//		if (bitmap_bg != null && !bitmap_bg.isRecycled()) {
//			bitmap_bg.recycle();
//		}
//		if (compressBitmp != null && !compressBitmp.isRecycled()) {
//			compressBitmp.recycle();
//		}
//		return bp;
//	}

	public static Bitmap getImCropImage(Bitmap bitmap_bg, Bitmap bitmapIn) {
		int width = bitmapIn.getWidth();
		int height = bitmapIn.getHeight();
		Bitmap roundConcerImage = Bitmap.createBitmap(width, height,
				Config.ARGB_8888);
		Canvas canvas = new Canvas(roundConcerImage);
		Rect rect = new Rect(0, 0, width, height);
		Rect rectF = new Rect(0, 0, width, height);
		NinePatch patch = new NinePatch(bitmap_bg,
				bitmap_bg.getNinePatchChunk(), null);
		patch.draw(canvas, rect);
		Paint paint = new Paint();
		paint.setAntiAlias(true);
		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
		canvas.drawBitmap(bitmapIn, rectF, rect, paint);
		return roundConcerImage;
	}

	public static Bitmap getScaledBitmap(Bitmap bitmap, int tw, int th,
			boolean needRecycled) {
		if (bitmap == null) {
			return null;
		}
		double sw = (double) tw / bitmap.getWidth();
		double sh = (double) th / bitmap.getHeight();
		Matrix m = new Matrix();
		m.postScale((float) sw, (float) sh);
		Bitmap destBitmap = Bitmap.createBitmap(bitmap, 0, 0,
				bitmap.getWidth(), bitmap.getHeight(), m, false);
		if (destBitmap != bitmap && needRecycled) {
			bitmap.recycle();
			bitmap = null;
		}
		return destBitmap;
	}

}
