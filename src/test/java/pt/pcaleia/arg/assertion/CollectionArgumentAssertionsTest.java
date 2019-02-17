package pt.pcaleia.arg.assertion;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


/**
 * @author Pedro Caleia
 */
public final class CollectionArgumentAssertionsTest {
	
	
	private static final List<String> EMPTY_COLLECTION = new ArrayList<>();
	private static final List<String> NON_NULL_ELEMENTS_COLLECTION = new ArrayList<>();
	private static final List<String> SOME_NULL_ELEMENTS_COLLECTION = new ArrayList<>();
	private static final List<String> ALL_NULL_ELEMENTS_COLLECTION = new ArrayList<>();
	
	
	@BeforeAll
	public static void beforeAll() {
		NON_NULL_ELEMENTS_COLLECTION.add( "string one" );
		NON_NULL_ELEMENTS_COLLECTION.add( "string two" );
		NON_NULL_ELEMENTS_COLLECTION.add( "string three" );
		
		SOME_NULL_ELEMENTS_COLLECTION.add( "string one" );
		SOME_NULL_ELEMENTS_COLLECTION.add( null );
		SOME_NULL_ELEMENTS_COLLECTION.add( "string two" );
		
		ALL_NULL_ELEMENTS_COLLECTION.add( null );
		ALL_NULL_ELEMENTS_COLLECTION.add( null );
	}
	
	
	/**
	 * Class Tests
	 */
	
	
	@Test
	public void testThatCollectionArgumentAssertionsClassIsAnUtilityClass() {
		// TODO Pedro Caleia
	}
	
	
	/**
	 * assertEmpty Tests
	 */
	
	
	@Test
	public void testThatAssertEmptyReturnsWhenTheCollectionIsEmpty() {
		CollectionArgumentAssertions.assertEmpty( EMPTY_COLLECTION, "theCollection" );
	}
	
	
	@Test
	public void testThatAssertEmptyThrowsWhenTheCollectionIsNull() {
		Executable executable = () -> CollectionArgumentAssertions.assertEmpty( null, "theCollection" );
		Assertions.assertThrows( IllegalArgumentException.class, executable );
	}
	
	
	@Test
	public void testThatAssertEmptyThrowsWhenTheArgumentNameIsNull() {
		Executable executable = () -> CollectionArgumentAssertions.assertEmpty( EMPTY_COLLECTION, null );
		Assertions.assertThrows( IllegalArgumentException.class, executable );
	}
	
	
	@Test
	public void testThatAssertEmptyThrowsWhenTheCollectionOnlyHasNonNullElements() {
		Executable executable = () -> CollectionArgumentAssertions.assertEmpty( NON_NULL_ELEMENTS_COLLECTION, "theCollection" );
		Assertions.assertThrows( IllegalArgumentException.class, executable );
	}
	
	
	@Test
	public void testThatAssertEmptyThrowsWhenTheCollectionHasBothNullAndNonNullElements() {
		Executable executable = () -> CollectionArgumentAssertions.assertEmpty( SOME_NULL_ELEMENTS_COLLECTION, "theCollection" );
		Assertions.assertThrows( IllegalArgumentException.class, executable );
	}
	
	
	@Test
	public void testThatAssertEmptyThrowsWhenTheCollectionOnlyHasNullElements() {
		Executable executable = () -> CollectionArgumentAssertions.assertEmpty( ALL_NULL_ELEMENTS_COLLECTION, "theCollection" );
		Assertions.assertThrows( IllegalArgumentException.class, executable );
	}
	
	
	/**
	 * assertNotEmpty Tests
	 */
	
	
	@Test
	public void testThatAssertNotEmptyReturnsWhenTheCollectionOnlyHasNonNullElements() {
		CollectionArgumentAssertions.assertNotEmpty( NON_NULL_ELEMENTS_COLLECTION, "theCollection" );
	}
	
	
	@Test
	public void testThatAssertNotEmptyReturnsWhenTheCollectionHasBothNullAndNonNullElements() {
		CollectionArgumentAssertions.assertNotEmpty( SOME_NULL_ELEMENTS_COLLECTION, "theCollection" );
	}
	
	
	@Test
	public void testThatAssertNotEmptyThrowsWhenTheCollectionIsNull() {
		Executable executable = () -> CollectionArgumentAssertions.assertNotEmpty( null, "theCollection" );
		Assertions.assertThrows( IllegalArgumentException.class, executable );
	}
	
	
	@Test
	public void testThatAssertNotEmptyThrowsWhenTheArgumentNameIsNull() {
		Executable executable = () -> CollectionArgumentAssertions.assertNotEmpty( NON_NULL_ELEMENTS_COLLECTION, null );
		Assertions.assertThrows( IllegalArgumentException.class, executable );
	}
	
	
	@Test
	public void testThatAssertNotEmptyThrowsWhenTheCollectionOnlyHasNullElements() {
		Executable executable = () -> CollectionArgumentAssertions.assertNotEmpty( ALL_NULL_ELEMENTS_COLLECTION, "theCollection" );
		Assertions.assertThrows( IllegalArgumentException.class, executable );
	}
	
	
	@Test
	public void testThatAssertNotEmptyThrowsWhenTheCollectionIsEmpty() {
		Executable executable = () -> CollectionArgumentAssertions.assertNotEmpty( EMPTY_COLLECTION, "theCollection" );
		Assertions.assertThrows( IllegalArgumentException.class, executable );
	}
	
	
	/**
	 * assertNonNullElements Tests
	 */
	
	
	@Test
	public void testThatAssertNonNullElementsReturnsWhenTheCollectionOnlyHasNonNullElements() {
		CollectionArgumentAssertions.assertNonNullElements( NON_NULL_ELEMENTS_COLLECTION, "theCollection" );
	}
	
	
	@Test
	public void testThatAssertNonNullElementsReturnsWhenTheCollectionIsEmpty() {
		CollectionArgumentAssertions.assertNonNullElements( EMPTY_COLLECTION, "theCollection" );
	}
	
	
	@Test
	public void testThatAssertNonNullElementsThrowsWhenTheCollectionIsNull() {
		Executable executable = () -> CollectionArgumentAssertions.assertNonNullElements( null, "theCollection" );
		Assertions.assertThrows( IllegalArgumentException.class, executable );
	}
	
	
	@Test
	public void testThatAssertNonNullElementsThrowsWhenTheSecondArgumentIsNull() {
		Executable executable = () -> CollectionArgumentAssertions.assertNonNullElements( NON_NULL_ELEMENTS_COLLECTION, null );
		Assertions.assertThrows( IllegalArgumentException.class, executable );
	}
	
	
	@Test
	public void testThatAssertNonNullElementsThrowsWhenTheCollectionHasBothNullAndNonNullElements() {
		Executable executable = () -> CollectionArgumentAssertions.assertNonNullElements( SOME_NULL_ELEMENTS_COLLECTION, "theCollection" );
		Assertions.assertThrows( IllegalArgumentException.class, executable );
	}
	
	
	@Test
	public void testThatAssertNonNullElementsThrowsWhenTheCollectionOnlyHasNullElements() {
		Executable executable = () -> CollectionArgumentAssertions.assertNonNullElements( ALL_NULL_ELEMENTS_COLLECTION, "theCollection" );
		Assertions.assertThrows( IllegalArgumentException.class, executable );
	}

}
