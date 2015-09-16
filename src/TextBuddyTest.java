import static org.junit.Assert.*;

import org.junit.Test;

public class TextBuddyTest {

	@Test
	public void test() {
		assertSame("test", 5, TextBuddy.searchFile("myTextFile.txt", "fox"));
	}

}
