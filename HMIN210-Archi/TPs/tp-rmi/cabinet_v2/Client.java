package cabinet_v2;

import java.rmi.registry.LocateRegistry;
import java.util.Scanner;
import java.rmi.registry.Registry;

public class Client {
	private Client() {}

	public static void main(String[] args) {

		String host = (args.length < 1) ? null : args[0];
		try {
			Registry registry = LocateRegistry.getRegistry(host);
			
			System.setProperty("java.security.policy", "/mnt/c/Users/Alex/Documents/GitHub/AIGLE-M1-S2/HMIN210-Archi/TPs/tp-rmi/cabinet_v2/cabinet.policy");
			SecurityManager manager = new SecurityManager();
			System.setSecurityManager(manager);
			
			ICabinetVeterinaire stub = (ICabinetVeterinaire) registry.lookup("CabinetVeterinaire");
			Animal lion = new Animal("Lion", "Bob", new Species("mammifere", 12), "Panthera leo", new DossierSuivi(null));
			stub.getPatients().addAnimal(lion);
//			stub.getAnimal()
//			String response = stub.toString();
//			System.out.println("response: " + response);
//			System.out.println(stub.description());
//			
//			stub.set_name("Lion");
//			stub.set_masterName("Bob");
//			stub.set_species(new Species("Mammifere", 20));
//			stub.set_race("etre vivant");
//			
//			System.out.println(stub.description());
		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();
		}
	}
}
