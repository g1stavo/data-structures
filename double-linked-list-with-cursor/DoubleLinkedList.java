/*
 *
 * No license at all. I'm just a guy who's studying Java.
 *
 */
 

/**
 *
 * @author gustavo
 */
class DoubleLinkedList {

    private Element head, cursor;

    DoubleLinkedList() {
    }

    boolean isEmpty() {
        return (head == null);
    }

    Element Last() {
        return head.getPrevious();
    }

    void moveCursorToHead() {
        if (!isEmpty()) {
            cursor = head;
        }
    }

    void moveCursorToLast() {
        if (!isEmpty()) {
            cursor = head.getPrevious();
        }
    }

    void jumpCursor(int k) {
        int n = 0;
        while ((n < k) && (cursor.getNext() != head)) {
            cursor = cursor.getNext();
            n++;
        }
    }

    void jumpCursor() {
        jumpCursor(1);
    }

    void twistCursor(int k) {
        int n = 0;
        while ((n < k) && (cursor.getPrevious() != Last())) {
            cursor = cursor.getPrevious();
            n++;
        }
    }

    void twistCursor() {
        twistCursor(1);
    }

    void putAtHead(int value) {
        Element e = new Element(value, null);
        if (isEmpty()) {
            cursor = head = e;
            head.setPrevious(e);
            head.setNext(e);
        } else {
            e.setPrevious(Last());
            e.setNext(head);
            head.setPrevious(e);
            head = e;
        }
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

    void putBeforeCursor(int value) {
        if (isEmpty()) {
            putAtHead(value);
        } else {
            Element element = new Element(value, cursor.getPrevious());
            element.setNext(cursor);
            cursor.getPrevious().setNext(element);
            cursor.setPrevious(element);
        }
    }

    void putAfterCursor(int value) {
        if (isEmpty()) {
            putAtHead(value);
        } else {
            Element element = new Element(value, cursor);
            element.setNext(cursor.getNext());
            cursor.getNext().setPrevious(element);
            cursor.setNext(element);
        }
    }

    Element getCursor() {
        return cursor;
    }

    Element removeAtFirst() throws Exception {
        if (isEmpty()) {
            throw new Exception("It's empty!");
        } else {
            Element aux = head;
            head.getNext().setPrevious(Last());
            head = head.getNext();
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

    Element removeByCursor() {
        Element e = cursor;
        cursor.getPrevious().setNext(cursor.getNext());
        cursor.getNext().setPrevious(cursor.getPrevious());
        cursor = cursor.getPrevious();
        return e;
    }

    void insertAfter(int element, int value) throws Exception {
        cursor = search(element);
        putAfterCursor(value);
    }

    void insertBefore(int element, int value) throws Exception {
        cursor = search(element);
        putBeforeCursor(value);
    }

}
