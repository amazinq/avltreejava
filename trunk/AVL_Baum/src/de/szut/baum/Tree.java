package de.szut.baum;

public class Tree {

	private Node root;

	public Tree() {
		root = null;
	}

	public void addValue(ComparableObject value) {

		boolean valueAdded = false;
		Node currentNode = root;

		if (!containsValue(value)) {
			if (root == null) {
				root = new Node(value, null);
			}
			while (!valueAdded) {
				if (value.getObject().compareTo(
						(currentNode.getValue().getObject())) == -1) {
					if (currentNode.getLeftNode() == null) {
						currentNode.setLeftNode(new Node(value, currentNode));
						valueAdded = true;
					} else {
						currentNode = currentNode.getLeftNode();
					}
				} else {
					if (currentNode.getRightNode() == null) {
						currentNode.setRightNode(new Node(value, currentNode));
						valueAdded = true;
					} else {
						currentNode = currentNode.getRightNode();
					}
				}
			}
		}
	}

	public void deleteValue(ComparableObject<?> value) {

	}

	public boolean containsValue(ComparableObject value) {
		Node currentNode = root;
		boolean valueFound = false;
		while (!valueFound) {
			if (currentNode.getValue().getObject().compareTo(value) == 0) {
				return true;
			} else {
				if (value.getObject().compareTo((currentNode.getValue().getObject())) == -1) {
					if(currentNode.getLeftNode() != null) {
						currentNode = currentNode.getLeftNode();
					} else {
						return false;
					}
				} else {
					if(currentNode.getRightNode() != null) {
						currentNode = currentNode.getRightNode();
					} else {
						return false;
					}
				}
			}
		}
		return valueFound;
	}

	public int getSize() {
		return 0;
	}

	public int getHeight() {
		return 0;
	}

	public ComparableObject<?> getBiggest() {
		return null;
	}

	public ComparableObject<?> getSmallest() {
		return null;
	}

	public int[] getAllValues() {
		return null;
	}
}
