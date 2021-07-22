package controller.validator;

public class UsernameUniqueException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public UsernameUniqueException(String field)
	{
		super(field + " cannot be same with other customer.");
	}

}
