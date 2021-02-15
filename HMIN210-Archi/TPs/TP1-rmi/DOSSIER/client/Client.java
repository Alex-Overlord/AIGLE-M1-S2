//package client;


import java.io.File;
import java.net.URL;
import java.rmi.registry.LocateRegistry;
// import java.util.Scanner;
import java.rmi.registry.Registry;


public class Client {
	
	private Client() {}

	public static void main(String[] args) {

		String host = (args.length < 1) ? null : args[0];
		try {
			System.setProperty("java.security.policy", "/mnt/c/Users/Alex/Documents/GitHub/AIGLE-M1-S2/HMIN210-Archi/TPs/TP1-rmi/DOSSIER/client/cabinet.policy");
			SecurityManager manager = new SecurityManager();
			System.setSecurityManager(manager);
			
			URL uri = new File("/mnt/c/Users/Alex/Documents/GitHub/AIGLE-M1-S2/HMIN210-Archi/TPs/TP1-rmi/DOSSIER/server").toURI().toURL();
			System.setProperty("java.rmi.server.codebase", uri.toString());

			Registry registry = LocateRegistry.getRegistry(host);
			
			ICabinetVeterinaire stub = (ICabinetVeterinaire) registry.lookup("CabinetVeterinaire");
			
		 	IConnexion co =	new Connexion();
			stub.addConnexion(co); 

			stub.addAnimal("Simba", "Bob", new Species("Panthera leo", 12), "Le lion d'Afrique", "Il va bien");
			stub.addAnimal("Flipper", "Marcel", new Species("Delphinidae", 45), "Delphinides", "Tout baigne");
			System.out.println(stub.description());
			// System.out.println(stub.getAnimal("Flipper").description());
			
			// Scanner sc = new Scanner(System.in);
			while(true);
			
		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();
		}
	}
}
