package cabinet;

import java.rmi.registry.LocateRegistry;
import java.util.Scanner;
import java.rmi.registry.Registry;

public class Client {
	private Client() {}

	public static void main(String[] args) {

		String host = (args.length < 1) ? null : args[0];
		try {
			Registry registry = LocateRegistry.getRegistry(host);
			System.setProperty("java.security.policy", "/mnt/c/Users/Alex/Documents/GitHub/AIGLE-M1-S2/HMIN210-Archi/TPs/tp-rmi/cabinet/cabinet.policy");
			SecurityManager manager = new SecurityManager();
			System.setSecurityManager(manager);
			
			IAnimal stub = (IAnimal) registry.lookup("Animal");
			System.out.println(stub.description());
			
			stub.set_name("Lion");
			stub.set_masterName("Daniel");
			stub.set_species(new Species("Panthera leo", 12));
			stub.set_race("Le lion d'Afrique");
//			DossierSuivi ds = new DossierSuivi("Ceci est un suivi"); // envoie un string dans une methode qui elle va creer le DossierSuivi
//			stub.set_dossierSuivi(ds);
//			System.out.println(stub.get_dossierSuivi());
			stub.get_dossierSuivi().set_suivi("Ceci est un suivi");
			System.out.println(stub.get_dossierSuivi().get_suivi());
			
			System.out.println(stub.get_dossierSuivi().getClass().toString());
			System.out.println(stub.get_dossierSuivi().getClass().toString());
			
			System.out.println(stub.description());
			
		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();
		}
	}
}
