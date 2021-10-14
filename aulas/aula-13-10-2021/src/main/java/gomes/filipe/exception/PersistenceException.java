package gomes.filipe.exception;

public class PersistenceException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	private static String mensagem;
	  
	  public PersistenceException(String menagem) {
		super(mensagem);
	}
	  
	  public PersistenceException(RuntimeException e) {
		super(e);
	}
}
