package com.ddhh.readonline.presenter;

import java.util.List;

import com.ddhh.readonline.activity.IndexActivity;
import com.ddhh.readonline.bean.IndexBean;
import com.ddhh.readonline.listener.OnResultListener;
import com.ddhh.readonline.model.IndexModel;
import com.ddhh.readonline.model.IndexModelImp;
import com.ddhh.readonline.view.ResultView;

public class IndexPresenter {

	ResultView<IndexBean> view;
	
	IndexModel model;
	
	public IndexPresenter(ResultView<IndexBean> view){
		this.view = view;
		model = new IndexModelImp();
	}
	
	public void setData(String url){
		view.showProgress();
		model.getIndexResult(url, new OnResultListener<IndexBean>() {
			
			@Override
			public void onSuccess(final List<IndexBean> list) {
				((IndexActivity)view).runOnUiThread(new Runnable() {
					
					@Override
					public void run() {
						setAdapter(list);
						view.hiddenProgress();
					}
				});
			}
			
			@Override
			public void onFailure() {
				((IndexActivity)view).finish();
			}
		});
	}
	public void setAdapter(List<IndexBean> list) {
		view.setList(list);
		view.setAdapter();
	}
}
