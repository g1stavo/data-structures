class Deque {
    int start;
    int end;
    int size;
    int[] deque;
    int n;
    
    Deque(int size) {
        this.size = size;
        end = size - 1;
        deque = new int[size];
    }
    
    boolean isEmpty () {
        return (n == 0);
    }
    
    boolean isFull() {
        return (n == size);
    }
    
    void inStart(int value) {
        if (!isFull()) {
            if (start == size) {
                deque[start - 1] = value;
                start = 0;
                n++;
            } else {
                deque[start++] = value;
                n++;
            }
        }  
    }
    
    void inEnd(int value) {
        if (!isFull()) {
            if (end == 0) {
                deque[end] = value;
                end = size - 1;
                n++;
            } else {
                deque[end--] = value;
                n++;
            }
        }
    }
    
    int outStart() {
        if (!isEmpty()) {
            if (start == 0) {
                start = size - 1;
                int ret = deque[start];
                deque[start] = 0;                   
                n--;                
                return ret;
            } else {
                int ret = deque[--start];
                deque[start] = 0;
                n--;
                return ret;
            }
        }
        return 0;
    }
    
    int outEnd() {
        if (!isEmpty()) {
            if (end == size - 1) { 
                end = 0;
                int ret = deque[end];
                deque[end] = 0;                
                n--;
                return ret;
            } else {
                int ret = deque[++end];                
                deque[end] = 0;
                n--;
                return ret;
            }
        }
        return 0;
    }
}