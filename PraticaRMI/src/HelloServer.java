import java.rmi.*;
import java.rmi.server.*;
import java.util.Scanner;
import java.rmi.registry.*;

public class HelloServer implements Hello {

	public static void main(String[] args) {
		try {
			HelloServer server = new HelloServer();
			//Exporta o server para o stub ("apendice ou toco") do RMI na porta 0
			Hello stub = (Hello) UnicastRemoteObject.exportObject(server, 0);
			
			Registry registry = LocateRegistry.getRegistry();
			// Registra a stub no RMI para que ela seja obtida pelos clientes
			registry.bind("Servidor", stub);
			
			System.out.println("Servidor inicializado com sucesso.");
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
	}

	public double multiplicacao(double a, double b, double c) throws RemoteException {
		System.out.println("Executando metodo neste host, multiplica��o de tr�s n�meros...");
		
		
		       
		//C�lculo da multiplica��o 
		double multiplicacao = a*b*c; 
		
		//Retorna o valor da multiplica��o
		return multiplicacao; 
	}
}
