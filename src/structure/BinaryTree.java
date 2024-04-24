package structure;

/*
 * A Simplified Binary Search Tree with LCA Method
 * @author Hazmed
 * @version 1
 */
public class BinaryTree {
	
	//Node
    public static class Node{    
        int data;    
        Node left;    
        Node right;    
        public Node(int data) {       
            this.data = data;    
            this.left = null;    
            this.right = null;    
        }    
    }  
    
    //Root
	public Node root;
	public BinaryTree() {
		root = null;
	}
	
	/*
	 * Finds Lowest Common Ancestor
	 * @param node - root node in tree
	 * @param a - node 1
	 * @param b - node 2
	 */
	public Node LCA(Node node, int a, int b) {
		if (node == null) return null;
		if (node.data > a && node.data > b) return LCA(node.left, a, b);
		if (node.data < a && node.data < b) return LCA(node.right, a, b);
		
		return node;
	}
	
	//Runs the program
	public void run() {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(8);
        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(10);
        tree.root.left.right.left = new Node(7);
        tree.root.left.right.right = new Node(6);
        
        int a = 6, b = 10;
        Node LCANode = tree.LCA(tree.root, a, b);
        System.out.println("The LCA of " + a + 
        				   " and " + b + " in this tree is "
        				   + LCANode.data + ".");
	}
}
