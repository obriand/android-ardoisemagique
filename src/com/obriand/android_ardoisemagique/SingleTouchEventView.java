package com.obriand.android_ardoisemagique;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class SingleTouchEventView extends View {

	public final static String TAG = "com.obriand.android_ardoisemagique.MainActivity";

	// Draw tools
	private Paint paint = new Paint();
	private Path path = new Path();

	// Cursor default position
	private float cursorX = 100;
	private float cursorY = 100;
	
	// Cursor imageView
	private ImageView ivCursor;

	// Constructor
	public SingleTouchEventView(Context context, AttributeSet attrs) {
		super(context, attrs);

		// Set the drawing tools
		paint.setAntiAlias(true);
		paint.setStrokeWidth(6f);
		paint.setColor(Color.BLACK);
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeJoin(Paint.Join.ROUND);
		
		// Set the cursor to the initial position
		path.moveTo(cursorX, cursorY);

	}

	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawPath(path, paint);
	}
	
	public boolean drawLeft(float x) {
		Log.i(TAG, "drawLeft:from:" + cursorX + "," + cursorY);
		// Change the x position of the cursor
		cursorX = cursorX - x;
		// Draw a line and move the cursor
		path.lineTo(cursorX, cursorY);
		Log.i(TAG, "drawLeft:to:" + cursorX + "," + cursorY);
		// Schedules a repaint.
		invalidate();
		return true;
	}

	public boolean drawRight(float x) {
		Log.i(TAG, "drawRight:from:" + cursorX + "," + cursorY);
		// Change the x position of the cursor
		cursorX = cursorX + x;
		// Draw a line and move the cursor
		path.lineTo(cursorX, cursorY);
		Log.i(TAG, "drawRight:to:" + cursorX + "," + cursorY);
		// Schedules a repaint.
		invalidate();
		return true;
	}
	
	public boolean drawUp(float y) {
		Log.i(TAG, "drawUp:from:" + cursorX + "," + cursorY);
		// Change the y position of the cursor
		cursorY = cursorY - y;
		// Draw a line and move the cursor
		path.lineTo(cursorX, cursorY);
		Log.i(TAG, "drawDown:to:" + cursorX + "," + cursorY);
		// Schedules a repaint, call onDraw()
		invalidate();
		return true;
	}
	
	public boolean drawDown(float y) {
		Log.i(TAG, "drawDown:from:" + cursorX + "," + cursorY);
		// Change the y position of the cursor
		cursorY = cursorY + y;
		// Draw a line and move the cursor
		path.lineTo(cursorX, cursorY);
		Log.i(TAG, "drawDown:to:" + cursorX + "," + cursorY);
		// Schedules a repaint, call onDraw()
		invalidate();
		return true;
	}
	
}