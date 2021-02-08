package cabinet_v2;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class Server {

	public Server() {}

	public static void main(String args[]) {
		try {
			CabinetVeterinaire obj = new CabinetVeterinaire();
			Registry registry = LocateRegistry.createRegistry(1099);
			registry = LocateRegistry.getRegistry();
			
			System.setProperty("java.security.policy", "/mnt/c/Users/Alex/Documents/GitHub/AIGLE-M1-S2/HMIN210-Archi/TPs/tp-rmi/cabinet_v2/cabinet.policy");
			SecurityManager manager = new SecurityManager();
			System.setSecurityManager(manager);
			
			if (registry == null) {
				System.err.println("RmiRegistry not found");
			} else {
				registry.bind("CabinetVeterinaire", obj);
				System.err.println("Server ready");
			}
		} catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}
	}
}