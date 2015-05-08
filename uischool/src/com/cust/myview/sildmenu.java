package com.cust.myview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;

import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

public class sildmenu extends HorizontalScrollView {

	private int ScreenWidth;
	private int menuWidth;
	private ViewGroup menu;
	private ViewGroup content;
	private LinearLayout warp;
	
	private int paddingright;
	
	private boolean once=true;
	
	private boolean isopen=false;
	
	
	
	public sildmenu(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		  WindowManager wm=(WindowManager)context.getSystemService(context.WINDOW_SERVICE);
		    //»ñÈ¡ÆÁÄ»¿í¶È
		    DisplayMetrics dm=new DisplayMetrics();
		    wm.getDefaultDisplay().getMetrics(dm);
		    ScreenWidth=dm.widthPixels;
	        
		    paddingright=(int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100,context.getResources().getDisplayMetrics());
	
		
	    
	    
	}
	public sildmenu(Context context, AttributeSet attrs) {
		  this(context, attrs,0);
		
	}
	public sildmenu(Context context) {
		this(context, null);
		
	}
	
	public void Toggle()
	{
		if(isopen)
		{
			this.smoothScrollTo(menuWidth, 0);
			
			isopen=false;
			return;
		}
		else{
			this.smoothScrollTo(0, 0);
			isopen=true;
			return;
		}
	}
	
	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		super.onInterceptTouchEvent( ev);
		int x=(int)ev.getX();
		if(x>50&&!isopen)
		 {
		    	return false;
		 }
		// super.onInterceptTouchEvent( ev);
		 return  super.onInterceptTouchEvent( ev);
		
	}
	@Override
	public boolean onTouchEvent(MotionEvent ev) {
	
		super.onTouchEvent(ev);
		int action=ev.getAction();
		int x=(int)ev.getX();
		switch(action)
		{
		  case MotionEvent.ACTION_DOWN:
			 if(x>50&&!isopen)
		     {
				  return false;
			 }
			  else{
				  return true;
			  }
		
		  case MotionEvent.ACTION_MOVE:
			  
		    break;
		  case MotionEvent.ACTION_UP:
			
			if(this.getScrollX()>menuWidth/2)
			{
				this.smoothScrollTo(menuWidth,0);
				isopen=false;
			}
			else{
				this.smoothScrollTo(0,0);
				isopen=true;
			}
			return true;
		}
	    return true;
	}
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		
		if(once)
		{
		   warp=(LinearLayout)this.getChildAt(0);
		   menu=(ViewGroup)warp.getChildAt(0);
		   content=(ViewGroup)warp.getChildAt(1);
		   content.getLayoutParams().width=ScreenWidth;
		   menuWidth=menu.getLayoutParams().width=ScreenWidth-paddingright;
		 
		   
		   
		   once=false;
		}
		
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}
	
	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		
		super.onLayout(changed, l, t, r, b);
		if(changed)
		{
		   this.scrollTo(menuWidth, 0);
		}
	}
	
	
	@SuppressLint("NewApi") @Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
	  
	
		content.getChildAt(0).setTranslationX(l-menuWidth);
		float alpha=l/menuWidth*0.5f+0.5f;
		content.setAlpha(alpha);
		super.onScrollChanged(l, t, oldl, oldt);
		
	}
	

}
