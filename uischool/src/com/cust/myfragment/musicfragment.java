package com.cust.myfragment;

import java.util.ArrayList;
import java.util.List;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.cust.model.musicitem;
import com.cust.service.musicservice;
import com.cust.tools.ImageLoader;
import com.cust.tools.LoadImageTask;
import com.cust.tools.LoadImageTask.Callback;
import com.cust.uischool.R;
public class musicfragment extends Fragment implements OnRefreshListener {

	private ListView listview;
	
	private MyAdapter adapter;
	
	private musicReceiver receiver;
	
	private List<musicitem> data;
	
	private int pos;
	
	private int type; //0表示最新 1表示最热
	private SwipeRefreshLayout swipeLayout;
	
	
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View v=inflater.inflate(R.layout.fragment_music, container, false);
		listview =(ListView)v.findViewById(R.id.lv_music);
		
		 swipeLayout = (SwipeRefreshLayout) v.findViewById(R.id.swipe_container);
		    swipeLayout.setOnRefreshListener(this);
		    swipeLayout.setColorScheme(android.R.color.holo_blue_bright, 
		            android.R.color.holo_green_light, 
		            android.R.color.holo_orange_light, 
		            android.R.color.holo_red_light);
		
		
		data=new ArrayList<musicitem>();
		

