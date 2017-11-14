package com.example.administrator.shapanche.http;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

public class HttpThread extends Thread{

	private Context context;
	private String url;
	private String jsonstring;
	private Handler handler;

	public HttpThread(Context context , Handler handler){
		this.context=context;
		//this.proDialog=proDialog;
		this.handler = handler;
	}

	@Override
	public void run(){
		HttpPostRequest post=new HttpPostRequest();
		int res=post.requestHttp(url, jsonstring);
//		System.out.println("****HttpThread中****url:"+url);
//		System.out.println("****HttpThread中****jsonstring:"+jsonstring);

		String webContent=post.getWebContext();
		System.out.println("***res:"+res);
		if(res==1){
			Message msg = new Message();
			msg.what=res;
			msg.obj=webContent;
			handler.sendMessage(msg);
		}
		/******/
		else if(res==901){
			Message msg = new Message();
			msg.what=res;
			msg.obj="timeout!";
			handler.sendMessage(msg);
		}
		/******/

	}

	//activity界面传递的参数
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getJsonstring() {
		return jsonstring;
	}

	public void setJsonstring(String jsonstring) {
		this.jsonstring = jsonstring;
	}
}

