package deck;

public class Vira extends Carta{

	public Vira(int tipo, int naipe) {
		super(tipo, naipe);
	}
	
	public Vira(int tipo, int naipe, boolean escondida) {
		super(tipo, naipe, escondida);
	}

	public int obterManilha() {
		return (this.getTipo() + 1) % 10;
	}
}
