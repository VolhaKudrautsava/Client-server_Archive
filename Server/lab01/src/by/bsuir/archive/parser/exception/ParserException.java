package by.bsuir.archive.parser.exception;

public class ParserException extends Exception{
	private static final long serialVersionUID = 1L;

	public ParserException(){
	}

	public ParserException(Exception e){
		super(e);
	}
	
	public ParserException(String message){
		super(message);
	}
	
	public ParserException(String message, Exception e){
		super(message, e);
	}
}