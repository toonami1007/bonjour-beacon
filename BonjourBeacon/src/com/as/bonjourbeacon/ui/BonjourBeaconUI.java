package com.as.bonjourbeacon.ui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.EventObject;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import com.as.bonjourbeacon.control.BeaconConfig;
import com.as.bonjourbeacon.control.Control;
import com.as.bonjourbeacon.utils.Utils;





public class BonjourBeaconUI extends JFrame implements ActionListener{


	
	private static final long serialVersionUID = -745432153435177892L;
	private DefaultTableModel tableModel = null;
	private ConfigurationPanel cfgPanel = null;
	

	
	public BonjourBeaconUI() {
		super("Bonjour Beacon");
				
		// some initial frame settings
		this.setSize(640, 500);
		
			
		Dimension screensize = getToolkit().getScreenSize();
		this.setLocation(screensize.width/2 - 320, screensize.height/2 -250);
		this.setResizable(false);
		//this.setAlwaysOnTop(true);
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		try {
			UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );
		} catch (Exception e) {
			System.out.println("Windows Look not possible");
		} 
		
		initializeGui(  );
		
		setVisible(true);
	}
	
	
	
	
	
	private void initializeGui() {
		JPanel cntPane = (JPanel)this.getContentPane();
		cntPane.setLayout( new BorderLayout() );
		
		this.setIconImages( IconUtil.getImageIconList() );
		// menu bar
		JPanel headerPanel = createHeaderPanel();
		cntPane.add( headerPanel, BorderLayout.PAGE_START);
		
		JPanel centerPanel = new JPanel( new BorderLayout() );
		centerPanel.setBorder( BorderFactory.createEmptyBorder(10, 10, 5, 10) );
		centerPanel.add(    createConfigPanel(), BorderLayout.PAGE_START );	
		centerPanel.add(	createOutputPanel(), BorderLayout.CENTER );
		cntPane.add( centerPanel, BorderLayout.CENTER);
	}
	
	

	
	
	private JPanel createHeaderPanel() {
		
		JPanel result = new JPanel(new GridLayout(1,1) );
		result.setPreferredSize( new Dimension( this.getWidth(), 52));
		result.setBorder( BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
		result.setBackground( Color.WHITE );
		
		JPanel buttons= new JPanel( new FlowLayout(FlowLayout.LEFT, 0, 0));
		buttons.setBackground(Color.white);
		
		JPanel exitItem = getMenuItemPanel("Exit", "exit-24.png");
		exitItem.addMouseListener( new MouseAdapter() {
			public void mouseClicked(  MouseEvent me ) {
				System.exit(0);
			}
		});
		
		JPanel aboutItem = getMenuItemPanel("About", "about-24.png");
		aboutItem.addMouseListener( new MouseAdapter() {
			public void mouseClicked(  MouseEvent me ) {
				new AboutSplashScreen().showSplashScreen();
			}
		});
		buttons.add( exitItem );
		buttons.add( aboutItem );
		
		result.add(buttons);
		return result;
	}
	
	
	
	private JPanel createConfigPanel() {
		JPanel result = new JPanel(new FlowLayout(FlowLayout.LEFT));
		result.setBorder( BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0), BorderFactory.createTitledBorder("Batch Commands")));
		
		
		cfgPanel = new ConfigurationPanel( this );
		result.add( cfgPanel );
		//result.setPreferredSize(new Dimension( result.getWidth(), 100));
		return result;
		
	}
	
	
	
	private JPanel createOutputPanel() {
		JPanel result = new JPanel( new BorderLayout() );
		result.setBorder( BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0), BorderFactory.createTitledBorder("Running Batch Files")));
		
		
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Profile Name");
		tableModel.addColumn("Status");
		tableModel.addColumn("Actions");
		
		
		JTable table = new JTable( tableModel );
		table.setEnabled(true);
		table.getColumnModel().getColumn(0).setPreferredWidth(300);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
		table.setRowHeight(20);
		table.getColumnModel().getColumn(0).setCellRenderer( new LabelRenderer() );
		table.getColumnModel().getColumn(1).setCellRenderer( new LabelRenderer() );
		table.getColumnModel().getColumn(2).setCellRenderer( new PanelRenderer() );
		table.getColumnModel().getColumn(2).setCellEditor( new PanelEditor() );
				
		result.add(new JScrollPane(table,  JScrollPane.VERTICAL_SCROLLBAR_ALWAYS , JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
		return result;
	}
	
	
	private JPanel getMenuItemPanel( String label, String imageName ) {
		final JPanel result = new JPanel( null );
		
		result.setPreferredSize( new Dimension( 60, 52) );
		result.setBackground( Color.white );
		
		JLabel imageLabel = new JLabel(Utils.getImageIconFromRessource(imageName));
		JLabel textLabel = new JLabel(label);
		textLabel.setFont( new Font( textLabel.getFont().getName(), Font.PLAIN, 10) );
		
		Insets insets = result.getInsets();
		// image is 24px
		imageLabel.setBounds(17 + insets.left, 5 + insets.top, 24, 24);
		Dimension d1 = textLabel.getPreferredSize();
		textLabel.setBounds( (int)((60-d1.getWidth())/2) + insets.left-3, 32 + insets.top, d1.width, d1.height);
		
		
		result.add( imageLabel );
		result.add( textLabel );
		
		
		result.addMouseListener(  new MouseAdapter() {
	
		        public void mouseEntered( MouseEvent e) {
		        	result.setBackground( new Color(233, 245,253));
		        }
		        
		        
		        public void mouseExited( MouseEvent e) {
		        	result.setBackground( Color.white );
		        }
		        
		       
	    } );

		
		return result;
	}
	
	
	
	
	public void changeConfig( BeaconConfig cfg ) {
		cfgPanel.changeConfig(cfg);
	}
	
	public void addBatchConfigToTable( BeaconConfig cfg, boolean doRepaint ) {
		
		JPanel acPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0,0));
		//acPanel.setBackground( Color.red );
		
		JButton btnStart = new JButton("Start");
		btnStart.setPreferredSize( new Dimension( 60, 18));
		final BeaconConfig fcfg = cfg;
		btnStart.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JButton src = (JButton)arg0.getSource();
				try {
					if (src.getText().equals("Start")) {
						Control.getInstance().startProcess( fcfg.getIdentifier() );
						updateTableModelAt( fcfg, "Running");
						src.setText("Stop");
						src.repaint();
					} else if (src.getText().equals("Stop")){
						Control.getInstance().stopProcess( fcfg.getIdentifier() );
						src.setText("Start");
						updateTableModelAt( fcfg, "Halted");
						src.repaint();
					}
				} catch( Exception e) {
					// TODO inform user
					e.printStackTrace();
				}
			} });
		acPanel.add(btnStart);
		
		
		final JButton btnMenu = new JButton("Config");
		btnMenu.setPreferredSize( new Dimension( 70, 18));
		btnMenu.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new BatchPopupMenu(fcfg).show(btnMenu, btnMenu.getX(), btnMenu.getY()-50 );
				
			}
			
		});
		acPanel.add(btnMenu);
		tableModel.addRow( new Object[] { cfg.getProperty( BeaconConfig._profileName), "[waiting]",acPanel } );
		
		if (doRepaint)
			this.repaint();
	}
	
	
	
	public void removeBatchConfigFromTable( BeaconConfig cfg) {
		int rowIndex = -1;
		for (int i=0; i<tableModel.getRowCount(); i++) {
			if (((String)tableModel.getValueAt(i, 0)).equals(cfg.getProperty(BeaconConfig._profileName))) {
				rowIndex=i;
				break;
			}
		}
		if (rowIndex > -1)
			tableModel.removeRow( rowIndex );
		this.repaint();
	}
	
	
	
	private void updateTableModelAt( BeaconConfig bcfg, String status) {
		for (int i=0; i<tableModel.getRowCount();i++) {
			if (tableModel.getValueAt(i, 0).equals(bcfg.getProperty( BeaconConfig._profileName))) {
				tableModel.setValueAt(status, i, 1);
				break;
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		new BonjourBeaconUI();
	}





	@Override
	public void actionPerformed(ActionEvent e) {

		String bt = ((JButton)e.getSource()).getText();
		
		if (bt.equals("Add New")) {
			
			// add a new Batch Config
			BeaconConfig bc = cfgPanel.getBatchConfigFromFields();
			System.out.println("Adding batch:");
			System.out.println(bc.toString());
			try {
				bc.storeProperties();
				Control.getInstance().addJob(bc, false);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this, "Batch Config could not be stored: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}
		
		else if (bt.equals("Change")) {
			System.out.println("CHange item!");
			JOptionPane.showMessageDialog(this, "Changing items is not supported in this beta version. Wait for the new release!", "Note", JOptionPane.INFORMATION_MESSAGE);
			cfgPanel.setDefaultValues();
		}
		
		else if (bt.equals("Discard")) {
			cfgPanel.setDefaultValues();
		}
		
		else {
			System.out.println("No button handler");
		}
	}

}




class LabelRenderer extends JLabel implements TableCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Component getTableCellRendererComponent(JTable arg0, Object arg1,
			boolean arg2, boolean arg3, int arg4, int arg5) {
		JLabel result = this;
		if (arg1 instanceof String)
			result.setText( (String)arg1 );
		else if (arg1 instanceof JLabel)
			result = (JLabel)arg1;
		
		result.setBorder( BorderFactory.createEmptyBorder(1,5,1,5));
		return result;
	}
	
}


class PanelRenderer implements TableCellRenderer {


	private static final long serialVersionUID = 1L;

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		JPanel panel = (JPanel)value;
		panel.setBackground(Color.white);
		return panel;
	}
	
}



class PanelEditor implements TableCellEditor {
    public PanelEditor() {
      
    }

    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
    	JPanel pane = (JPanel)value;
    	return pane;
    }

    public void cancelCellEditing() {
        System.out.println("Cancel");
    }

    public boolean stopCellEditing() {        
        return true;
    }

    public Object getCellEditorValue() {
        return null;
    }

   
    

	@Override
	public boolean isCellEditable(EventObject arg0) {
		return true;
	}

	@Override
	public boolean shouldSelectCell(EventObject arg0) {
		return true;
	}
	
	
	@Override
	public void removeCellEditorListener(CellEditorListener arg0) {	}
	
	@Override
	public void addCellEditorListener(CellEditorListener arg0) {}

}






