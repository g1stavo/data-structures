class SMI {    
    int[] matriz;
    int colunas;
    int linhas;
    
    SMI(int colunas, int linhas) {
        this.colunas = colunas;
        this.linhas = linhas;
        matriz = new int[colunas * linhas];
    }
    
    void atribui(int coluna, int linha, int valor) {
        if ((linha < 0) || (coluna <0) || (linha > linhas) || (coluna > colunas)) {
            System.out.println("Exceção");
        }
        int posicao = (colunas * (linha - 1) + linha) - 1;
        matriz[posicao] = valor;
    }    
    
    int acessa(int coluna, int linha) {
        if ((linha < 0) || (coluna <0) || (linha > linhas) || (coluna > colunas)) {
            System.out.println("Exceção");
        }
        int posicao = (colunas * (linha - 1) + linha) - 1;
        return matriz[posicao];
    }
}