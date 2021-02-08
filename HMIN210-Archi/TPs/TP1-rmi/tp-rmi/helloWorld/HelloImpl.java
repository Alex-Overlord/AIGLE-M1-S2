package helloWorld;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject  implements Hello {

	private static final long serialVersionUID = 1L;

	public HelloImpl() throws RemoteException {
	}
	
    public String sayHello() throws RemoteException {
    	return "Hello, world!";
    } 

	public void printHello() throws RemoteException {
		System.out.println("The server prints: Hello, world!");
	}
}
