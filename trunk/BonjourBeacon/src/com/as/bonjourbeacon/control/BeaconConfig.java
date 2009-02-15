package com.as.bonjourbeacon.control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;



public class BeaconConfig {

	
	/** Configuration keys **/
	public final static String _profileName = "ProfileName";
	public final static String _hostName = "HostName";
	public final static String _hostMac = "HostMac";
	public final static String _hostIp = "HostIP";
	public final static String _password = "Password";
	public final static String _localOS = "LocalOS";
	public final static String _localOSValue = "LocalOSValue";
	public final static String _protocol = "Protocol";
	public final static String _port = "Port";
	public final static String _autoStart = "AutoStart";
	public final static String _cmdParams = "CmdParams";
	public final static String _customCmd = "CustomCmd";
	
	
	public final static String AIRFOIL_ARGUMENT = "tp=UDP txtvers=1 ss=16 rast=afs raver=1.0.0.0 sr=44100 ch=2";
	
	private Properties props = null;
	
	
	public BeaconConfig( Properties props ) {
		this.props = props;
	}
	
	public BeaconConfig( ) {
		this.props = new Properties();
	}
	
	
	
	
	public String getProperty( String propertyName) {
		return props.getProperty(propertyName);
	}
	
	public void setProperty( String propertyName, String value ) {
		props.setProperty(propertyName, value);
	}
	
	
	public String getIdentifier() {
		return getProperty( _profileName ).replace(" ", "_");
	}
	
	
	public void storeProperties() throws Exception {
		if (getProperty( _profileName) ==null)
			throw new IllegalArgumentException("Values must be initialized before storing!");
		String fileName = this.getIdentifier();
		File outFile = new File("configurations/" + fileName + ".props");
		FileOutputStream fout = new FileOutputStream(outFile);
		props.store(fout, "Configurations for profile " + getProperty( _profileName) );
	}
	
	
	public static BeaconConfig getBatchConfig( File file ) throws Exception {
		Properties result = new Properties();
		if (!file.exists())
			throw new Exception("Batch config file does not exist: " + file.getAbsolutePath());
		
		result.load( new FileInputStream( file ));
		return new BeaconConfig( result );
	}

	
	
	public boolean isAutoStart() {
		return getProperty(_autoStart).toLowerCase().equals("true");
	}
	
	public boolean isCustomBatch() {
		return getProperty(_customCmd).toLowerCase().equals("true");
	}
	
	public String getCustomCommand() {
		return getProperty(_cmdParams).replace("\"", "");
	}
	
	
	public File getConfigFile() {
		return new File("configurations/" + getIdentifier() + ".props");
	}
	public String toString() {
		return "Batch Config for profile '" + getProperty(_profileName) + "': \n" +
				"\t- HostName: " + getProperty(_hostName) + "\n" +
				"\t- HostIp: " + getProperty(_hostIp) + "\n" +
				"\t- HostMAC: " + getProperty(_hostMac) + "\n" +
				"\t- LocalOS: " + getProperty(_localOS) + "\n" +
				"\t- LocalOS Value: " + getProperty(_localOSValue) + "\n" +
				"\t- Protocol: " + getProperty(_protocol) + "\n" +
				"\t- Port: " + getProperty(_port) + "\n" +
				"\t- Password: " + getProperty(_password);
	}
	
	
	
}
