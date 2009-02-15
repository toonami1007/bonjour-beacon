package com.as.bonjourbeacon.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.JWindow;



public class AboutSplashScreen extends JWindow {

	
	private static final long serialVersionUID = 1L;

	

	public void showSplashScreen() {
		setSize(500, 300);
		addMouseListener( new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		setLocationRelativeTo(null);
		setBackground( Color.red);
		setAlwaysOnTop(true);
		setVisible(true);
	}
	
	
	
	public void paint(Graphics g)
	{
		URL url = this.getClass().getResource("/com/as/bonjourbeacon/res/bonjour-beacon.png"); 
		Image img = Toolkit.getDefaultToolkit().getImage(url); 
		g.drawImage(img, 0, 0, this); 
	}
	
	
	
	public static void main( String[] args) {
		new AboutSplashScreen().showSplashScreen();
	}
}
