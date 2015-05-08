package com.cust.service;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;

import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

public class musicservice extends Service implements OnBufferingUpdateListener,
		OnCompletionListener, OnPreparedListener {

	private MediaPlayer player;

	private Timer timer = new Timer();

	private int state = 0;
	private String id;

	private TimerTask timertask = new TimerTask() {

		@Override
		public void run() {

			if (player == null) {
				return;
			}
			if (player.isPlaying()) {
				int position = player.getCurrentPosition();
				int dir = player.getDuration();
				Intent intent = new Intent();
				intent.setAction("update");
				intent.putExtra("id", id);
				intent.putExtra("jd", position / dir);
				sendBroadcast(intent);
			}
		}

	};

//	private Handler handler = new Handler() {
//
//		public void handleMessage(android.os.Message msg) {
//
//			
//
//		}
//
//	};

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {

		super.onCreate();
		try {
			player = new MediaPlayer();
			player.setAudioStreamType(AudioManager.STREAM_MUSIC); // 设置媒体流类型
			player.setOnCompletionListener(this);
			player.setOnPreparedListener(this);
			player.setOnBufferingUpdateListener(this);
			
	        timer.schedule(timertask, 0,1000);
		} catch (Exception e) {

		}

	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {

		final String url = intent.getStringExtra("url");
		 id = intent.getStringExtra("id");

		Log.v("setview", url);
		if (state == 0) {

			try {
				player.reset();
				player.setDataSource(url);
				player.prepare();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return super.onStartCommand(intent, flags, startId);

	}

	@Override
	public void onDestroy() {

		super.onDestroy();
	}

	@Override
	public void onPrepared(MediaPlayer mp) {

		player.start();
	}

	@Override
	public void onCompletion(MediaPlayer mp) {

	}

	@Override
	public void onBufferingUpdate(MediaPlayer mp, int percent) {

	}

}
