package com.ddhh.readonline.model;

import com.ddhh.readonline.listener.OnResultListener;

public interface ReadModel {

	void getContentResult(String url, final OnResultListener<String> listener);
	
}
