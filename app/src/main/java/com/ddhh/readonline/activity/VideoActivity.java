package com.ddhh.readonline.activity;

import com.ddhh.readonline.R;
import com.ddhh.readonline.widget.FullScreenVideoView;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.ProgressBar;

public class VideoActivity extends Activity implements OnCompletionListener,
		OnErrorListener, OnPreparedListener {

	private static final String TAG = "VideoActivity";

	FullScreenVideoView videoView;

	ProgressBar progressBar;

	MediaController controller;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏标题
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);// 设置全屏
		setContentView(R.layout.avticity_video);
		initView();
		videoView.setVideoURI(Uri.parse(getIntent().getStringExtra("tv_url")));
	}

	public void initView() {
		controller = new MediaController(this);
		progressBar = (ProgressBar) findViewById(R.id.progressBar);
		videoView = (FullScreenVideoView) findViewById(R.id.videoView);
		videoView.setMediaController(controller);
		videoView.setOnCompletionListener(this);
		videoView.setOnPreparedListener(this);
		videoView.setOnErrorListener(this);
	}

	@Override
	public void onCompletion(MediaPlayer arg0) {
		Log.i(TAG, "电视直播，希望有播放完的一天......");
	}

	@Override
	public boolean onError(MediaPlayer arg0, int arg1, int arg2) {
		finish();
		return true;
	}

	@Override
	public void onPrepared(MediaPlayer mp) {
		progressBar.setVisibility(View.GONE);
		//播放
		videoView.start();
	}
}
