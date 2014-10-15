package de.szut.baum;


public class ComparableObject<T extends Comparable<T>> {
	
	private T object;
	
	public ComparableObject(T object) {
		this.object = object;
		
	}
	
	public T getObject() {
		return object;
	}
}
