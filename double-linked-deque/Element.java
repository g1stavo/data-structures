class Element {
    private int value;
    private Element end;
    private Element previous;
    private Element next;
    
    Element(int value, Element end, Element previous){
        this.value = value;
        this.end = end;
        this.previous = previous;
    }
    
    void putNext(Element next){
        this.next = next;
    }
    
    void putPrevious(Element previous) {
        this.previous = previous;
    }

    Element getNext() {
        return next;
    }
    
    int getValue() {
        return value;
    }

    Element getEnd() {
        return end;
    }

    Element getPrevious() {
        return previous;
    }    
}