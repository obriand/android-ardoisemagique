package com.obriand.android_ardoisemagique;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	
	public final static String TAG = "com.obriand.android_ardoisemagique.MainActivity";
	
	private Button btHorizontal;
	private Button btVertical;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btHorizontal = (Button) this.findViewById(R.id.mainactivity_horizontal_bt);
		btVertical = (Button) this.findViewById(R.id.mainactivity_vertical_bt);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	// Horizontal button
	public void btHorizontal(View view) {
		Log.i(TAG, "horizontal");
	}
	
	// Vertical button
	public void btVertical(View view) {
		Log.i(TAG, "vertical");
	}

}
