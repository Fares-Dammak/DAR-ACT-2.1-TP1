package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import Objet.Operation;

public class Client2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	try {
		System.out.println("Je suis un client ");
		//client et server dans le meme machine
		//Socket client = new Socket("localhost",1234);
		//clien et server n'ont pas dans le meme machine 
		InetAddress inetAddress =  InetAddress.getByName("10.26.15.106");//if faut indique l'adress IP de la machine de server
		//on va connecter au server avec son adress IP et son port mais il faut etre connecter avec le memme reseau
		InetSocketAddress inetSocketAdd = new InetSocketAddress(inetAddress,1234);
		Socket client = new Socket();
		client.connect(inetSocketAdd);
		// les 2 methode getInputStream() et getOutputStream()sont 2 metode d'echange des donnes avec le server
		System.out.println("Je suis un clinet connecté ");
		InputStream is = client.getInputStream();
		OutputStream os = client.getOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(os);
		int nb1;
		String op;
		int nb2;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Donner un nombre 1 : ");
		nb1 = scanner.nextInt();
		//PrintWriter pw = new PrintWriter(os,true);
		//pw.println(nb1);
		System.out.println("Donner un nombre 2 : ");
		nb2 = scanner.nextInt();
		//pw.println(nb2);
		do {
			System.out.println("Choisir l operateur : ");
			System.out.println("Pour + pour addition \n Pour - sustraction \n Pour *multiplication \n Pour / division \n");
			op = scanner.nextLine();
			System.out.println(op);
		}while(!op.equals("+") || !op.equals("-") || !op.equals("*") || !op.equals("/"));
		Operation opr = new Operation(nb1,nb2,op);
		oos.writeObject(opr);
		//pw.println(op);
		//on va lire le nb du l'utilisateur et on va envoyer au server avec methode write
		
		//on va lire le resultat du server
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader bf = new BufferedReader(isr);
		
		System.out.println("Resultat : "+bf.readLine());
		System.out.println("Deconnexion");
		client.close();
		scanner.close();
		
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}
}
