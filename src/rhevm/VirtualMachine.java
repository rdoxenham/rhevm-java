package rhevm;

public class VirtualMachine
{
	String vmID, clusterID; 
	String vmName, vmType, vmStatus, vmOSType;
	int vmSockets, vmCores, vmMemory, vmHostID;
	
	public void vmStart()
	{
		// Empty method to start the VM
	}
	
	public void vmShutdown()
	{
		// Empty method to shutdown the VM
	}
	
	public void vmForceOff()
	{
		// Empty method to force the VM down
	}
	
	public void vmDelete()
	{
		// Empty method to delete the VM
	}
	
	public void vmMigrate()
	{
		// Empty method to migrate the VM manually
	}
	
	public String getVMID()
	{
		return vmID;
	}
	
	public String getClusterID()
	{
		return clusterID;
	}
	
	public String getVMName()
	{
		return vmName;
	}
	
	public String getVMType()
	{
		return vmType;
	}
	
	public String getVMStatus()
	{
		return vmStatus;
	}
	
	public String getVMOSType()
	{
		return vmOSType;
	}
	
	public int getVMHost()
	{
		return vmHostID;
	}
	
	public int getVMSockets()
	{
		return vmSockets;
	}
	
	public int getVMCores()
	{
		return vmCores;
	}
	
	public int getVMMemory()
	{
		return vmMemory;
	}
}
