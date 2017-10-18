package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.Inventory;

public class InventoryTest {

	private Inventory obj;
	
	@Before
	public void setUp() throws Exception {
		obj = new Inventory("Candy Bar", 4, 2.5, 1);
	}

	@Test
	public void testCalculation() {
		double price = 2.5;
		int quantity = 4;
		assertEquals(price * quantity, obj.calculation(), 0);
	}
	
	@Test
	public void testSearch() {
		int id = 1;
		assertTrue(obj.search(id));
	}

}
