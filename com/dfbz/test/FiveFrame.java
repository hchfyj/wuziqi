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
	
	private JPanel toolBar;//����������������ť
	private JButton startButton,backButton,exitButton;
	private DrawPanel drawPanel;//��е����
	
	private JMenuBar menuBar;
	private JMenu sysMenu;
	private JMenuItem startMenuItem,backMenuItem,exitMenuItem;
	
	private MyListener listener;
	
	public FiveFrame(){
		
	}
	public void init() {
		listener=new MyListener();
		
		this.setTitle("��������������Ϸ");
		
		toolBar=new JPanel();
		startButton=new JButton("��ʼ");
		startButton.addActionListener(listener);
		
		backButton=new JButton("����");
		backButton.addActionListener(listener);
		
		exitButton=new JButton("�˳�");
		exitButton.addActionListener(listener);
		
		drawPanel=new DrawPanel();
		
		menuBar=new JMenuBar();
		sysMenu=new JMenu("ϵͳ");
		startMenuItem=new JMenuItem("��ʼ");
		startMenuItem.addActionListener(listener);
		
		backMenuItem=new JMenuItem("����");
		backMenuItem.addActionListener(listener);
		
		exitMenuItem=new JMenuItem("�˳�");
		exitMenuItem.addActionListener(listener);
		
		this.setJMenuBar(menuBar);	//���ô��ڲ˵���
		menuBar.add(sysMenu);//�ӡ�ϵͳ���˵�
		sysMenu.add(startMenuItem);//�ӡ�ϵͳ���˵���
		sysMenu.add(backMenuItem);
		sysMenu.add(exitMenuItem);
		
		toolBar.add(startButton);//�ӹ�������ť
		toolBar.add(backButton);
		toolBar.add(exitButton);
		
		this.setLayout(new BorderLayout());//JFrame�ı߿򲼾ַ�ʽ
		this.add(toolBar,BorderLayout.NORTH);//��toolBar�������������ϱߣ�������
		this.add(drawPanel,BorderLayout.CENTER);//�����̼����м�
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ڹر�
		this.setResizable(false);//���ڲ��ܸı��С
		
		//this.setSize(WIDTH, HEIGH);���ڵĴ�С��͸�
		//�ô��ڳ�������Ļ�м� getScreenSize().widthָ����������Ļ�Ŀ�
		this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width)/2-200, (Toolkit.getDefaultToolkit().getScreenSize().height)/2-400);
		//Ҫ�������������ǰ�����
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
