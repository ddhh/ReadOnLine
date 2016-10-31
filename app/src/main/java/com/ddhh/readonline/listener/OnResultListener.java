package com.ddhh.readonline.listener;

import java.util.List;

public interface OnResultListener<T> {

	void onSuccess(List<T> list);
	void onFailure();
	
}
