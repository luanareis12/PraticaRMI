import java.rmi.*;
 
public interface Hello extends Remote {
   public double multiplicacao(double a, double b, double c) throws RemoteException;
}