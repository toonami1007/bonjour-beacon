package com.as.bonjourbeacon;

import com.as.bonjourbeacon.control.Control;


public class StartUp {

	
	
	public static void main( String[] args ) {
		try {
			Control.getInstance().startUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
