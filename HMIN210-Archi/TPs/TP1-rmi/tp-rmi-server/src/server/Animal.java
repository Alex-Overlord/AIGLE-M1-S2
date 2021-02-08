package server;



import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Animal extends UnicastRemoteObject implements IAnimal {

	private static final long serialVersionUID = 1L;
	private String _name;
	private String _masterName;
	private Species _species;
	private String _race;
	private DossierSuivi _dossierSuivi;
	
	protected Animal() throws RemoteException {
		super();
		_dossierSuivi = new DossierSuivi();
	}
	protected Animal(String name, String masterName, Species species, String race, DossierSuivi dossierSuivi) throws RemoteException {
		super();
		_name = name;
		_masterName = masterName;
		_species = species;
		_race = race;
		_dossierSuivi = dossierSuivi;
	}
	
	public String get_name() {
		return _name;
	}
	public void set_name(String _name) {
		this._name = _name;
	}
	public String get_masterName() {
		return _masterName;
	}
	public void set_masterName(String _masterName) {
		this._masterName = _masterName;
	}
	public Species get_species() {
		return _species;
	}
	public void set_species(Species _species) {
		this._species = _species;
	}
	public String get_race() {
		return _race;
	}
	public void set_race(String _race) {
		this._race = _race;
	}
	public DossierSuivi get_dossierSuivi() {
		return _dossierSuivi;
	}
	public void set_dossierSuivi(IDossierSuivi _dossierSuivi) {
		this._dossierSuivi = (DossierSuivi) _dossierSuivi;
	}
	
	@Override
	public String description() {
		String result = "\n[Description]\n";
		result += "Name : "+this._name+"\n"
				+"MasterName : "+this._masterName+"\n"
				+"Species : "+this._species+"\n"
				+"Race : "+this._race+"\n"
				+"DossierSuivi : "+this._dossierSuivi+"\n";
		return result;
	}
	
	@Override
	public void setSuivi(String suivi) throws RemoteException {
		_dossierSuivi.set_suivi(suivi);
	}
  
}
