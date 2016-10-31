package com.ddhh.readonline.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import com.ddhh.readonline.listener.OnResultListener;
import com.ddhh.readonline.utils.HttpClientUtil;
import com.ddhh.readonline.utils.JsoupUtil;

public class ReadModelImp implements ReadModel{

	@Override
	public void getContentResult(String url,final OnResultListener<String> listener) {
		HttpClientUtil.getInstance().get().baseUrl(url).call(new Callback() {
			
			@Override
			public void onResponse(Call arg0, Response arg1) throws IOException {
				List<String> list = new ArrayList<String>();
				String html = new String(arg1.body().bytes(),"gbk");
				String content = JsoupUtil.paraseHtmlToContent(html);
				list.add(content);
				listener.onSuccess(list);
			}
			
			@Override
			public void onFailure(Call arg0, IOException arg1) {
				listener.onFailure();
			}
		});
	}

}
