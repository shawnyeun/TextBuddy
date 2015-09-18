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
	
	private static final String SORT_3_STRINGS = "Compare 3 strings";
	private static final String SORT_EMPTY_FILE = "Compare empty file";
	private static final String SEARCH_MULTIPLE_INSTANCES = "Multiple instances word test";
	private static final String SEARCH_SINGULAR_INSTANCE = "Singular instance word test";
	private static final String SEARCH_EMPTY_FILE = "Empty file search test";

	@Test
	public void testEmptySearchFile() throws IOException {
		assertSame(SEARCH_EMPTY_FILE, 0, TextBuddy.searchFile("textfile.txt", "aaa"));
		TextBuddy.clearFile("textfile.txt");
	}

	@Test
	public void testSearchFileMultipleWords() throws IOException {
		TextBuddy.addCommand("textfile.txt", "aaa");
		TextBuddy.addCommand("textfile.txt", "aaa");
		TextBuddy.addCommand("textfile.txt", "ccc");
		assertSame(SEARCH_MULTIPLE_INSTANCES, 2, TextBuddy.searchFile("textfile.txt", "aaa"));
		TextBuddy.clearFile("textfile.txt");
	}
	
	@Test
	public void testSearchFile() throws IOException {
		TextBuddy.addCommand("textfile.txt", "aaa");
		TextBuddy.addCommand("textfile.txt", "bbb");
		TextBuddy.addCommand("textfile.txt", "ccc");
		assertSame(SEARCH_SINGULAR_INSTANCE, 1, TextBuddy.searchFile("textfile.txt", "aaa"));
		TextBuddy.clearFile("textfile.txt");
	}
	
	@Test
	public void testEmptySortFile() throws IOException {
		assertEquals(SORT_EMPTY_FILE, true, TextBuddy.sortFile("textfile.txt") );
		TextBuddy.clearFile("textfile.txt");
	}
	
	@Test
	public void testSortFile() throws IOException {
		TextBuddy.addCommand("textfile.txt", "bbb");
		TextBuddy.addCommand("textfile.txt", "ccc");
		TextBuddy.addCommand("textfile.txt", "aaa");
		assertEquals(SORT_3_STRINGS, true, TextBuddy.sortFile("textfile.txt") );
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
