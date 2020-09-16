package Knight;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Knight;
import model.KnightsLogic;

public class TestKnightLogic {
	Knight testKnight = new Knight("Paul");
	KnightsLogic kl = new KnightsLogic();
	@Before
	public void setUp() throws Exception{
		testKnight.setHealth(100);
		
	}
	
	@Test
	public void testHasArmour() {
		kl.giveArmour(testKnight);
		assertEquals(true, kl.hasArmour(testKnight));
	}
	
	@Test
	public void testTakeDamage() {
		kl.takeDamage(testKnight);
		assertEquals(90,testKnight.getHealth());
	}
	
	@Test
	public void testTakeDamageWithArmour() {
		kl.giveArmour(testKnight);
		kl.takeDamage(testKnight);
		assertEquals(100,testKnight.getHealth());
	}
}
