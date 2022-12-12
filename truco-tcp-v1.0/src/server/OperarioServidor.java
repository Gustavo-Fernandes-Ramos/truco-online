package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class OperarioServidor implements Runnable {
	
	private ServerSocket servidorSocket;
	private Socket conexaoCliente;
	
	public OperarioServidor(ServerSocket servidorSocket, Socket conexaoCliente) {
		super();
		this.servidorSocket = servidorSocket;
		this.conexaoCliente = conexaoCliente;
	}

	@Override
	public void run() {
		executar();
	}
	
	public void executar() {
		
		try { 

			DataOutputStream dout=new DataOutputStream(conexaoCliente.getOutputStream());  
			DataInputStream din=new DataInputStream(conexaoCliente.getInputStream()); 
			
			String str="";
			
			while(!str.equals("stop")){ 
				
				str=din.readUTF(); 
				
				
				dout.writeUTF("recebido"); 
				dout.flush();
				
			}
			
			din.close();  
			conexaoCliente.close(); 
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
