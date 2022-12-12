package exception;

public class NumeroClientesException extends Exception{
	
	private static final long serialVersionUID = 1L;
	protected int numeroClientes;
	
	public NumeroClientesException(int numeroClientes) {
		this.numeroClientes = numeroClientes;
	}

	@Override
	public String toString() {
		return "Numero de Clientes deve ser igual a 2 ou 4!";
	}
}
