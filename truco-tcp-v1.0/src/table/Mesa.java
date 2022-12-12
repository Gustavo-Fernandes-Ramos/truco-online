package table;

import deck.Baralho;
import deck.Carta;

public class Mesa {
	
	private Baralho baralho;
	private Carta vira;
	private Jogadas jogadas;
	
	public Mesa() {
		super();
		this.baralho = new Baralho();
		this.baralho.iniciar();
	}
	
	public Mesa(Baralho baralho) {
		super();
		this.baralho = baralho;
	}

	public Mesa(Baralho baralho, Carta vira, Jogadas jogadas) {
		super();
		this.baralho = baralho;
		this.vira = vira;
		this.jogadas = jogadas;
	}
	
	public Baralho getBaralho() {
		return baralho;
	}

	public void setBaralho(Baralho baralho) {
		this.baralho = baralho;
	}

	public Carta getVira() {
		return vira;
	}

	public void setVira(Carta vira) {
		this.vira = vira;
	}

	public Jogadas getJogadas() {
		return jogadas;
	}

	public void setJogadas(Jogadas jogadas) {
		this.jogadas = jogadas;
	}

}
