import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IConnexion extends Remote {
  public void alerte() throws RemoteException;
}