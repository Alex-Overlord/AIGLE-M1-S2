package server;


//import java.io.Serializable;
//import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

//public class DossierSuivi implements Serializable {
public class DossierSuivi extends UnicastRemoteObject implements IDossierSuivi { 

	private static final long serialVersionUID = 1L;
	private String _suivi;

	public DossierSuivi() throws RemoteException {
		super();
		_suivi = "vide";
	}
	
	public DossierSuivi(String suivi) throws RemoteException {
		super();
		_suivi = suivi;
	}
	
	public String get_suivi() { return _suivi; }
	public void set_suivi(String suivi) { this._suivi = suivi; }
	
	public String toString() {
		String res = "";
		res += _suivi;
		return res;
	}
}
