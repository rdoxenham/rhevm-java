package rhevm;

import java.util.ArrayList;

import javax.swing.JTable;

public class VMManager 
{
	public ArrayList<VirtualMachine> VMArray = new ArrayList<VirtualMachine>();
	
	public int getVMCount()
	{
		return VMArray.size();
	}
	
	public void reloadData()
	{
		// TODO Empty VM Array
		VirtualMachine vm1 = new VirtualMachine();
		vm1.vmName = "froer.example.com";
		vm1.vmCores = 4;
		VMArray.add(vm1);
	}
	
	public JTable getVMTable(String vmName)
	{
		String[] columnNames = {"First Name",
        "Last Name"};
		VirtualMachine tempVM = (VirtualMachine) VMArray.get(0);
		Object[][] data = {
				{"VM Name", tempVM.getVMName()},
				{"vCPU Cores", tempVM.getVMCores()}
		};
		JTable vmTable = new JTable(data, columnNames);
		return vmTable;
	}
	
	
}
