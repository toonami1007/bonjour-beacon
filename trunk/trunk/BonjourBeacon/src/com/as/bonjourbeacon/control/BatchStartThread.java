package com.as.bonjourbeacon.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BatchStartThread extends Thread {
	
	private BatchDispatcher dispatcher = null;
	private Process batchProcess = null;
	private StringBuffer output = null;
	
	public BatchStartThread( BatchDispatcher dispatcher, Process batchProcess, StringBuffer output ) {
		this.dispatcher = dispatcher;
		this.batchProcess = batchProcess;
		this.output = output;
	}
	
	
	public void run() {
		
		System.out.println("Batch Thread started.");
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader( batchProcess.getInputStream()));
			String msg = reader.readLine();
			while (msg != null) {
				output.append(msg + '\n');
				System.out.println(msg);
				msg = reader.readLine();
			}
	        batchProcess.waitFor();
	        dispatcher.informProcessFinished();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
