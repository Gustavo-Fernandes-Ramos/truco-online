package deck;

public class Carta {
	
	public static final String[] TIPO_NOMES = {"4", "5", "6", "7", "Rainha", "Valete", "Rei", "Ás", "2", "3"};
	public static final String[] NAIPE_NOMES = {"Ouro", "Espadilha", "Copas", "Paus"};
	
	private int tipo;
	private int naipe;
	
	private boolean escondida = false;
	
	public Carta(int tipo, int naipe) {
		super();
		this.tipo = tipo;
		this.naipe = naipe;
	}
	
	public Carta(int tipo, int naipe, boolean escondida) {
		super();
		this.tipo = tipo;
		this.naipe = naipe;
		this.escondida = escondida;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getNaipe() {
		return naipe;
	}

	public void setNaipe(int naipe) {
		this.naipe = naipe;
	}
	
	public boolean isEscondida() {
		return escondida;
	}

	public void setEscondida(boolean escondida) {
		this.escondida = escondida;
	}

	public String getTipoNome() {
		return TIPO_NOMES[this.tipo];
	}
	
	public String getNaipeNome() {
		return NAIPE_NOMES[this.naipe];
	}
	
	public static boolean tipoValido(int tipo) {
		return ((tipo >= 0) && (tipo < TIPO_NOMES.length));
	} 
	
	public static boolean naipeValido(int naipe) {
		return ((naipe >= 0) && (naipe < NAIPE_NOMES.length));
	}

}
