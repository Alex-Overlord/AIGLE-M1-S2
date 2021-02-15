import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class Connexion extends UnicastRemoteObject implements IConnexion {

  private static final long serialVersionUID = 1L;

  public Connexion() throws RemoteException {}

  public void alerte(String s) {
    System.out.println("--- Alerte : " + s + " patients enregistrés !");
  }
}
