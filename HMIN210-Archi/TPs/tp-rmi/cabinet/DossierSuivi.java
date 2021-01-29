package cabinet;

//import java.io.Serializable;
//import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class DossierSuivi extends UnicastRemoteObject implements IDossierSuivi {
//public class DossierSuivi implements Serializable {
	private static final long serialVersionUID = 1L;
	private String _suivi;
	
	public DossierSuivi() throws RemoteException {
		super();
	}
	
	public DossierSuivi(String suivi) throws RemoteException {
		super();
		_suivi = suivi;
	}
	
	public String toString() {
		String res = "";
		res += _suivi;
		return res;
	}

	public void setSuivi(String suivi) {
		_suivi = suivi;
	}
}
