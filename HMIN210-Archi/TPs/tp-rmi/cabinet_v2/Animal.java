package cabinet_v2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Animal extends UnicastRemoteObject implements IAnimal{

	private static final long serialVersionUID = 1L;
	private String _name;
	private String _masterName;
	private Species _species;
	private String _race;
	private DossierSuivi _dossierSuivi;
	
	protected Animal() throws RemoteException {
		super();
	}
	protected Animal(String name, String masterName, Species species, String race, DossierSuivi dossierSuivi) throws RemoteException {
		super();
		_name = name;
		_masterName = masterName;
		_species = species;
		_race = race;
		_dossierSuivi = dossierSuivi;
	}
	
	public String get_name() throws RemoteException {
		return _name;
	}
	public void set_name(String _name) throws RemoteException {
		this._name = _name;
	}
	public String get_masterName() throws RemoteException {
		return _masterName;
	}
	public void set_masterName(String _masterName) throws RemoteException {
		this._masterName = _masterName;
	}
	public Species get_species() throws RemoteException {
		return _species;
	}
	public void set_species(Species _species) throws RemoteException {
		this._species = _species;
	}
	public String get_race() throws RemoteException {
		return _race;
	}
	public void set_race(String _race) throws RemoteException {
		this._race = _race;
	}
	public DossierSuivi get_dossierSuivi() throws RemoteException {
		return _dossierSuivi;
	}
	public void set_dossierSuivi(DossierSuivi _dossierSuivi) {
		this._dossierSuivi = _dossierSuivi;
	}
	
	@Override
	public String description() throws RemoteException {
		String result = "[Description]\n";
		result += "Name : "+this._name+"\n"
				+"MasterName : "+this._masterName+"\n"
				+"Species : "+this._species+"\n"
				+"Race : "+this._race+"\n"
				+"DossierSuivi : "+this._dossierSuivi;
		return result;
	}
	
	@Override
	public void setSuivi(String suivi) throws RemoteException {
		_dossierSuivi.setSuivi(suivi);
	}
  
}
