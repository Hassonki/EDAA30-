package bst;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Iterator;

class TestBST {
	private BinarySearchTree<Integer> integerTree;
	private BinarySearchTree<String> stringTree;


	@BeforeEach
	void setUp() {
		integerTree = new BinarySearchTree<>();
		stringTree = new BinarySearchTree<>((e1, e2) -> ((Comparable<String>) e1).compareTo(e2));
	}

	@AfterEach
	void tearDown(){
		integerTree = null;
		stringTree = null;
	}

	/**
	 * test if height och size funkar med tomt tree.
	 */
	@Test
	void testNewTree() {
		//tomt integer tree
		assertEquals(0, integerTree.height(), "Wrong result from empty integer tree");
		assertEquals(0, integerTree.size(), "Wrong size of empty integer tree");
		//tomt string tree
		assertEquals(0, stringTree.height(), "Wrong result from empty integer tree");
		assertEquals(0, integerTree.size(), "Wrong size of empty integer tree");
	}

	/** Test height integer tree och string tree */
	@Test
	void testHeight() {

		//integerTree
		integerTree.add(2);
		integerTree.add(5);
		integerTree.add(1);
		assertEquals(2, integerTree.height(),"Wrong height in integerTree");
		assertEquals(3, integerTree.size(),"Wrong size integerTree");

		//stringTree
		stringTree.add("hej");
		stringTree.add("apa");
		assertEquals(2, stringTree.height(),"Wrong height in stringTree");
		assertEquals(2, stringTree.size());
	}

	/**
	 * Test add med integers och strings
	 */
	@Test
	void testAdd() {
		assertTrue(integerTree.add(2));
		assertTrue(integerTree.add(5));
		assertTrue(integerTree.add(1));
		assertEquals(2, integerTree.height(),"Wrong height in integerTree");
		assertEquals(3, integerTree.size(),"Wrong size integerTree");
		//testa med dublett 
		assertEquals(false, integerTree.add(2));

		assertTrue(stringTree.add("hej"));
		assertTrue(stringTree.add("apa"));
		assertTrue(stringTree.add("nej"));

		//testa med dublett
		assertEquals(false, stringTree.add("hej"));
	}

	/**
	* Testar clear metoden 
	*/
	@Test
	void testClear() {
		integerTree.add(2);
		integerTree.add(5);
		integerTree.add(1);

		integerTree.clear();
		assertEquals(0, integerTree.size());
		assertEquals(0, integerTree.height());

		stringTree.add("hej");
		stringTree.add("apa");
		stringTree.clear();
		assertEquals(0, stringTree.size());
		assertEquals(0,stringTree.height());
	}
}
