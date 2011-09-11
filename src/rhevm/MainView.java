package rhevm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainView 
{
	private static String this_version = "1.1";
	private static JTabbedPane tabbedPane;
	private static JPanel	hostPanel;
	private static JPanel	dcPanel;
	private static JSplitPane vmPanel;
	private static JPanel clusterPanel;
	private static JScrollPane vmScroll;
	public JTable vmTable;
	
	public JMenuBar createMenuBar() 
	{
	        JMenuBar menuBar;
	        JMenu menu, submenu;
	        JMenuItem menuItem;

	        menuBar = new JMenuBar();
	        menu = new JMenu("Main Menu");
	        menuBar.add(menu);
	        menuItem = new JMenuItem("Connect..");
	     
	        menu.add(menuItem);
	 
	        menu.addSeparator();
	        submenu = new JMenu("New");
	        menu.add(submenu);
	        menuItem = new JMenuItem("Virtual Machine");
	        submenu.add(menuItem);
	        
	        menu.addSeparator();
	        menuItem = new JMenuItem("Quit");
	        menu.add(menuItem);

	        menu = new JMenu("Preferences");
	        menuItem = new JMenuItem("RHEV Settings");
	        menu.add(menuItem);
	        menuBar.add(menu);
	        
	        menu = new JMenu("Help");
	        menuItem = new JMenuItem("About");
	        menu.add(menuItem);
	        menuBar.add(menu);

	        return menuBar;
	}

	public void buildUI()
	{
		JFrame mainWindow = new JFrame("Red Hat Enterprise Virtualisation Manager v" + this_version);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setSize(700, 600);
		mainWindow.setLayout(new BorderLayout(5,5));
		mainWindow.setJMenuBar(createMenuBar());
		String comboData[] = { "Select RHEV Instance...", "DemoLab Farnborough (rhev-m.saleslab.fab.redhat.com:8543)"};
		JPanel topPanel = new JPanel(new BorderLayout(2,2));
		JComboBox topSelect = new JComboBox(comboData);
		topPanel.add(topSelect, BorderLayout.SOUTH);
		mainWindow.getContentPane().add(topPanel, BorderLayout.NORTH);
		tabbedPane = new JTabbedPane();
		
		createVMPane();
		createHostPanel();
		
		tabbedPane.addTab( "RHEV Data Centers", dcPanel );
		tabbedPane.addTab( "RHEV Clusters", clusterPanel );
		tabbedPane.addTab( "Physical Hosts", hostPanel );
		tabbedPane.addTab( "Virtual Machines", vmPanel );
		
		mainWindow.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		JLabel statusLabel = new JLabel("Status: OFFLINE");
		mainWindow.getContentPane().add(statusLabel, BorderLayout.SOUTH);
        mainWindow.setVisible(true);
	}
	
	private void createHostPanel()
	{
		hostPanel = new JPanel(new FlowLayout());
		JLabel empty = new JLabel("Hello");
		hostPanel.add(empty);
	}
	
	private void createVMPane() 
	{
		String listData[] = { "hello", "vm2.example.com", "vm3.example.com","vm1.example.com", "vm2.example.com","vm1.example.com", "vm2.example.com","vm1.example.com", "vm2.example.com","vm1.example.com", "vm2.example.com","vm1.example.com", "vm2.example.com","vm1.example.com", "vm2.example.com" };
		JList vmList = new JList(listData);
		vmScroll = new JScrollPane(vmList);
		JPanel vmRightHand = new JPanel();
		vmRightHand.setLayout(new BoxLayout(vmRightHand, BoxLayout.PAGE_AXIS));
		
		VMManager thisVM = new VMManager();
		thisVM.reloadData();
		vmTable = thisVM.getVMTable("hello");
		
		vmRightHand.add(vmTable);
		JPanel vmBottomPanel = new JPanel(new FlowLayout());
		JButton testButton = new JButton("Start VM");
		vmBottomPanel.add(testButton);
		JButton testButton2 = new JButton("Shutdown VM");
		vmBottomPanel.add(testButton2);
		JButton testButton3 = new JButton("Force Off");
		vmBottomPanel.add(testButton3);
		JButton testButton4 = new JButton("Delete VM");
		vmBottomPanel.add(testButton4);
		vmRightHand.add(vmBottomPanel);
		vmPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, vmScroll, vmRightHand);
		vmPanel.setDividerLocation(200);
	}

	public static void main(String[] args) 
	{
		MainView rhevm = new MainView();
		rhevm.buildUI();
	}

}
