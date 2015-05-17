package com.cust.uischool;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.cust.myfragment.menu1fragment;
import com.cust.myfragment.menu2fragment;
import com.cust.myfragment.menu3fragment;
import com.cust.myfragment.menu4fragment;
import com.cust.myview.sildmenu;

public class MainActivity extends FragmentActivity implements OnClickListener {

	private OnClickListener l = new OnClickListener() {

		@Override
		public void onClick(View v) {

			menu.Toggle();

		}

	};

	private sildmenu menu;

	private RelativeLayout menu1;
	private RelativeLayout menu2;
	private RelativeLayout menu3;
	private RelativeLayout menu4;

	private ImageView img_menu;

	private menu1fragment fragmentmenu1;
	private menu2fragment fragmentmenu2;
	private menu3fragment fragmentmenu3;
	private menu4fragment fragmentmenu4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		InitView();
		if (savedInstanceState == null) {
			fragmentmenu1 = new menu1fragment();

			getSupportFragmentManager().beginTransaction()
					.replace(R.id.fragment_container, fragmentmenu1).commit();
		}

		menu1.setBackgroundResource(R.drawable.setting_strip_bg_unpressed);
		menu2.setBackgroundResource(R.drawable.setting_strip_bg_unpressed);
		menu3.setBackgroundResource(R.drawable.setting_strip_bg_unpressed);
		menu4.setBackgroundResource(R.drawable.setting_strip_bg_unpressed);

		menu1.setBackgroundResource(R.drawable.setting_strip_bg_pressed);

	}

	private void InitView() {
		menu = (sildmenu) this.findViewById(R.id.menu);
		menu1 = (RelativeLayout) this.findViewById(R.id.menu1);
		menu2 = (RelativeLayout) this.findViewById(R.id.menu2);
		menu3 = (RelativeLayout) this.findViewById(R.id.menu3);
		menu4 = (RelativeLayout) this.findViewById(R.id.menu4);
		img_menu = (ImageView) this.findViewById(R.id.img_menu);

		menu1.setOnClickListener(this);
		menu2.setOnClickListener(this);
		menu3.setOnClickListener(this);
		menu4.setOnClickListener(this);

		img_menu.setOnClickListener(l);
	}

	private void hiddeall(FragmentTransaction ft) {

		menu1.setBackgroundResource(R.drawable.setting_strip_bg_unpressed);
		menu2.setBackgroundResource(R.drawable.setting_strip_bg_unpressed);
		menu3.setBackgroundResource(R.drawable.setting_strip_bg_unpressed);
		menu4.setBackgroundResource(R.drawable.setting_strip_bg_unpressed);
		if (fragmentmenu1 != null) {
			ft.hide(fragmentmenu1);
		}
		if (fragmentmenu2 != null) {
			ft.hide(fragmentmenu2);
		}
		if (fragmentmenu3 != null) {
			ft.hide(fragmentmenu3);
		}
		if (fragmentmenu4 != null) {
			ft.hide(fragmentmenu4);
		}

	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {

		return super.onTouchEvent(event);
	}

	@Override
	public void onClick(View v) {

		FragmentManager fm = this.getSupportFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		hiddeall(ft);
		switch (v.getId()) {

		case R.id.menu1:
			if (fragmentmenu1 != null) {
				ft.show(fragmentmenu1);

			} else {

				fragmentmenu1 = new menu1fragment();
				ft.add(R.id.fragment_container, fragmentmenu1);

			}

			menu1.setBackgroundResource(R.drawable.setting_strip_bg_pressed);
			break;
		case R.id.menu2:

			if (fragmentmenu2 != null) {
				ft.show(fragmentmenu2);

			} else {

				fragmentmenu2 = new menu2fragment();
				ft.add(R.id.fragment_container, fragmentmenu2);

			}
			menu2.setBackgroundResource(R.drawable.setting_strip_bg_pressed);
			break;
		case R.id.menu3:

			if (fragmentmenu3 != null) {
				ft.show(fragmentmenu3);

			} else {

				fragmentmenu3 = new menu3fragment();
				ft.add(R.id.fragment_container, fragmentmenu3);

			}
			menu3.setBackgroundResource(R.drawable.setting_strip_bg_pressed);
			break;
		case R.id.menu4:
			if (fragmentmenu4 != null) {
				ft.show(fragmentmenu4);

			} else {

				fragmentmenu4 = new menu4fragment();
				ft.add(R.id.fragment_container, fragmentmenu4);

			}
			menu4.setBackgroundResource(R.drawable.setting_strip_bg_pressed);
			break;
		}
		ft.commit();
		menu.Toggle();

	}

}
