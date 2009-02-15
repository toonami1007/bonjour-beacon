package com.as.bonjourbeacon.control;

import java.util.Collection;
import java.util.Iterator;

public class ShutdownHook implements Runnable {

	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Collection<BatchDispatcher> col = Control.batchDispatcher.values();
		
		Iterator<BatchDispatcher> iter = col.iterator();
		while (iter.hasNext())
			iter.next().stopProcess();
	}

}
