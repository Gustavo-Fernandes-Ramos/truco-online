package game;

import java.util.ArrayList;
import java.util.List;

import deck.Baralho;
import table.Mesa;
import team.Equipe;
import team.Jogador;

public class Jogo {
	private Status status;
	private Mesa mesa;
	
	private Equipe equipe1;
	private Equipe equipe2;
	
	private List<Jogador> jogadores;
	private List<Baralho> cartasJogadores;
	
	public Jogo(String nomeEquipe1, String nomeEquipe2) {
		this.status = new Status();
		this.mesa = new Mesa();
		this.equipe1 = new Equipe(nomeEquipe1);
		this.equipe2 = new Equipe(nomeEquipe2);
		this.jogadores = new ArrayList<Jogador>();
		this.cartasJogadores = new ArrayList<Baralho>();
	}
	
	public Jogo(Status status, Mesa mesa, Equipe equipe1, Equipe equipe2, List<Jogador> jogadores, List<Baralho> cartasJogadores) {
		super();
		this.status = status;
		this.mesa = mesa;
		this.equipe1 = equipe1;
		this.equipe2 = equipe2;
		this.jogadores = jogadores;
		this.cartasJogadores = cartasJogadores;
	}
	
	public boolean inserirParticipante(Jogador jogador) {
		Equipe equipeEscolhida;
		boolean inseriu = false;
		
		if(this.equipe1.possuiVaga() || this.equipe2.possuiVaga()) {
		
			if(this.equipe1.qtdJogadores() <= this.equipe2.qtdJogadores()) {
				equipeEscolhida = this.equipe1;
				
			}else {
				equipeEscolhida = this.equipe2;
			}
			
			this.jogadores.add(jogador);
			this.cartasJogadores.add(new Baralho());
			
			equipeEscolhida.inserirJogador(jogador);
			inseriu = true;
		}
		return inseriu;
	}

	public boolean inserirParticipante(Jogador jogador, Equipe equipe) {
		return inserirParticipante(jogador, new Baralho(), equipe);
	}
	
	public boolean inserirParticipante(Jogador jogador, Baralho cartasJogador, Equipe equipe) {
		boolean inseriu = false;
		
		if(equipe.possuiVaga()) {
			this.jogadores.add(jogador);
			this.cartasJogadores.add(cartasJogador);
			
			equipe.inserirJogador(jogador);
			inseriu = true;
		}
		return inseriu;
	}
	
	public boolean removerParticipante(Jogador jogador) {
		boolean removeu = true;
		
		if(this.equipe1.possuiJogador(jogador)) {
			this.equipe1.removerJogador(jogador);
			
		}else if(this.equipe2.possuiJogador(jogador)) {
			this.equipe2.removerJogador(jogador);
			
		}else {
			removeu = false;
		}
		return removeu;
	}
	
	public Jogador obterJogador(int indice) {
		return this.jogadores.get(indice);
	}
	
	public Baralho obterCartasJogador(int indice) {
		return this.cartasJogadores.get(indice);
	}
	
	public boolean existeJogador(Jogador jogador) {
		return this.jogadores.contains(jogador);
	}
}
