package com.ddhh.readonline.view;

public interface MainView {

	void initView();
	
	String getQueryString();
	
	void startActivity(String query);
	
	void showCancel();
	void hiddenCancel();
	
}
