package com.ddhh.readonline.activity;

import java.util.ArrayList;
import java.util.List;

import com.ddhh.readonline.R;
import com.ddhh.readonline.adapter.ResultListAdapter;
import com.ddhh.readonline.bean.SearchResultBean;
import com.ddhh.readonline.presenter.ResultListPresenter;
import com.ddhh.readonline.view.ResultView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.ProgressBar;

public class ResultListActivity extends AppCompatActivity implements ResultView<SearchResultBean>, OnItemClickListener{

	ListView result_list;
	
	ResultListAdapter adapter;
	
	ProgressBar progressBar;
	
	List<SearchResultBean> list = new ArrayList<SearchResultBean>();
	
	ResultListPresenter presenter = new ResultListPresenter(this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result_list_layout);
		initView();
		String queryStr = getIntent().getStringExtra("query");
		presenter.setData(queryStr, "0");
	}

	@Override
	public void initView() {
		progressBar = (ProgressBar) findViewById(R.id.progressBar);
		result_list = (ListView) findViewById(R.id.result_list);
		result_list.setOnItemClickListener(this);
	}

	@Override
	public void setAdapter() {
		adapter = new ResultListAdapter(this);
		adapter.setList(list);
		result_list.setAdapter(adapter);
	}

	@Override
	public void showProgress() {
		if(progressBar!=null){
			progressBar.setVisibility(View.VISIBLE);
		}
	}

	@Override
	public void hiddenProgress() {
		if(progressBar!=null){
			progressBar.setVisibility(View.INVISIBLE);
		}
	}

	@Override
	public void setList(List<SearchResultBean> list) {
		this.list = list;
	}

	
	
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		Intent intent = new Intent(this,IndexActivity.class);
		intent.putExtra("id", adapter.getList().get(arg2).getId());
		startActivity(intent);
	}
	
	
	
}
