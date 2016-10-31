package com.ddhh.readonline.presenter;

import java.util.List;

import com.ddhh.readonline.activity.ReadActivity;
import com.ddhh.readonline.listener.OnResultListener;
import com.ddhh.readonline.model.ReadModel;
import com.ddhh.readonline.model.ReadModelImp;
import com.ddhh.readonline.view.ResultView;

public class ReadPresenter {

	ResultView<String> view;
	
	ReadModel model;
	
	public ReadPresenter(ResultView<String> view){
		this.view = view;
		model = new ReadModelImp();
	}
	
	public void setData(String url){
		view.showProgress();
		model.getContentResult(url, new OnResultListener<String>() {
			
			@Override
			public void onSuccess(final List<String> list) {
				((ReadActivity)view).runOnUiThread(new Runnable() {
					@Override
					public void run() {
						view.setList(list);
						view.setAdapter();
						view.hiddenProgress();
					}
				});
			}
			
			@Override
			public void onFailure() {
				((ReadActivity)view).finish();
			}
		});
	}
	
}
