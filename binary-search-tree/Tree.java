package linkedTree;

class Tree {

    Node root;
    int n;
    
    Tree() {
    }

    Node getRoot() {
        return root;
    }

    void setRoot(Node root) {
        this.root = root;
    }

    void insert(int value) throws Exception {
        insertRecursive(root, value);
    }
    
    private void insertRecursive(Node root, int value) throws Exception {
        if (n == 0) {            
            this.root = new Node(value);      
            n++;
        } else if (value < root.value) {
            if (root.getLeft() != null) {
                insertRecursive(root.getLeft(), value);
            } else {
                root.setLeft(new Node(value));               
                n++;
            }
        } else if (value > root.value) {
            if (root.getRight() != null) {
                insertRecursive(root.getRight(), value);
            } else {
                root.setRight(new Node(value));
                n++;
            }
        } else {
            throw new Exception("There's already an node in this tree with the given value.");
        }
    }

    boolean search(int value) throws Exception {
        return searchRecursive(root, value);
    }

    private boolean searchRecursive(Node root, int value) throws Exception {
        if (root == null) {
            return false;
        } else {
            if (root.getValue() == value) {
                return true;
            } else if (value < root.getValue()) {
                return searchRecursive(root.getLeft(), value);
            } else {
                return searchRecursive(root.getRight(), value);
            }
        }
    }
}
