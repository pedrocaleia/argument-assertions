package pt.pcaleia.arg.assertion;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


/**
 * @author Pedro Caleia
 */
public final class ArrayArgumentAssertionsTest {
	
	
	private static final String[] EMPTY_ARRAY = new String[ 0 ];
	private static final String[] NON_NULL_ELEMENTS_ARRAY = new String[ 3 ];
	private static final String[] SOME_NULL_ELEMENTS_ARRAY = new String[ 3 ];
	private static final String[] ALL_NULL_ELEMENTS_ARRAY = new String[ 2 ];
	
	
	@BeforeAll
	public static void beforeAll() {
		NON_NULL_ELEMENTS_ARRAY[ 0 ] = "string one";
		NON_NULL_ELEMENTS_ARRAY[ 1 ] = "string two";
		NON_NULL_ELEMENTS_ARRAY[ 2 ] = "string three";
		
		SOME_NULL_ELEMENTS_ARRAY[ 0 ] = "string one";
		SOME_NULL_ELEMENTS_ARRAY[ 1 ] = null;
		SOME_NULL_ELEMENTS_ARRAY[ 2 ] = "string three";
		
		ALL_NULL_ELEMENTS_ARRAY[ 0 ] = null;
		ALL_NULL_ELEMENTS_ARRAY[ 1 ] = null;
	}
	
	
	/*
	 * Class Tests
	 */
	
	
	@Test
	public void testThatArrayArgumentAssertionsClassIsAnUtilityClass() {
		// TODO Pedro Caleia
	}
	
	
	/*
	 * assertEmpty Tests
	 */
	
	
	@Test
	public void testThatAssertEmptyReturnsWhenTheArrayIsEmpty() {
		ArrayArgumentAssertions.assertEmpty( EMPTY_ARRAY, "theArray" );
	}
	
	
	@Test
	public void testThatAssertEmptyThrowsWhenTheArrayIsNull() {
		Executable executable = () -> ArrayArgumentAssertions.assertEmpty( null, "theArray" );
		Assertions.assertThrows( IllegalArgumentException.class, executable );
	}
	
	
	@Test
	public void testThatAssertEmptyThrowsWhenTheArgumentNameIsNull() {
		Executable executable = () -> ArrayArgumentAssertions.assertEmpty( EMPTY_ARRAY, null );
		Assertions.assertThrows( IllegalArgumentException.class, executable );
	}
	
	
	@Test
	public void testThatAssertEmptyThrowsWhenTheArrayOnlyHasNonNullElements() {
		Executable executable = () -> ArrayArgumentAssertions.assertEmpty( NON_NULL_ELEMENTS_ARRAY, "theArray" );
		Assertions.assertThrows( IllegalArgumentException.class, executable );
	}
	
	
	@Test
	public void testThatAssertEmptyThrowsWhenTheArrayHasBothNullAndNonNullElements() {
		Executable executable = () -> ArrayArgumentAssertions.assertEmpty( SOME_NULL_ELEMENTS_ARRAY, "theArray" );
		Assertions.assertThrows( IllegalArgumentException.class, executable );
	}
	
	
	@Test
	public void testThatAssertEmptyThrowsWhenTheArrayOnlyHasNullElements() {
		Executable executable = () -> ArrayArgumentAssertions.assertEmpty( ALL_NULL_ELEMENTS_ARRAY, "theArray" );
		Assertions.assertThrows( IllegalArgumentException.class, executable );
	}
	
	
	/*
	 * assertNotEmpty Tests
	 */
	
	
	@Test
	public void testThatAssertNotEmptyReturnsWhenTheArrayOnlyHasNonNullElements() {
		ArrayArgumentAssertions.assertNotEmpty( NON_NULL_ELEMENTS_ARRAY, "theArray" );
	}
	
	
	@Test
	public void testThatAssertNotEmptyReturnsWhenTheArrayHasBothNullAndNonNullElements() {
		ArrayArgumentAssertions.assertNotEmpty( SOME_NULL_ELEMENTS_ARRAY, "theArray" );
	}
	
	
	@Test
	public void testThatAssertNotEmptyThrowsWhenTheArrayIsNull() {
		Executable executable = () -> ArrayArgumentAssertions.assertNotEmpty( null, "theArray" );
		Assertions.assertThrows( IllegalArgumentException.class, executable );
	}
	
	
	@Test
	public void testThatAssertNotEmptyThrowsWhenTheArgumentNameIsNull() {
		Executable executable = () -> ArrayArgumentAssertions.assertNotEmpty( NON_NULL_ELEMENTS_ARRAY, null );
		Assertions.assertThrows( IllegalArgumentException.class, executable );
	}
	
	
	@Test
	public void testThatAssertNotEmptyThrowsWhenTheArrayOnlyHasNullElements() {
		Executable executable = () -> ArrayArgumentAssertions.assertNotEmpty( ALL_NULL_ELEMENTS_ARRAY, "theArray" );
		Assertions.assertThrows( IllegalArgumentException.class, executable );
	}
	
	
	@Test
	public void testThatAssertNotEmptyThrowsWhenTheArrayIsEmpty() {
		Executable executable = () -> ArrayArgumentAssertions.assertNotEmpty( EMPTY_ARRAY, "theArray" );
		Assertions.assertThrows( IllegalArgumentException.class, executable );
	}
	
	
	/*
	 * assertNonNullElements Tests
	 */
	
	
	@Test
	public void testThatAssertNonNullElementsReturnsWhenTheArrayOnlyHasNonNullElements() {
		ArrayArgumentAssertions.assertNonNullElements( NON_NULL_ELEMENTS_ARRAY, "theArray" );
	}
	
	
	@Test
	public void testThatAssertNonNullElementsReturnsWhenTheArrayIsEmpty() {
		ArrayArgumentAssertions.assertNonNullElements( EMPTY_ARRAY, "theArray" );
	}
	
	
	@Test
	public void testThatAssertNonNullElementsThrowsWhenTheArrayIsNull() {
		Executable executable = () -> ArrayArgumentAssertions.assertNonNullElements( (String[]) null, "theArray" );
		Assertions.assertThrows( IllegalArgumentException.class, executable );
	}
	
	
	@Test
	public void testThatAssertNonNullElementsThrowsWhenTheArgumentNameIsNull() {
		Executable executable = () -> ArrayArgumentAssertions.assertNonNullElements( NON_NULL_ELEMENTS_ARRAY, null );
		Assertions.assertThrows( IllegalArgumentException.class, executable );
	}
	
	
	@Test
	public void testThatAssertNonNullElementsThrowsWhenTheArrayHasBothNullAndNonNullElements() {
		Executable executable = () -> ArrayArgumentAssertions.assertNonNullElements( SOME_NULL_ELEMENTS_ARRAY, "theArray" );
		Assertions.assertThrows( IllegalArgumentException.class, executable );
	}
	
	
	@Test
	public void testThatAssertNonNullElementsThrowsWhenTheArrayOnlyHasNullElements() {
		Executable executable = () -> ArrayArgumentAssertions.assertNonNullElements( ALL_NULL_ELEMENTS_ARRAY, "theArray" );
		Assertions.assertThrows( IllegalArgumentException.class, executable );
	}

}
