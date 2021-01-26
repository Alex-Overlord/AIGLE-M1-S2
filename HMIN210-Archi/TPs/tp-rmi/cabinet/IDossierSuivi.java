package cabinet;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IDossierSuivi extends Remote {

	public void setSuivi(String suivi) throws RemoteException;
}
