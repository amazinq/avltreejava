package de.szut.baum;

import java.util.ArrayList;

/**
 * 
 * @author Steffen Wi�mann
 * Class representing the AVL binary tree 
 * Inherits all Methods available to use the tree
 * @param <T>
 */
public class Tree<T extends Comparable<T>> {

	private Node<T> root;
	private ArrayList<ComparableObject<T>> allValues;
	private ArrayList<Node<T>> allNodes;

	public Tree() {
		root = null;
		allValues = new ArrayList<ComparableObject<T>>();
		allNodes = new ArrayList<Node<T>>();
	}

	/**
	 * Adds a Value to the AVL Binary tree if its still not contained, else 
	 * the add will be ignored. After adding the Value, the tree
	 * will be rebalanced
	 * @param value
	 */
	public void addValue(ComparableObject<T> value) {
		boolean valueAdded = false;
		Node<T> currentNode = root;
		if (root == null) {
			root = new Node<T>(value, null);
		}
		if (!containsValue(value)) {
			while (!valueAdded) {
				if (value.getKey().compareTo((currentNode.getValue().getKey())) == -1) {
					if (currentNode.getLeftNode() == null) {
						currentNode.setLeftNode(new Node<T>(value, currentNode));
						this.rebalanceAVLTree(currentNode.getLeftNode());
						valueAdded = true;
					} else {
						currentNode = currentNode.getLeftNode();
					}
				} else {
					if (currentNode.getRightNode() == null) {
						currentNode.setRightNode(new Node<T>(value, currentNode));
						this.rebalanceAVLTree(currentNode.getRightNode());
						valueAdded = true;
					} else {
						currentNode = currentNode.getRightNode();
					}
				}
			}
		}
	}
	

