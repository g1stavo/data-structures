class Stack {
    private int[] stack;
    private int top;
    private int originalSize;
    
    Stack(int size) {
        stack = new int[size];
        top = size;
        originalSize = size;
    }
    
    boolean emptyStack() {
        return (top == originalSize);
    }
    
    boolean fullStack() {
        return (top == 0);
    }
    
    void push(int value) {
        if (!fullStack()) {
            stack[--top] = value;    
        }        
    }
    
    int pop() {
        if (!emptyStack()) {
            return stack[top++];           
        }
        return 0;
    }
}