package util;

public class NoDestinoException extends Exception{
	private Throwable innerException;
	private String message;
	
	
	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public NoDestinoException(Throwable e, String message){
		this.innerException=e;
		this.setMessage(message);
	}
	
	public NoDestinoException(String message){
		this.setMessage(message);
	}

}