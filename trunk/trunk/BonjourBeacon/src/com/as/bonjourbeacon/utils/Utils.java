package com.as.bonjourbeacon.utils;

import java.net.URL;

import javax.swing.ImageIcon;


public class Utils {

	
	public static ImageIcon getImageIconFromRessource( String ressource ) {
		URL url = Utils.class.getResource("/com/as/bonjourbeacon/res/" + ressource + "");
		
		if (url==null)
			throw new IllegalArgumentException( "ImageIcon could not be found!");
		
		ImageIcon icon = new ImageIcon(url);
		return icon;
	}
}
