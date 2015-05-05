package com.cust.myview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
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
	
	
	public sildmenu(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		  WindowManager wm=(WindowManager)context.getSystemService(context.WINDOW_SERVICE);
		    //»ñÈ¡ÆÁÄ»¿í¶È
		    DisplayMetrics dm=new DisplayMetrics();
		    wm.getDefaultDisplay().getMetrics(dm);
		    ScreenWidth=dm.widthPixels;
	        
		    paddingright=(int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50,context.getResources().getDisplayMetrics());
	
		
	    
	    
	}
	public sildmenu(Context context, AttributeSet attrs) {
		  this(context, attrs,0);
		
	}
	public sildmenu(Context context) {
		this(context, null);
		
	}
	@Override
	public boolean onTouchEvent(MotionEvent ev) {
	
		int action=ev.getAction();
		switch(action)
		{
		  case MotionEvent.ACTION_DOWN:
			break;
		  case MotionEvent.ACTION_MOVE:
		    break;
		  case MotionEvent.ACTION_UP:
			if(this.getScrollX()>menuWidth/2)
			{
				this.smoothScrollTo(menuWidth,0);
			}
			else{
				this.smoothScrollTo(0,0);
			}
			return true;
		}
		return super.onTouchEvent(ev);
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
	    Log.v("Tag", ""+(l-menuWidth));
		//content.setPadding(l-menuWidth,content.getPaddingTop(), content.getPaddingRight(), content.getPaddingBottom());
		//content.invalidate();
		//content.requestLayout();
	//	content.getChildAt(0).scrollTo(menuWidth-l, 0);
		content.getChildAt(0).setTranslationX(l-menuWidth);
		super.onScrollChanged(l, t, oldl, oldt);
		
	}
	

}
