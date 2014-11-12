package de.szut.baum;

import java.util.ArrayList;

public class Tree<T extends Comparable<T>> {

	private Node<T> root;
	private ArrayList<ComparableObject<T>> allValues;
	private ArrayList<Node<T>> allNodes;

	public Tree() {
		root = null;
		allValues = new ArrayList<ComparableObject<T>>();
		allNodes = new ArrayList<Node<T>>();
	}

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
	
	
	public void getValue(ComparableObject<T> valueToGet) {
		
	}

	
	public ArrayList<Node<T>> getAllNodes() {
		return allNodes;
	}

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
							System.out.println("Deletion of no child nodes");
							if(valueToDelete.getValue().getKey().compareTo(valueToDelete.getParent().getValue().getKey()) == -1) {
								System.out.println("Deletion of Leftnode");
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

	public Node<T> getRoot() {
		return root;
	}

	public ComparableObject<T> getBiggest() {
		Node<T> currentNode = root;
		while (currentNode.getRightNode() != null) {
			currentNode = currentNode.getRightNode();
		}
		return currentNode.getValue();
	}

	public ComparableObject<T> getSmallest() {
		Node<T> currentNode = root;
		while (currentNode.getLeftNode() != null) {
			currentNode = currentNode.getLeftNode();
		}
		return currentNode.getValue();
	}

	public ArrayList<ComparableObject<T>> getAllValues() {
		allValues = new ArrayList<ComparableObject<T>>();
		inOrder(root);
		return allValues;
	}
	
	private void inOrder(Node<T> node) {
		if(node!= null) {
			inOrder(node.getLeftNode());
			allValues.add(node.getValue());
			inOrder(node.getRightNode());
		}
	}
	
	
	private void rebalanceAVLTree(Node<T> treeToBalance) {
		//System.out.println(treeToBalance.getValue().getKey());
		while(treeToBalance != null) {
			//System.out.println("currentValue: " + treeToBalance.getValue().getKey());
			TreeHeight subTreeHeight = getHeight(treeToBalance);
			TreeHeight leftChildTreeHeight = getHeight(treeToBalance.getLeftNode());
			TreeHeight rightChildTreeHeight = getHeight(treeToBalance.getRightNode());
			//System.out.println("LefHeight: " + subTreeHeight.getLeftHeight());
			//System.out.println("RightHeight: " + subTreeHeight.getRightHeight());
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
				
			} else if(subTreeHeight.getLeftHeight() - subTreeHeight.getRightHeight() == 2) {
//				System.out.println("Right Rotation");
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
			} else if(subTreeHeight.getRightHeight() - subTreeHeight.getLeftHeight() == 2) {
//				System.out.println("Left Rotation");
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
	
	public void print() {
        printBinaryTree(root, 0);
}

	private void printBinaryTree(Node<T> root, int level){
    if(root==null)
         return;
    printBinaryTree(root.getRightNode(), level+1);
    if(level!=0){
        for(int i=0;i<level-1;i++)
            System.out.print("|\t");
            System.out.println("|///////"+root.getValue().getKey());
    }
    else
        System.out.println(root.getValue().getKey());
    printBinaryTree(root.getLeftNode(), level+1);
}
}
