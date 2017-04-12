class Deque {
    private int n;
    private Element element;
    private Element end;

    Deque() {
    }    
    
    boolean isEmpty () {
        return (n == 0);
    }

    void inStart(int value) {
        Element used = new Element(value, end, element);
        if (!isEmpty()) {
            element.putNext(used);
            element = used;
        } else {
            element = used;
            end = used;
        }
        n++;
    }
    
    void inEnd(int value){
        Element used = new Element(value, end, null);
        if (!isEmpty()) {
            used.putNext(end);
            end.putPrevious(used);
            end = used;
        } else {
            element = used;
            end = used;
        }
        n++;
    }

    int outEnd() {
        if (!isEmpty()) {
            Element ret = end;
            end = ret.getNext();
            n--;
            return ret.getValue();
        }
        return 0;
    }
    
    int outStart() {
        if (!isEmpty()) {
            Element ret = element;
            element = ret.getPrevious();
            n--;
            return ret.getValue();
        }
        return 0;
    }
}