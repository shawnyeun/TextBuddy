import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class TextBuddyTest {
	
	@Test
	public void testEmptySearchFile() throws IOException {
		assertEquals("search empty file", false, TextBuddy.searchFile("textfile.txt", " "));
		TextBuddy.clearFile("mytextbuddy.txt");
	}

	@Test
	public void testSearchFile() throws IOException {
		assertSame("test the number of counts of a word", 1, TextBuddy.searchFile("textfile.txt", "aaa"));
	}
	
	@Test
	public void testSortFile() throws IOException {
		assertEquals("Compare strings", true, TextBuddy.sortFile("textfile.txt") );
	}
	
	@Test
	public void testAddCommand() throws IOException {
		assertSame("test if string is added", "eee", TextBuddy.addCommand("textfile.txt", "eee"));
	}
	
	@Test
	public void testClearFile() throws IOException {
		assertEquals("Tests if file is cleared", true, TextBuddy.clearFile("textfile.txt"));
	}
}
