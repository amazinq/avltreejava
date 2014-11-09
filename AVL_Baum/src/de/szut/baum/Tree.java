package de.szut.baum;

public class Tree {

	private Node root;

	public Tree() {
		root = null;
	}

	public void addValue(ComparableObject value) {

		boolean valueAdded = false;
		Node currentNode = root;
		if (root == null) {
			root = new Node(value, null);
		}
		if (!containsValue(value)) {
			while (!valueAdded) {
				if (value.getKey().compareTo(
						(currentNode.getValue().getKey())) == -1) {
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
		Node currentNode = root;
	}

	public boolean containsValue(ComparableObject value) {
		Node currentNode = root;
		boolean valueFound = false;
		while (!valueFound) {
			if (currentNode.getValue().getKey().compareTo(value.getKey()) == 0) {
				return true;
			} else {
				if (value.getKey().compareTo(
						(currentNode.getValue().getKey())) == -1) {
					if (currentNode.getLeftNode() != null) {
						currentNode = currentNode.getLeftNode();
					} else {
						return false;
					}
				} else {
					if (currentNode.getRightNode() != null) {
						currentNode = currentNode.getRightNode();
					} else {
						return false;
					}
				}
			}
		}
		return valueFound;
	}

	public int getSize(Node currentNode) {
		int leftSize = 0, rightSize = 0;
		if (currentNode == null) {
			return 0;
		} else {
			if(currentNode.getLeftNode() != null) {
				leftSize++;
			}
			if(currentNode.getRightNode() != null) {
				rightSize++;
			}
			leftSize = getSize(currentNode.getLeftNode());
			rightSize = getSize(currentNode.getRightNode());
			return leftSize + rightSize + 1;
		}
	}

	public TreeHeight getHeight(Node currentNode) {
		int leftHeight, rightHeight;
		if (currentNode == null) {
			return new TreeHeight(0,0);
		} else {
			leftHeight = getHeight(currentNode.getLeftNode()).getTotalHeight();
			rightHeight = getHeight(currentNode.getRightNode()).getTotalHeight();
			return new TreeHeight(leftHeight + 1, rightHeight + 1);
		}
	}

	public Node getRoot() {
		return root;
	}

	public ComparableObject getBiggest() {
		Node currentNode = root;
		while (currentNode.getRightNode() != null) {
			currentNode = currentNode.getRightNode();
		}
		return currentNode.getValue();
	}

	public ComparableObject getSmallest() {
		Node currentNode = root;
		while (currentNode.getLeftNode() != null) {
			currentNode = currentNode.getLeftNode();
		}
		return currentNode.getValue();
	}

	public int[] getAllValues() {
		return null;
	}
}
