/*****************************************************
 * class TreeNode
 * SKELETON
 * Implements a node for use in a binary tree.
 * Only holds int cargo.
 *****************************************************/

public class TreeNode {

    // instance variables:
    int cargo; // node's data
    TreeNode lt, rt; // pointers to left, right subtrees

    /*****************************************************
     * default constructor
     * Construct a tree node with specified value, 
     * with null left and right subtrees.
     *****************************************************/
    TreeNode (int initValue) {
	cargo = initValue;
	TreeNode lt = rt = null;
    }

    /*****************************************************
     * overloaded constructor
     * Construct tree node w specified value, left, and right subtrees.
     *****************************************************/
    TreeNode (int initValue, TreeNode initLeft, TreeNode initRight) {
	cargo = initValue;
	lt = initLeft;
	rt = initRight;
    }
 
    /*****************************************************
     * Returns the left subtree of this node.
     *****************************************************/
    TreeNode getLeft() {
	return lt;
    }
    
    /*****************************************************
     * Returns the right subtree of this node.
     *****************************************************/
    TreeNode getRight() {
	return rt;
    }

    /*****************************************************
     * Returns the value stored in this tree node.
     *****************************************************/
    int getCargo() {
	return cargo;
    }

    /*****************************************************
     * Sets the value of the left subtree of this node.
     *****************************************************/
    void setLeft (TreeNode theNewLeft) {
	lt = theNewLeft;
    }
    
    /*****************************************************
     * Sets the value of the right subtree of this node.
     *****************************************************/
    void setRight (TreeNode theNewRight) {
	rt = theNewRight;
    }

    /*****************************************************
     * Sets the value of this tree node.
     *****************************************************/
    void setCargo (int theNewValue) {
	cargo = theNewValue;
    }
} // end class