        data.add(new musicitem(2,"http://pic8.qiyipic.com/image/20150414/12/83/v_109079087_m_601_160_90.jpg", "", "左耳 电影《左耳》主题曲", "作词：林夕\r\n作曲：王宗贤\r\n演唱：赵薇", "", "http://112.126.65.202/ipush/images/2403730813600128.mp3", "", "", 2 + ""));
        data.add(new musicitem(2,"http://112.126.65.202/ipush/file/92015030716233116760.jpeg", "", "左耳 电影《左耳》主题曲", "作词：林夕\r\n作曲：王宗贤\r\n演唱：赵薇", "", "http://112.126.65.202/ipush/images/2403730813600128.mp3", "", "", 2 + ""));    
        data.add(new musicitem(2,"http://112.126.65.202/ipush/file/92015030716233116760.jpeg", "", "左耳 电影《左耳》主题曲", "作词：林夕\r\n作曲：王宗贤\r\n演唱：赵薇", "", "http://112.126.65.202/ipush/images/2403730813600128.mp3", "", "", 2+ ""));
        data.add(new musicitem(2,"http://112.126.65.202/ipush/file/92015030716233118321.jpeg", "", "左耳 电影《左耳》主题曲", "作词：林夕\r\n作曲：王宗贤\r\n演唱：赵薇", "", "http://112.126.65.202/ipush/images/2403730813600128.mp3", "", "", 2+ ""));
        data.add(new musicitem(2,"http://112.126.65.202/ipush/file/92015030716233118321.jpeg", "", "左耳 电影《左耳》主题曲", "作词：林夕\r\n作曲：王宗贤\r\n演唱：赵薇", "", "http://112.126.65.202/ipush/images/2403730813600128.mp3", "", "", 2+ ""));
        data.add(new musicitem(2,"http://112.126.65.202/ipush/file/92015030716233116760.jpeg", "", "左耳 电影《左耳》主题曲", "作词：林夕\r\n作曲：王宗贤\r\n演唱：赵薇", "", "http://112.126.65.202/ipush/images/2403730813600128.mp3", "", "", 2+ ""));
        data.add(new musicitem(2,"http://112.126.65.202/ipush/file/92015030716233116760.jpeg", "", "左耳 电影《左耳》主题曲", "作词：林夕\r\n作曲：王宗贤\r\n演唱：赵薇", "", "http://112.126.65.202/ipush/images/2403730813600128.mp3", "", "", 2+ ""));
        data.add(new musicitem(2,"http://112.126.65.202/ipush/file/92015030716233116760.jpeg", "", "左耳 电影《左耳》主题曲", "作词：林夕\r\n作曲：王宗贤\r\n演唱：赵薇", "", "http://112.126.65.202/ipush/images/2403730813600128.mp3", "", "", 2+ ""));
        data.add(new musicitem(2,"http://112.126.65.202/ipush/file/92015030716233116760.jpeg", "", "左耳 电影《左耳》主题曲", "作词：林夕\r\n作曲：王宗贤\r\n演唱：赵薇", "", "http://112.126.65.202/ipush/images/2403730813600128.mp3", "", "", 2+ ""));
        data.add(new musicitem(2,"http://112.126.65.202/ipush/file/92015030716233116760.jpeg", "", "左耳 电影《左耳》主题曲", "作词：林夕\r\n作曲：王宗贤\r\n演唱：赵薇", "", "http://112.126.65.202/ipush/images/2403730813600128.mp3", "", "", 2+ ""));
        data.add(new musicitem(2,"http://112.126.65.202/ipush/file/92015030716233116760.jpeg", "", "左耳 电影《左耳》主题曲", "作词：林夕\r\n作曲：王宗贤\r\n演唱：赵薇", "", "http://112.126.65.202/ipush/images/2403730813600128.mp3", "", "", 2+ ""));
        data.add(new musicitem(2,"http://pic8.qiyipic.com/image/20150414/12/83/v_109079087_m_601_160_90.jpg", "", "左耳 电影《左耳》主题曲", "作词：林夕\r\n作曲：王宗贤\r\n演唱：赵薇", "", "http://112.126.65.202/ipush/images/2403730813600128.mp3", "", "", 2+ ""));
        data.add(new musicitem(2,"http://pic8.qiyipic.com/image/20150414/12/83/v_109079087_m_601_160_90.jpg", "", "左耳 电影《左耳》主题曲", "作词：林夕\r\n作曲：王宗贤\r\n演唱：赵薇", "", "http://112.126.65.202/ipush/images/2403730813600128.mp3", "", "", 2+ ""));
        data.add(new musicitem(2,"http://pic8.qiyipic.com/image/20150414/12/83/v_109079087_m_601_160_90.jpg", "", "左耳 电影《左耳》主题曲", "作词：林夕\r\n作曲：王宗贤\r\n演唱：赵薇", "", "http://112.126.65.202/ipush/images/2403730813600128.mp3", "", "", 2+ ""));
        data.add(new musicitem(2,"http://pic8.qiyipic.com/image/20150414/12/83/v_109079087_m_601_160_90.jpg", "", "左耳 电影《左耳》主题曲", "作词：林夕\r\n作曲：王宗贤\r\n演唱：赵薇", "", "http://112.126.65.202/ipush/images/2403730813600128.mp3", "", "", 2+ ""));
        data.add(new musicitem(2,"http://pic8.qiyipic.com/image/20150414/12/83/v_109079087_m_601_160_90.jpg", "", "左耳 电影《左耳》主题曲", "作词：林夕\r\n作曲：王宗贤\r\n演唱：赵薇", "", "http://112.126.65.202/ipush/images/2403730813600128.mp3", "", "", 2+ ""));
        data.add(new musicitem(2,"http://pic8.qiyipic.com/image/20150414/12/83/v_109079087_m_601_160_90.jpg", "", "左耳 电影《左耳》主题曲", "作词：林夕\r\n作曲：王宗贤\r\n演唱：赵薇", "", "http://112.126.65.202/ipush/images/2403730813600128.mp3", "", "", 2+ ""));
        data.add(new musicitem(2,"http://pic8.qiyipic.com/image/20150414/12/83/v_109079087_m_601_160_90.jpg", "", "左耳 电影《左耳》主题曲", "作词：林夕\r\n作曲：王宗贤\r\n演唱：赵薇", "", "http://112.126.65.202/ipush/images/2403730813600128.mp3", "", "", 2+ ""));
        data.add(new musicitem(2,"http://pic8.qiyipic.com/image/20150414/12/83/v_109079087_m_601_160_90.jpg", "", "左耳 电影《左耳》主题曲", "作词：林夕\r\n作曲：王宗贤\r\n演唱：赵薇", "", "http://112.126.65.202/ipush/images/2403730813600128.mp3", "", "", 2+ ""));
        data.add(new musicitem(2,"http://pic8.qiyipic.com/image/20150414/12/83/v_109079087_m_601_160_90.jpg", "", "左耳 电影《左耳》主题曲", "作词：林夕\r\n作曲：王宗贤\r\n演唱：赵薇", "", "http://112.126.65.202/ipush/images/2403730813600128.mp3", "", "", 2+ ""));
		adapter=new MyAdapter(getActivity(),data);
		
		

		listview.setAdapter(adapter);
		
		receiver=new musicReceiver();
		
