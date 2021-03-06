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
import android.widget.ImageView;

public class MainActivity extends Activity {
	
	public final static String TAG = "com.obriand.android_ardoisemagique.MainActivity";
	
	// Current position
	private float currentXPos = 60;
	private float currentYPos = 60;
	
	// Draw step
	private final static float DRAW_STEP = 10;
	
	// Repeat delay in ms
	private final static int REPEAT_DELAY = 250;
	
	// Cursor imageView
	private ImageView ivCursor;
	
	// Local handler
	private Handler mHandler;
	
	// Objects for drawing
	private Paint paint = new Paint(); 
	private Path path = new Path();
	
	// Draw view
	private SingleTouchEventView drawView;
	
	// Buttons to draw
	private Button btLeft;
	private Button btRight;
	private Button btUp;
	private Button btDown;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Draw view zone
		drawView = (SingleTouchEventView) this.findViewById(R.id.draw_view); 
		
		// Set the imageView cursor
		ivCursor = (ImageView) findViewById(R.id.mainactivity_tortue_iv);
		ivCursor.setX(currentXPos);
		ivCursor.setY(currentYPos);
		
		// Right direction
		btLeft = (Button) findViewById(R.id.mainactivity_left_bt);
		btLeft.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View view, MotionEvent event) { 
				
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					Log.i(TAG, "onTouch left: ACTION_DOWN => start draw");
					drawView.drawLeft(DRAW_STEP);					
					currentXPos = currentXPos-DRAW_STEP;
					Log.i(TAG, "currentXPos:"+currentXPos);
					ivCursor.setX(currentXPos);
					// when the user touch down, we can start the draw with an Handler using a recurrent action done with a Runnable
		            if (mHandler != null) return true;
		            mHandler = new Handler();
		            mHandler.postDelayed(mAction, REPEAT_DELAY);
				}
				if (event.getAction() == MotionEvent.ACTION_UP) {
					Log.i(TAG, "onTouch left: ACTION_UP => stop draw");
					// when the user touch down, we can stop the draw removing the callbacks of the Handler
		            if (mHandler == null) return true;
		            mHandler.removeCallbacks(mAction);
		            mHandler = null;
				}
				return false;
			}
			
		    Runnable mAction = new Runnable() {
		        @Override public void run() {
		        	drawView.drawLeft(DRAW_STEP);
					currentXPos = currentXPos-DRAW_STEP;
					Log.i(TAG, "currentXPos:"+currentXPos);
					ivCursor.setX(currentXPos);
		            mHandler.postDelayed(this, REPEAT_DELAY);
		        }
		    };
			
		   });
		
		// Right direction
		btRight = (Button) findViewById(R.id.mainactivity_right_bt);
		btRight.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View view, MotionEvent event) { 
				
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					Log.i(TAG, "onTouch right: ACTION_DOWN => start draw");
					drawView.drawRight(DRAW_STEP);
					currentXPos = currentXPos+DRAW_STEP;
					Log.i(TAG, "currentXPos:"+currentXPos);
					ivCursor.setX(currentXPos);
					// when the user touch down, we can start the draw with an Handler using a recurrent action done with a Runnable
		            if (mHandler != null) return true;
		            mHandler = new Handler();
		            mHandler.postDelayed(mAction, REPEAT_DELAY);
				}
				if (event.getAction() == MotionEvent.ACTION_UP) {
					Log.i(TAG, "onTouch right: ACTION_UP => stop draw");
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
					currentXPos = currentXPos+DRAW_STEP;
					Log.i(TAG, "currentXPos:"+currentXPos);
					ivCursor.setX(currentXPos);
		            mHandler.postDelayed(this, REPEAT_DELAY);
		        }
		    };
			
		   });
		
		// Up direction
		btUp = (Button) findViewById(R.id.mainactivity_up_bt);
		btUp.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View view, MotionEvent event) {

				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					Log.i(TAG, "onTouch up: ACTION_DOWN => start draw");
					drawView.drawUp(DRAW_STEP);
					currentYPos = currentYPos-DRAW_STEP;
					Log.i(TAG, "currentYPos:"+currentYPos);
					ivCursor.setY(currentYPos);
					// TODO the user touch down, we can start the draw
		            if (mHandler != null) return true;
		            mHandler = new Handler();
		            mHandler.postDelayed(mAction, REPEAT_DELAY);
				}
				if (event.getAction() == MotionEvent.ACTION_UP) {
					Log.i(TAG, "onTouch up: ACTION_UP => stop draw");
					// TODO the user touch the button here, we stop the draw
		            if (mHandler == null) return true;
		            mHandler.removeCallbacks(mAction);
		            mHandler = null;
				}
				return false;
			}
			
		    Runnable mAction = new Runnable() {
		        @Override public void run() {
		        	drawView.drawUp(DRAW_STEP);
					currentYPos = currentYPos-DRAW_STEP;
					Log.i(TAG, "currentYPos:"+currentYPos);
					ivCursor.setY(currentYPos);
		            mHandler.postDelayed(this, REPEAT_DELAY);
		        }
		    };
			
		   });
		
		// Down direction
		btDown = (Button) findViewById(R.id.mainactivity_down_bt);
		btDown.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View view, MotionEvent event) {

				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					Log.i(TAG, "onTouch down: ACTION_DOWN => start draw");
					drawView.drawDown(DRAW_STEP);
					currentYPos = currentYPos+DRAW_STEP;
					Log.i(TAG, "currentYPos:"+currentYPos);
					ivCursor.setY(currentYPos);
					// TODO the user touch down, we can start the draw
		            if (mHandler != null) return true;
		            mHandler = new Handler();
		            mHandler.postDelayed(mAction, REPEAT_DELAY);
				}
				if (event.getAction() == MotionEvent.ACTION_UP) {
					Log.i(TAG, "onTouch down: ACTION_UP => stop draw");
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
					currentYPos = currentYPos+DRAW_STEP;
					Log.i(TAG, "currentYPos:"+currentYPos);
					ivCursor.setY(currentYPos);
		            mHandler.postDelayed(this, REPEAT_DELAY);
		        }
		    };
			
		   });
		
	}
	
	public void setCurrentPosition(float XPos, float YPos) {
		currentXPos = XPos;
		currentYPos = YPos;
	}
	
	public float[] getCurrentPosition(float XPos, float YPos) {
		float[] pos = {currentXPos, currentYPos};
		return pos;
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
