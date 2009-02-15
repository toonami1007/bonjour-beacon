package com.as.bonjourbeacon.control;

import java.io.File;
import java.util.HashMap;

import com.as.bonjourbeacon.ui.BonjourBeaconUI;

public class Control {

	
	private static Control instance = new Control();
	private BonjourBeaconUI ui = new BonjourBeaconUI();
	
	public static HashMap<String, BatchDispatcher> batchDispatcher = new HashMap<String, BatchDispatcher>();
	
	
	
	private Control() { }
	
	
	
	public static Control getInstance() {
		return instance;
	}
	
	
	
	
	
	public void startProcess( String pid ) throws Exception {
		BatchDispatcher bd =  batchDispatcher.get( pid );
		if (bd==null) 
			throw new IllegalArgumentException("BatchDispatcher '" + pid + "' is not registered!" );
		
		if (!bd.isRunning())
			bd.dispatch();
	}
	
	
	public void stopProcess( String pid ) throws Exception {
		BatchDispatcher bd =  batchDispatcher.get( pid );
		if (bd==null) 
			throw new IllegalArgumentException("BatchDispatcher '" + pid + "' is not registered!" );
		
		if (bd.isRunning())
			bd.stopProcess();
	}
	
	
	public void addJob( BeaconConfig cfg, boolean autoStart) throws Exception {
		if (cfg==null)
			throw new IllegalArgumentException("Batch config mus not be null!");
		BatchDispatcher bd = new BatchDispatcher(cfg);
		batchDispatcher.put(cfg.getIdentifier(), bd);
		ui.addBatchConfigToTable(cfg, true);
		if (autoStart)
			bd.dispatch();
	}


	
	public void changeConfigOf( BeaconConfig bcfg ) {
		ui.changeConfig(bcfg);
	}
	
	
	
	
	public void removeConfig( BeaconConfig bcfg) {
		ui.removeBatchConfigFromTable(bcfg);
		batchDispatcher.remove( bcfg.getIdentifier() );
		if (bcfg.getConfigFile().exists()) {
			if (!bcfg.getConfigFile().delete())
				bcfg.getConfigFile().deleteOnExit();
		} else
			System.out.println("File " + bcfg.getConfigFile().getAbsolutePath() + " does not exist");
		
	}
	
	
	private void initialize() throws Exception {
	
		for (File f:new File( "configurations").listFiles()) {
			if (!f.getName().endsWith("props"))
				continue;
			BeaconConfig bc = BeaconConfig.getBatchConfig( f);
			addJob( bc,  bc.getProperty( BeaconConfig._autoStart).equals("true"));
		}
	}
	
	
	
	
	
	
	public void startUp() throws Exception {
		initialize();
		Thread t = new Thread(new ShutdownHook());
		Runtime.getRuntime().addShutdownHook(t);

	}
	
	
	
	
}
