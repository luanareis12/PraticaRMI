import java.rmi.registry.*;
import java.util.Scanner;

public class HelloClient {
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		double a, b, c, multiplicacao;
		
		try {
			// Procura o registro do RMI no Servidor
			// Se o servidor estiver em outro host basta substituir pelo seu IP
			Registry registry = LocateRegistry.getRegistry("localhost");

			// Procura a stub do servidor
			Hello stub= (Hello) registry.lookup("Servidor");

			// Chama o método do servidor e imprime a mensagem
			System.out.println("Invocando metodo do servidor");
			
			//valor de A
			System.out.println("Digite o valor de a: "); 
			a = Double.parseDouble(read.next());

			//valor de B
			System.out.println("Digite o valor de b: "); 
			b = Double.parseDouble(read.next());
			       
			 //valor de C
			System.out.println("Digite o valor de c: ");
			c = Double.parseDouble(read.next());
			
			multiplicacao = stub.multiplicacao(a, b, c);
			System.out.println("O valor da multiplicação é: " +multiplicacao); 
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
	}
}
