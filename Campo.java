import java.util.ArrayList;



public class Campo {

    private ArrayList<Lixo> lixos; 
    private int linhas, colunas;
    private int[] posicaoAtual;
    

    public Campo(int linhas , int colunas, int[] posicaoAtual){
            this.linhas = linhas;
            this.colunas = colunas;
            this.lixos = new ArrayList<Lixo>();
            this.posicaoAtual = new int[2];   
            this.posicaoAtual[0] = 0; //X
            this.posicaoAtual[1] = 0; //Y    
    }

    public int getColunas() {
        return colunas;
    }

    public int getLinhas() {
        return linhas;
    }
    
    public ArrayList<Lixo> getLixos() {
        return lixos;
    }

    public int[] getPosicaoAtual() {
        return posicaoAtual;
    }


    //Mostrar no console uma matriz representando o campo
    // C = [0,0] (CASA)
    // B = [x,y] (BOT)
    // A = [X,Y] (Lixo que vale 10 pontos)
    // V = [X,Y] (Lixo que vale 20 pontos)
    // N = [x,y] (lugar que n tem nada)

    public void atualizaCampo(){
        String matriz[][]  = new String[20][20];
        if (getPosicaoAtual()[0] == 0 && getPosicaoAtual()[1] == 0){
            matriz[0][0] = "B";    
        }else{
            matriz[0][0] = "C";
            matriz[getPosicaoAtual()[0]][getPosicaoAtual()[1]] = "B";
        }
        
        for (Lixo l : getLixos()) {
            if (l.getquantPontos() == 10){
                matriz[l.getX()][l.getY()] = "A";
            }else if (l.getquantPontos() == 20){
                matriz[l.getX()][l.getY()] = "V";
            }
            
        }

        mostraCampo(matriz);

    }

    private static void mostraCampo(String[][]matriz){
        for (int i=0; i<20; i++){
            for (int j =0; j<20; j++){
                if (matriz[i][j] != null){
                    System.out.print(matriz[i][j]+"|");
                }else{
                    System.out.print("*|");
                }
                
            }
            System.out.println();
        }
    }

    //quantDeLixos = 10
    public void criar_Campo(){
       
        boolean flagPosRepetida = false;
        
        while (getLixos().size() < 10){
            
            for (int i=0; i<5;i++){
                Lixo lixoTipo1 = null;
                int[] coordAleatoria = Coordenadas.randomCoordenada(getLinhas(), getColunas()-1);
                if (coordAleatoria[0] != 0 && coordAleatoria[1] != 0){
                    lixoTipo1 = new Lixo(coordAleatoria[0], coordAleatoria[1], 10);
                }
                for (Lixo l : getLixos()) {
                    if (l.getX() == coordAleatoria[0] && l.getY() == coordAleatoria[1]){
                        flagPosRepetida = true;
                        break;
                    }
                }
                if (flagPosRepetida == false && lixoTipo1 != null){
                    getLixos().add(lixoTipo1);
                }else{
                    i-=1;
                }
                
            }
             //Preencher com X = 5 lixos do tipo_2 {vale 20 pontos}
             for (int i=0; i<5;i++){
                Lixo lixoTipo2 = null;
                int[] coordAleatoria = Coordenadas.randomCoordenada(getLinhas(), getColunas()-1);
                if (coordAleatoria[0] != 0 && coordAleatoria[1] != 0){
                    lixoTipo2 = new Lixo(coordAleatoria[0], coordAleatoria[1], 20);
                }
                for (Lixo l : getLixos()) {
                    if (l.getX() == coordAleatoria[0] && l.getY() == coordAleatoria[1]){
                        flagPosRepetida = true;
                        break;
                    }
                }
                if (flagPosRepetida == false && lixoTipo2!=null){
                    getLixos().add(lixoTipo2);
                }else{
                    i-=1;
                }
            }
        }

        
    }
}