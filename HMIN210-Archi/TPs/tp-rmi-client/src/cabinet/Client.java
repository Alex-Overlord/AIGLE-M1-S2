package cabinet;


import java.rmi.registry.LocateRegistry;
//import java.util.Scanner;
import java.rmi.registry.Registry;

public class Client {
	
	private Client() {}

	public static void main(String[] args) {

		String host = (args.length < 1) ? null : args[0];
		try {
			Registry registry = LocateRegistry.getRegistry(host);
			System.setProperty("java.security.policy", "/mnt/c/Users/Alex/Documents/GitHub/AIGLE-M1-S2/HMIN210-Archi/TPs/tp-rmi-client/src/cabinet.policy");
			SecurityManager manager = new SecurityManager();
			System.setSecurityManager(manager);
			
			ICabinetVeterinaire stub = (ICabinetVeterinaire) registry.lookup("CabinetVeterinaire");

			stub.addAnimal("Simba", "Bob", new Species("Panthera leo", 12), "Le lion d'Afrique", "Il va bien");
			stub.addAnimal("Flipper", "Marcel", new Species("Delphinidae", 45), "Delphinides", "Tout baigne");
			System.out.println(stub.description());
			System.out.println(stub.getAnimal("Flipper").description());
			
		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();
		}
	}
}
