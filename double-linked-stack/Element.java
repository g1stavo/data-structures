class Element { 
    int value;
    Element previous; 
    
    Element(int value, Element previous) {
        this.value = value;
        this.previous = previous;
    } 
    
    int getValue() {
        return value;
    } 
    
    Element getPrevious() {
        return previous;
    } 
}
 
 
