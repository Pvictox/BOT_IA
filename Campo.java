import java.util.ArrayList;



public class Campo {

    private ArrayList<Lixo> lixos; 
    private int linhas, colunas;
    private int[] posicaoAtual;
    private int pontos;
    private boolean saiuDeCasa;
    private int cont;


    public Campo(int linhas , int colunas, int[] posicaoAtual){
            this.linhas = linhas;
            this.colunas = colunas;
            this.lixos = new ArrayList<Lixo>();
            this.posicaoAtual = new int[2];   
            this.posicaoAtual[0] = 0; //X
            this.posicaoAtual[1] = 0; //Y 
            this.pontos=0;   
            this.cont = 0;
    }



    public void setCont(int cont) {
        this.cont = cont;
    }

    public int getCont() {
        return cont;
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
            if (getPosicaoAtual()[0] != 20 && getPosicaoAtual()[1] != 20){
                matriz[getPosicaoAtual()[0]][getPosicaoAtual()[1]] = "B";
            }
        }
        
        for (Lixo l : getLixos()) {
            if (l.getQuantPontos() == 10){
                matriz[l.getX()][l.getY()] = l.getLetra();
            }else if (l.getQuantPontos() == 20){
                matriz[l.getX()][l.getY()] = l.getLetra();
            }          
        }

       mostraCampo(matriz);

    }
    public int checkLixo(){
       var y=this.getPosicaoAtual()[0];
       var x=this.getPosicaoAtual()[1];
        for( Lixo l : this.getLixos()){
            if(l.getX() == y && l.getY() == x ){
               this.lixos.remove(l);
               return l.getQuantPontos();

            }
        }
       return 0; 
    }

     
    public void movRight(){
        this.posicaoAtual[1]++;
    }
    public void movLeft(){
        this.posicaoAtual[1]--;
    }
    public void movTop(){
        this.posicaoAtual[0]--;
    }
    public void movDown(){
        this.posicaoAtual[0]++;
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
                int[] coordAleatoria = Coordenadas.randomCoordenada(getLinhas()-1, getColunas()-1);
                if (coordAleatoria[0] != 0 && coordAleatoria[1] != 0){
                    lixoTipo1 = new Lixo(coordAleatoria[0], coordAleatoria[1], 10, "A");
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
                int[] coordAleatoria = Coordenadas.randomCoordenada(getLinhas()-1, getColunas()-1);
                if (coordAleatoria[0] != 0 && coordAleatoria[1] != 0){
                    lixoTipo2 = new Lixo(coordAleatoria[0], coordAleatoria[1], 20, "V");
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

    public ArrayList<Lixo> getLixos() {
        return lixos;
    }

    public void setLixos(ArrayList<Lixo> lixos) {
        this.lixos = lixos;
    }

    public boolean getSaiudeCasa(){
        return this.saiuDeCasa;

    }
    
    public void setSaiudeCasa( boolean val){
        this.saiuDeCasa = val;

    }

    public int getLinhas() {
        return linhas;
    }

    public void setLinhas(int linhas) {
        this.linhas = linhas;
    }

    public int getColunas() {
        return colunas;
    }

    public void setColunas(int colunas) {
        this.colunas = colunas;
    }

    public int[] getPosicaoAtual() {
        return posicaoAtual;
    }

    public void setPosicaoAtual(int[] posicaoAtual) {
        this.posicaoAtual = posicaoAtual;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
    
    
}