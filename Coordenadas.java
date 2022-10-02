import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class Coordenadas {
    

    /*A ideia é simples: Passando como parâmetro duas cordeanadas nós somamos elas
        -> Se coordenada1, por ex, representa a posição [0,0] do BOT e coord2 representar [0,1] (movimento para a direita em uma casa)
        -> a nova coordenada retornada é [0,1] (o bot moveu um passo para a direita)
    */
    public static int[] somaCoordenadas(int[] coodenada1, int[] coordenada2){
        int novaCoordenada[] = new int[2];
        novaCoordenada[0] = coodenada1[0]+coordenada2[0];
        novaCoordenada[1] = coodenada1[1]+coordenada2[1];
        return novaCoordenada;
    }

    private static int numeroAleatorio(int intervaloMax,int intervaloMin){
        return (int)Math.floor(Math.random()*(intervaloMax-intervaloMin)) + intervaloMin;
    }

   


    public static int[] menorDistancia(int[] posBot, ArrayList<int[]> posLixo, ArrayList<Lixo> lixos) {
        int menorDist;
        int novaDist;
        int[] valorRetor = new int[2];
        int auxMenor = 0;
        int[] posAtualLixo = new int[2];
    
        for (Lixo l : lixos) {
            posAtualLixo[0] = l.getX();
             posAtualLixo[1] = l.getY();
             menorDist = (int)getDistanciaPontos(posBot, posAtualLixo );
            novaDist = (int)getDistanciaPontos(posBot, posLixo.get(lixos.indexOf(l)));
           if (menorDist > novaDist){
                valorRetor = posAtualLixo;
             }else{
                 valorRetor = posLixo.get(lixos.indexOf(l));
                
             }
          }
         return valorRetor;
  }

    public static double getDistanciaPontos(int[]p1, int[]p2){
        return Math.sqrt( Math.pow((p1[0] - p2[0]),2) + Math.pow((p1[1]-p2[1]), 2) );
    }

    public static int[] randomCoordenada(int valMax1, int valMax2){
        int []newCoord = new int[2];
        newCoord[0] = numeroAleatorio(valMax1, 0);
        newCoord[1] = numeroAleatorio(valMax2, 0);
        return newCoord;

    }

    

}
