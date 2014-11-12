package de.szut.baum;

public class Node<T extends Comparable<T>> {
	
	private ComparableObject<T> value;
	private Node<T> parent;
	private Node<T> leftNode;
	private Node<T> rightNode;
	
	public Node(ComparableObject<T> value2, Node<T> parent) {
		this.value = value2;
		this.parent = parent;
		leftNode = null;
		rightNode = null;
	}
	
	public Node<T> getLeftNode() {
		return leftNode;
	}
	
	public void setLeftNode(Node<T> leftNode) {
		this.leftNode = leftNode;
	}
	
	public Node<T> getRightNode() {
		return rightNode;
	}
	
	public void setRightNode(Node<T> rightNode) {
		this.rightNode = rightNode;
	}
	
	public ComparableObject<T> getValue() {
		return value;
	}

	public Node<T> getParent() {
		return parent;
	}

	public void setParent(Node<T> parent) {
		this.parent = parent;
	}

}
