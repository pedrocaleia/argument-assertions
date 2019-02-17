package pt.pcaleia.arg.assertion;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


/**
 * @author Pedro Caleia
 */
public final class StringArgumentAssertionsTest {
	
	
	private static final String NON_EMPTY_STRING = "just a string";
	
	
	/*
	 * Class Tests
	 */
	
	
	@Test
	public void testThatStringArgumentAssertionsClassIsAnUtilityClass() {
		// TODO Pedro Caleia
	}
	
	
	/*
	 * assertNotEmpty Tests
	 */
	
	
	@Test
	public void testThatAssertNotEmptyReturnsWhenTheArgumentIsANonEmptyString() {
		StringArgumentAssertions.assertNotEmpty( NON_EMPTY_STRING, "theArgument" );
	}
	
	
	@Test
	public void testThatAssertNotEmptyThrowsWhenTheArgumentIsNull() {
		Executable executable = () -> StringArgumentAssertions.assertNotEmpty( null, "theArgument" );
		Assertions.assertThrows( IllegalArgumentException.class, executable );
	}
	
	
	@Test
	public void testThatAssertNotEmptyThrowsWhenTheArgumentNameIsNull() {
		Executable executable = () -> StringArgumentAssertions.assertNotEmpty( NON_EMPTY_STRING, null );
		Assertions.assertThrows( IllegalArgumentException.class, executable );
	}
	
	
	@Test
	public void testThatAssertNotEmptyThrowsWhenTheArgumentIsAStringWithWhiteSpaceCharactersOnly() {
		//Executable executable = () -> StringArgumentAssertions.assertNotEmpty( TestConstants.WHITE_SPACE_STRING, "theArgument" );
		//TODO Fix this
		Executable executable = () -> StringArgumentAssertions.assertNotEmpty( " ", "theArgument" );
		Assertions.assertThrows( IllegalArgumentException.class, executable );
	}
	
	
	@Test
	public void testThatAssertNotEmptyThrowsWhenTheSecondArgumentIsAnEmptyString() {
		//Executable executable = () -> StringArgumentAssertions.assertNotEmpty( NON_EMPTY_STRING, TestConstants.WHITE_SPACE_STRING );
		//TODO Fix this
		Executable executable = () -> StringArgumentAssertions.assertNotEmpty( NON_EMPTY_STRING, " " );
		Assertions.assertThrows( IllegalArgumentException.class, executable );
	}

}
