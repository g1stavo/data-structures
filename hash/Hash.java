package hash;

class Hash {

    List[] index;

    Hash(int size, int loadFactor) {
        index = new List[size / loadFactor];
    }

    void put(int value) {
        int group = value % index.length;
        if (index[group] == null) {
            index[group] = new List();
            index[group].putAtLast(value);
        } else {
            index[group].putAtLast(value);
        }
    }

    Element remove(int value) throws Exception {
        int group = value % index.length;
        return index[group].remove(value);
    }

}
