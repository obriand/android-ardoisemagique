package com.obriand.android_ardoisemagique;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;

public class MainActivity extends Activity {
	
	public final static String TAG = "com.obriand.android_ardoisemagique.MainActivity";
	
	// Draw step
	private final static float DRAW_STEP = 10;
	
	// Repeat delay in ms
	private final static int REPEAT_DELAY = 250;
	
	// Local handler
	private Handler mHandler;
	
	// Objects for drawing
	private Paint paint = new Paint(); 
	private Path path = new Path();
	
	// Draw view
	private SingleTouchEventView drawView;
	
	// Buttons to draw
	private Button btHorizontal;
	private Button btVertical;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Draw view zone
		drawView = (SingleTouchEventView) this.findViewById(R.id.draw_view); 
		
		// TODO left and right direction
		btHorizontal = (Button) this.findViewById(R.id.mainactivity_right_bt);
		btHorizontal.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View view, MotionEvent event) { 
				
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					Log.i(TAG, "onTouch horizontal: ACTION_DOWN => start draw");
					drawView.drawRight(DRAW_STEP);
					// when the user touch down, we can start the draw with an Handler using a recurrent action done with a Runnable
		            if (mHandler != null) return true;
		            mHandler = new Handler();
		            mHandler.postDelayed(mAction, REPEAT_DELAY);
				}
				if (event.getAction() == MotionEvent.ACTION_UP) {
					Log.i(TAG, "onTouch horizontal: ACTION_UP => stop draw");
					// when the user touch down, we can stop the draw removing the callbacks of the Handler
		            if (mHandler == null) return true;
		            mHandler.removeCallbacks(mAction);
		            mHandler = null;
				}
				return false;
			}
			
		    Runnable mAction = new Runnable() {
		        @Override public void run() {
		        	drawView.drawRight(DRAW_STEP);
		            mHandler.postDelayed(this, REPEAT_DELAY);
		        }
		    };
			
		   });
		
		// TODO up and down direction
		btVertical = (Button) this.findViewById(R.id.mainactivity_down_bt);
		btVertical.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View view, MotionEvent event) {

				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					Log.i(TAG, "onTouch vertical: ACTION_DOWN => start draw");
					drawView.drawDown(DRAW_STEP);
					// TODO the user touch down, we can start the draw
		            if (mHandler != null) return true;
		            mHandler = new Handler();
		            mHandler.postDelayed(mAction, REPEAT_DELAY);
				}
				if (event.getAction() == MotionEvent.ACTION_UP) {
					Log.i(TAG, "onTouch vertical: ACTION_UP => stop draw");
					// TODO the user touch the button here, we stop the draw
		            if (mHandler == null) return true;
		            mHandler.removeCallbacks(mAction);
		            mHandler = null;
				}
				return false;
			}
			
		    Runnable mAction = new Runnable() {
		        @Override public void run() {
		        	drawView.drawDown(DRAW_STEP);
		            mHandler.postDelayed(this, REPEAT_DELAY);
		        }
		    };
			
		   });
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	// Horizontal button
	public void btHorizontal(View view) {
		//Log.i(TAG, "onclick horizontal");
	}
	
	// Vertical button
	public void btVertical(View view) {
		//Log.i(TAG, "onclick vertical");
	}

}
