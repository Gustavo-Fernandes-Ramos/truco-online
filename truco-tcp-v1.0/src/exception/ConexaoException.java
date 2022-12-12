package exception;

public class ConexaoException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public ConexaoException() {}
	
	@Override
	public String toString() {
		return "nao foi possivel se conectar a nenhum dos enderecos do arquivo .txt de enderecos ip!";
	}
	
}
