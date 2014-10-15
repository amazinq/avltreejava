package de.szut.baum.test;

import static org.junit.Assert.*;

import org.junit.Test;

import de.szut.baum.ComparableObject;
import de.szut.baum.Tree;

public class Tree_Test {

	
	Tree tree = new Tree();
	
	@Test
	public void addValue_test() {
		
		int[] unsortedList = {4,3,6,2,1,5,-3,-1,-2};
		int[] sortedList = {-3,-2,-1,1,2,3,4,5,6};
		Integer a = 2;
		for(int i : unsortedList) {
			tree.addValue(new ComparableObject<Integer>((Integer)i));
		}
		
	}

}
