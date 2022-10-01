import java.util.ArrayList;

public class Bots {
    private int [] movimento;
    private int y;
    private int x;
    private int pontos;
    public void agenteSimples(Campo campo){
        y=campo.getPosicaoAtual()[0];
        x=campo.getPosicaoAtual()[1];
        if(pontos>0){
            if(x>0){
                campo.movLeft(); return;
            }else if(y>0){
                campo.movTop(); return;
            }
        }
        
        var aux=campo.checkLixo();
        if(aux !=0) pontos=aux;
        if(x==0 && y==0){
            campo.setPontos(pontos+campo.getPontos());
            this.pontos=0;
        }
       
        if( x==19 && y%2==0){campo.movDown(); return;}
        if (x==0 && y%2==1) {campo.movDown(); return;}
        if(y%2==0 ) {campo.movRight(); return;}
        if(y%2==1){ campo.movLeft(); return ; }
       
    }
    public int[] getMovimento() {
        return movimento;
    }
    public void setMovimento(int[] movimento) {
        this.movimento = movimento;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getPontos() {
        return pontos;
    }
    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
}
  
