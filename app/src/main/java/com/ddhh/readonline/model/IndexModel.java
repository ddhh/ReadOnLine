package com.ddhh.readonline.model;

import com.ddhh.readonline.bean.IndexBean;
import com.ddhh.readonline.listener.OnResultListener;

public interface IndexModel {

	void getIndexResult(String url, final OnResultListener<IndexBean> listener);
	
}
