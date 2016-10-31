package com.ddhh.readonline.activity;

import java.util.List;

import com.ddhh.readonline.R;
import com.ddhh.readonline.presenter.ReadPresenter;
import com.ddhh.readonline.view.ResultView;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ReadActivity extends AppCompatActivity implements ResultView<String> {

	ProgressBar progressBar;

	TextView tv_name, tv_content;
	String section;
	String section_url;
	String content;
	ReadPresenter presenter = new ReadPresenter(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_read);
		initView();
		section = getIntent().getStringExtra("section");
		section_url = getIntent().getStringExtra("section_url");
		presenter.setData(section_url);
	}

	public void setData(String content) {

	}

	@Override
	public void showProgress() {
		if (progressBar != null) {
			progressBar.setVisibility(View.VISIBLE);
		}
	}

	@Override
	public void hiddenProgress() {
		if (progressBar != null) {
			progressBar.setVisibility(View.INVISIBLE);
		}
	}

	@Override
	public void initView() {
		progressBar = (ProgressBar) findViewById(R.id.progressBar);
		tv_name = (TextView) findViewById(R.id.tv_name);
		tv_content = (TextView) findViewById(R.id.tv_content);
	}

	@Override
	public void setAdapter() {
		tv_name.setText(section);
		String s = Html.fromHtml(content).toString()
				.replace("shipei_x()", "").replace("dudu", "");
		tv_content.setText(s);
	}

	@Override
	public void setList(List<String> list) {
		content = list.get(0);
	}

}
