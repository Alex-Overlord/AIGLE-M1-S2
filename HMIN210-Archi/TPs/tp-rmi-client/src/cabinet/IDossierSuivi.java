package cabinet;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IDossierSuivi extends Remote {

	public String get_suivi() throws RemoteException;
	public void set_suivi(String suivi) throws RemoteException;
}
