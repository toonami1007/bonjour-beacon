package com.as.bonjourbeacon.ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import com.as.bonjourbeacon.control.BeaconConfig;



	/**
	 *
	 * @author Mastereye
	 */
public class ConfigurationPanel extends javax.swing.JPanel {

	private static final long serialVersionUID = 5264799100366435047L;
	
	private BonjourBeaconUI control = null;
	
	
	/** Creates new form ConfigurationPanel */
    public ConfigurationPanel( BonjourBeaconUI control) {
    	this.control = control;
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        _profileName = new javax.swing.JTextField();
        _hostName = new javax.swing.JTextField();
        _hostMAC = new javax.swing.JTextField();
        _hostIp = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        _password = new javax.swing.JTextField();
        _customOS = new javax.swing.JTextField();
        _protocol = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        _localOS = new javax.swing.JComboBox();
        _btnSubmit = new javax.swing.JButton();

        setName("Form"); // NOI18N

        jPanel1.setName("jPanel1"); // NOI18N

        //org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(desktopapplication1.DesktopApplication1.class).getContext().getResourceMap(ConfigurationPanel.class);
        _profileName.setText(""); // NOI18N
        _profileName.setName("_profileName"); // NOI18N

        _hostName.setName("_hostName"); // NOI18N

        _hostMAC.setText(""); // NOI18N
        _hostMAC.setName("_hostMAC"); // NOI18N

        _hostIp.setText(""); // NOI18N
        _hostIp.setName("_hostIp"); // NOI18N

        jLabel1.setText("Profile Name:"); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel4.setText(("Host Name:")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        jLabel2.setText(("Host MAC:")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setText(("Host IP")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(54, 54, 54)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(_hostIp, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(_hostMAC, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(_hostName, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(_profileName, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(_profileName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(_hostName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(_hostMAC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(_hostIp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel3.setName("jPanel3"); // NOI18N

        _password.setName("_password"); // NOI18N

        _customOS.setEditable(false);
        _customOS.setText(""); // NOI18N
        _customOS.setName("_customOS"); // NOI18N

        _protocol.setEditable(true);
        _protocol.setText(""); // NOI18N
        _protocol.setName("_protocol"); // NOI18N

        jLabel8.setText("Password:"); // NOI18N
        jLabel8.setName("jLabel8"); // NOI18N

        jLabel9.setText(("Local OS:")); // NOI18N
        jLabel9.setName("jLabel9"); // NOI18N

        jLabel10.setText(("")); // NOI18N
        jLabel10.setName("jLabel10"); // NOI18N

        jLabel11.setText(("Protocol/Port:")); // NOI18N
        jLabel11.setName("jLabel11"); // NOI18N

        _localOS.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Windows Vista", "Windows XP/2000", "MacOsX (MacBook Pro 3.1)", "Custom" }));
        _localOS.setName("_localOS"); // NOI18N
        
        _localOS.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();
				
				_customOS.setEnabled(false);
				int selIndex =cb.getSelectedIndex();
				switch (selIndex) {
				case 0: 	_customOS.setText( "Win32NT.6"); break;
				case 1:		_customOS.setText( "Win32NT.5"); break;
				case 2:		_customOS.setText( "MAC VALUE"); break;
				case 3:		_customOS.setText( "Enter your OS value"); _customOS.setEnabled(true); _customOS.setEditable(true); break;
				default: 	_customOS.setText( "undefined");
				}
			}});

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addGap(168, 168, 168))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(_protocol)
                            .addComponent(_customOS)
                            .addComponent(_password)
                            .addComponent(_localOS, 0, 150, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(_localOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(_customOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(_protocol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        _btnSubmit.setText(("Add New")); // NOI18N
        _btnSubmit.setName("_btnSubmit"); // NOI18N
        _btnSubmit.addActionListener( control );
        _btnSubmit.setActionCommand("addNew");
        
        _btnReset = new JButton("Discard");
        _btnReset.setName("_btnReset"); // NOI18N
        _btnReset.addActionListener( control );
        _btnReset.setActionCommand("reset");
        _btnReset.setVisible(false);

        JPanel btnPanel = new JPanel( new FlowLayout( FlowLayout.LEFT, 0,0 ));
        btnPanel.add(_btnSubmit);
        btnPanel.add( _btnReset );
        
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnPanel /*_btnSubmit*/, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, 0, 122, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent( btnPanel /*_btnSubmit*/)
                .addContainerGap())
        );
        
        
        setDefaultValues();
    }// </editor-fold>


    
    public void setDefaultValues() {
    	_btnSubmit.setText("Add New");
    	_btnReset.setVisible(false);
    	_profileName.setEnabled(true);
    	_localOS.setSelectedIndex(0);
    	_customOS.setText( "Win32NT.6");
    	_hostIp.setText("");
    	_hostMAC.setText("");
    	_hostName.setText("");
    	_password.setText("");
    	_profileName.setText("");
    	_protocol.setText("_airfoilspeaker._tcp./5000");
    }
    
    public void setValues( BeaconConfig cfg) {
    	for (int i=0; i<_localOS.getItemCount();i++) {
    		if (_localOS.getItemAt(i).equals(cfg.getProperty(BeaconConfig._localOS))) {
    			_localOS.setSelectedIndex(i);
    			break;
    		}
    	}		
    	_customOS.setText(cfg.getProperty( BeaconConfig._localOSValue));
    	_hostIp.setText(cfg.getProperty( BeaconConfig._hostIp));
    	_hostMAC.setText(cfg.getProperty( BeaconConfig._hostMac));
    	_hostName.setText(cfg.getProperty( BeaconConfig._hostName));
    	_password.setText(cfg.getProperty( BeaconConfig._password));
    	_profileName.setText(cfg.getProperty( BeaconConfig._profileName));
    	_protocol.setText("_airfoilspeaker._tcp./5000");
    }
    
    
    public void changeConfig( BeaconConfig cfg) {
    	setValues(cfg);
    	_profileName.setEnabled(false);
    	_btnSubmit.setText("Change");
    	_btnReset.setVisible(true);
    	this.repaint();
    }
    
    public BeaconConfig getBatchConfigFromFields() {
    	BeaconConfig result = new BeaconConfig();
    	
    	result.setProperty( BeaconConfig._autoStart, "false" );
    	result.setProperty( BeaconConfig._hostIp, _hostIp.getText() );
    	result.setProperty( BeaconConfig._hostMac, _hostMAC.getText());
    	result.setProperty( BeaconConfig._hostName, _hostName.getText() );
    	result.setProperty( BeaconConfig._localOS, (String)_localOS.getItemAt( _localOS.getSelectedIndex() ));
    	result.setProperty( BeaconConfig._localOSValue, _customOS.getText());
    	result.setProperty( BeaconConfig._password, _password.getText());
    	String protocol = _protocol.getText().substring( 0, _protocol.getText().lastIndexOf('/'));
    	String port = _protocol.getText().substring( _protocol.getText().lastIndexOf('/') + 1 );
    	result.setProperty( BeaconConfig._port, port);
    	result.setProperty( BeaconConfig._profileName, _profileName.getText());
    	result.setProperty( BeaconConfig._protocol, protocol);
    	result.setProperty( BeaconConfig._cmdParams, "\"" + BeaconConfig.AIRFOIL_ARGUMENT + "\"");
    	result.setProperty( BeaconConfig._customCmd, "false");
    	return result;
    }

    // Variables declaration - do not modify
    private javax.swing.JButton _btnSubmit;
    private javax.swing.JButton _btnReset;
    private javax.swing.JTextField _customOS;
    private javax.swing.JTextField _hostIp;
    private javax.swing.JTextField _hostMAC;
    private javax.swing.JTextField _hostName;
    private javax.swing.JComboBox _localOS;
    private javax.swing.JTextField _password;
    private javax.swing.JTextField _profileName;
    private javax.swing.JTextField _protocol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration

}
