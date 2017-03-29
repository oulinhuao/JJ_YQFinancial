package com.proj.JJYQFinancial;

import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.proj.androidlib.tool.LogHelper;

import butterknife.ButterKnife;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 主页
 * @author Tony
 */
public class HomeFragment extends MyBaseFragment{
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mRootView = inflater.inflate(R.layout.fragment_home,
				container, false);
		return mRootView;
	}
	
	@Override
	public void onStart() {
		super.onStart();
		LogHelper.customLogging("onStart");
		if(mContext == null){
			mContext = this.getActivity();
			getViews();
			init();
			setListeners();
		}
	}
	
	protected void getViews() {
		ButterKnife.inject(this,mRootView);
	}
	
	protected void setListeners() {
		
		
	}
	
	private void init(){
		
	}
	
	
	private MsgHandler mMsgHandler = new MsgHandler(this);
	private static class MsgHandler extends Handler {
		private WeakReference<Object> mOB;
		HomeFragment owner = null;

		public MsgHandler(HomeFragment ob) {
			mOB = new WeakReference<Object>(ob);
			owner = (HomeFragment) mOB.get();
		}

		@Override
		public void handleMessage(Message msg) {
			if (msg == null || owner == null) {
				return;
			}
			owner.executeByMessage(msg);
			super.handleMessage(msg);
		}
	}
	protected void executeByMessage(Message msg){
		if(mIsFinish){ return;}
		
		switch (msg.what) {
		}
	}

}