//package bridge;



import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAnimal extends Remote {
	
	public String get_name() throws RemoteException;
	public void set_name(String _name) throws RemoteException;
	public String get_masterName() throws RemoteException;
	public void set_masterName(String _masterName) throws RemoteException;
	public Species get_species() throws RemoteException;
	public void set_species(Species _species) throws RemoteException;
	public String get_race() throws RemoteException;
	public void set_race(String _race) throws RemoteException;
	public IDossierSuivi get_dossierSuivi() throws RemoteException;
	public void set_dossierSuivi(IDossierSuivi _dossierSuivi) throws RemoteException;
	
	public String description() throws RemoteException;
	public void setSuivi(String suivi) throws RemoteException;
}
