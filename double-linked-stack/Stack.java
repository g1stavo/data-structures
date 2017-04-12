class Stack { 
    Element top;
    int n;
 
    Stack() {
    }
 
    void push(int value) {
        Element element = new Element(value, top);
        this.top = element;
        n++;
    }
 
    int pop() throws Exception {
        if (n != 0) {
            int ret = top.getValue();
            top = top.getPrevious();
            n--;
            return ret;
        }
        return 0;
    }
}
