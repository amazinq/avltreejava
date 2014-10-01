package de.szut.baum;


@SuppressWarnings("rawtypes")
public class ComparableObject<T extends Comparable> {
	
	private T object;
	
	public ComparableObject(T object) {
		this.object = object;
		
	}
	
	public T getObject() {
		return object;
	}
}
