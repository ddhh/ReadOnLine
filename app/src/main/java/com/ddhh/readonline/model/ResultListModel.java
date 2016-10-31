package com.ddhh.readonline.model;

import com.ddhh.readonline.listener.OnResultListener;

public interface ResultListModel<T> {
	void getSearchResult(String q, String p, final OnResultListener<T> listener);
}
