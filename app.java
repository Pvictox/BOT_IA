import java.util.ArrayList;

public class app {

    public static void main(String[] args) {
        int[] posInicial = {0,0};
        Campo campo = new Campo(20, 20, posInicial);
        Bots b = new Bots();
        campo.criar_Campo();
        int count = 1;
        System.out.println("size: "+campo.getLixos().size());
        campo.atualizaCampo();
        int[] memoria = {0,0};
        int miliseconds = 0500;
        while(campo.getPontos()<150){            

            try{
                Thread.sleep(miliseconds);
            }catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }
            
            //b.agenteSimples(campo);
            //memoria = b.agenteSimplesModelo(campo, memoria);
            memoria = b.agenteDeObjetivo(campo, memoria);
            System.out.println("\n\n\n\n\n\n\n");
            campo.atualizaCampo();
            System.out.println("Pontors: "+campo.getPontos());
            System.out.println(campo.getLixos().size());
            System.out.println("Memoria do lixo mais recente: \n"+ "X: " +memoria[0] + "| Y :"+memoria[1]);
            System.out.println("Saiu de casa: "+campo.getSaiudeCasa());
            if (memoria[0] != 0){
                miliseconds = 0500;
            }
        }
      
        
    }
}
