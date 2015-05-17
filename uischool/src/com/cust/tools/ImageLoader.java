package com.cust.tools;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.support.v4.util.LruCache;

@SuppressLint("NewApi") public class ImageLoader {
	
	private static LruCache<String,Bitmap> mMemorycache;
	
	private static ImageLoader mImageLoader=new ImageLoader();;
	
	private ImageLoader()
	{
		int maxMemory=(int)Runtime.getRuntime().maxMemory(); //获取程序最大可用字节数
		int mcache=maxMemory/8;
		mMemorycache=new LruCache<String, Bitmap>(mcache)
		{
			@Override
			protected int sizeOf(String key, Bitmap value) {
				
				return value.getByteCount();
			}
	    };
		
	}
	
	//单例模式获取
	public static ImageLoader getInstance()
	{
		
		return mImageLoader;
	}
	public Bitmap getBitmap(String url)
	{
		return mMemorycache.get(url);
	}
	
	public void putBitmap(String url,Bitmap bitmap)
	{
		if(getBitmap(url)==null)
		mMemorycache.put(url, bitmap);
	}
	
	
	//将bitmap图片压缩
	public Bitmap zoomBitmap(Bitmap bitmap,int newwidth)
	{
		//该方法适用于  file stream 资源类型缩放
		//BitmapFactory.Options options= new BitmapFactory.Options();
		//options.inJustDecodeBounds=true; //不占用内存空间
		
		int width=bitmap.getWidth();
		int height=bitmap.getHeight(); 
		
		float scale= newwidth*1.0f/width; //计算缩放比例
		
		Matrix matrix = new Matrix();
		
		matrix.postScale(scale, scale);
		
		
		return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
				
		
		//BitmapFactory.
		
		
	}
	

}
