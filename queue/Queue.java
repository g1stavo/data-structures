class Queue {
    int end;
    int next;
    int size;
    int[] queue;
    int n;
    
    Queue(int size) {
        this.size = size;
        queue = new int[size];
    }
    
    boolean isEmpty () {
        return (n == 0);
    }
    
    boolean isFull() {
        return (n == size);
    }
    
    void in (int value) {
        if(next == size) {
            next = 0;
        }
        if (!isFull()) {
            queue[next++] = value;
            n++;
        }
    }
    
    int out () {
        if (!isEmpty()) {
            n--;
            return queue[end++];
        }
        return 0;
    }
}