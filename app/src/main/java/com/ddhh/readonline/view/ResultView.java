package com.ddhh.readonline.view;

import java.util.List;

public interface ResultView<T> {

	void initView();
	void setAdapter();
	void showProgress();
	void hiddenProgress();
	
	void setList(List<T> list);
}
