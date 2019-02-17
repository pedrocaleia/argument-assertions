package pt.pcaleia.arg.assertion;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


/**
 * @author Pedro Caleia
 */
public final class NullArgumentAssertionsTest {
	
	
	/*
	 * Class Tests
	 */
	
	
	@Test
	public void testThatNullArgumentAssertionsClassIsAnUtilityClass() {
		// TODO Pedro Caleia
	}
	
	
	/*
	 * assertNull Tests
	 */
	
	
	@Test
	public void testThatAssertNullReturnsWhenTheArgumentIsNull() {
		NullArgumentAssertions.assertNull( null, "theArgument" );
	}
	
	
	@Test
	public void testThatAssertNullThrowsWhenTheArgumentIsNotNull() {
		Executable executable = () -> NullArgumentAssertions.assertNull( "just a not null object", "theArgument" );
		Assertions.assertThrows( IllegalArgumentException.class, executable );
	}
	
	
	@Test
	public void testThatAssertNullThrowsWhenTheArgumentNameIsNull() {
		Executable executable = () -> NullArgumentAssertions.assertNull( null, null );
		Assertions.assertThrows( IllegalArgumentException.class, executable );
	}
	
	
	/*
	 * assertNotNull Tests
	 */
	
	
	@Test
	public void testThatAssertNotNullReturnsWhenTheArgumentIsNotNull() {
		NullArgumentAssertions.assertNotNull( "just a not null object", "theArgument" );
	}
	
	
	@Test
	public void testThatAssertNotNullThrowsWhenTheArgumentIsNull() {
		Executable executable = () -> NullArgumentAssertions.assertNotNull( null, "theArgument" );
		Assertions.assertThrows( IllegalArgumentException.class, executable );
	}
	
	
	@Test
	public void testThatAssertNotNullThrowsWhenTheArgumentNameIsNull() {
		Executable executable = () -> NullArgumentAssertions.assertNotNull( "just a not null object", null );
		Assertions.assertThrows( IllegalArgumentException.class, executable );
	}

}
