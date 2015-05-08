package com.cust.myfragment;



import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;


import com.cust.uischool.R;

 @SuppressLint("NewApi") public class menu1fragment extends Fragment implements OnClickListener {
	   
	    private  ViewPager viewpager;
	   
	    private MyPagerAdapter pageradapter;
	    private ArrayList<Fragment> list;
	    
	    private Button button1;
	    private Button button2;
	    
	    private View viewline;
	    
	    private int Screenwidth;
	    
	    private int viewwidth;
	    @Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
		 
		    
		     
			View v=inflater.inflate(R.layout.fragment_menu1, container, false);
			button1=(Button)v.findViewById(R.id.button1);
			button2=(Button)v.findViewById(R.id.button2);
			button1.setOnClickListener(this);
			button2.setOnClickListener(this);
			viewline=(View)v.findViewById(R.id.line);
			Screenwidth=getActivity().getWindow().getWindowManager().getDefaultDisplay().getWidth();
			viewwidth=viewline.getLayoutParams().width=Screenwidth/2;
			
			viewpager=(ViewPager)v.findViewById(R.id.viewpager);
			if(list==null)
			{
				list=new ArrayList<Fragment>();
				musicfragment menu1=new musicfragment();
				menu3fragment menu2=new menu3fragment();
				list.add(menu1);
				list.add(menu2);
			}
		
			pageradapter=new MyPagerAdapter(getActivity().getSupportFragmentManager(),list);
			viewpager.setAdapter(pageradapter);
			viewpager.setOnPageChangeListener(pagechangelistener);
			viewpager.setCurrentItem(0);
			return v;
		}
	    
	    private OnPageChangeListener pagechangelistener=new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				
				viewline.setTranslationX(viewwidth*arg0);
				
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		};
	    
	    private class MyPagerAdapter extends FragmentPagerAdapter
	    {

	    	private ArrayList<Fragment> list;
			public MyPagerAdapter(FragmentManager fm,ArrayList<Fragment> list) {
				super(fm);
			    this.list=list;
			}

			@Override
			public Fragment getItem(int arg0) {
				// TODO Auto-generated method stub
				return list.get(arg0);
			}

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return list.size();
			}

		

		
	    	
	    }
		@Override
		public void onClick(View v) {
			
		
			switch(v.getId()){
			case R.id.button1:
				viewpager.setCurrentItem(0);
				break;
			case R.id.button2:
				viewpager.setCurrentItem(1);
				break;
			}
			
		}
	   
}
