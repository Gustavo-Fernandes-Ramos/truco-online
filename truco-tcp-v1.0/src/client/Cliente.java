package client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

import exception.conexaoException;
import file.SimpleFile;

public class Cliente {
	
	private Socket socket = null; 
	
	public Cliente(List<String> enderecosHost, int porta) throws conexaoException {	
		
		this.socket = definirHost(enderecosHost, porta);
		
		if(this.socket == null) throw new conexaoException();
	}
	
	public Socket definirHost(List<String> enderecosHost, int porta) {
		Socket possivelSocket = null;	int indice = 0;
		boolean encontrou = false;
		
		while(!encontrou && indice < enderecosHost.size()) {
			
			try {
				possivelSocket = new Socket(enderecosHost.get(indice), porta);
				encontrou = true;
				
			}catch(ConnectException e){
				continue;
			}catch (UnknownHostException e) {
				continue;
			} catch (IOException e) {
				continue;
			} finally {
				indice++;
			}
			
		}
		return possivelSocket;
	}
	
	public void executar() {
		try{  
			
			DataOutputStream dout=new DataOutputStream(this.socket.getOutputStream());  
			DataInputStream din=new DataInputStream(this.socket.getInputStream());  
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
			  
			String request = "", answer;
			
			while(!request.equals("stop")){
				System.out.print("escrever para o servidor: ");
				
				request=br.readLine(); 
		
				dout.writeUTF(request); 
				dout.flush();
				
				answer=din.readUTF();
				System.out.println(answer);
			}
				    
			dout.close();  
			this.socket.close();  
			
		}catch(ConnectException e){
			System.out.println("Conexao com o servidor foi recusada!");
		}catch(IOException e){
			System.out.println("Ocorreu uma IOException do lado cliente!");
		}catch(Exception e){
			System.out.println("Ocorreu uma Exception do lado cliente!");
		}
	}

	public static void main(String[] args) { 
		try {
			SimpleFile f = new SimpleFile("servidor-sockets.txt");
			f.createFile();
			Cliente cliente;
			cliente = new Cliente(f.readFileLines(), 8080);
			cliente.executar();
			
		} catch (conexaoException e) {
			e.printStackTrace();
		}
	}
		
}