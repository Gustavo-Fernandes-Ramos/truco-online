package deck;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Baralho {

	private List<Carta> cartas;
	
	public Baralho() {
		this.cartas = new ArrayList<Carta>();
	}

	public Baralho(List<Carta> cartas) {
		super();
		this.cartas = cartas;
	}
	
	public void inserir(Carta carta) {
		this.cartas.add(carta);
	}
	
	public void remover(int indice) {
		this.cartas.remove(indice);
	}

	public Carta obter(int indice) {
		return this.cartas.get(indice);
	}
	
	public boolean existe(Carta carta) {
		return this.cartas.contains(carta);
	}
	
	public void iniciar() {
		for(int i = 0 ; i < Carta.TIPO_NOMES.length ; i++) {
			for(int j = 0 ; j < Carta.NAIPE_NOMES.length ; j++) {
				this.cartas.add(new Carta(i, j));
			}
		}
	}
	
	public void exibir() {
		for(Carta carta: this.cartas) {
			System.out.print("(" + carta.getTipo() + ", " + carta.getNaipe() + ")");
		}
		System.out.print("\n");
	}
	
	public void embaralhar() {
		Collections.shuffle(this.cartas);
	}
	
}
