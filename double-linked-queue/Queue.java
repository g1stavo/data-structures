class Queue {
    int n;
    Element element;
    Element end;

    Queue() {
    }

    void in(int value) {
        Element used = new Element(value, end, element);
        if (n > 0) {
            element.putNext(used);
            element = used;
        } else {
            element = used;
            end = used;
        }
        n++;
    }

    int out() {
        if (n != 0) {
            Element ret = end;
            end = ret.getNext();
            n--;
            return ret.getValue();
        }
        return 0;
    }
}