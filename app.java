public class App {
    public static void main(String[] args) {
        int[] posInicial = {0,0};
        Campo campo = new Campo(20, 20, posInicial);
        Bots b = new Bots();
        campo.criar_Campo();
        int count = 1;
        System.out.println("size: "+campo.getLixos().size());
        campo.atualizaCampo();
        
        while(campo.getPontos()<150){
            b.agenteSimples(campo);
            System.out.println("\n\n\n\n\n\n\n");
            campo.atualizaCampo();
            System.out.println(campo.getPontos());
            System.out.println(campo.getLixos().size());
        }
      
        
    }
}
