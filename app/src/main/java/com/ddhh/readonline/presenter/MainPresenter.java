package com.ddhh.readonline.presenter;

import com.ddhh.readonline.view.MainView;

public class MainPresenter {

	MainView view;
	
	public MainPresenter(MainView view){
		this.view = view;
	}
	
	public String getQueryStr(){
		return view.getQueryString();
	}
	
	public void startActivity(){
		view.startActivity(getQueryStr());
	}
	
}
