import java.rmi.ConnectIOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Bots {
    private int [] movimento;
    private int y;
    private int x;
    private int pontos;
    
    public void agenteSimples(Campo campo){
        x=campo.getPosicaoAtual()[0];
        y=campo.getPosicaoAtual()[1];
        if(pontos>0){
            if(y>0){
                campo.movLeft(); return;
            }else if(x>0){
                campo.movTop(); return;
            }
        }
        
        int aux=campo.checkLixo();
        if(aux !=0) pontos=aux;
        if(x==0 && y==0){
            campo.setPontos(pontos+campo.getPontos());
            this.pontos=0;
        }
       
        if( y==19 && x%2==0){campo.movDown(); return;}
        if (y==0 && x%2==1) {campo.movDown(); return;}
        if(x%2==0 ) {campo.movRight(); return;}
        if(x%2==1){ campo.movLeft(); return ; }
       
    }


    public int[] agenteSimplesModelo(Campo campo, int[] memoriaMaisRecente){
        x=campo.getPosicaoAtual()[0];
        y=campo.getPosicaoAtual()[1];
        int esquerdaParede = 0;
        int direitaParede = campo.getColunas() - 1;

        if(pontos>0){
            if(y>0){
                campo.movLeft(); return memoriaMaisRecente;
            }else if(x>0){
                campo.movTop(); return memoriaMaisRecente;
            }
        }

        if (x == 0 && y==1 && this.pontos == 0){
            campo.setSaiudeCasa(true);
        }

        int aux=campo.checkLixo();
        if(aux !=0){
            
            pontos=aux;
            memoriaMaisRecente[0] = x;
            memoriaMaisRecente[1] = y;  
            
        } 
        if(x==0 && y==0){
            campo.setPontos(pontos+campo.getPontos());
            this.pontos=0;
        }
        
        if (campo.getSaiudeCasa()){
            if (y < memoriaMaisRecente[1]){
                campo.movRight(); return memoriaMaisRecente;
            }else if (x < memoriaMaisRecente[0]){
                campo.movDown(); return memoriaMaisRecente;
            }else if (x == memoriaMaisRecente[0] && y == memoriaMaisRecente[1]){
                campo.setSaiudeCasa(false);
            }
        }
        
        
        
        
        if( y==19 && x%2==0){campo.movDown(); return memoriaMaisRecente;}
        if (y==0 && x%2==1) {campo.movDown(); return memoriaMaisRecente;}
        if(x%2==0 ) {campo.movRight(); return memoriaMaisRecente;}
        if(x%2==1){ campo.movLeft(); return memoriaMaisRecente; }

        return memoriaMaisRecente;
       
    }



    public int[] agenteDeObjetivo(Campo campo, int[] memoriaMaisRecente){
        x=campo.getPosicaoAtual()[0];
        y=campo.getPosicaoAtual()[1];
        int esquerdaParede = 0;
        int direitaParede = campo.getColunas() - 1;

        if(pontos>0){
            if(y>0){
                campo.movLeft(); return memoriaMaisRecente;
            }else if(x>0){
                campo.movTop(); return memoriaMaisRecente;
            }
        }

        if (x == 0 && y==1 && this.pontos == 0){
            campo.setSaiudeCasa(true);
        }

        int aux=campo.checkLixo();
        if(aux !=0){
            
            pontos=aux;
            memoriaMaisRecente[0] = x;
            memoriaMaisRecente[1] = y;  
            
        } 

        if(x==0 && y==0){
            campo.setPontos(pontos+campo.getPontos());
            this.pontos=0;
        }
        
        if (campo.getSaiudeCasa()){
            if (y < memoriaMaisRecente[1]){
                campo.movRight(); return memoriaMaisRecente;
            }else if (x < memoriaMaisRecente[0]){
                campo.movDown(); return memoriaMaisRecente;
            }else if (x == memoriaMaisRecente[0] && y == memoriaMaisRecente[1]){
                campo.setSaiudeCasa(false);
            }
        }

       
        int[] nextPosition = new int[2];
        if (campo.getLixos().size() != 0){
            nextPosition[0] = campo.getLixos().get(campo.getLixos().size()-1).getX();
            nextPosition[1] = campo.getLixos().get(campo.getLixos().size()-1).getY();
        }
        
        memoriaMaisRecente = nextPosition;
        
        if( y==19 && x%2==0){campo.movDown(); return memoriaMaisRecente;}
        if (y==0 && x%2==1) {campo.movDown(); return memoriaMaisRecente;}
        if(x%2==0 ) {campo.movRight(); return memoriaMaisRecente;}
        if(x%2==1){ campo.movLeft(); return memoriaMaisRecente; }

        return memoriaMaisRecente;
       
    }



   

    public int[] agenteDeUtilidade(Campo campo, int[] memoriaMaisRecente){
        
        x=campo.getPosicaoAtual()[0];
        y=campo.getPosicaoAtual()[1];
        
         ArrayList<int[]> posLixos = new ArrayList<>();
         int[] pos = new int[2];
         for (Lixo l : campo.getLixos()) { 
             pos[0] = l.getX();
            pos[1] = l.getY();
            posLixos.add(pos);
        }

        

        if(pontos>0){
            if(y>0){
                campo.movLeft(); return memoriaMaisRecente;
            }else if(x>0){
                campo.movTop(); return memoriaMaisRecente;
            }
        }

        int aux=campo.checkLixo();
        if(aux !=0) pontos=aux;
        if(x==0 && y==0){
            campo.setPontos(pontos+campo.getPontos());
            this.pontos=0;
        }
      
        int[] botDist = new int[2];
        botDist[0] = x;
        botDist[1] = y;

        int[] menorDistancia; 
        if (Coordenadas.menorDistancia(botDist, posLixos, campo.getLixos()) != null){
             menorDistancia = Coordenadas.menorDistancia(botDist, posLixos, campo.getLixos());
        }else{
             menorDistancia = memoriaMaisRecente;
        }

        


            if (x < menorDistancia[0]){campo.movDown(); return menorDistancia;}
            if (x > menorDistancia[0]){campo.movTop(); return menorDistancia;}
            if (y < menorDistancia[1]){campo.movRight(); return menorDistancia;}
            if (y > menorDistancia[1]){campo.movLeft(); return menorDistancia;}

            return menorDistancia;
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
  