class BatchPopupMenu extends JPopupMenu implements ActionListener{

	private static final long serialVersionUID = 1833433079326540982L;

	private BeaconConfig bcf = null;
	
	public BatchPopupMenu(BeaconConfig bcf) {
		this.bcf = bcf;
		initializeUI();
	}
	
	
	
	private void initializeUI() {
		JMenuItem menuItem;
		menuItem = new JMenuItem("Change Config");
		menuItem.addActionListener(this);
		add(menuItem);
		
		menuItem = new JMenuItem("Change Parameters");
		menuItem.addActionListener(this);
		add(menuItem);
		
		menuItem = new JMenuItem("Delete Item");
		menuItem.addActionListener(this);
		add(menuItem);
		
		menuItem = new JMenuItem(((bcf.isAutoStart())?"Disable":"Enable") + " Autostart");
		menuItem.addActionListener(this);
		add(menuItem);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem src = (JMenuItem)e.getSource();
		
		if (src.getText().equals("Change Config")) {
			Control.getInstance().changeConfigOf(bcf);
		}
		
		else if (src.getText().equals("Delete Item")) {
			Control.getInstance().removeConfig( bcf );
		}
		
		else if (src.getText().equals("Enable Autostart")) {
			bcf.setProperty( BeaconConfig._autoStart, "true");
		}
		
		else if (src.getText().equals("Disable Autostart")) {
			bcf.setProperty( BeaconConfig._autoStart, "false");
		}
		
		else if (src.getText().equals("Change Parameters")) {
			Object result = JOptionPane.showInputDialog(this, "Change the additional Parameters for " + bcf.getProperty( BeaconConfig._profileName ) + ":                                               ", "Additional Parameters", JOptionPane.QUESTION_MESSAGE, null, null, bcf.getCustomCommand() );
			if (result!=null) {
				bcf.setProperty( BeaconConfig._cmdParams, "\"" + (String)result + "\"");
				System.out.println( (String)result );
				System.out.println( BeaconConfig.AIRFOIL_ARGUMENT );
				if (((String)result).equals( BeaconConfig.AIRFOIL_ARGUMENT)) {
					bcf.setProperty( BeaconConfig._customCmd, "false");
					System.out.println("False");
				}
				else {
					bcf.setProperty( BeaconConfig._customCmd, "true");
					System.out.println("true");
				}
			
				try {
					bcf.storeProperties();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(this, "Error while storing properties file. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
				
			
		}

	}

}

