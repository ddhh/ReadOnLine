package com.ddhh.readonline.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.ddhh.readonline.R;
import com.ddhh.readonline.adapter.IndexAdapter;
import com.ddhh.readonline.bean.IndexBean;
import com.ddhh.readonline.presenter.IndexPresenter;
import com.ddhh.readonline.view.ResultView;

public class IndexActivity extends AppCompatActivity implements ResultView<IndexBean>, OnItemClickListener{

	ListView listview;
	IndexAdapter adapter;
	ProgressBar progressBar;
	
	List<IndexBean> list = new ArrayList<IndexBean>();
	
	IndexPresenter presenter = new IndexPresenter(this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_index);
		initView();
		String id = getIntent().getStringExtra("id");
		presenter.setData("http://m.qu.la/booklist/"+id+".html");
	}
	
	@Override
	public void initView() {
		listview = (ListView) findViewById(R.id.index_list);
		listview.setOnItemClickListener(this);
		progressBar = (ProgressBar) findViewById(R.id.progressBar);
	}

	@Override
	public void setAdapter() {
		adapter = new IndexAdapter(this);
		adapter.setList(list);
		listview.setAdapter(adapter);
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
//
	@Override
	public void setList(List<IndexBean> list) {
		this.list = list;
	}
	
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		Intent intent = new Intent(this,ReadActivity.class);
		intent.putExtra("section_url", adapter.getList().get(arg2).getSection_url());
		intent.putExtra("section", adapter.getList().get(arg2).getSection());
		startActivity(intent);
	}

}
