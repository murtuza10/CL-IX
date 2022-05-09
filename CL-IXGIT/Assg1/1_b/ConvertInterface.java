// Creating a  interface
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface ConvertInterface extends Remote {
	// Declaring the method prototype
	public double convert(double input) throws RemoteException;
}

