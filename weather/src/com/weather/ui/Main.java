package com.weather.ui;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;

public class Main extends BaseActivity {

	

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		ActionBar bar = getActionBar();
		bar.setDisplayShowHomeEnabled(true);
		bar.setHomeButtonEnabled(true);
		

		
	}
	/*
	 * ActionBar 创建菜单
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	/*
	 * ActionBar选择菜单
	 * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
		case R.id.action_location:
			
			return true;
		case R.id.action_share:
			return true;
		case R.id.action_refresh:
			return true;
		case R.id.action_settings:
			return true;
		default:
			return super.onOptionsItemSelected(item);
	
		}
		
		
		
	}

}
