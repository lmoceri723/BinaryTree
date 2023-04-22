import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Landon Moceri
 * @version: 4/21/22
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */

    // Searches in a binary tree for a value, calling a recursive helper method starting at the root
    public boolean search(int val) {
        return binarySearch(val, root);
    }

    // Searches for a value in a node of the tree,
    // Moving on to its children in the relative direction of val from the node
    public boolean binarySearch(int val, BSTNode node) {
        // Checks if the current node is val and returns true
        if (node.getVal() == val) {
            return true;
        }
        // Checks if val should be to the left of the node and recurs down the left branch if so
        if (val < node.getVal())
        {
            if (node.getLeft() == null)
            {
                // Returns false if the place where val should be is empty
                return false;
            }
            return binarySearch(val, node.getLeft());
        }
        // Checks if val should be to the right of the node and recurs down the right branch if so
        else
        {
            if (node.getRight() == null)
            {
                // Returns false if the place where val should be is empty
                return false;
            }
            return binarySearch(val, node.getRight());
        }
    }
    /**
     * @return ArrayList of BSTNodes in inorder
     */

    // Gets the nodes of the tree in inorder, calling a recursive method to modify an ArrayList of nodes
    public ArrayList<BSTNode> getInorder() {
        ArrayList<BSTNode> inOrder = new ArrayList<BSTNode>();
        inorderHelper(inOrder, root);
        return inOrder;
    }

    // Recurs down each branch of the tree in the order of left, root, right, adding them to an ArrayList
    public void inorderHelper(ArrayList<BSTNode> inOrder, BSTNode currentNode)
    {
        // Goes as far down in the left direction as possible
        if (currentNode.getLeft() != null)
        {
            inorderHelper(inOrder, currentNode.getLeft());
        }

        // Adds the element to the ArrayList
        inOrder.add(currentNode);

        // Goes in the right direction afterwards
        if (currentNode.getRight() != null)
        {
            inorderHelper(inOrder, currentNode.getRight());
        }
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    // Gets the nodes of the tree in preorder, calling a recursive method to modify an ArrayList of nodes
    public ArrayList<BSTNode> getPreorder() {
        ArrayList<BSTNode> preOrder = new ArrayList<BSTNode>();
        preorderHelper(preOrder, root);
        return preOrder;
    }

    // Recurs down each branch of the tree in the order of root, left, right, adding them to an ArrayList
    public void preorderHelper(ArrayList<BSTNode> preOrder, BSTNode currentNode)
    {
        // Adds the root first
        preOrder.add(currentNode);

        // Explores as much as possible in the left direction
        if (currentNode.getLeft() != null)
        {
            preorderHelper(preOrder, currentNode.getLeft());
        }

        // Explores as much as possible in the right direction
        if (currentNode.getRight() != null)
        {
            preorderHelper(preOrder, currentNode.getRight());
        }
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    // Gets the nodes of the tree in postorder, calling a recursive method to modify an ArrayList of nodes
    public ArrayList<BSTNode> getPostorder() {
        ArrayList<BSTNode> postOrder = new ArrayList<BSTNode>();
        postorderHelper(postOrder, root);
        return postOrder;
    }

    // Recurs down each branch of the tree in the order of left, right, root, adding them to an ArrayList
    public void postorderHelper(ArrayList<BSTNode> postOrder, BSTNode currentNode) {

        // Explores as much as possible in the left direction
        if (currentNode.getLeft() != null) {
            postorderHelper(postOrder, currentNode.getLeft());
        }

        // Explores as much as possible in the right direction
        if (currentNode.getRight() != null) {
            postorderHelper(postOrder, currentNode.getRight());
        }
        // Adds the node last
        postOrder.add(currentNode);
    }

    /**
     * @param val The value ot insert
     */
    // Inserts an element into the tree by calling a recursive method that starts at the root
    public void insert(int val)
    {
        insertHelper(val, root);
    }

    // Recurs down each node of the tree in the direction of val, until either reaching it or adding it to the tree
    public void insertHelper(int val, BSTNode currentNode)
    {
        // Returns if the current node is val
        if (val == currentNode.getVal())
        {
            return;
        }

        // Checks if val should be to the left of the node
        if (val < currentNode.getVal())
        {
            // Adds the node if the spot it should be in is empty
            if (currentNode.getLeft() == null)
            {
                currentNode.setLeft(new BSTNode(val));
                return;
            }
            // Runs the method again with the node to the left as the current node
            insertHelper(val, currentNode.getLeft());
        }
        // Checks if val should be to the right of the node
        else
        {
            // Adds the node if the spot it should be in is empty
            if (currentNode.getRight() == null)
            {
                currentNode.setRight(new BSTNode(val));
                return;
            }
            // Runs the method again with the node to the right as the current node
            insertHelper(val, currentNode.getRight());
        }
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
