package de.szut.baum;

public class Node {
	
	private ComparableObject<?> value;
	private Node leftNode;
	private Node rightNode;
	
	public Node(ComparableObject<?> value) {
		this.value = value;
		leftNode = null;
		rightNode = null;
	}
	
	public Node getLeftNode() {
		return leftNode;
	}
	
	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}
	
	public Node getRightNode() {
		return rightNode;
	}
	
	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}
	
	public ComparableObject<?> getValue() {
		return value;
	}

}
