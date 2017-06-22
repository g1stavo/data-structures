package decisionTree.model;


public class Tree {

    private Node root;

    public Tree() {
        root = new Node("baleia");
    }
 
    public Node getRoot() {
        return root;
    }
    
    public void setRoot(Node root) {
        this.root = root;
    }

    /* 
    void insert(int value) throws Exception {
        insertRecursive(root, value);
    }

    private void insertRecursive(Node root, int value) throws Exception {
        if (n == 0) {            
            this.root = new Node(value);        
            n++;
        } else if (value < root.value) { 
            if (root.getYes() != null) {
                insertRecursive(root.getYes(), value);
            } else {
                root.setYes(new Node(value));               
                n++;
            }
        } else if (value > root.value) {
            if (root.getNo() != null) {
                insertRecursive(root.getNo(), value);
            } else {
                root.setNo(new Node(value));
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
                return searchRecursive(root.getYes(), value);
            } else {
                return searchRecursive(root.getNo(), value);
            }
        }
    }
    */
}