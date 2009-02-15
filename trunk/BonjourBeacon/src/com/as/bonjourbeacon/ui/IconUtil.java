package com.as.bonjourbeacon.ui;

import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class IconUtil {

	
	
	
	
	public static ArrayList<Image> getImageIconList() {
		ArrayList<Image> imageList = new ArrayList<Image>();
		imageList.add(getImageFromIconHelp("i16.png"));
		imageList.add(getImageFromIconHelp("i24.png"));
		imageList.add(getImageFromIconHelp("i32.png"));
		
		return imageList;
	}
	
	
	
	
	public static Image getImageFromIcon( String name){
		return getImageFromIconHelp( name );
	}
	
	
	
	private static Image getImageFromIconHelp( String name ) {
		URL url = IconUtil.class.getResource("/com/as/bonjourbeacon/res/" + name + "");
		
		if (url==null)
			throw new IllegalArgumentException( "ImageIcon could not be found!");
		
		ImageIcon galIcon = new ImageIcon(url);
		return galIcon.getImage();
	}
	
	
	
	
	
	
}
