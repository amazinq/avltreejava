package de.szut.baum.test;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;

import de.szut.baum.ComparableObject;
import de.szut.baum.Tree;

public class Tree_Test {

	private int[] unsortedList = { 4, 3, 6, 2, 1, 5, -3, -1, -2 };
	private int[] sortedList = { -3, -2, -1, 1, 2, 3, 4, 5, 6 };
	
	
	@Test
	public void addValue_test() {
		Tree tree = new Tree();

		for (int i : unsortedList) {
			tree.addValue(new ComparableObject<Integer>((Integer) i));
		}

		for (int i = 0; i < sortedList.length; i++) {
			assertEquals(sortedList[i], tree.getAllValues()[i]);
		}
	}

	@Test
	public void getSmallest_Test() {
		Tree tree = new Tree();
		for(int i : unsortedList) {
			tree.addValue(new ComparableObject<Integer>((Integer) i));
		}
		assertEquals(-3, tree.getSmallest().getObject());
	}
	
	@Test
	public void getHighest_Test() {
		Tree tree = new Tree();
		for(int i : unsortedList) {
			tree.addValue(new ComparableObject<Integer>((Integer) i));
		}
		assertEquals(6, tree.getBiggest().getObject());
	}
	
	@Test
	public void getSize_Test() {
		Tree tree = new Tree();
		for(int i : unsortedList) {
			tree.addValue(new ComparableObject<Integer>((Integer) i));
		}
		assertEquals(unsortedList.length, tree.getSize());
	}
	
	@Test
	public void containsValue_Test() {
		Tree tree = new Tree();
		for(int i : unsortedList) {
			tree.addValue(new ComparableObject<Integer>((Integer) i));
		}
		assertEquals(true, tree.containsValue(new ComparableObject<Integer>((Integer)unsortedList[new Random().nextInt(unsortedList.length)])));
	}
	
	@Test
	public void deleteValue_Test() {
		Tree tree = new Tree();
		for(int i : unsortedList) {
			tree.addValue(new ComparableObject<Integer>((Integer) i));
		}
		tree.deleteValue(new ComparableObject<Integer>((Integer) 3));
		assertEquals(false, tree.containsValue(new ComparableObject<Integer>((Integer) 3)));
	}
}