	/**
	 * returns all nodes inherited in the binary tree
	 * by using an arraylist
	 * @return allNodes
	 */
	public ArrayList<Node<T>> getAllNodes() {
		return allNodes;
	}
	/**
	 * deletes a Value given, also rebalances the tree
	 * after deleting a value
	 * @param value
	 */
	public void deleteValue(ComparableObject<T> value) {
		Node<T> currentNode = root;
		boolean valueDeleted = false;
		if (containsValue(value)) {
			while (!valueDeleted) {
				if(currentNode.getValue().getKey().compareTo(value.getKey()) == 0) {
					Node<T> valueToDelete = currentNode;
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
								valueDeleted = true;
							} else {
								valueToDelete.getParent().setRightNode(null);
								valueDeleted = true;
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

	/**
	 * Checks if a value is contained in the binary tree
	 * @param value
	 * @return boolean valueFound
	 */
	public boolean containsValue(ComparableObject<T> value) {
		Node<T> currentNode = root;
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

	/**
	 * Calculates the total number of values contained
	 * in the binary tree
	 * @param currentNode
	 * @return int size
	 */
	public int getSize(Node<T> currentNode) {
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

	/**
	 * Calculates the height of the given subtree
	 * @param currentNode
	 * @return TreeHeight treeHeight
	 */
	public TreeHeight getHeight(Node<T> currentNode) {
		int leftHeight, rightHeight;
		if (currentNode == null) {
			return new TreeHeight(0, 0);
		} else {
			leftHeight = getHeight(currentNode.getLeftNode()).getTotalHeight();
			rightHeight = getHeight(currentNode.getRightNode()).getTotalHeight();
			return new TreeHeight(leftHeight + 1, rightHeight + 1);
		}
	}

	/**
	 * returns the root
	 * @return Node<T> node
	 */
	public Node<T> getRoot() {
		return root;
	}

	/**
	 * returns the biggest value of the binary tree
	 * @return biggestValue
	 */
	public ComparableObject<T> getBiggest() {
		Node<T> currentNode = root;
		while (currentNode.getRightNode() != null) {
			currentNode = currentNode.getRightNode();
		}
		return currentNode.getValue();
	}

	/**
	 * returns the smallest value of the binary tree
	 * @return smallestValue
	 */
	public ComparableObject<T> getSmallest() {
		Node<T> currentNode = root;
		while (currentNode.getLeftNode() != null) {
			currentNode = currentNode.getLeftNode();
		}
		return currentNode.getValue();
	}

	/**
	 * returns all values of the binary tree
	 * @return allValues
	 */
	public ArrayList<ComparableObject<T>> getAllValues() {
		allValues = new ArrayList<ComparableObject<T>>();
		inOrder(root);
		return allValues;
	}
	/**
	 * in order Method to read all values of the binary tree
	 * @param node
	 */
	private void inOrder(Node<T> node) {
		if(node!= null) {
			inOrder(node.getLeftNode());
			allValues.add(node.getValue());
			inOrder(node.getRightNode());
		}
	}
	
	/**
	 * method to rebalance the binary tree 
	 * uses specific avl algorithms to keep the tree balanced
	 * @param treeToBalance
	 */
	private void rebalanceAVLTree(Node<T> treeToBalance) {
		while(treeToBalance != null) {
			TreeHeight subTreeHeight = getHeight(treeToBalance);
			TreeHeight leftChildTreeHeight = getHeight(treeToBalance.getLeftNode());
			TreeHeight rightChildTreeHeight = getHeight(treeToBalance.getRightNode());
			//Left-Right Case
			if(subTreeHeight.getLeftHeight() - subTreeHeight.getRightHeight() == 2
					&& leftChildTreeHeight.getLeftHeight() - leftChildTreeHeight.getRightHeight() == -1) {
				Node<T> leftChild = treeToBalance.getLeftNode();
				Node<T> nodeToRotate = leftChild.getRightNode();
				nodeToRotate.setParent(leftChild.getParent());
				leftChild.setRightNode(nodeToRotate.getLeftNode());
				if(leftChild.getParent() != null) {
					leftChild.getParent().setLeftNode(nodeToRotate);
				} else {
					root = nodeToRotate;
				}
				nodeToRotate.setLeftNode(leftChild);
				leftChild.setParent(nodeToRotate);
				
				Node<T> node = treeToBalance.getLeftNode();
				node.setParent(treeToBalance.getParent());
				treeToBalance.setLeftNode(node.getRightNode());
				if(treeToBalance.getParent() != null) {
					treeToBalance.getParent().setLeftNode(node);
				} else {
					root = node;
				}
				
				node.setRightNode(treeToBalance);
				treeToBalance.setParent(node);
			//Right-Left Case	
			} else if(subTreeHeight.getLeftHeight() - subTreeHeight.getRightHeight() == -2
					&& rightChildTreeHeight.getLeftHeight() - rightChildTreeHeight.getRightHeight() == 1) {
				
				Node<T> rightChild = treeToBalance.getRightNode();
				Node<T> nodeToRotate = rightChild.getLeftNode();
				nodeToRotate.setParent(rightChild.getParent());
				rightChild.setLeftNode(nodeToRotate.getRightNode());
				if(rightChild.getParent() != null) {
					rightChild.getParent().setRightNode(nodeToRotate);
				} else {
					root = nodeToRotate;
				}
				
				nodeToRotate.setRightNode(rightChild);
				rightChild.setParent(nodeToRotate);
				
				Node<T> node = treeToBalance.getRightNode();
				node.setParent(treeToBalance.getParent());
				treeToBalance.setRightNode(node.getLeftNode());
				if(treeToBalance.getParent() != null) {
					treeToBalance.getParent().setRightNode(node);
				} else {
					root = node;
				}
				node.setLeftNode(treeToBalance);
				treeToBalance.setParent(node); 
			//Left-Left Case
			} else if(subTreeHeight.getLeftHeight() - subTreeHeight.getRightHeight() == 2) {
				Node<T> nodeToRotate = treeToBalance.getLeftNode();
				nodeToRotate.setParent(treeToBalance.getParent());
				treeToBalance.setLeftNode(nodeToRotate.getRightNode());
				if(treeToBalance.getParent() != null) {
					treeToBalance.getParent().setLeftNode(nodeToRotate);
				} else {
					root = nodeToRotate;
				}
				
				nodeToRotate.setRightNode(treeToBalance);
				treeToBalance.setParent(nodeToRotate);
			//Right-Right Case	
			} else if(subTreeHeight.getRightHeight() - subTreeHeight.getLeftHeight() == 2) {
				Node<T> nodeToRotate = treeToBalance.getRightNode();
				nodeToRotate.setParent(treeToBalance.getParent());
				treeToBalance.setRightNode(nodeToRotate.getLeftNode());
				if(treeToBalance.getParent() != null) {
					treeToBalance.getParent().setRightNode(nodeToRotate);
				} else {
					root = nodeToRotate;
				}
				nodeToRotate.setLeftNode(treeToBalance);
				treeToBalance.setParent(nodeToRotate); 
			}
			treeToBalance = treeToBalance.getParent();
		}
	}
}
