package decisiontree.model;

import java.io.Serializable;

public class Node implements Serializable {
    private static final long serialVersionUID = 1L;
    private String text;
    private Node yes;
    private Node no;

    public Node(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
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
}