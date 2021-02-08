package cabinet_v2;

import java.rmi.registry.LocateRegistry;
//import java.util.Scanner;
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
//			System.out.println("stub = " + stub);
			stub.addAnimal("Simba", "Bob", new Species("Panthera leo", 12), "Le lion d'Afrique", "Il va bien");
			stub.addAnimal("Flipper", "Marcel", new Species("Delphinidae", 45), "Delphinides", "Tout baigne");
			System.out.println(stub.description());
			System.out.println(stub.getAnimal("Flipper").description());
			
//			Animal lion = new Animal();
//			lion.set_name("Lion");
//			lion.set_masterName("Bob");
//			lion.set_species(new Species("Panthera leo", 12));
//			lion.set_race("Le lion d'Afrique");
//			lion.get_dossierSuivi().set_suivi("Il va bien");
//			stub.addAnimal(lion);
			
//			Animal lion = new Animal("Lion", "Bob", new Species("Panthera leo", 12), "Le lion d'Afrique", null);
//			stub.getPatients().addAnimal(lion);
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
//			System.out.println(stub.toString());
		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();
		}
	}
}
