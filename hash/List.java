package hash;

class List {

    private Element head, cursor;

    List() {
    }

    boolean isEmpty() {
        return (head == null);
    }

    Element Last() {
        return head.getPrevious();
    }

    void putAtLast(int value) {
        Element e = new Element(value, null);
        if (isEmpty()) {
            cursor = head = e;
            head.setPrevious(e);
            head.setNext(e);
        } else {
            Last().setNext(e);
            e.setPrevious(Last());
            e.setNext(head);
            head.setPrevious(e);
        }
    }

    Element search(int value) throws Exception {
        putAtLast(value);
        Element aux = head;
        while ((aux.getValue() != value) && (aux.getNext() != head)) {
            aux = aux.getNext();
        }
        if (aux.getNext() == head) {
            removeAtEnd();
            throw new Exception("There's no element with this value in the list.");
        } else {
            removeAtEnd();
            return aux;
        }
    }

    Element removeAtEnd() throws Exception {
        if (isEmpty()) {
            throw new Exception("It's empty!");
        } else {
            Element aux = Last();
            aux.getPrevious().setNext(head);
            head.setPrevious(aux.getPrevious());
            return aux;
        }
    }

    Element remove(int value) throws Exception {
        if (isEmpty()) {
            throw new Exception("It's empty!");
        } else {
            Element aux = search(value);
            aux.getPrevious().setNext(aux.getNext());
            aux.getNext().setPrevious(aux.getPrevious());
            return aux;
        }
    }

}