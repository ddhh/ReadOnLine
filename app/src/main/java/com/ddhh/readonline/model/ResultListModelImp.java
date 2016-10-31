package com.ddhh.readonline.model;

import java.io.IOException;

import com.ddhh.readonline.bean.SearchResultBean;
import com.ddhh.readonline.common.Constant;
import com.ddhh.readonline.listener.OnResultListener;
import com.ddhh.readonline.utils.HttpClientUtil;
import com.ddhh.readonline.utils.JsoupUtil;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Response;

public class ResultListModelImp implements ResultListModel<SearchResultBean> {

	OkHttpClient httpClient;

	String url;

	@Override
	public void getSearchResult(String q, String p,final OnResultListener<SearchResultBean> listener) {

		url = Constant.BASE_SEARCH_URL + "?q=" + q + "&p=" + p + "&s="
				+ Constant.S;
		
		HttpClientUtil.getInstance().get().baseUrl(url).call(new Callback() {
			
			@Override
			public void onResponse(Call arg0, final Response arg1) throws IOException {
				if (arg1.isSuccessful()) {
					listener.onSuccess(JsoupUtil.paraseHtmlToResult(arg1.body().string()));
				}
			}

			@Override
			public void onFailure(Call arg0, IOException arg1) {
				listener.onFailure();
			}
		});
		
	}
	
}
