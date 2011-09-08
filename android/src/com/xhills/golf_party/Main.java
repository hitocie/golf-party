package com.xhills.golf_party;

import android.content.Intent;
import android.os.Bundle;

import com.phonegap.DroidGap;

public class Main extends DroidGap {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.main);
		
		// FIXME: For testing
		//startActivityForResult(new Intent(this, FacebookAuth.class), 0);
		super.loadUrl("file:///android_asset/www/index.html");
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
		
		super.onActivityResult(requestCode, resultCode, intent);
		
		if (intent == null) 
			return;
		
		super.loadUrl("file:///android_asset/www/index.html");
	}
}