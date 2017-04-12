/*
 *
 * No license at all. I'm just a guy who's studying Java.
 *
 */
 

/**
 *
 * @author gustavo
 */
class Element {

    private int value;
    private Element previous;
    private Element next;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Element getPrevious() {
        return previous;
    }

    public void setPrevious(Element previous) {
        this.previous = previous;
    }

    public Element getNext() {
        return next;
    }

    public void setNext(Element next) {
        this.next = next;
    }

    public Element(int value, Element previous) {
        this.value = value;
        this.previous = previous;
    }
}
