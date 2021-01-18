class LinkedArray {

    Element[] list;
    int[] aux;
    int head, last, n, id;

    /**
     * @param size size of the Element list.
     */
    LinkedArray(int size) {
        list = new Element[size];
        aux = new int[size * 2];

        for (int i = size; i < (size * 2); i++) {
            aux[i] = i - size;
        }
    }

    /**
     * @return true if there's no elements in the list.
     */
    boolean empty() {
        return n == 0;
    }

    /**
     * @return true if the list is full.
     */
    boolean full() {
        return n == list.length;
    }

    /**
     * @param index element's index.
     * @param value element's value.
     * @throws if the list is full.
     */
    void put(int index, int value) throws Exception {
        Element element = new Element(++id, value);

        if (!full()) {
            if (aux[index + list.length] == -1) {
                throw new Exception("There's already an element in that position.");
            } else {
                list[index] = element;
                aux[index] = -1;
                aux[index + list.length] = -1;
                aux[last] = index;
                if (empty()) {
                    aux[last] = 0;
                    head = index;
                }
                last = index;
                n++;
            }
        } else {
            throw new Exception("It's full.");
        }
    }

    /**
     * @param index the position to begin the search for the next free position.
     * @return the @index aux or the next free position.
     * @throws Exception if the argument is bigger than the list's size.
     */
    int nextFree(int index) throws Exception {
        index = index + list.length;

        if (index < aux.length) {
            while (aux[index] == -1) {
                index++;
                if (index == aux.length) {
                    index = list.length;
                }
            }
        } else {
            throw new Exception("There's no element with this index in the list.");
        }
        return aux[index];
    }

    /**
     * @param value element's value.
     * @throws if the list is full.
     */
    void putAtHead(int value) throws Exception {/* create an element with the parameters. */
        Element element = new Element(++id, value);
        int index = nextFree(0);

        if (!full()) {
            if (aux[index + list.length] == -1) {
                throw new Exception("There's already an element in that position.");
            } else {
                list[index] = element;
                aux[index] = head;
                aux[index + list.length] = -1;
                if (empty()) {
                    aux[last] = 0;
                    head = index;
                }
                head = index;
                n++;
            }
        } else {
            throw new Exception("It's full.");
        }
    }

    /**
     * @param value element's value.
     * @throws if the list is full.
     */
    void putAtLast(int value) throws Exception {
        put(nextFree(0), value);
    }

    /**
     * @param index element's index.
     * @param value element's value.
     * @throws if the list is full.
     */
    void putAfter(int after, int value) throws Exception {
        Element element = new Element(++id, value);
        int index = nextFree(0);
        after = searchIndex(after);

        if (!full()) {
            if (aux[index + list.length] == -1) {
                throw new Exception("There's already an element in that position.");
            } else {
                list[index] = element;
                aux[after] = index;
                aux[index] = after;
                aux[index + list.length] = -1;

                if (after == last) {
                    aux[index] = -1;
                    last = index;
                }

                n++;
            }
        } else {
            throw new Exception("It's full.");
        }
    }

    /**
     * @param value element's value.
     * @return @value's index.
     * @throws Exception if no element with the @value is found.
     */
    int searchIndex(int value) throws Exception {
        int index = 0;
        while (index < list.length) {
            if (list[index] != null && list[index].getValue() == value) {
                return index;
            }
            index++;
        }
        throw new Exception("There's no element with this value in the list.");
    }

    /**
     * @param id element's id.
     * @return @value's id.
     * @throws Exception if no element with the @id is found.
     */
    Element search(int id) throws Exception {
        int index = 0;
        while (index < list.length) {
            if (list[index] != null && list[index].getId() == id) {
                return list[index];
            }
            index++;
        }
        throw new Exception("There's no element with this id in the list.");
    }

    /**
     * @param id the id who you want the previous.
     * @return index of the previous element.
     * @throws Exception no previous element found.
     */
    int getPreviousIndex(int id) throws Exception {
        int index = 0;
        while (index < list.length) {
            if (list[index] != null && aux[index] != -1 && list[aux[index]].getId() == id) {
                return index;
            }
            index++;
        }
        throw new Exception("There's no previous element for this id in the list.");
    }

    /**
     * @param index element's index.
     * @param value element's value.
     * @throws if the list is full.
     */
    void putBefore(int before, int value) throws Exception {
        Element element = new Element(++id, value);
        int index = nextFree(0);
        int beforeIndex = searchIndex(before);
        before = list[beforeIndex].getId();

        if (!full()) {
            if (aux[index + list.length] == -1) {
                throw new Exception("There's already an element in that position.");
            } else {
                list[index] = element;
                aux[getPreviousIndex(before)] = index;
                aux[index] = beforeIndex;
                aux[index + list.length] = -1;

                if (beforeIndex == head) {
                    head = index;
                }

                n++;
            }
        } else {
            throw new Exception("It's full.");
        }
    }

    /**
     * @param index position of the element to be removed.
     * @throws Exception if there's no element in the list.
     */
    void remove(int index) throws Exception {
        if (!empty()) {
            if (index == last && index != head) {
                last = getPreviousIndex(list[index].getId());
            }
            if (index != head) {
                aux[getPreviousIndex(list[index].getId())] = aux[index];
            }
            aux[index] = 0;
            list[index] = null;
            aux[index + list.length] = index;
            n--;
        } else {
            throw new Exception("It's empty.");
        }
    }
    
    /**
     * @param value element's value.
     * @throws Exception if the list is empty.
     */
    void removeByValue(int value) throws Exception {
        remove(searchIndex(value));
    }
    
    /**
     * @param value element's value.
     * @throws Exception if the list is empty.
     */
    void removeLast() throws Exception {
        remove(last);
    }
    
    /**
     * @param value element's value.
     * @throws Exception if the list is empty.
     */
    void removeHead() throws Exception {
        remove(head);
    }
}
