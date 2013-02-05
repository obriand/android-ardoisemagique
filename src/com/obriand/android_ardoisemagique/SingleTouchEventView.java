package com.obriand.android_ardoisemagique;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class SingleTouchEventView extends View {

	public final static String TAG = "com.obriand.android_ardoisemagique.MainActivity";

	// Draw tools
	private Paint paint = new Paint();
	private Path path = new Path();

	// Mouse position
	private float cursorX = 100;
	private float cursorY = 100;

	// Constructor
	public SingleTouchEventView(Context context, AttributeSet attrs) {
		super(context, attrs);

		paint.setAntiAlias(true);
		paint.setStrokeWidth(6f);
		paint.setColor(Color.BLACK);
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeJoin(Paint.Join.ROUND);
		
		path.moveTo(cursorX, cursorY);

	}

	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawPath(path, paint);
	}

	public boolean drawHori(float x) {
		Log.i(TAG, "drawHori:from:" + cursorX + "," + cursorY);
		// Change the x position of the cursor
		cursorX = cursorX + x;
		// Draw a line and move the cursor
		path.lineTo(cursorX, cursorY);
		Log.i(TAG, "drawHori:to:" + cursorX + "," + cursorY);
		// Schedules a repaint.
		invalidate();
		return true;
	}
	
	public boolean drawVert(float y) {
		Log.i(TAG, "drawVert:from:" + cursorX + "," + cursorY);
		// Change the y position of the cursor
		cursorY = cursorY + y;
		// Draw a line and move the cursor
		path.lineTo(cursorX, cursorY);
		Log.i(TAG, "drawVert:to:" + cursorX + "," + cursorY);
		// Schedules a repaint.
		invalidate();
		return true;
	}

//	@Override
//	public boolean onTouchEvent(MotionEvent event) {
//		float eventX = event.getX();
//		float eventY = event.getY();
//
//		switch (event.getAction()) {
//		case MotionEvent.ACTION_DOWN:
//			path.moveTo(eventX, eventY);
//			return true;
//		case MotionEvent.ACTION_MOVE:
//			path.lineTo(eventX, eventY);
//			break;
//		case MotionEvent.ACTION_UP:
//			// nothing to do
//			break;
//		default:
//			return false;
//		}
//
//		// Schedules a repaint.
//		invalidate();
//		return true;
//	}
}