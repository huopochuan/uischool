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
		int maxMemory=(int)Runtime.getRuntime().maxMemory(); //��ȡ�����������ֽ���
		int mcache=maxMemory/8;
		mMemorycache=new LruCache<String, Bitmap>(mcache)
		{
			@Override
			protected int sizeOf(String key, Bitmap value) {
				
				return value.getByteCount();
			}
	    };
		
	}
	
	//����ģʽ��ȡ
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
	
	
	//��bitmapͼƬѹ��
	public Bitmap zoomBitmap(Bitmap bitmap,int newwidth)
	{
		//�÷���������  file stream ��Դ��������
		//BitmapFactory.Options options= new BitmapFactory.Options();
		//options.inJustDecodeBounds=true; //��ռ���ڴ�ռ�
		
		int width=bitmap.getWidth();
		int height=bitmap.getHeight(); 
		
		float scale= newwidth*1.0f/width; //�������ű���
		
		Matrix matrix = new Matrix();
		
		matrix.postScale(scale, scale);
		
		
		return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
				
		
		//BitmapFactory.
		
		
	}
	

}
