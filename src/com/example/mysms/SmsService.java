package com.example.mysms;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

public class SmsService
{
	private static Context context;
	
	public SmsService(Context context)
	{
		this.context = context;
	}
	
	public static ArrayList<SmsInfo> getSmsInfo()
	{
		ArrayList<SmsInfo> infos = new ArrayList<SmsInfo>();
		ContentResolver resolver = context.getContentResolver();
		Uri uri = Uri.parse("content://sms/");
		Cursor cursor = resolver.query(uri, new String[] {"_id", "address", "date", "type", "body"}, null, null, " date desc ");
		SmsInfo info;
		while(cursor.moveToNext())
		{
			info = new SmsInfo();
			String id = cursor.getString(0);
			String address = cursor.getString(1);
			String date = cursor.getString(2);
			int type = cursor.getInt(3);
			String body = cursor.getString(4);
			//info.setId(id);
			//info.setAddress(address);
			//info.setDate(date);
			//info.setType(type);
			//info.setBody(body);
			infos.add(info);
		}
		cursor.close();
		return infos;
	}

}
