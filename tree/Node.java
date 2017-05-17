package linkedTree;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */

class Node {

    Node left;
    Node right;
    int value;

    Node(int value) {
        this.value = value;
    }

    Node getLeft() {
        return left;
    }

    void setLeft(Node left) {
        this.left = left;
    }

    Node getRight() {
        return right;
    }

    void setRight(Node right) {
        this.right = right;
    }

    int getValue() {
        return value;
    }

}