//package server;


import java.rmi.registry.Registry;
import java.io.File;
import java.net.URL;
import java.rmi.registry.LocateRegistry;

public class Server {

	public Server() {}

	public static void main(String args[]) {
		try {
			CabinetVeterinaire obj = new CabinetVeterinaire();
			
			System.setProperty("java.security.policy", "/mnt/c/Users/Alex/Documents/GitHub/AIGLE-M1-S2/HMIN210-Archi/TPs/TP1-rmi/tp-rmi-server/src/cabinet.policy");
			SecurityManager manager = new SecurityManager();
			System.setSecurityManager(manager);
			URL uri = new File("/mnt/c/Users/Alex/Documents/GitHub/AIGLE-M1-S2/HMIN210-Archi/TPs/TP1-rmi/tp-rmi-bridge/bin").toURI().toURL();
			System.setProperty("java.rmi.server.codebase", uri.toString());

			Registry registry = LocateRegistry.createRegistry(1099);
			
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