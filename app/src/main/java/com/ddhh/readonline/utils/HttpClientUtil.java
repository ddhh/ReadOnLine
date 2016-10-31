package com.ddhh.readonline.utils;

import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class HttpClientUtil {

	private static final byte[] LOCKER = new byte[0];  
	private static HttpClientUtil mInstance;
	private OkHttpClient httpClient;
	private Request.Builder requestBuilder;
	private HttpClientUtil() {
		httpClient = new OkHttpClient.Builder()
				.connectTimeout(10, TimeUnit.SECONDS)
				.readTimeout(20, TimeUnit.SECONDS).build();
		requestBuilder = new Request.Builder();
	}
	
	public static HttpClientUtil getInstance(){
		if (mInstance == null) {  
            synchronized (LOCKER) {  
                if (mInstance == null) {  
                    mInstance = new HttpClientUtil();  
                }  
            }  
        }  
        return mInstance;  
	}
	
	public HttpClientUtil get(){
		requestBuilder.method("GET", null);
		return getInstance();
	}
	
	public HttpClientUtil post(){
		requestBuilder.method("POST", null);
		return getInstance();
	}
	
	public HttpClientUtil baseUrl(String url){
		requestBuilder.url(url);
		return getInstance();
	}

	public void call(Callback callback){
		if(httpClient!=null){
			Call call = httpClient.newCall(requestBuilder.build());
			call.enqueue(callback);
		}
	}
	
}
