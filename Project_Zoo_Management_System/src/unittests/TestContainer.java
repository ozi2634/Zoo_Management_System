package unittests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import support.List;
import core.DoubleLinkedList;

public class TestContainer {

	@Test
	void testisEmpty() {
		List container = new List();
		// DoubleLinkedList container =new DoubleLinkedList();
		assertEquals(true, container.isEmpty());
	}

	@Test
	void testAddAndSize() {
		List container = new List();
		// DoubleLinkedList container =new DoubleLinkedList();
		container.add("Test String");
		container.add("Zweiter Test String");
		container.add("Dritter Test String");
		assertEquals(3, container.size(), "Container should have 3 elements after adding three items");
	}

	@Test
	void testRemove() {
		List container = new List();
		// DoubleLinkedList container =new DoubleLinkedList();
		container.add("Test String");
		container.add("Zweiter Test String");
		container.remove("Zweiter Test String");
		assertFalse(container.contains("Zweiter Test String"),
				"Container should not contain 'Zweiter Test String' after it's removed");
		assertEquals(1, container.size(), "Container should have 1 element after removing one item");
	}

	@Test
	void testContains() {
		List container = new List();
		// DoubleLinkedList container =new DoubleLinkedList();
		container.add("Test String");
		assertTrue(container.contains("Test String"), "Container should contain 'Test String'");
		assertFalse(container.contains("Nicht im Container"), "Container should not contain 'Nicht im Container'");
	}

	@Test
	void testToArray() {
		List container = new List();
		// DoubleLinkedList container =new DoubleLinkedList();
		container.add("Test String");
		container.add("Zweiter Test String");
		container.add("Dritter Test String");

		Object[] Array = container.toArray();
		assertEquals("Test String", Array[2]);
		assertEquals("Zweiter Test String", Array[1]);
		assertEquals("Dritter Test String", Array[0]);

	}

	@Test
	void testClear() {
		// DoubleLinkedList container =new DoubleLinkedList();
		List container = new List();
		container.add("Test String");
		container.clear();
		assertEquals(0, container.size(), "Container should be empty after clear");
		assertTrue(container.isEmpty(), "Container should be empty after clear");
	}

}
