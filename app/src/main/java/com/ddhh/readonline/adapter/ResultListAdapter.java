package com.ddhh.readonline.adapter;

import java.util.List;

import com.bumptech.glide.Glide;
import com.ddhh.readonline.R;
import com.ddhh.readonline.bean.SearchResultBean;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultListAdapter extends BaseAdapter{

	Context context;
	List<SearchResultBean> list;
	public ResultListAdapter(Context context){
		this.context = context;
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
		
		ResultListItemHolder holder;
		if(arg1==null){
			arg1 = LayoutInflater.from(context).inflate(R.layout.result_list_item, arg2,false);
			holder = new ResultListItemHolder(arg1);
			arg1.setTag(holder);
		}else{
			holder = (ResultListItemHolder)arg1.getTag();
		}
		SearchResultBean rrb = list.get(arg0);
		Glide.with(context).load(rrb.getCrossUrl()).into(holder.cross_image);
		holder.tv_name.setText(rrb.getName());
		holder.tv_desc.setText(rrb.getDesc());
		holder.tv_author.setText(rrb.getAuthor());
		holder.tv_type.setText(rrb.getType());
		holder.tv_section.setText(rrb.getSection());
		holder.tv_time.setText(rrb.getTime());
		return arg1;
	}
	
	public void setList(List<SearchResultBean> list){
		this.list = list;
	}
	
	public List<SearchResultBean> getList(){
		return this.list;
	}
	class ResultListItemHolder{
		ImageView cross_image;
		TextView tv_name,tv_desc,tv_author,tv_type,tv_section,tv_time;
		public ResultListItemHolder(View itemView){
			cross_image = (ImageView) itemView.findViewById(R.id.cross_image);
			tv_name = (TextView) itemView.findViewById(R.id.tv_name);
			tv_desc = (TextView) itemView.findViewById(R.id.tv_desc);
			tv_author = (TextView) itemView.findViewById(R.id.tv_author);
			tv_type = (TextView) itemView.findViewById(R.id.tv_type);
			tv_section = (TextView) itemView.findViewById(R.id.tv_section);
			tv_time = (TextView) itemView.findViewById(R.id.tv_time);
		}
	}

}
