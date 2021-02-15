//package client;


import java.io.File;
import java.net.URL;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;


public class Client {
	
	private Client() {}
	
	public static void ajoutPatients(ICabinetVeterinaire stub, int n) throws RemoteException {
		System.out.println("Ajout de " + n + " patients");
		for (int i = 0; i < n; i++) {
			stub.addAnimal("Simba" + i, "Bob", new Species("Panthera leo", 12), "Le lion d'Afrique", "Il va bien");
		}
	}

	public static void main(String[] args) {

		String host = (args.length < 1) ? null : args[0];
		Scanner sc = new Scanner(System.in);
		int n = 100;
		try {
			System.setProperty("java.security.policy", "../client/cabinet.policy");
			SecurityManager manager = new SecurityManager();
			System.setSecurityManager(manager);
			
			URL uri = new File("../server").toURI().toURL();
			System.setProperty("java.rmi.server.codebase", uri.toString());

			Registry registry = LocateRegistry.getRegistry(host);
			
			ICabinetVeterinaire stub = (ICabinetVeterinaire) registry.lookup("CabinetVeterinaire");
			
		 	IConnexion co =	new Connexion();
			stub.addConnexion(co); 
			System.out.println(stub.description());

			// stub.addAnimal("Flipper", "Marcel", new Species("Delphinidae", 45), "Delphinides", "Tout baigne");
			// System.out.println(stub.getAnimal("Flipper").description());
			
			while(true) {
				System.out.print("Combient de patients voulez-vous ajoutez ? : ");
				n = sc.nextInt();
				ajoutPatients(stub, n);
				System.out.println(stub.description());
			}
			
		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();
		}
	}
}
