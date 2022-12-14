package ui;

import java.util.Scanner;

import menu.Menu;
import menu.MenuAction;
import server.Servidor;

public class TextUI {
	Servidor server;
	Menu menu;

	class AcaoIniciar implements MenuAction {
		@Override
		public String execute(Object ...params) {
			server.executar();
			return "ok";
		}
	}
	
	class AcaoPausar implements MenuAction {
		@Override
		public String execute(Object ...params) {
			server.pausar();
			return "ok";
		}
	}
	
	class AcaoContinuar implements MenuAction {
		@Override
		public String execute(Object ...params) {
			server.continuar();
			return "ok";
		}
	}
	
	class AcaoParar implements MenuAction {
		@Override
		public String execute(Object ...params) {
			server.parar();
			return "ok";
		}
	}

	public TextUI(Servidor srv) {
		server = srv;
		menu = new Menu("Escolha uma das opcoes...");
		menu.addItem("Iniciar", new AcaoIniciar());
		menu.addItem("Parar", new AcaoParar());
		menu.addItem("Pausar", new AcaoPausar());
		menu.addItem("Continuar", new AcaoContinuar());
		menu.addItem("Terminar", new AcaoTerminar());
	}
	

	public void display() {
		Scanner entrada = null;
		try {
			entrada = new Scanner(System.in);
			boolean forever = true;
			while(forever) {
				menu.display();
				int opcao = entrada.nextInt();
				try {
					MenuAction action = menu.getAction(opcao);
					String result = action.execute(server);
					if (result.equalsIgnoreCase("terminou")) {
						forever = false;
					}
				} catch (Exception ex) {
					println("Oops, algo deu errado, tente novamente.");
					println(ex.getMessage());
				}
			}
		} finally {
			entrada.close();
		}
	}
	
	void println(String msg) {
		System.out.println(msg);
	}
}
