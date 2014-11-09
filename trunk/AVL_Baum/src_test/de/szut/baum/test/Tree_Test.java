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
		assertEquals(-3, tree.getSmallest().getKey());
	}
	
	@Test
	public void getBiggest_Test() {
		Tree tree = new Tree();
		for(int i : unsortedList) {
			tree.addValue(new ComparableObject<Integer>((Integer) i));
		}
		assertEquals(6, tree.getBiggest().getKey());
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
		assertEquals(true, tree.containsValue(new ComparableObject<Integer>((Integer)unsortedList[new Random().nextInt(unsortedList.length)])));
	}
	
	@Test
	public void deleteValue_Test() {
		Tree tree = new Tree();
		for(int i : unsortedList) {
			tree.addValue(new ComparableObject<Integer>((Integer) i));
		}
		tree.deleteValue(new ComparableObject<Integer>((Integer) (1)));
		assertEquals(false, tree.containsValue(new ComparableObject<Integer>((Integer) (1))));
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
