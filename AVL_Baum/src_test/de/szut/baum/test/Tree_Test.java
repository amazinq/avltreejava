package de.szut.baum.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.szut.baum.ComparableObject;
import de.szut.baum.Tree;
/**
 * JUnit test class for the whole binary tree and its methods
 * @author Steffen Wiﬂmann
 *
 */
public class Tree_Test {

	private int[] unsortedList = { 3, 4, 6, 2, 1, 5, -3, -1, -2 };
	private int[] sortedList = { -3, -2, -1, 1, 2, 3, 4, 5, 6 };
	
	/**
	 * tests the addValue and getAllValue method to 
	 * make sure the adding method works fine
	 */
	@Test
	public void addValue_test() {
		Tree<Integer> tree = new Tree<Integer>();
		boolean correctOutput = true;

		for (int i : unsortedList) {
			tree.addValue(new ComparableObject<Integer>((Integer) i));
		}
		for (int i = 0; i < sortedList.length; i++) {
			//System.out.println((Integer)((ComparableObject<Integer>) tree.getAllValues().get(i)).getKey());
			if(sortedList[i] != (Integer)((ComparableObject<Integer>) tree.getAllValues().get(i)).getKey()) {
				correctOutput = false;
			}
		}
		assertEquals(true, correctOutput);
	}

	/**
	 * tests the getSmallest method to ensure that 
	 * only the smallest value will be returned
	 */
	@Test
	public void getSmallest_Test() {
		Tree<Integer> tree = new Tree<Integer>();
		for(int i : unsortedList) {
			tree.addValue(new ComparableObject<Integer>((Integer) i));
		}
		assertEquals((Integer)sortedList[0], tree.getSmallest().getKey());
	}
	
	/**
	 * tests the getBiggest method to ensure that
	 * only the biggest value will be returned
	 */
	@Test
	public void getBiggest_Test() {
		Tree<Integer> tree = new Tree<Integer>();
		for(int i : unsortedList) {
			tree.addValue(new ComparableObject<Integer>((Integer) i));
		}
		assertEquals((Integer)sortedList[sortedList.length-1], tree.getBiggest().getKey());
	}
	
	/**
	 * tests the getSize method to verify if
	 * the method returns the correct size 
	 * of the avl binary tree
	 */
	@Test
	public void getSize_Test() {
		Tree<Integer> tree = new Tree<Integer>();
		for(int i : unsortedList) {
			tree.addValue(new ComparableObject<Integer>((Integer) i));
		}
		assertEquals(unsortedList.length, tree.getSize(tree.getRoot()));
	}
	
	/**
	 * tests if the containsValue returns the correct boolean 
	 * for added values
	 */
	@Test
	public void containsValue_Test() {
		Tree<Integer> tree = new Tree<Integer>();
		for(int i : unsortedList) {
			tree.addValue(new ComparableObject<Integer>((Integer) i));
		}
		for(int i = 0 ; i < sortedList.length; i++) {
			assertEquals(true, tree.containsValue(new ComparableObject<Integer>((Integer)sortedList[i])));
		}
	}
	/**
	 * tests if the deleteValue method deletes all given values
	 * also checks if the other values are still reachable
	 */
	@Test
	public void deleteValue_Test() {
		Tree<Integer> tree = new Tree<Integer>();
		for(int i : unsortedList) {
			tree.addValue(new ComparableObject<Integer>((Integer) i));
		}
		tree.print();
		System.out.println();
		tree.deleteValue(new ComparableObject<Integer>((Integer) (1)));
		//tree.deleteValue(new ComparableObject<Integer>((Integer) (4)));
		//tree.deleteValue(new ComparableObject<Integer>((Integer) (3)));
		tree.print();
		//assertEquals(false, tree.containsValue(new ComparableObject<Integer>((Integer) (3))));
		assertEquals(false, tree.containsValue(new ComparableObject<Integer>((Integer) (1))));
		//assertEquals(false, tree.containsValue(new ComparableObject<Integer>((Integer) (4))));
		assertEquals(true, tree.containsValue(new ComparableObject<Integer>((Integer) (6))));
		assertEquals(true, tree.containsValue(new ComparableObject<Integer>((Integer) (-2))));
		assertEquals(true, tree.containsValue(new ComparableObject<Integer>((Integer) (-3))));
		assertEquals(true, tree.containsValue(new ComparableObject<Integer>((Integer) (-1))));
		assertEquals(true, tree.containsValue(new ComparableObject<Integer>((Integer) (2))));
		assertEquals(true, tree.containsValue(new ComparableObject<Integer>((Integer) (5))));
	}
	/**
	 * tests if the getHeight method returns the correct Height 
	 * of the AVL binary tree
	 */
	@Test
	public void getHeight_Test() {
		Tree<Integer> tree = new Tree<Integer>();
		for(int i : unsortedList) {
			tree.addValue(new ComparableObject<Integer>((Integer) i));
		}
		assertEquals(4, tree.getHeight(tree.getRoot()).getTotalHeight());
	}
}
