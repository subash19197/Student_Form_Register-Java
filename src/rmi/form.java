package rmi;
import java.rmi.*;
import java.rmi.RemoteException;



public interface form extends Remote{
       String stdData(int eno,String name, String dept, String desg, String uname, String prd)throws RemoteException;
	    
	

	
		
		

	

}
