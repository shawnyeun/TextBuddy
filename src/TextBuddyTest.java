import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;


/**
 * AUTHOR'S NOTES
 * This unit testing is only testing 2 methods, searchFile and sortFile.
 * However, it still uses the other methods such as addCommand and clearFile
 * But it assumes that the other methods are correct, as previously tested in CE1
 * @author Shawn
 */

public class TextBuddyTest {
	
	@Test
	public void testEmptySearchFile() throws IOException {
		assertSame("Empty file search test", 0, TextBuddy.searchFile("textfile.txt", "aaa"));
		TextBuddy.clearFile("textfile.txt");
	}

	@Test
	public void testSearchFileMultipleWords() throws IOException {
		TextBuddy.addCommand("textfile.txt", "aaa");
		TextBuddy.addCommand("textfile.txt", "aaa");
		TextBuddy.addCommand("textfile.txt", "ccc");
		assertSame("Multiple instances word test", 2, TextBuddy.searchFile("textfile.txt", "aaa"));
		TextBuddy.clearFile("textfile.txt");
	}
	
	@Test
	public void testSearchFile() throws IOException {
		TextBuddy.addCommand("textfile.txt", "aaa");
		TextBuddy.addCommand("textfile.txt", "bbb");
		TextBuddy.addCommand("textfile.txt", "ccc");
		assertSame("Singular instance word test", 1, TextBuddy.searchFile("textfile.txt", "aaa"));
		TextBuddy.clearFile("textfile.txt");
	}
	
	@Test
	public void testEmptySortFile() throws IOException {
		assertEquals("Compare empty file", true, TextBuddy.sortFile("textfile.txt") );
		TextBuddy.clearFile("textfile.txt");
	}
	
	@Test
	public void testSortFile() throws IOException {
		TextBuddy.addCommand("textfile.txt", "bbb");
		TextBuddy.addCommand("textfile.txt", "ccc");
		TextBuddy.addCommand("textfile.txt", "aaa");
		assertEquals("Compare 3 strings", true, TextBuddy.sortFile("textfile.txt") );
		TextBuddy.clearFile("textfile.txt");
	}
	
	//@Test
	//public void testAddCommand() throws IOException {
		//assertSame("test if string is added", "eee", TextBuddy.addCommand("textfile.txt", "eee"));
	//}
	
	//@Test
	//public void testClearFile() throws IOException {
		//assertEquals("Tests if file is cleared", true, TextBuddy.clearFile("textfile.txt"));
	//}
}
