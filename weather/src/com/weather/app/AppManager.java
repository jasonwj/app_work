package com.weather.app;

import java.util.Stack;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

/*
 * app������,����Activity����ͳ����˳�
 */
public class AppManager {
	private static Stack<Activity> stack;
	private static AppManager instance = new AppManager();
	
	public AppManager(){
		stack = new Stack<Activity>();
	}
	/*
	 * ��ȡAppManager
	 */
	public static AppManager getInstance(){
		return instance;
	}
	/**
	 * ���Activity����ջ
	 */
	public void addActivity(Activity activity) {
		stack.add(activity);
	}

	/**
	 * ��ȡ��ǰActivity����ջ�����һ��ѹ��ģ�
	 */
	public Activity currentActivity() {
		Activity activity = stack.lastElement();
		return activity;
	}

	/**
	 * ������ǰActivity����ջ�����һ��ѹ��ģ�
	 */
	public void finishActivity() {
		Activity activity = stack.lastElement();
		finishActivity(activity);
	}

	/**
	 * ����ָ����Activity
	 */
	public void finishActivity(Activity activity) {
		if (activity != null) {
			stack.remove(activity);
			activity.finish();
		}
	}

	/**
	 * ����ָ��������Activity
	 */
	public void finishActivity(Class<?> cls) {
		for (Activity activity : stack) {
			if (activity.getClass().equals(cls)) {
				finishActivity(activity);
			}
		}
	}

	/**
	 * ��������Activity
	 */
	public void finishAllActivity() {
		for (Activity activity : stack) {
			if(activity != null ) {
				activity.finish();
			}
		}
		stack.clear();
	}

	/**
	 * �˳�Ӧ�ó���
	 */
	public void AppExit(Context context) {
		try {
			finishAllActivity();
			ActivityManager activityMgr = (ActivityManager) context
					.getSystemService(Context.ACTIVITY_SERVICE);
			//activityMgr.restartPackage(context.getPackageName());
			activityMgr.killBackgroundProcesses(context.getPackageName());
			System.exit(0);
		} catch (Exception e) {
		}
	}
}
