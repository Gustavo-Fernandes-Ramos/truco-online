package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.List;

import game.Jogo;

public class ServidorTruco implements Servidor, Runnable{

	private static final int porta = 8080;
	
	private boolean parado = true;
	private boolean pausado = false;
	
	private Thread threadWorker = null;
	private Object monitor = new Object();
	
	private ServerSocket socket = null;
	
	private Jogo jogo = null;
	
	private List<Socket> conexoesCliente = null;
	
	public ServidorTruco() throws IOException {
		super();
		this.socket = new ServerSocket(porta);
		this.socket.setSoTimeout(2*1000);
	}
	
	public boolean pausado() {
		return pausado;
	}
	
	public boolean parado() {
		return parado;
	}

	@Override
	public void iniciar() {
		executar();
	}

	@Override
	public void pausar() {
		pausado = true;
	}

	@Override
	public void parar() {
		parado = true;
		threadWorker = null;
	}

	@Override
	public void continuar() {
		if (parado) {
			System.out.println("SERVIDOR FAKE ESTA PARADO.");
			return;
		}
		if(pausado) {
			pausado = false;
			synchronized(monitor) {
				monitor.notify();
			}
		}
	}

	@Override
	public void executar() {
		if (pausado) {
			continuar();
		}
		if (parado) {
			parado = false;
			threadWorker = new Thread(this);
			threadWorker.start();
		}
	}
	
	@Override
	public void run() {
		_executar();
	}
	
	@Override
	public void terminar() {
		try {
			System.out.println("TERMINOU SERVIDOR FAKE.");
			this.socket.close();
			this.socket = null;
			parar();
			
		} catch (IOException e) { }
	}
	
	private void _executar() {	
		System.out.println("INICIOU SERVIDOR FAKE");
		while(true) {
			try {
				if (parado) {
					break;
				}
				if (pausado) {
					System.out.println("PAUSOU SERVIDOR FAKE");
					synchronized(monitor) {
						monitor.wait();
					}
					System.out.println("CONTINUOU SERVIDOR FAKE");
				}
				Thread.sleep(1*1000);
				
				System.out.println("SERVIDOR FAKE EXECUTANDO");
				
				if(this.socket == null || this.socket.isClosed()) {
					break;
				}
				
				Socket connect = this.socket.accept();
				
				OperarioServidor operario = new OperarioServidor(this.socket, connect);
				Thread threadHandler = new Thread(operario);
				threadHandler.start();
				
			} catch(InterruptedException e) { 
				e.printStackTrace();
			} catch (SocketTimeoutException e) {
				continue;
			}catch (SocketException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean inserirCliente(Socket conexaoCliente) {
		return this.conexoesCliente.add(conexaoCliente);
	}
	
	public Socket removerCliente(int indice) {
		return this.conexoesCliente.remove(indice);
	}
	
	public boolean removerCliente(Socket conexaoCliente) {
		return this.conexoesCliente.remove(conexaoCliente);
	}
	
	public Socket obterCliente(int indice) {
		return this.conexoesCliente.get(indice);
	}
	
	public boolean clienteExiste(Socket conexaoCliente) {
		return this.conexoesCliente.contains(conexaoCliente);
	}
}
