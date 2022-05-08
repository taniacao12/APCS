// Tania Cao
// APCS2 pd2
// HW44 -- Prune Your Tree
// 2018-05-02

public class BST {
    // instance variables
    TreeNode root;
    
    // default constructor
    BST() {root = null;}
    
    // methods
    public void insert (int newVal) {
	TreeNode newNode = new TreeNode (newVal);
	if (root == null) {
	    root = newNode;
	    return;
	}
	insert(root,newNode);
    }
    public void insert (TreeNode stRoot, TreeNode newNode) {
	if (newNode.getCargo() < stRoot.getCargo()) {
	    if (stRoot.getLeft() == null)
		stRoot.setLeft(newNode);
	    else insert(stRoot.getLeft(), newNode);
	    return;
	}
	else {
	    if (stRoot.getRight() == null)
		stRoot.setRight(newNode);
	    else insert(stRoot.getRight(), newNode);
	}
    }
    
    public void remove (int val) {root = remove(val,root);}
    public TreeNode remove (int val, TreeNode node) {
	if (node == null) return node;
        if (val < node.getCargo())
	    node.setLeft(remove(val,node.getLeft()));
	else if (val > node.getCargo())
	    node.setRight(remove(val,node.getRight()));
	else {
	    if (node.getLeft() == null && node.getRight() == null)
		node = null;
	    else if (node.getLeft() == null)
		node = node.getRight();
	    else if (node.getRight() == null)
		node = node.getLeft();
	    else {
		node.setCargo(min(node.getRight()).getCargo());
		node.setRight(remove(min(node.getRight()).getCargo(),node.getRight()));
	    }
	}
	return node;
    }
	
    public TreeNode min (TreeNode node) {
	while (node.getLeft() != null)
	    node = node.getLeft();
	return node;
    }
    
    public void preOrderTrav() {preOrderTrav(root);}
    public void preOrderTrav (TreeNode currNode) {
	if (currNode == null) return;
	System.out.println(currNode.getCargo());
	preOrderTrav(currNode.getLeft());
	preOrderTrav(currNode.getRight());
    }
    
    public void inOrderTrav() {inOrderTrav(root);}
    public void inOrderTrav (TreeNode currNode) {
	if (currNode == null) return;
	inOrderTrav(currNode.getLeft());
	System.out.println(currNode.getCargo());
	inOrderTrav(currNode.getRight());
    }

    public void postOrderTrav() {postOrderTrav(root);}
    public void postOrderTrav (TreeNode currNode) {
	if (currNode == null) return;
	postOrderTrav(currNode.getLeft());
	postOrderTrav(currNode.getRight());
	System.out.println(currNode.getCargo());
    }
    
    TreeNode search (int target) {return search(root,target);}
    TreeNode search (TreeNode currNode, int target) {
	if (currNode.getCargo() == target)
	    return currNode;
        else if (currNode.getCargo() > target)
	    return search(currNode.getLeft(),target);
	else if (currNode.getCargo() < target)
	    return search(currNode.getRight(),target);
	else return null;
    }
    
    public int height() {return height(root);}
    public int height (TreeNode currNode) {
	if (currNode.getLeft() == null && currNode.getRight() == null)
	    return 0;
	else if (currNode.getLeft() == null)
	    return height(currNode.getRight()) + 1;
	else if (currNode.getRight() == null)
	    return height(currNode.getLeft()) + 1;
	else {
	    if (height(currNode.getLeft()) >= height(currNode.getRight()))
		return height(currNode.getLeft()) + 1;
	    return height(currNode.getRight()) + 1;
	}
    }
    
    public int numLeaves() {return numLeaves(root);}
    public int numLeaves (TreeNode currNode) {
	if (currNode.getLeft() == null && currNode.getRight() == null)
	    return 1;
	else if (currNode.getLeft() == null)
	    return numLeaves(currNode.getRight());
	else if (currNode.getRight() == null)
	    return numLeaves(currNode.getLeft());
	else 
	    return numLeaves(currNode.getLeft()) + numLeaves(currNode.getRight());
    }
    
    // main method for testing
    public static void main (String[] args) {
	BST arbol = new BST();
	arbol.insert(4);
	arbol.insert(2);
	arbol.insert(5);
	arbol.insert(6);
	arbol.insert(1);
	arbol.insert(3);
	
	System.out.println("\n-----------------------------");
	System.out.println("pre-order traversal:" );
	arbol.preOrderTrav();
	
	System.out.println("\n-----------------------------");
	System.out.println("in-order traversal:" );
	arbol.inOrderTrav();

	System.out.println("\n-----------------------------");
	System.out.println("post-order traversal:" );
	arbol.postOrderTrav();
	
	System.out.println("\n-----------------------------");
	System.out.println("3 is located at: " + arbol.search(3));
	System.out.println("Height: " + arbol.height());
	System.out.println("Number of Leaves: " + arbol.numLeaves());

	System.out.println("\n-----------------------------");
	arbol.remove(2);
	System.out.println("pre-order traversal after removing 2:");
	arbol.preOrderTrav();
	System.out.println("in-order traversal after removing 2:");
	arbol.inOrderTrav();
	System.out.println("post-order traversal after removing 2:");
	arbol.postOrderTrav();
    }
} // end class
