import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class TextBuddyTest {

	@Test
	public void testSearchFile() throws IOException {
		assertSame("test number of counts of word", 1, TextBuddy.searchFile("textfile.txt", "aaa"));
	}
	
	public void testSortFile() throws IOException {
		assertEquals("Compare strings", true, TextBuddy.sortFile("textfile.txt") );
	}
		
}
