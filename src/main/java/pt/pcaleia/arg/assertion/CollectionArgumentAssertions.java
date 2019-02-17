package pt.pcaleia.arg.assertion;


import java.util.Collection;
import java.util.function.Predicate;


/**
 * @author Pedro Caleia
 */
public final class CollectionArgumentAssertions {
	
	
	private static final String MUST_BE_EMPTY_MESSAGE = "The %s argument must not have any elements, even null ones.";
	private static final String MUST_HAVE_NON_NULL_ELEMENTS_MESSAGE = "The %s argument must have at least 1 non-null element.";
	private static final String CANNOT_HAVE_NULL_ELEMENTS_MESSAGE = "The %s argument cannot have null elements.";
	
	
	private CollectionArgumentAssertions() {
		throw new AssertionError( CollectionArgumentAssertions.class.getSimpleName() + " class cannot be instantiated." );
	}
	
	
	/**
	 * Assert that the given collection is not null and does not have any elements even null ones.
	 * 
	 * @param collection
	 * @param argumentName
	 */
	public static <E> void assertEmpty( Collection<E> collection, String argumentName ) {
		StringArgumentAssertions.assertNotEmpty( argumentName, "argumentName" );
		NullArgumentAssertions.assertNotNull( collection, argumentName );
		
		if( collection.size() > 0 ) {
			String message = String.format( MUST_BE_EMPTY_MESSAGE, argumentName );
			throw new IllegalArgumentException( message );
		}
	}
	
	
	/**
	 * Assert that the given collections is not null and has at least one non-null element.
	 * 
	 * @param collection
	 * @param argumentName
	 */
	public static <E> void assertNotEmpty( Collection<E> collection, String argumentName ) {
		StringArgumentAssertions.assertNotEmpty( argumentName, "argumentName" );
		NullArgumentAssertions.assertNotNull( collection, argumentName );
		
		if( collection.size() == 0 ) {
			String message = String.format( MUST_HAVE_NON_NULL_ELEMENTS_MESSAGE, argumentName );
			throw new IllegalArgumentException( message );
		}
		else {
			Predicate<E> nullPredicate = element -> element == null;
			long count = collection.parallelStream().filter( nullPredicate ).count();
			if( collection.size() == count ) {
				String message = String.format( MUST_HAVE_NON_NULL_ELEMENTS_MESSAGE, argumentName );
				throw new IllegalArgumentException( message );
			}
		}
	}
	
	
	/**
	 * Assert that the given collection is not null and does not have any null elements.
	 * 
	 * @param collection
	 * @param argumentName
	 */
	public static <E> void assertNonNullElements( Collection<E> collection, String argumentName ) {
		StringArgumentAssertions.assertNotEmpty( argumentName, "argumentName" );
		NullArgumentAssertions.assertNotNull( collection, argumentName );
		
		if( collection.size() > 0 ) {
			Predicate<E> nullPredicate = element -> element == null;
			long count = collection.parallelStream().filter( nullPredicate ).count();
			if( count > 0 ) {
				String message = String.format( CANNOT_HAVE_NULL_ELEMENTS_MESSAGE, argumentName );
				throw new IllegalArgumentException( message );
			}
		}
	}

}
