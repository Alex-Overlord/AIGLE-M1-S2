package cabinet_v2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import cabinet.Animal;

public class CabinetVeterinaire extends UnicastRemoteObject implements ICabinetVeterinaire {

	private static final long serialVersionUID = 1L;
	ArrayList<Animal> patients = new ArrayList<Animal>();

	protected CabinetVeterinaire() throws RemoteException {
		super();
	}
	
	@Override
	public ArrayList<Animal> getPatients() { return patients; }
	@Override
	public void setPatients(ArrayList<Animal> patients) { this.patients = patients; }
	
	@Override
	public String toString() {
		return "CabinetVeterinaire [patients=" + patients + "]";
	}
	
	public Animal getAnimal(String animal_name) {
		for (Animal a : patients) {
			if (animal_name == a.get_name()) {
				return a;
			}
		}
		return null;
	}
	public void addAnimal(Animal animal) {
		this.getPatients().add(animal);
	}
	
}
