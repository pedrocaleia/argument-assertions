package pt.pcaleia.arg.assertion;

import java.util.Arrays;
import java.util.function.Predicate;

/**
 * @author Pedro Caleia
 */
public final class ArrayArgumentAssertions {
	
	
	private static final String MUST_BE_EMPTY_MESSAGE = "The %s argument must not have any elements, even null ones.";
	private static final String MUST_HAVE_NON_NULL_ELEMENTS_MESSAGE = "The %s argument must have at least 1 non-null element.";
	private static final String CANNOT_HAVE_NULL_ELEMENTS_MESSAGE = "The %s argument cannot have null elements.";
	
	
	private ArrayArgumentAssertions() {
		throw new AssertionError( ArrayArgumentAssertions.class.getSimpleName() + " class cannot be instantiated." );
	}
	
	
	/**
	 * Assert that the given array is not null and does not have any elements even null ones.
	 * 
	 * @param array
	 * @param argumentName
	 */
	public static <E> void assertEmpty( E[] array, String argumentName ) {
		StringArgumentAssertions.assertNotEmpty( argumentName, "argumentName" );
		NullArgumentAssertions.assertNotNull( array, argumentName );
		
		if( array.length > 0 ) {
			String message = String.format( MUST_BE_EMPTY_MESSAGE, argumentName );
			throw new IllegalArgumentException( message );
		}
	}
	
	
	/**
	 * Assert that the given array is not null and has at least one non-null element. 
	 * 
	 * @param array
	 * @param argumentName
	 */
	public static <E> void assertNotEmpty( E[] array, String argumentName ) {
		StringArgumentAssertions.assertNotEmpty( argumentName, "argumentName" );
		NullArgumentAssertions.assertNotNull( array, argumentName );
		
		if( array.length == 0 ) {
			String message = String.format( MUST_HAVE_NON_NULL_ELEMENTS_MESSAGE, argumentName );
			throw new IllegalArgumentException( message );
		}
		else {
			Predicate<E> nullPredicate = element -> element == null;
			long count = Arrays.stream( array ).parallel().filter( nullPredicate ).count();
			if( array.length == count ) {
				String message = String.format( MUST_HAVE_NON_NULL_ELEMENTS_MESSAGE, argumentName );
				throw new IllegalArgumentException( message );
			}
		}
	}
	
	
	/**
	 * Assert that the given array is not null and does not have any null elements.
	 * 
	 * @param array
	 * @param argumentName
	 */
	public static <E> void assertNonNullElements( E[] array, String argumentName ) {
		StringArgumentAssertions.assertNotEmpty( argumentName, "argumentName" );
		NullArgumentAssertions.assertNotNull( array, argumentName );
		
		if( array.length > 0 ) {
			Predicate<E> nullPredicate = element -> element == null;
			long count = Arrays.stream( array ).parallel().filter( nullPredicate ).count();
			if( count > 0 ) {
				String message = String.format( CANNOT_HAVE_NULL_ELEMENTS_MESSAGE, argumentName );
				throw new IllegalArgumentException( message );
			}
		}
	}

}
