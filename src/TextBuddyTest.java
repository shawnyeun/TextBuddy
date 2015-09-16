import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class TextBuddyTest {

	@Test
	public void testSearchFile() throws IOException {
		assertSame("test the number of counts of a word", 1, TextBuddy.searchFile("textfile.txt", "aaa"));
	}
	
	public void testSortFile() throws IOException {
		assertEquals("Compare strings", true, TextBuddy.sortFile("textfile.txt") );
	}
	
	public void testAddCommand() throws IOException {
		assertSame("test if string is added", "eee", TextBuddy.addCommand("textfile.txt", "eee"));
	}
	
	public void testClearFile() throws IOException {
		assertEquals("Tests if file is cleared", true, TextBuddy.clearFile("textfile.txt"));
	}
}
