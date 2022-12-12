package game;

import team.Equipe;

public class Status {
	
	private int partidaAtual = 1;
	private int maoAtual = 1;
	private int rodadaAtual = 1;
	
	private Equipe vencedorPrimeiraRodada = null;
	private int valorMao = 1;
	
	public Status() {
		super();
	}
	
	public Status(int partidaAtual, int maoAtual, int rodadaAtual,
				  Equipe vencedorPrimeiraRodada, int valorMao) {
		super(); 
		this.partidaAtual = partidaAtual;
		this.maoAtual = maoAtual;
		this.rodadaAtual = rodadaAtual;
		this.vencedorPrimeiraRodada = vencedorPrimeiraRodada;
		this.valorMao = valorMao;
	}

	public int getPartidaAtual() {
		return partidaAtual;
	}

	public void setPartidaAtual(int partidaAtual) {
		this.partidaAtual = partidaAtual;
	}

	public int getMaoAtual() {
		return maoAtual;
	}

	public void setMaoAtual(int maoAtual) {
		this.maoAtual = maoAtual;
	}

	public int getRodadaAtual() {
		return rodadaAtual;
	}

	public void setRodadaAtual(int rodadaAtual) {
		this.rodadaAtual = rodadaAtual;
	}

	public Equipe getVencedorPrimeiraRodada() {
		return vencedorPrimeiraRodada;
	}

	public void setVencedorPrimeiraRodada(Equipe vencedorPrimeiraRodada) {
		this.vencedorPrimeiraRodada = vencedorPrimeiraRodada;
	}

	public int getValorMao() {
		return valorMao;
	}

	public void setValorMao(int valorMao) {
		this.valorMao = valorMao;
	}
	
	public static boolean partidaAtualValida(int partidaAtual) {
		return (partidaAtual >= 1 && partidaAtual <= 3);
	}
	
	public static boolean maoAtualValida(int maoAtual) {
		return (maoAtual >= 1 && maoAtual <= 12);
	}
	
	public static boolean rodadaAtualValida(int rodadaAtual) {
		return (rodadaAtual >= 1 && rodadaAtual <= 3);
	}
	
	public boolean incrementarRodadaAtual() {
		boolean ok = true;
		int novaRodada = this.rodadaAtual + 1;
		
		if(rodadaAtualValida(novaRodada)) {
			this.rodadaAtual = novaRodada;
			
		}else {
			this.rodadaAtual = novaRodada % 3;
			int novaMao = this.maoAtual + 1; 
			
			if(maoAtualValida(novaMao)) {
				this.maoAtual = novaMao;
				
			}else {
				this.maoAtual = novaMao % 12;
				int novaPartida = this.partidaAtual + 1;
				
				if(partidaAtualValida(novaPartida)) {
					this.partidaAtual = novaPartida;
					
				}else {
					this.rodadaAtual = 3;
					this.maoAtual = 12;
					ok = false;		//retorna false quando não for mais possivel incrementar
				}
			}
		}
		return ok; 
	}
	
	public static boolean valorMaoValida(int valorMao) {
		return (valorMao == 1 | valorMao == 3 | valorMao == 6 | valorMao == 9 | valorMao == 12);
	}
	
	public boolean incrementarValorMao() {
		int incremento;
		boolean ok = false;
		
		if(this.valorMao == 1) incremento = 2;
		else incremento = 3;
		
		if(this.valorMao != 12) {
			this.valorMao += incremento;
			ok = true;
		}
		return ok;
	}
	
}
