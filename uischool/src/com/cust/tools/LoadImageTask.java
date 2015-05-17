package com.cust.tools;

import java.io.InputStream;
import java.net.HttpURLConnection;

import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

public class LoadImageTask extends AsyncTask<String, Void, Bitmap>{

	private String imgurl;
	
	public interface Callback
	{
		public void updateImageView(Bitmap map);
		
	}
	private Callback callback;
	
	public LoadImageTask(Callback callback)
	{
		this.callback=callback;
	}
	
	@Override
	protected Bitmap doInBackground(String... arg0) {
        imgurl=arg0[0];
        Bitmap bmp=ImageLoader.getInstance().getBitmap(imgurl);
       
        if(bmp!=null)
        {
        	return bmp;
        }
        
        HttpURLConnection conn=null;
        InputStream is =null;
       
		try {
			URL url=new URL(imgurl);
			conn=(HttpURLConnection)url.openConnection();
		    conn.setConnectTimeout(5 * 1000);  
            conn.setReadTimeout(10 * 1000);  
			is=conn.getInputStream();
			 bmp= BitmapFactory.decodeStream(is);
			
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		finally{
			if (conn != null) {  
                conn.disconnect();  
            }  
			
		}
		
		 
		return bmp;
	}
	@Override
	protected void onPostExecute(Bitmap result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		if(callback!=null)
		{
			callback.updateImageView(result);
		}
		
	}

}
