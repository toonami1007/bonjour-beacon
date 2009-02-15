package com.as.bonjourbeacon.control;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class BatchDispatcher {

	
	private static HashMap<String, Process> runningProcesses = new HashMap<String, Process>();
	
	
	private BeaconConfig cfg = null;
	
	private Process batchProcess = null;
	private StringBuffer inputStreamMessage = new StringBuffer();
	private String processId = null;
	
	
	public BatchDispatcher( BeaconConfig cfg) {
		this.cfg = cfg;
		this.processId = cfg.getIdentifier();
	}
	
	
	
	
	
	public int dispatch() throws Exception {
		System.out.println("Dispatching job '" + processId  + "'");
		//ProcessBuilder pb = createProcessBuilder();
		batchProcess = Runtime.getRuntime().exec(getCommand()); //pb.start(); //Runtime.getRuntime().exec(command);
    	runningProcesses.put( processId, batchProcess);
		new BatchStartThread(this, batchProcess, inputStreamMessage ).start();
		
        return 0;
	}
	
	
	public void informProcessFinished() {
		runningProcesses.remove(batchProcess);
		this.batchProcess = null;
	}
	
	
	public static void stopProcess( String pid ) {
		Process p = runningProcesses.get(pid);
		if (p!=null) {
			System.out.println("Stopping job '" + pid  + "'");
			p.destroy();
		}
			
	}
	
	
	public void stopProcess() {
		System.out.println("Stopping job '" + processId  + "'");
		if (batchProcess!=null)
			batchProcess.destroy();
		batchProcess=null;
	}
	
	public boolean isRunning() {
		return batchProcess!=null;
	}
	
	
	public BeaconConfig getConfig() {
		return this.cfg;
	}

	
	public String getInputStreamMessage() {
		return inputStreamMessage.toString();
	}
	
	
	
	
	
	private ProcessBuilder createProcessBuilder() {
		// dns-sd -P 000C76C03FA6@Bandersnatch _airfoilspeaker._tcp. "" 5000 bandersnatch.local 172.16.14.102 tp=UDP txtvers=1 ss=16 rast=afs pw=true raver=1.0.0.0 sr=44100 ch=2 ramach=Win32NT.5
		List<String> command = new ArrayList<String>();
		command.add("dns-sd");
		command.add("-P");
		
		// basic configuration
		command.add(cfg.getProperty(BeaconConfig._hostMac) + "@" + cfg.getProperty(BeaconConfig._hostName) );		// mac @ host name
		command.add(cfg.getProperty(BeaconConfig._protocol));					// protocol
		command.add("\"\"");													// empty
		command.add(cfg.getProperty(BeaconConfig._port));						// port
		command.add(cfg.getProperty(BeaconConfig._hostName) + ".local");			// host name . local
		command.add(cfg.getProperty(BeaconConfig._hostIp));						// host ip
		
		
		// attach the batch command
		if ( !cfg.isCustomBatch() ) {
			command.add( cfg.getCustomCommand());
			command.add("pw=" + cfg.getProperty(BeaconConfig._password));	
			command.add("ramach=" + cfg.getProperty(BeaconConfig._localOSValue));				// operating system
		} else {
			command.add( cfg.getCustomCommand());
			command.add("ramach=" + cfg.getProperty(BeaconConfig._localOSValue));	
		}
		System.out.println( command.toString() );
		return new ProcessBuilder(command);
	}
	
	
	
	
	private String getCommand() {
		List<String> l = createProcessBuilder().command();
		String result = "";
		for (String s:l)
			result+=s + " ";
		System.out.println("Command: " + result);
		return result;
	}

}
