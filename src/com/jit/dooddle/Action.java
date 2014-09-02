package com.jit.dooddle;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

//基础类
public abstract class Action {
	public int color;

	Action() {
		color = Color.BLACK;
	}

	Action(int color) {
		this.color = color;
	}

	public abstract void draw(Canvas canvas);

	public abstract void move(float mx, float my);
}

// 点
class MyPoint extends Action {
	public float x;
	public float y;

	MyPoint(float px, float py, int color) {
		super(color);
		this.x = px;
		this.y = py;
	}

	public void draw(Canvas canvas) {
		Paint paint = new Paint();
		paint.setColor(color);
		canvas.drawPoint(x, y, paint);
	}

	@Override
	public void move(float mx, float my) {
		
	}
}

// 自由曲线
class MyPath extends Action {
	Path path;
	int size;

	MyPath() {
		path = new Path();
		size = 1;
	}

	MyPath(float x, float y, int size, int color) {
		super(color);
		path = new Path();
		this.size = size;
		path.moveTo(x, y);
		path.lineTo(x, y);
	}

	public void draw(Canvas canvas) {
		Paint paint = new Paint();
		paint.setAntiAlias(true);
		paint.setDither(true);
		paint.setColor(color);
		paint.setStrokeWidth(size);
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeJoin(Paint.Join.ROUND);
		paint.setStrokeCap(Paint.Cap.ROUND);
		canvas.drawPath(path, paint);
	}

	public void move(float mx, float my) {
		path.lineTo(mx, my);
	}
}

// 直线
class MyLine extends Action {
	float startX;
	float startY;
	float stopX;
	float stopY;
	int size;

	MyLine() {
		startX = 0;
		startY = 0;
		stopX = 0;
		stopY = 0;
	}

	MyLine(float x, float y, int size, int color) {
		super(color);
		startX = x;
		startY = y;
		stopX = x;
		stopY = y;
		this.size = size;
	}

	public void draw(Canvas canvas) {
		Paint paint = new Paint();
		paint.setAntiAlias(true);
		paint.setStyle(Paint.Style.STROKE);
		paint.setColor(color);
		paint.setStrokeWidth(size);
		canvas.drawLine(startX, startY, stopX, stopY, paint);
	}

	public void move(float mx, float my) {
		stopX = mx;
		stopY = my;
	}
}

// 方框
class MyRect extends Action {
	float startX;
	float startY;
	float stopX;
	float stopY;
	int size;

	MyRect() {
		startX = 0;
		startY = 0;
		stopX = 0;
		stopY = 0;
	}

	MyRect(float x, float y, int size, int color) {
		super(color);
		startX = x;
		startY = y;
		stopX = x;
		stopY = y;
		this.size = size;
	}

	public void draw(Canvas canvas) {
		Paint paint = new Paint();
		paint.setAntiAlias(true);
		paint.setStyle(Paint.Style.STROKE);
		paint.setColor(color);
		paint.setStrokeWidth(size);
		canvas.drawRect(startX, startY, stopX, stopY, paint);
	}

	public void move(float mx, float my) {
		stopX = mx;
		stopY = my;
	}
}

// 圆框
class MyCircle extends Action {
	float startX;
	float startY;
	float stopX;
	float stopY;
	float radius;
	int size;

	MyCircle() {
		startX = 0;
		startY = 0;
		stopX = 0;
		stopY = 0;
		radius = 0;
	}

	MyCircle(float x, float y, int size, int color) {
		super(color);
		startX = x;
		startY = y;
		stopX = x;
		stopY = y;
		radius = 0;
		this.size = size;
	}

	public void draw(Canvas canvas) {
		Paint paint = new Paint();
		paint.setAntiAlias(true);
		paint.setStyle(Paint.Style.STROKE);
		paint.setColor(color);
		paint.setStrokeWidth(size);
		canvas.drawCircle((startX + stopX) / 2, (startY + stopY) / 2, radius,
				paint);
	}

	public void move(float mx, float my) {
		stopX = mx;
		stopY = my;
		radius = (float) ((Math.sqrt((mx - startX) * (mx - startX)
				+ (my - startY) * (my - startY))) / 2);
	}
}

// 方块
class MyFillRect extends Action {
	float startX;
	float startY;
	float stopX;
	float stopY;
	int size;

	MyFillRect() {
		startX = 0;
		startY = 0;
		stopX = 0;
		stopY = 0;
	}

	MyFillRect(float x, float y, int size, int color) {
		super(color);
		startX = x;
		startY = y;
		stopX = x;
		stopY = y;
		this.size = size;
	}

	public void draw(Canvas canvas) {
		Paint paint = new Paint();
		paint.setAntiAlias(true);
		paint.setStyle(Paint.Style.FILL);
		paint.setColor(color);
		paint.setStrokeWidth(size);
		canvas.drawRect(startX, startY, stopX, stopY, paint);
	}

	public void move(float mx, float my) {
		stopX = mx;
		stopY = my;
	}
}

// 圆饼
class MyFillCircle extends Action {
	float startX;
	float startY;
	float stopX;
	float stopY;
	float radius;
	int size;

	MyFillCircle() {
		startX = 0;
		startY = 0;
		stopX = 0;
		stopY = 0;
		radius = 0;
	}

	MyFillCircle(float x, float y, int size, int color) {
		super(color);
		startX = x;
		startY = y;
		stopX = x;
		stopY = y;
		radius = 0;
		this.size = size;
	}

	public void draw(Canvas canvas) {
		Paint paint = new Paint();
		paint.setAntiAlias(true);
		paint.setStyle(Paint.Style.FILL);
		paint.setColor(color);
		paint.setStrokeWidth(size);
		canvas.drawCircle((startX + stopX) / 2, (startY + stopY) / 2, radius,
				paint);
	}

	public void move(float mx, float my) {
		stopX = mx;
		stopY = my;
		radius = (float) ((Math.sqrt((mx - startX) * (mx - startX)
				+ (my - startY) * (my - startY))) / 2);
	}
}

