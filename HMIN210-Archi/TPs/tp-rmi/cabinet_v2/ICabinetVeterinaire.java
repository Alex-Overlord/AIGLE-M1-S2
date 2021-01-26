package cabinet_v2;

import java.rmi.RemoteException;
import java.util.ArrayList;

import cabinet.Animal;

public interface ICabinetVeterinaire {
	public ArrayList<Animal> getPatients() throws RemoteException;
	public void setPatients(ArrayList<Animal> patients) throws RemoteException;
	public Animal getAnimal(String animal_name) throws RemoteException;
	public void addAnimal(Animal animal) throws RemoteException;
}
