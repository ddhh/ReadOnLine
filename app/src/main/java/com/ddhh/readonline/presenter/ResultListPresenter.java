package com.ddhh.readonline.presenter;

import java.util.List;

import com.ddhh.readonline.activity.ResultListActivity;
import com.ddhh.readonline.bean.SearchResultBean;
import com.ddhh.readonline.listener.OnResultListener;
import com.ddhh.readonline.model.ResultListModel;
import com.ddhh.readonline.model.ResultListModelImp;
import com.ddhh.readonline.view.ResultView;

public class ResultListPresenter {

	ResultView<SearchResultBean> view;
	ResultListModel<SearchResultBean> model;

	public ResultListPresenter(ResultView<SearchResultBean> view) {
		this.view = view;
		model = new ResultListModelImp();
	}

	public void setData(String q, String p) {
		view.showProgress();
		model.getSearchResult(q, p, new OnResultListener<SearchResultBean>() {

			@Override
			public void onSuccess(final List<SearchResultBean> list) {
				((ResultListActivity) view).runOnUiThread(new Runnable() {

					@Override
					public void run() {
						setAdapter(list);
						view.hiddenProgress();
					}
				});
			}

			@Override
			public void onFailure() {
				((ResultListActivity) view).finish();
			}
		});
	}

	public void setAdapter(List<SearchResultBean> list) {
		view.setList(list);
		view.setAdapter();
	}

}
