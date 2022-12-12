package table;

import java.util.HashMap;
import java.util.Map;

import deck.Carta;

public class Jogadas {
	private Map<String, Carta> jogadas;

	public Jogadas() {
		super();
		this.jogadas = new HashMap<String, Carta>();
	}
	
	public void inserir(String nome, Carta carta) {
		this.jogadas.put(nome, carta);
	}
	
	public void remover(String nome) {
		this.jogadas.remove(nome);
	}
	
	public void obter(String nome) {
		this.jogadas.getOrDefault(nome, null);
	}
	
	public boolean existe(String nome) {
		return this.jogadas.containsKey(nome);
	}
}
