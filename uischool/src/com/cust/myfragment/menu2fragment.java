package com.cust.myfragment;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cust.uischool.R;;

 public class menu2fragment extends Fragment {
	 @Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
		  ImageView img =new ImageView(this.getActivity());
		     img.setBackgroundResource(R.drawable.img2);
		     
			//View v=inflater.inflate(R.layout.fragment_main, container, false);
			
			return img;
		}
}
