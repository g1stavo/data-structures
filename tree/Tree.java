package linkedTree;

// the tree itself.
class Tree {

    Node root;
    // tree's root. the center element.
    int n;
    // number of elements.

    // tree's constructor.
    Tree() {
    }

    // returns tree's root node.    
    Node getRoot() {
        return root;
    }

    // @param (Node) $root new root.
    // sets tree's root node.
    void setRoot(Node root) {
        this.root = root;
    }

    // calls the recursive method for inserting a new element.
    // @param (int) $value new node's value.
    // @exception if there's already an element with this value on the tree.
    void insert(int value) throws Exception {
        insertRecursive(root, value);
        // calls insertRecursive() with the actual root and $value as parameters.
    }

    // recursive method for inserting a new element. 
    // @param (Node) $root actual root.
    // @param (int) $value new node's value.
    // @exception if there's already an element with this value on the tree.    
    void insertRecursive(Node root, int value) throws Exception {
        if (n == 0) {
            // checks if the tree is empty.            
            this.root = new Node(value);
            // this.root receives a new node with $value as parameter.            
            n++;
            // increments the number of elements.
        } else if (value < root.value) {
            // checks if $value is smaller than root's value. 
            if (root.getLeft() != null) {
                // checks if root has a left son. 
                insertRecursive(root.getLeft(), value);
                // calls insertRecursive() with root's left son as root and $value.
            } else {
                root.setLeft(new Node(value));
                // insert new Node with $value as parameter as root's left son.                
                n++;
                // increments the number of elements.
            }
        } else if (value > root.value) {
            // checks if $value is bigger than root's value.  
            if (root.getRight() != null) {
                // checks if root has a right son. 
                insertRecursive(root.getRight(), value);
                // calls insertRecursive() with root's right son as root and $value.
            } else {
                root.setRight(new Node(value));
                // insert new Node with $value as parameter as root's right son.
                n++;
                // increments the number of elements.
            }
        } else {
            // if $value is equal to root's value throws exception.
            throw new Exception("There's already an element in this tree with the given value.");
        }
    }

    // calls the recursive method for searching an element.
    // @param (int) $value node's value.  
    boolean search(int value) throws Exception {
        return searchRecursive(root, value);
        // calls searchRecursive() with the actual root and $value as parameters.
    }

    boolean searchRecursive(Node root, int value) throws Exception {
        if (root.getLeft() != null) {
            if (root.getLeft().getValue() == value) {
                return true;
            } else {
                searchRecursive(root.getLeft(), value);
            }
        } else if (root.getValue() == value) {
            return true;
        } else if (root.getRight() != null) {
            if (root.getRight().getValue() == value) {
                return true;
            } else {
                searchRecursive(root.getRight(), value);
            }
        }
        throw new Exception("Value not found!");
    }
}
