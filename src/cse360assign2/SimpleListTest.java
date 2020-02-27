/**
 * Author:		Andrew Smith
 * Class ID:	102
 * Assignment:	2
 * Description:	This file is a JUnit test that tests each method of the
 * 				SimpleList class in succession.
 */

package cse360assign2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SimpleListTest {

	@Test
	public void testSimpleList()
	{ // make sure the constructor creates an object
		SimpleList list = new SimpleList();
		assertNotNull(list, "Construction failed.\n");
	}

	@Test
	public void testAdd()
	{ // test add by adding more than 10 elements
		SimpleList list = new SimpleList();
		list.add(5);
		list.add(5);
		list.add(2);
		list.add(5);
		list.add(1);
		list.add(5);
		list.add(4);
		list.add(5);
		list.add(5);
		list.add(9);
		list.add(5);
		list.add(7);
		list.add(5);
		list.add(5);
		assertEquals(14, list.count(), "Adding failed.\n");
	}
	
	@Test
	public void testRemove()
	{ // test remove by adding a few elements and then removing one
		SimpleList list = new SimpleList();
		list.add(5);
		list.add(3);
		list.add(10);
		list.remove(3);
		assertEquals(2, list.count(), "Removing failed.\n");
	}
	
	@Test
	public void testCount()
	{ // test count by making sure the list always has the expected number of elements
		SimpleList list = new SimpleList();
		list.add(5);
		list.add(2);
		list.add(4);
		assertEquals(3, list.count(), "Counting failed.\n");
		list.remove(5);
		list.remove(4);
		assertEquals(1, list.count(), "Counting failed.\n");
	}
	
	@Test
	public void testToString()
	{ // make sure toString has the output we want
		SimpleList list = new SimpleList();
		list.add(5);
		list.add(2);
		list.add(4);
		assertEquals("4 2 5", list.toString(), "toString() failed.\n");
	}
	
	@Test
	public void testSearch()
	{ // check that the search function finds the correct index
		SimpleList list = new SimpleList();
		list.add(5);
		list.add(2);
		list.add(4);
		assertEquals(1, list.search(2), "Searching failed.\n");
	}
	
	@Test
	public void testAppend()
	{
		SimpleList list = new SimpleList();
		list.add(5);
		list.add(5);
		list.add(2);
		list.add(5);
		list.add(1);
		list.add(5);
		list.add(4);
		list.append(10);
		assertEquals(10, list.last(), "Appending failed.\n");
	}
	
	@Test
	public void testFirst()
	{
		SimpleList list = new SimpleList();
		list.add(12);
		list.add(5);
		list.add(2);
		list.add(5);
		list.add(1);
		list.add(5);
		list.add(4);
		list.append(10);
		assertEquals(4, list.first(), "First failed.\n");
	}
	
	@Test
	public void testLast()
	{
		SimpleList list = new SimpleList();
		list.add(5);
		list.add(5);
		list.append(2);
		list.add(5);
		list.add(1);
		list.add(5);
		list.add(4);
		list.append(9);
		assertEquals(9, list.last(), "Last failed.\n");
	}
	
	@Test
	public void testSize()
	{
		SimpleList list = new SimpleList();
		list.add(5);
		list.add(5);
		list.add(2);
		list.add(5);
		assertEquals(6, list.size(), "Size failed.\n");
	}
}
