// Java program to implement the Convert Interface
import java.rmi.*;
import java.rmi.server.*;
//import java.lang.Math; 

public class Impl extends UnicastRemoteObject implements ConvertInterface {

	// Default constructor to throw RemoteException
	// from its parent constructor
	public Impl() throws Exception { super(); }

	
	public double convert(double input) {  System.out.println("Received Account Number from CLient " + input); return input + 10000*Math.random(); }
}

