package de.szut.baum;


public class ComparableObject<T extends Comparable<T>> {
	
	private T key;
	
	public ComparableObject(T object) {
		this.key = object;
		
	}
	
	public T getKey() {
		return key;
	}
}
