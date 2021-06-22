package com.dfbz.test;

import java.awt.Color;

public class Chess {
	private int x;//棋盘中x的索引值
	private int y;
	private Color color;
	
	public static final int DIANETER=30;

//构造方法
	public Chess(int x, int y, Color color) {
		super();
		this.x = x;
		this.y = y;
		this.color = color;
	}
//get x,y,color的方法
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	//
	
}
