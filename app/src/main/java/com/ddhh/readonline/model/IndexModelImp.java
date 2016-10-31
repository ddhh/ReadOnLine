package com.ddhh.readonline.model;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import com.ddhh.readonline.bean.IndexBean;
import com.ddhh.readonline.listener.OnResultListener;
import com.ddhh.readonline.utils.HttpClientUtil;
import com.ddhh.readonline.utils.JsoupUtil;

public class IndexModelImp implements IndexModel{

	
	@Override
	public void getIndexResult(String url,final OnResultListener<IndexBean> listener) {
		
		HttpClientUtil.getInstance().get().baseUrl(url).call(new Callback() {
			
			@Override
			public void onResponse(Call arg0, Response arg1) throws IOException {
				if(arg1.isSuccessful()){
					byte[] b = arg1.body().bytes();
					String html = new String(b,"gbk");
					listener.onSuccess(JsoupUtil.paraseHtmlToIndex(html));
				}
			}
			
			@Override
			public void onFailure(Call arg0, IOException arg1) {
				listener.onFailure();
			}
		});
		
	}

}
