public class app {
    public static void main(String[] args) {
        int[] posInicial = {0,0};
        Campo campo = new Campo(20, 20, posInicial);
        campo.criar_Campo();
        int count = 1;
        System.out.println("size: "+campo.getLixos().size());
        /*for (Lixo l : campo.getLixos()) {
            System.out.println("Lixo: "+count+" | X: "+l.getX()+" | Y: "+l.getY()+ " | Peso: "+l.getquantPontos());
            count+=1;
        }*/
        campo.atualizaCampo();
    }
}
