package de.szut.baum;

/**
 * Object which contains the height
 * of the left and right limb of the given node
 * @author Steffen Wißmann
 *
 */
public class TreeHeight {
	private int leftHeight;
	private int rightHeight;
	
	public TreeHeight(int leftHeight, int rightHeight) {
		this.leftHeight = leftHeight;
		this.rightHeight = rightHeight;
	}
	/**
	 * sets the height of the left limb
	 * @param leftHeight
	 */
	public void setLeftHeight(int leftHeight) {
		this.leftHeight = leftHeight;
	}
	/**
	 * sets the height of the right limb
	 * @param rightHeight
	 */
	public void setRightHeight(int rightHeight) {
		this.rightHeight = rightHeight;
	}
	/**
	 * returns the height of the left limb
	 * @return
	 */
	public int getLeftHeight() {
		return leftHeight;
	}
	/**
	 * returns the height of the right limb
	 * @return
	 */
	public int getRightHeight() {
		return rightHeight;
	}
	/**
	 * returns the total height of the tree, which
	 * is the biggest limb height
	 * @return
	 */
	public int getTotalHeight() {
		if(leftHeight > rightHeight) {
			return leftHeight;
		}	
		return rightHeight;
	}
}
