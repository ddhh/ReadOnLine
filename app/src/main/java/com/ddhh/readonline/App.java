package com.ddhh.readonline;

import android.app.Application;

import cn.sharesdk.framework.ShareSDK;

public class App extends Application{

	@Override
	public void onCreate() {
		super.onCreate();
		ShareSDK.initSDK(this,"188761fd38930");
	}

}
