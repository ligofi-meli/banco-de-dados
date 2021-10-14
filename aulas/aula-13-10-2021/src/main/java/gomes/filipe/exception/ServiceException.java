package gomes.filipe.exception;

public class ServiceException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private static String mensagem;
	  
	  public ServiceException(String menagem) {
		super(mensagem);
	}
	  
	  public ServiceException(RuntimeException e) {
		super(e);
	}

}
