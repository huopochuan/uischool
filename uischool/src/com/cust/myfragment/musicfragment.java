package com.cust.myfragment;

import java.util.ArrayList;
import java.util.List;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.cust.model.musicitem;
import com.cust.service.musicservice;
import com.cust.uischool.R;

public class musicfragment extends Fragment {

	private ListView listview;
	
	private MyAdapter adapter;
	
	private musicReceiver receiver;
	
	private List<musicitem> data;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View v=inflater.inflate(R.layout.fragment_music, container, false);
		listview =(ListView)v.findViewById(R.id.lv_music);
		
		data=new ArrayList<musicitem>();
		data.add(new musicitem(1,"","","","","","http://abv.cn/music/π‚ª‘ÀÍ‘¬.mp3","","",""));
		
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
			
			String id=intent.getStringExtra("id");
			String jd=intent.getStringExtra("jd");
			
			adapter.upadteview(Integer.parseInt(id), Integer.parseInt(jd));
			
		}
		
	}
	
	private class MyAdapter extends BaseAdapter
	{

		private LayoutInflater inflater;
		private Context context;
		private List<musicitem> data;
		private int posit=0;
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
        public void upadteview(int pos,int jd)
        {
        	this.posit=pos;
        	this.jd=jd;
        	this.notify();
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
			
			ViewHolder holder=null;
			if(convertView==null)
			{
				convertView=inflater.inflate(R.layout.item_music, null);
				holder=new ViewHolder(convertView);
				convertView.setTag(holder);
				data.get(position).setPos(position+"");
			}
			holder=(ViewHolder)convertView.getTag();
			holder.setDate(data.get(position));
			if(position==posit)
			{
				holder.seekbar.setProgress(holder.seekbar.getMax()*jd);
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
			}
            public void setDate(musicitem item)
            {
            	this.item=item;
            	tv_pl.setText(item.getPlcount());
            }
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(getActivity(),musicservice.class);
				
				intent.putExtra("id", item.getId());
				intent.putExtra("url", item.getMusicurl());
				getActivity().startService(intent);
			}
			
			
			
		} 
	}
}
