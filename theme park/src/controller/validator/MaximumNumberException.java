package controller.validator;

public class MaximumNumberException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public MaximumNumberException(String field, int minimum)
	{
		super(field + "Must be greater than or equal to" + minimum + ".");
	}
	public MaximumNumberException(String field, double minimum)
	{
		super(field + "Must be greater than or equal to" + minimum + ".");
	}

	
}
