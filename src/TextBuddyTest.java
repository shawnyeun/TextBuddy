import static org.junit.Assert.*;

import org.junit.Test;

public class TextBuddyTest {

	@Test
	public void test() {
		assertSame("test", 1, TextBuddy.searchFile("myTextFile.txt", "aaa"));
	}
	

}