		IntentFilter filter=new IntentFilter();
		filter.addAction("update");
		getActivity().registerReceiver(receiver, filter);
		return v;
	}
	
	private class musicReceiver extends BroadcastReceiver
	{

		@Override
		public void onReceive(Context context, Intent intent) {
			

			String jd=intent.getStringExtra("jd");

			Log.v("receiver jd",jd);
			adapter.upadteview(Integer.parseInt(jd));
			
		}
		
	}
	@Override
	public void onDestroy() {
		getActivity().unregisterReceiver(receiver);
		super.onDestroy();
	}
	private class MyAdapter extends BaseAdapter implements OnScrollListener
	{

		private LayoutInflater inflater;
		private Context context;
		private List<musicitem> data;
	
		private int jd=0;
		
		public  MyAdapter(Context context,List<musicitem> data)
		{
			this.context=context;
			this.data=data;
			inflater=LayoutInflater.from(context);
		}
		@Override
		public int getCount() {
			
			return data.size();
		}
        public void upadteview(int jd)
        {
        
        	this.jd=jd;
         	this.notifyDataSetChanged();
        }
		@Override
		public Object getItem(int position) {
		
			return null;
		}

		@Override
		public long getItemId(int position) {
		
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {


            Log.v("position item",position+"");
			ViewHolder holder=null;
			if(convertView==null)
			{
				convertView=inflater.inflate(R.layout.item_music, null);
				holder=new ViewHolder(convertView);
				convertView.setTag(holder);
				
			}
			data.get(position).setPos(position+"");
			holder=(ViewHolder)convertView.getTag();
			holder.setDate(data.get(position));
		
			if(position==pos)
			{
				holder.seekbar.setProgress(jd);
			}
            else{
                //view 澶嶇敤
                holder.seekbar.setProgress(0);
            }
			
			
			
			return convertView;
		}
		private class ViewHolder implements OnClickListener{
			private ImageView img_music;
			private ImageView img_user;
			private TextView tv_pl;
			private TextView tv_zan;
			private TextView tv_username;
			private TextView tv_bt;
			private TextView tv_bz;
			public SeekBar seekbar;
			private musicitem item;
			public ViewHolder(View v)
			{
				  img_music=(ImageView)v.findViewById(R.id.img_music);
			
				  img_music.setOnClickListener(this);
				  
				  
				  img_user=(ImageView)v.findViewById(R.id.img_user);
				  tv_pl=(TextView)v.findViewById(R.id.tv_pl);
				  tv_zan=(TextView)v.findViewById(R.id.tv_zan);
				  tv_username=(TextView)v.findViewById(R.id.tv_username);
				  tv_bt=(TextView)v.findViewById(R.id.tv_bt);
				  tv_bz=(TextView)v.findViewById(R.id.tv_bz);
				  seekbar=(SeekBar)v.findViewById(R.id.seekbar);
				  seekbar.setMax(100);
                  seekbar.setProgress(0);
                 
			}
            public void setDate(final musicitem item)
            {
            	this.item=item;
            	tv_pl.setText(item.getPlcount());
            	tv_zan.setText(item.getZancont());
            	tv_username.setText(item.getUsername());
            	tv_bt.setText(item.getBt());
            	tv_bz.setText(item.getBz());
                img_music.setTag(item.getMusicphoto());
          	 
            	LoadImageTask task =new LoadImageTask(new Callback() {
					
					@Override
					public void updateImageView(Bitmap map) {
						if(img_music.getTag().equals(item.getMusicphoto()))
						{
							Log.v("photo",item.getMusicphoto());
							Log.v("map","map");
							if(map!=null)
							{
							   Bitmap map1=ImageLoader.getInstance().zoomBitmap(map, img_music.getWidth());
							   ImageLoader.getInstance().putBitmap(item.getMusicphoto(),map1);
							   img_music.setImageBitmap(map);
							}
							else
							{
							   img_music.setBackgroundResource(R.drawable.default_iv_loading);
							}
						}
					}
				});
            	task.execute(item.getMusicphoto());
            	
            }
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(getActivity(),musicservice.class);
				pos=Integer.parseInt(item.getPos());

				intent.putExtra("url", item.getMusicurl());
				getActivity().startService(intent);
			}
			
			
			
		}
		@Override
		public void onScroll(AbsListView arg0, int arg1, int arg2, int arg3) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void onScrollStateChanged(AbsListView arg0, int arg1) {
			// TODO Auto-generated method stub
			
		} 
	}
	@Override
	public void onRefresh() {
		 new Handler().postDelayed(new Runnable() {
		        @Override public void run() {
		            swipeLayout.setRefreshing(false);
		        }
		    }, 5000);
		
	}
}
