package de.szut.baum;

import java.util.ArrayList;

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
				if (value.getKey().compareTo((currentNode.getValue().getKey())) == -1) {
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
	
	public void getValue(ComparableObject valueToGet) {
		
	}

	public void deleteValue(ComparableObject value) {
		Node currentNode = root;
		boolean valueDeleted = false;
		if (containsValue(value)) {
			while (!valueDeleted) {
				if(currentNode.getValue().getKey().compareTo(value.getKey()) == 0) {
					Node valueToDelete = currentNode;
					TreeHeight subTreeHeight = getHeight(currentNode);
					if(valueToDelete != root) {
						if(subTreeHeight.getLeftHeight() > subTreeHeight.getRightHeight() 
								|| (subTreeHeight.getLeftHeight() == subTreeHeight.getRightHeight() 
								&& valueToDelete.getLeftNode() != null)) {
							if(valueToDelete.getValue().getKey().compareTo(valueToDelete.getParent().getValue().getKey()) == -1) {
								valueToDelete.getParent().setLeftNode(valueToDelete.getLeftNode());
								valueToDelete.getLeftNode().setParent(valueToDelete.getParent());
								if(valueToDelete.getRightNode() != null) {
									currentNode = valueToDelete.getLeftNode();
									while(currentNode.getRightNode() != null) {
										currentNode = currentNode.getRightNode();
									}
									currentNode.setRightNode(valueToDelete.getRightNode());
									valueToDelete.getRightNode().setParent(currentNode);
								
								}
								
							} else {
								valueToDelete.getParent().setRightNode(valueToDelete.getRightNode());
								valueToDelete.getRightNode().setParent(valueToDelete.getParent());
								if(valueToDelete.getLeftNode() != null) {
									currentNode = valueToDelete.getRightNode();
									while(currentNode.getLeftNode() != null) {
										currentNode = currentNode.getLeftNode();
									}
									currentNode.setLeftNode(valueToDelete.getLeftNode());
									valueToDelete.getLeftNode().setParent(currentNode);
								}
								
							}
						} else if(subTreeHeight.getRightHeight() > subTreeHeight.getLeftHeight()
								|| (subTreeHeight.getRightHeight() == subTreeHeight.getLeftHeight() 
								&& valueToDelete.getRightNode() != null)) {
							if(valueToDelete.getValue().getKey().compareTo(valueToDelete.getParent().getValue().getKey()) == -1) {
								valueToDelete.getParent().setLeftNode(valueToDelete.getLeftNode());
								valueToDelete.getLeftNode().setParent(valueToDelete.getParent());
								if(valueToDelete.getLeftNode() != null) {
									currentNode = valueToDelete.getRightNode();
									while(currentNode.getLeftNode() != null) {
										currentNode = currentNode.getLeftNode();
									}
									currentNode.setRightNode(valueToDelete.getRightNode());
									valueToDelete.getRightNode().setParent(currentNode);
								}
							} else {
								valueToDelete.getParent().setRightNode(valueToDelete.getRightNode());
								valueToDelete.getRightNode().setParent(valueToDelete.getParent());
								if(valueToDelete.getLeftNode() != null) {
									currentNode = valueToDelete.getRightNode();
									while(currentNode.getLeftNode() != null) {
										currentNode = currentNode.getLeftNode();
									}
									currentNode.setLeftNode(valueToDelete.getLeftNode());
									valueToDelete.getLeftNode().setParent(currentNode);
								}
							}
						} else {
							if(valueToDelete.getValue().getKey().compareTo(valueToDelete.getParent().getValue().getKey()) == -1) {
								valueToDelete.getParent().setLeftNode(null);
							} else {
								valueToDelete.getParent().setRightNode(null);
							}
						}
					} else {
						if(subTreeHeight.getLeftHeight() > subTreeHeight.getRightHeight() 
								|| (subTreeHeight.getLeftHeight() == subTreeHeight.getRightHeight() 
								&& valueToDelete.getLeftNode() != null)) {
							
							valueToDelete.getLeftNode().setParent(null);
							if(valueToDelete.getRightNode() != null) {
								currentNode = valueToDelete.getLeftNode();
								while(currentNode.getRightNode() != null) {
									currentNode = currentNode.getRightNode();
								}
								currentNode.setRightNode(valueToDelete.getRightNode());
								valueToDelete.getRightNode().setParent(currentNode);
							
							}
							root = valueToDelete.getLeftNode();
							
						} else if(subTreeHeight.getRightHeight() > subTreeHeight.getLeftHeight()
								|| (subTreeHeight.getRightHeight() == subTreeHeight.getLeftHeight() 
								&& valueToDelete.getRightNode() != null)) {
							
							valueToDelete.getRightNode().setParent(null);
							if(valueToDelete.getLeftNode() != null) {
								currentNode = valueToDelete.getRightNode();
								while(currentNode.getLeftNode() != null) {
									currentNode = currentNode.getLeftNode();
								}
								currentNode.setLeftNode(valueToDelete.getLeftNode());
								valueToDelete.getLeftNode().setParent(currentNode);
							}
							root = valueToDelete.getRightNode();
						} else {
							root = null;
						}
					}
					valueDeleted = true;
				} else if(value.getKey().compareTo(currentNode.getValue().getKey()) == -1) {
					currentNode = currentNode.getLeftNode();
				} else {
					currentNode = currentNode.getRightNode(); 
				}
			}
		}

	}

	public boolean containsValue(ComparableObject value) {
		Node currentNode = root;
		boolean valueFound = false;
		while (!valueFound) {
			if (currentNode.getValue().getKey().compareTo(value.getKey()) == 0) {
				return true;
			} else {
				if (value.getKey().compareTo((currentNode.getValue().getKey())) == -1) {
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
			if (currentNode.getLeftNode() != null) {
				leftSize++;
			}
			if (currentNode.getRightNode() != null) {
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
			return new TreeHeight(0, 0);
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

	public ArrayList<Integer> getAllValues() {
		return null;
	}
	
	private void rebalanceAVLTree(Node treeToBalance) {
		
	}
}
