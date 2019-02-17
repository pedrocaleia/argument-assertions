package pt.pcaleia.arg.assertion;


/**
 * @author Pedro Caleia
 */
public final class NullArgumentAssertions {
	
	
	private static final String MUST_BE_NULL_MESSAGE = "The '%s' argument must be null.";
	private static final String CANNOT_BE_NULL_MESSAGE = "The '%s' argument cannot be null.";

	
	private NullArgumentAssertions() {
		throw new AssertionError( NullArgumentAssertions.class.getSimpleName() + " class cannot be instantiated." );
	}
	
	
	/**
	 * Assert that the given object is null.
	 * 
	 * @param argument
	 * @param argumentName
	 */
	public static void assertNull( Object argument, String argumentName ) {
		StringArgumentAssertions.assertNotEmpty( argumentName, "argumentName" );
		
		if( argument != null ) {
			String message = String.format( MUST_BE_NULL_MESSAGE, argumentName );
			throw new IllegalArgumentException( message );
		}
	}
	
	
	/**
	 * Assert that the given object is not null.
	 * 
	 * @param argument
	 * @param argumentName
	 */
	public static void assertNotNull( Object argument, String argumentName ) {
		StringArgumentAssertions.assertNotEmpty( argumentName, "argumentName" );
		
		if( argument == null ) {
			String message = String.format( CANNOT_BE_NULL_MESSAGE, argumentName );
			throw new IllegalArgumentException( message );
		}
	}
	
}
