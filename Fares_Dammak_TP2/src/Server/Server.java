package Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	try {
		System.out.println("Je suis le server ");
		// port du server
		
		ServerSocket server = new ServerSocket(1234);
		
		System.out.println("En attente du client !! ");
		//la methode accept bloque l'execution jusqua un client se connecte
		Socket s = server.accept();
		System.out.println("Un client est connecté !! ");
		InputStream is = s.getInputStream();
		OutputStream os = s.getOutputStream();
		int nb = is.read();
		int rep1 = nb*5;
		os.write(rep1);
		int rep2 = nb+5;
		os.write(rep2);
		System.out.println("Deconnexion");
		server.close();
		s.close();
	} catch (IOException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	}

}
