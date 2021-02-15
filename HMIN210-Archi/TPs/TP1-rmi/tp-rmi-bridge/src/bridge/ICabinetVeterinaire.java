//package bridge;



import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ICabinetVeterinaire extends Remote {
	
	public ArrayList<IAnimal> getPatients() throws RemoteException;
	public void setPatients(ArrayList<IAnimal> patients) throws RemoteException;
	public IAnimal getAnimal(String animal_name) throws RemoteException;
	public void addAnimal(String name, String masterName, Species species, String race, String suivi) throws RemoteException;
	public String description() throws RemoteException;
}
