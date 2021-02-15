//package server;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class CabinetVeterinaire extends UnicastRemoteObject implements ICabinetVeterinaire {

	private static final long serialVersionUID = 1L;
	ArrayList<IAnimal> patients = new ArrayList<IAnimal>();
	ArrayList<IConnexion> connexions = new ArrayList<IConnexion>();
	
	protected CabinetVeterinaire() throws RemoteException {
		super();
	}
	
	public String description() throws RemoteException {
		String result = "CabinetVeterinaire (" + patients.size() + ") { ";
		for (IAnimal a : patients) {
			result += a.description() + ", ";
		}
		return result + "}";
	}
	
	@Override
	public ArrayList<IAnimal> getPatients() { 
		return patients; 
	}

	@Override
	public void setPatients(ArrayList<IAnimal> patients) { 
		this.patients = patients; 
	}

	public IAnimal getAnimal(String animal_name) throws RemoteException {
		for (IAnimal a : patients) {
			if (animal_name.equals(a.get_name())) {
				return a;
			}
		}
		return null;
	}
	public void addAnimal(String name, String masterName, Species species, String race, String suivi) throws RemoteException {
		Animal animal = new Animal(name, masterName, species, race, new DossierSuivi(suivi));
		this.getPatients().add(animal);
		if (patients.size() == 100 || patients.size() == 500 || patients.size() == 1000) {
			for (IConnexion co : connexions) {
				co.alerte(String.valueOf(patients.size()));
			}
		}
	}
	
	public void addConnexion(IConnexion co) throws RemoteException {
		connexions.add(co);
	}
	
}
