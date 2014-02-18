package com.example.mysms;

import java.util.ArrayList;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {

	ListView listView;
	SharedPreferences      preferences;
	ArrayList<SmsInfo> smsInfos;/**
	 * 所有的短信
	 */
	public static final String SMS_URI_ALL = "content://sms/";
	/**
	 * 收件箱短信
	 */
	public static final String SMS_URI_INBOX = "content://sms/inbox";
	/**
	 * 发件箱短信
	 */
	public static final String SMS_URI_SEND = "content://sms/sent";
	/**
	 * 草稿箱短信
	 */
	public static final String SMS_URI_DRAFT = "content://sms/draft";
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setViewList();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void setViewList() {
		listView = (ListView) findViewById(R.id.listView1);
		//获取数据库的时候应该单独开一条线程  以为是耗时的操作  这个demo数据库简单  我就放
		Uri uri = Uri.parse(MainActivity.SMS_URI_INBOX);
		 SmsContent sc = new SmsContent(this, uri);
		 smsInfos = (ArrayList<SmsInfo>) sc.getSmsInfo();
		Toast.makeText(MainActivity.this, smsInfos.size()+"", 0).show();
		if (smsInfos != null && smsInfos.size() != 0) {
			listView.setAdapter(new ListViewAdapter(smsInfos,MainActivity.this));
		} else {
			Toast.makeText(MainActivity.this, "No Data", 0).show();
		}
		listView.invalidate();
	}
	
	public void exist(View v){
		finish();
	}
}
