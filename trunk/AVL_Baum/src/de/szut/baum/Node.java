package de.szut.baum;

/**
 * represents a node in the binary tree
 * @author Steffen Wiﬂmann
 *
 * @param <T>
 */
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
	/**
	 * returns the left child of this node
	 * @return
	 */
	public Node<T> getLeftNode() {
		return leftNode;
	}
	/**
	 * sets the left child of this node
	 * @param leftNode
	 */
	public void setLeftNode(Node<T> leftNode) {
		this.leftNode = leftNode;
	}
	/**
	 * returns the right child of this node
	 * @return
	 */
	public Node<T> getRightNode() {
		return rightNode;
	}
	/**
	 * sets the right child of this node
	 * @param rightNode
	 */
	public void setRightNode(Node<T> rightNode) {
		this.rightNode = rightNode;
	}
	/**
	 * returns the value of this node
	 * @return
	 */
	public ComparableObject<T> getValue() {
		return value;
	}
	/**
	 * returns the parent of this node
	 * @return
	 */
	public Node<T> getParent() {
		return parent;
	}
	/**
	 * sets the parent of this node
	 * @param parent
	 */
	public void setParent(Node<T> parent) {
		this.parent = parent;
	}

}
