package Knight;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Knight;

public class FixtureExample {
	protected Knight testKnight;
	

	@Before
	public void setUp() throws Exception {
		testKnight = new Knight("Paul");
		testKnight.setHealth(100);
	}

	@Test
	public void test() {
		assertTrue(testKnight.getName() == "Paul");
	}

}
