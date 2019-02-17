package pt.pcaleia.arg.assertion;


/**
 * @author Pedro Caleia
 */
public final class StringArgumentAssertions {
	
	
	private static final String NULL_OR_EMPTY_MESSAGE = "The '%s' argument cannot be null or empty.";

	
	private StringArgumentAssertions() {
		throw new AssertionError( StringArgumentAssertions.class.getSimpleName() + " class cannot be instantiated." );
	}
	
	
	/**
	 * Assert that the given String is not null and contains at least one non white space character.
	 * 
	 * @param argument
	 * @param argumentName
	 */
	public static void assertNotEmpty( String argument, String argumentName ) {
		if( argumentName == null || argumentName.trim().isEmpty() ) {
			String message = String.format( NULL_OR_EMPTY_MESSAGE, "argumentName" );
			throw new IllegalArgumentException( message );
		}
		
		if( argument == null || argument.trim().isEmpty() ) {
			String message = String.format( NULL_OR_EMPTY_MESSAGE, argumentName );
			throw new IllegalArgumentException( message );
		}
	}
	
	
}
