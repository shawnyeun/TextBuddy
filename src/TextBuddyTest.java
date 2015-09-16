import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class TextBuddyTest {

	@Test
	public void testSearchFile() throws IOException {
		assertSame("test", 1, TextBuddy.searchFile("myTextFile.txt", "aaa"));
	}
		
}
