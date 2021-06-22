package com.dfbz.test;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class FiveFrame extends JFrame{
	
	private JPanel toolBar;//工具栏里有三个按钮
	private JButton startButton,backButton,exitButton;
	private DrawPanel drawPanel;//棋盒的面板
	
	private JMenuBar menuBar;
	private JMenu sysMenu;
	private JMenuItem startMenuItem,backMenuItem,exitMenuItem;
	
	private MyListener listener;
	
	public FiveFrame(){
		
	}
	public void init() {
		listener=new MyListener();
		
		this.setTitle("单机版五子棋游戏");
		
		toolBar=new JPanel();
		startButton=new JButton("开始");
		startButton.addActionListener(listener);
		
		backButton=new JButton("悔棋");
		backButton.addActionListener(listener);
		
		exitButton=new JButton("退出");
		exitButton.addActionListener(listener);
		
		drawPanel=new DrawPanel();
		
		menuBar=new JMenuBar();
		sysMenu=new JMenu("系统");
		startMenuItem=new JMenuItem("开始");
		startMenuItem.addActionListener(listener);
		
		backMenuItem=new JMenuItem("悔棋");
		backMenuItem.addActionListener(listener);
		
		exitMenuItem=new JMenuItem("退出");
		exitMenuItem.addActionListener(listener);
		
		this.setJMenuBar(menuBar);	//设置窗口菜单栏
		menuBar.add(sysMenu);//加“系统”菜单
		sysMenu.add(startMenuItem);//加“系统”菜单项
		sysMenu.add(backMenuItem);
		sysMenu.add(exitMenuItem);
		
		toolBar.add(startButton);//加工具栏按钮
		toolBar.add(backButton);
		toolBar.add(exitButton);
		
		this.setLayout(new BorderLayout());//JFrame的边框布局方式
		this.add(toolBar,BorderLayout.NORTH);//把toolBar即工具栏加在上边，即北边
		this.add(drawPanel,BorderLayout.CENTER);//把棋盘加在中间
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//窗口关闭
		this.setResizable(false);//窗口不能改变大小
		
		//this.setSize(WIDTH, HEIGH);窗口的大小宽和高
		//让窗口出现在屏幕中间 getScreenSize().width指整个电脑屏幕的宽
		this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width)/2-200, (Toolkit.getDefaultToolkit().getScreenSize().height)/2-400);
		//要窗口里面的组件是包紧的
		pack();
		this.setVisible(true);
		
	}
	
	private class MyListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==startButton||e.getSource()==startMenuItem) {
				drawPanel.restartGame();
			}
			
			if(e.getSource()==backButton||e.getSource()==backMenuItem) {
				drawPanel.goback();
			}
			
			if(e.getSource()==exitButton||e.getSource()==exitMenuItem) {
				System.exit(0);
			}
		}
	}
}
