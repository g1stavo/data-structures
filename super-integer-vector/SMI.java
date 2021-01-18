class SMI {    
    int[] matrix;
    int columns;
    int lines;
    
    SMI(int columns, int lines) {
        this.columns = columns;
        this.lines = lines;
        matrix = new int[columns * lines];
    }
    
    void set(int column, int line, int valor) {
        if ((line < 0) || (column < 0) || (line > lines) || (column > columns)) {
            System.out.println("Exception");
        }
        int position = (columns * (line - 1) + line) - 1;
        matrix[position] = valor;
    }    
    
    int get(int column, int line) {
        if ((line < 0) || (column < 0) || (line > lines) || (column > columns)) {
            System.out.println("Exception");
        }
        int position = (columns * (line - 1) + line) - 1;
        return matrix[position];
    }
}