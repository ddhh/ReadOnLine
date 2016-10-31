package com.ddhh.readonline.activity;

import com.ddhh.readonline.common.Constant;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TVListActivity extends ListActivity{

	ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		listView = getListView();
		listView.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, Constant.TV_NAME));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Intent intent = new Intent(this,VideoActivity.class);
		intent.putExtra("tv_url", Constant.TV_LIST.get(position));
		startActivity(intent);
	}
}
