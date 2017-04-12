class DoubleStack {
    private int[] stack;
    private int indexA = -1;
    private int indexB;
    private int originalSize;
    
    DoubleStack(int size) {
        if (size > 1) {
            originalSize = size;
            stack = new int[size];
            indexB = size;
        }
    }
    
    void pushA (int value) {
        if (stack[indexA + 1] != indexB) {
            stack[++indexA] = value;            
        }
    }
    
    void pushB (int value) {
        if (stack[indexB - 1] != indexA) {
            stack[--indexB] = value;            
        }
    }
    
    int popA() {
        if (indexA >= 0) {
            return stack[indexA--];
        }
        return 0;
    }
    
    int popB() {
        if (indexB <= originalSize) {
            return stack[indexB++];
        }
        return 0;
    }
}