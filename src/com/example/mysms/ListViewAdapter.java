package com.example.mysms;



import java.util.ArrayList;
import java.math.BigDecimal;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class ListViewAdapter extends BaseAdapter{
	ArrayList<SmsInfo> smsInfos;
	private Context        context;

	public ListViewAdapter(ArrayList<SmsInfo> smsInfos, Context context) {
		this.smsInfos  = smsInfos;
		this.context      = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return smsInfos.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return smsInfos.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		SmsInfo smsInfo = smsInfos.get(position);
					
		ViewHolder holder;
		if (convertView != null) {
			holder = (ViewHolder) convertView.getTag();
		} else {
			holder        = new ViewHolder();
			convertView   = View.inflate(context, R.layout.list_view_item, null);
			
			holder.item_value   = (TextView) convertView.findViewById(R.id.textView1);
			
			convertView.setTag(holder);
		}

		holder.item_value.setText(smsInfo.getSmsbody());

		return convertView;
	}

	class ViewHolder {
		private TextView item_date,item_value,item_week;
	}

}
