package de.szut.baum;

/**
 * generic object which can be inserted into the binary tree
 * to enable the usage of different datatypes which 
 * have to implement the comparable interface
 * @author Steffen Wiﬂmann
 *
 * @param <T>
 */
public class ComparableObject<T extends Comparable<T>> {
	
	private T key;
	
	public ComparableObject(T object) {
		this.key = object;
		
	}
	/**
	 * returns the generic key
	 * @return
	 */
	public T getKey() {
		return key;
	}
}
