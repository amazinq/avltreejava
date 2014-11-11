package de.szut.baum.test;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;

import de.szut.baum.ComparableObject;
import de.szut.baum.Tree;
import de.szut.baum.TreeHeight;

public class Tree_Test {

	private int[] unsortedList = { 3, 4, 6, 2, 1, 5, -3, -1, -2 };
	private int[] sortedList = { -3, -2, -1, 1, 2, 3, 4, 5, 6 };
	
	
	@Test
	public void addValue_test() {
		Tree tree = new Tree();
		boolean correctOutput = false;

		for (int i : unsortedList) {
			tree.addValue(new ComparableObject<Integer>((Integer) i));
		}

		for (int i = 0; i < sortedList.length; i++) {
			if(sortedList[i] != (int)tree.getAllValues().get(i).getKey()) {
				
			}
		}
		correctOutput = true;
		assertEquals(true, correctOutput);
	}

	@Test
	public void getSmallest_Test() {
		Tree tree = new Tree();
		for(int i : unsortedList) {
			tree.addValue(new ComparableObject<Integer>((Integer) i));
		}
		assertEquals(sortedList[0], tree.getSmallest().getKey());
	}
	
	@Test
	public void getBiggest_Test() {
		Tree tree = new Tree();
		for(int i : unsortedList) {
			tree.addValue(new ComparableObject<Integer>((Integer) i));
		}
		assertEquals(sortedList[sortedList.length-1], tree.getBiggest().getKey());
	}
	
	@Test
	public void getSize_Test() {
		Tree tree = new Tree();
		for(int i : unsortedList) {
			tree.addValue(new ComparableObject<Integer>((Integer) i));
		}
		assertEquals(unsortedList.length, tree.getSize(tree.getRoot()));
	}
	
	@Test
	public void containsValue_Test() {
		Tree tree = new Tree();
		for(int i : unsortedList) {
			tree.addValue(new ComparableObject<Integer>((Integer) i));
		}
		for(int i = 0 ; i < sortedList.length; i++) {
			assertEquals(true, tree.containsValue(new ComparableObject<Integer>((Integer)sortedList[i])));
		}
	}
	
	@Test
	public void deleteValue_Test() {
		Tree tree = new Tree();
		for(int i : unsortedList) {
			tree.addValue(new ComparableObject<Integer>((Integer) i));
		}
		tree.deleteValue(new ComparableObject<Integer>((Integer) (1)));
		tree.deleteValue(new ComparableObject<Integer>((Integer) (4)));
		tree.deleteValue(new ComparableObject<Integer>((Integer) (3)));
		assertEquals(false, tree.containsValue(new ComparableObject<Integer>((Integer) (3))));
		assertEquals(false, tree.containsValue(new ComparableObject<Integer>((Integer) (1))));
		assertEquals(false, tree.containsValue(new ComparableObject<Integer>((Integer) (4))));
		assertEquals(true, tree.containsValue(new ComparableObject<Integer>((Integer) (6))));
		assertEquals(true, tree.containsValue(new ComparableObject<Integer>((Integer) (-2))));
		assertEquals(true, tree.containsValue(new ComparableObject<Integer>((Integer) (-3))));
		assertEquals(true, tree.containsValue(new ComparableObject<Integer>((Integer) (-1))));
		assertEquals(true, tree.containsValue(new ComparableObject<Integer>((Integer) (2))));
		assertEquals(true, tree.containsValue(new ComparableObject<Integer>((Integer) (5))));
	}
	@Test
	public void getHeight_Test() {
		Tree tree = new Tree();
		for(int i : unsortedList) {
			tree.addValue(new ComparableObject<Integer>((Integer) i));
		}
		assertEquals(6, tree.getHeight(tree.getRoot()).getTotalHeight());
	}
}
