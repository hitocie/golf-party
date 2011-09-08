package com.xhills.golf_party;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.xhills.golf_party.common.facebook.App;

public class FacebookAuth extends Activity {

	private ProgressDialog progressDialog;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		progressDialog = new ProgressDialog(this);
		progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		progressDialog.setMessage("Loading ...");
		progressDialog.show();
		
		WebView webView = new WebView(this);
		webView.setWebViewClient(new WebViewClient() {

			@Override
			public void onPageFinished(WebView view, String url) {
				super.onPageFinished(view, url);
				Log.i(getClass().getName(), "Finished page: " + url);

				if (url != null && url.contains(App.siteUrl + "?code=")) {

					if (progressDialog != null) {
						progressDialog.dismiss();
						progressDialog = null;
					}

					Intent intent = getIntent();
					//String validationCode = url.split("\\?code=")[1];
					//intent.putExtra("validationCode", validationCode);
					setResult(Activity.RESULT_OK, intent);
					finish();
				}
			}

			@Override
			public void onPageStarted(WebView view, String url, Bitmap favicon) {
				super.onPageStarted(view, url, favicon);
				Log.i(getClass().getName(), "Started page: " + url);
			}
		});

		setContentView(webView,
				new LayoutParams(
						ViewGroup.LayoutParams.WRAP_CONTENT,
						ViewGroup.LayoutParams.FILL_PARENT)
		);
		webView.loadUrl(
				"https://www.facebook.com/dialog/oauth?client_id=" + App.appId +
				"&redirect_uri=" + App.siteUrl + 
				"&scope=user_birthday,user_location,user_hometown"
		);
	}
}
