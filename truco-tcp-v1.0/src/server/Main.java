package server;


import java.io.IOException;

import ui.TextUI;

public class Main {

	public static void main(String[] args) {
		
		try {
			Servidor server = new ServidorTruco();
			TextUI ui = new TextUI(server);
			ui.display();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
