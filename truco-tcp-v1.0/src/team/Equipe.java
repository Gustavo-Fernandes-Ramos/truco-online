package team;

import java.util.ArrayList;
import java.util.List;

public class Equipe {
	
	private String nome;
	
	private int partidasVencidas = 0;
	private int maosVencidas = 0;
	private int rodadasVencidas = 0;
	
	private List<Jogador> jogadores;
	
	private static final int MAX_JOGADORES = 2;
	
	
	public Equipe(String nome) {
		super();
		this.nome = nome;
		this.jogadores = new ArrayList<Jogador>();
	}
	
	public Equipe(String nome, Jogador jogador) {
		this(nome);
		this.inserirJogador(jogador);
	}
	
	public Equipe(String nome, Jogador jogador1, Jogador jogador2) {
		this(nome);
		this.inserirJogador(jogador1);
		this.inserirJogador(jogador2);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getPartidasVencidas() {
		return partidasVencidas;
	}

	public void setPartidasVencidas(int partidasVencidas) {
		this.partidasVencidas = partidasVencidas;
	}
	
	public int getMaosVencidas() {
		return maosVencidas;
	}

	public void setMaosVencidas(int maosVencidas) {
		this.maosVencidas = maosVencidas;
	}

	public int getRodadasVencidas() {
		return rodadasVencidas;
	}

	public void setRodadasVencidas(int rodadasVencidas) {
		this.rodadasVencidas = rodadasVencidas;
	}
	
	public boolean inserirJogador(Jogador jogador) {
		boolean inseriu = false;
		
		if(jogador != null && this.jogadores.size() < MAX_JOGADORES) {
			this.jogadores.add(jogador);
			inseriu = true;
		}
		return inseriu;
	}
	
	public boolean removerJogador(int indice) {
		boolean removeu = false;
		
		if(indice >= 0 && indice < this.jogadores.size()) {
			this.jogadores.remove(indice);
			removeu = true;
		}
		return removeu;
	}
	
	public boolean removerJogador(Jogador jogador) {
		return this.jogadores.remove(jogador);
	}
	
	public Jogador obterJogador(int indice) {
		Jogador jogador = null;
		
		if(indice >= 0 && indice < this.jogadores.size()) {
			jogador = this.jogadores.get(indice);	
		}
		return jogador;
	}
	
	public boolean possuiJogador(Jogador jogador) {
		boolean possui = false;
		
		if(jogador != null) {
			possui = this.jogadores.contains(jogador);
		}
		return possui;
	}
	
	public boolean possuiVaga() {
		return (this.jogadores.size() >= 0 && this.jogadores.size() < MAX_JOGADORES);
	}
	
	public boolean estaVazia() {
		return (this.jogadores.size() == 0);
	}
	
	public int qtdJogadores() {
		return this.jogadores.size();
	}
	
}
