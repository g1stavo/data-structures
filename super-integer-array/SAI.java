class SAI {    
    int[] array;
    int lower;
    int higher;
    
    SAI (int lower, int higher) {
        array = new int[(higher - lower) + 1];
        this.lower = lower;
        this.higher = higher;
    }
    
    void set(int index, int value) {
        array[index - lower] = value;
    }
    
    int get(int index) {
        return array[index - lower];
    }
}
