class List {    
    private Element head;
    
    public List() { }
    
    boolean isEmpty() {
        return (head == null);
    }
    
    void putAtFirst(int value) {
        Element e = new Element(value, null);
        if (isEmpty()) {
            head = e;
        } else {
            head.setPrevious(e);
            e.setNext(head);
            head = e;
        }
    }
    
    void putAtEnd(int value) {
        Element e = head;
        if (isEmpty()) {
            head = new Element(value, null);
        } else {
            while (e.getNext() != null) {
                e = e.getNext();
            }
            e.setNext(new Element(value, e));
        }
    }
    
    void put(int index, int value) {
        if (isEmpty()) {
            putAtFirst(value);
        } else {
            int n = 1;
            Element e = head;
            while ((n < index) && (e.getNext() != null)) {
                e = e.getNext();
                n++;
            }
            Element f = new Element(value, e.getPrevious());
            e.getPrevious().setNext(f);
            f.setNext(e);
            e.setPrevious(f);
        }
    }    
    
    int searchByValue(int value){
        if (!isEmpty()) {
            int n = 1;
            Element e = head;
            while ((e.getValue() != value) && (e.getNext() != null)) {
                e = e.getNext();
                n++;
            }
            return n;
        }
        return 0;
    }
}