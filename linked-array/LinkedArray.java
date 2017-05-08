/**
 * @author gustavo de castro salvador and silvia laurentino.
 * federal university of santa catarina. may, 2017.
 */

/* the linked array itself. */
class LinkedArray {

    /* an element's array. */
    Element[] list;
    /* auxiliar array that links the elements in the first half and handles the free spaces on the second half. */
    int[] aux;
    /* @head the first element of the list. @last the last element which entered the list. @n the number of elements on the list. @id the last identification code used.*/
    int head, last, n, id;

    /**
     * @param size size of the Element list.
     */
    LinkedArray(int size) {
        /* create an Element array with the parameter's size and put in @list. */
        list = new Element[size];
        /* create an int array with the size times 2 and put in @aux. */
        aux = new int[size * 2];

        /* fill the second half of @aux with the free spaces index. */
        for (int i = size; i < (size * 2); i++) {
            /* put in @aux[i] the respective position in the first half. */
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
        /* create an element with the parameters. */
        Element element = new Element(++id, value);

        if (!full()) {
            if (aux[index + list.length] == -1) {
                throw new Exception("There's already an element in that position.");
            } else {
                /* put the element in @index position. */
                list[index] = element;
                /* makes the @index aux point to -1. */
                aux[index] = -1;
                /* makes the @index of the second half of aux point to -1, turning it to not free. */
                aux[index + list.length] = -1;
                /* makes the @last aux point to the new element. */
                aux[last] = index;
                /* if the list is empty, makes the last aux point to 0 and makes the head points to the new element. */
                if (empty()) {
                    aux[last] = 0;
                    head = index;
                }
                /* makes @index the last element position. */
                last = index;
                /* increments the number of elements. */
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
        /* index receives it's correspondent on the list's second half. */
        index = index + list.length;

        if (index < aux.length) {
            while (aux[index] == -1) {
                /* increments @index. */
                index++;
                if (index == aux.length) {
                    /* if the index is the last element of the @aux, turn it to the second half start. */
                    index = list.length;
                }
            }
        } else {
            throw new Exception("There's no element with this index in the list.");
        }
        /* return the next free position. */
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
                /* put the element in @index position. */
                list[index] = element;
                /* makes the @index aux point to @head. */
                aux[index] = head;
                /* makes the @index of the second half of aux point to -1, turning it to not free. */
                aux[index + list.length] = -1;
                /* if the list is empty, makes the last aux point to 0 and makes the head points to the new element. */
                if (empty()) {
                    aux[last] = 0;
                    head = index;
                }
                /* makes @index the first element position. */
                head = index;
                /* increments the number of elements. */
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
        /* create an element with the parameters. */
        Element element = new Element(++id, value);
        /* get the next free position for inserting the new element. */
        int index = nextFree(0);
        /* get the @after index. */
        after = searchIndex(after);

        if (!full()) {
            if (aux[index + list.length] == -1) {
                throw new Exception("There's already an element in that position.");
            } else {
                /* put the element in @index position. */
                list[index] = element;
                /* makes the @after aux point to the new element position. */
                aux[after] = index;
                /* makes the new element aux point to the @after aux. */
                aux[index] = after;
                /* makes the @index of the second half of aux point to -1, turning it to not free. */
                aux[index + list.length] = -1;

                if (after == last) {
                    /* makes the new element the last. */
                    aux[index] = -1;
                    last = index;
                }

                /* increments the number of elements. */
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
        /* index receives 0. */
        int index = 0;
        /* make sure that it only searchs in the fist half on the @aux. */
        while (index < list.length) {
            /* check if the current index's element is the desired one. */
            if (list[index] != null && list[index].getValue() == value) {
                return index;
            }
            /* increments @index. */
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
        /* index receives 0. */
        int index = 0;
        /* make sure that it only searchs in the fist half on the @aux. */
        while (index < list.length) {
            /* check if the current index's element is the desired one. */
            if (list[index] != null && list[index].getId() == id) {
                return list[index];
            }
            /* increments @index. */
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
        /* index receives 0. */
        int index = 0;
        /* make sure that it only searchs in the fist half on the @aux. */
        while (index < list.length) {
            /* check if the current list's aux element's id is the desired one. */
            if (list[index] != null && aux[index] != -1 && list[aux[index]].getId() == id) {
                return index;
            }
            /* increments @index. */
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
        /* create an element with the parameters. */
        Element element = new Element(++id, value);
        /* get the next free position for inserting the new element. */
        int index = nextFree(0);
        /* saves the @before index. */
        int beforeIndex = searchIndex(before);
        /* get the @before id. */
        before = list[beforeIndex].getId();

        if (!full()) {
            if (aux[index + list.length] == -1) {
                throw new Exception("There's already an element in that position.");
            } else {
                /* put the element in @index position. */
                list[index] = element;
                /* makes the @before previous element point to the new element. */
                aux[getPreviousIndex(before)] = index;
                /* makes the new element aux point to @before. */
                aux[index] = beforeIndex;
                /* makes the @index of the second half of aux point to -1, turning it to not free. */
                aux[index + list.length] = -1;

                if (beforeIndex == head) {
                    /* makes the new element the first. */
                    head = index;
                }

                /* increments the number of elements. */
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
            /* check if @index is the last element of the index. */
            if (index == last && index != head) {
                /* makes the index previous element as @last. */
                last = getPreviousIndex(list[index].getId());
            }
            /* check if @index is the first element of the index. */
            if (index != head) {
                /* points the previous @aux to index's.. */
                aux[getPreviousIndex(list[index].getId())] = aux[index];
            }
            /* erase the list link. */
            aux[index] = 0;
            /* remove the element. */
            list[index] = null;
            /* free the space on the second half of @aux. */
            aux[index + list.length] = index;
            /* decreases the number of elements. */
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
        /* use the @value as parameter for the remove operation. */
        remove(searchIndex(value));
    }
    
    /**
     * @param value element's value.
     * @throws Exception if the list is empty.
     */
    void removeLast() throws Exception {
        /* use the last element of the list as parameter for the remove operation. */
        remove(last);
    }
    
    /**
     * @param value element's value.
     * @throws Exception if the list is empty.
     */
    void removeHead() throws Exception {
        /* use the first element of the list as parameter for the remove operation. */
        remove(head);
    }

}
