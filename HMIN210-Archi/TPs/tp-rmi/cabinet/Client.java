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
			String response = stub.toString();
			System.out.println("response: " + response);
			System.out.println(stub.description());
			
			try (Scanner scanner = new Scanner(System.in)) {
				System.out.println("Name : ");
				stub.set_name(scanner.nextLine());
				System.out.println("MasterName : ");
				stub.set_masterName(scanner.nextLine());
				System.out.println("Species name : ");
				String speciesName = scanner.nextLine();
				System.out.println("Species average life : ");
				int speciesAverageLife = Integer.parseInt(scanner.nextLine());
				stub.set_species(new Species(speciesName, speciesAverageLife));
				System.out.println("Race : ");
				stub.set_race(scanner.nextLine());
				System.out.println("Suivi du Dossier de suivi : ");
				String suivi = scanner.nextLine();
				stub.set_dossierSuivi(new DossierSuivi(suivi));
			}
			System.out.println(stub.description());
		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();
		}
	}
}
