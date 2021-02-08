package server;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class CabinetVeterinaire extends UnicastRemoteObject implements ICabinetVeterinaire {

	private static final long serialVersionUID = 1L;
	ArrayList<IAnimal> patients = new ArrayList<IAnimal>();
	
	protected CabinetVeterinaire() throws RemoteException {
		super();
	}
	
	public String description() throws RemoteException {
		String result = "CabinetVeterinaire [patients= ";
		for (IAnimal a : patients) {
			result += a.description();
		}
		return result + "]";
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
//		System.out.println("[getAnimal]");
		for (IAnimal a : patients) {
//			System.out.println(a.get_name());
			if (animal_name.equals(a.get_name())) {
				return a;
			}
		}
		return null;
	}
	public void addAnimal(String name, String masterName, Species species, String race, String suivi) throws RemoteException {
		Animal animal = new Animal(name, masterName, species, race, new DossierSuivi(suivi));
		this.getPatients().add(animal);
	}
	
}
