public class Campo {

    private Lixo[] lixos; 
    private int linhas, colunas;
    private int[] posicao_Atual;
    
    //lista_lixos NÃO vai ser inteiro e sim uma lista contendo objetos da classe Lixo
    //20x20
    //posição atual representa a pos. atual do bot {X, Y}

    public Campo(int linhas , int colunas, int[]posicao_Atual){
            //Setar as coisas
            this.lixos = new Lixo[10];
    }


    //Mostrar no console uma matriz representando o campo
    // C = [0,0] (CASA)
    // B = [x,y] (BOT)
    // LA = [X,Y] (Lixo que vale 10 pontos)
    // LV = [X,Y] (Lixo que vale 20 pontos)
    // N = [x,y] (lugar que n tem nada)
    public String mostraCampo(){
        String matriz[][]  = new String[20][20];
        if (this.posicao_Atual[0] == 0 && this.posicao_Atual[1] == 0){
            matriz[0][0] = "B";    
        }else{
            matriz[0][0] = "C";
        }
        
        for (Lixo l : this.lixos) {
            if (l.getquantPontos() == 10){
                matriz[l.getX()][l.getY()] = "LA";
            }
            
        }

        //outro para o lixo vermelho

    }

    //quantDeLixos = 10
    public Lixo[] criar_Campo(){
       

        //termino = vetor de lixos deve estar preenchido
        while (this.lixos.length < 10){
            
            //Preencher com X = 5 lixos do tipo_1 {vale 10 pontos}
            for (int i=0; i<5;i++){
                // Pegar coordenada aleatória com base no num de linhas e colunas

                // criar objeto Lixo e por no vetor 'lixos no campo'
            }
             //Preencher com X = 5 lixos do tipo_2 {vale 20 pontos}
             for (int i=0; i<5;i++){
                // Pegar coordenada aleatória com base no num de linhas e colunas
                // criar objeto Lixo e por no vetor 'lixos no campo'
            }
        }

        return this.lixos;
    }
}