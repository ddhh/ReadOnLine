package com.ddhh.readonline.adapter;

import java.util.List;

import com.ddhh.readonline.R;
import com.ddhh.readonline.bean.IndexBean;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class IndexAdapter extends BaseAdapter{

	
	Context context;
	List<IndexBean> list;
	
	public IndexAdapter(Context context){
		this.context = context;
	}
	
	public void setList(List<IndexBean> list){
		this.list = list;
	}
	public List<IndexBean> getList(){
		return list;
	}
	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		
		IndexItemHolder holder;
		if(arg1==null){
			
			arg1 = LayoutInflater.from(context).inflate(R.layout.index_list_item, arg2, false);
			holder = new IndexItemHolder(arg1);
			arg1.setTag(holder);
			
		}else{
			holder = (IndexItemHolder)arg1.getTag();
		}
		holder.tv_index.setText(list.get(arg0).getSection());
		return arg1;
	}

	class IndexItemHolder{
		TextView tv_index;
		public IndexItemHolder(View view){
			tv_index = (TextView)view.findViewById(R.id.tv_index);
		}
	}
	
}
