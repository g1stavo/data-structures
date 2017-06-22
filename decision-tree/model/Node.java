package decisionTree.model;

public class Node {

    private Node yes;
    private Node no;
    private String text;

    public Node(String text) {
        this.text = text;
    }

    public Node getYes() {
        return yes;
    }

    public void setYes(Node yes) {
        this.yes = yes;
    }

    public Node getNo() {
        return no;
    }

    public void setNo(Node no) {
        this.no = no;
    }

    public String getText() {
        return text;
    }

}

