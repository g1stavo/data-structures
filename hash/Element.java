package hash;

class Element {
    private int value;
    private Element previous;
    private Element next;

    int getValue() {
        return value;
    }

    void setValue(int value) {
        this.value = value;
    }

   Element getPrevious() {
        return previous;
    }

    void setPrevious(Element previous) {
        this.previous = previous;
    }
    
    Element getNext() {
        return next;
    }

    void setNext(Element next) {
        this.next = next;
    }

    Element(int value, Element previous) {
        this.value = value;
        this.previous = previous;
    }  

    Element(int value) {
        this.value = value;
    }    
    
}