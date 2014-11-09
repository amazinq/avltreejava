package de.szut.baum;

public class TreeHeight {
	private int leftHeight;
	private int rightHeight;
	
	public TreeHeight(int leftHeight, int rightHeight) {
		this.leftHeight = leftHeight;
		this.rightHeight = rightHeight;
	}

	public void setLeftHeight(int leftHeight) {
		this.leftHeight = leftHeight;
	}

	public void setRightHeight(int rightHeight) {
		this.rightHeight = rightHeight;
	}

	public int getLeftHeight() {
		return leftHeight;
	}
	
	public int getRightHeight() {
		return rightHeight;
	}
	
	public int getTotalHeight() {
		if(leftHeight > rightHeight) {
			return leftHeight;
		}	
		return rightHeight;
	}
}
