/**
 * @author gustavo de castro salvador and silvia laurentino.
 * federal university of santa catarina. may, 2017.
 */

/* element used in the linked array. */
class Element  {
    
    /* @id element's identifier. @value element's value. */ 
    int id, value; 

    Element(int id, int value) {
        this.id = id;
        this.value = value;
    }   
    
    /* @return the element's id. */
    int getId() {
        return id; 
    }

    /* @return the element's value. */
    public int getValue() {
        return value; 
    }  
        
}
