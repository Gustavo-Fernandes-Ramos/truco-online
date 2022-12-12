package ui;

import java.security.InvalidParameterException;

import menu.MenuAction;
import server.Servidor;

public class AcaoTerminar implements MenuAction {
	@Override
	public String execute(Object ...params) {
		if (params == null) {
			throw new InvalidParameterException("Faltou o Servidor");
		}
		Object obj = params[0];
		if (!(obj instanceof Servidor)) {
			throw new InvalidParameterException("Parametro Invalido: " + obj);				
		}
		Servidor srv = (Servidor)obj;
		srv.terminar();
		return "terminou";
	}
}
