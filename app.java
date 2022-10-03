import java.util.ArrayList;
import java.util.Scanner;

public class app {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int[] posInicial = { 0, 0 };
        Campo campo = null;
        Bots b = null;
        System.out.println("******* CAMPO A SER USADO *******");
        campo = new Campo(20, 20, posInicial);
        campo.criar_Campo();
        campo.atualizaCampo();
        System.out.println("******* CAMPO A SER USADO *******");
        b = new Bots();
        int count = 1;
        //System.out.println("size: " + campo.getLixos().size());
        int[] memoria = { 0, 0 };
        int miliseconds = 0001;
        int opcao = 0;

        do {
            System.out.println("------------------------------------------");
            System.out.println("Escolhe uma opcao !");
            System.out.println("1-Agente reativo simples");
            System.out.println("2-Agente reativo com modelos");
            System.out.println("3-Agente com objetivos");
            System.out.println("4-Agente com utilidades");
            System.out.println("0-Sair");
            opcao = teclado.nextInt();
            switch (opcao) {
                case 1:

                    while (campo.getPontos() < 151) {

                        try {
                            Thread.sleep(miliseconds);
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                        System.out.println("\n\n\n\n\n\n\n");
                        campo.atualizaCampo();
                        System.out.println(campo.getLixos().size());
                        System.out.println(
                                "Memoria do lixo mais recente: \n" + "X: " + memoria[0] + "| Y :" + memoria[1]);
                        System.out.println("Saiu de casa: " + campo.getSaiudeCasa());
                        b.agenteSimples(campo);
                    }
                    System.out.println("PONTUAÇÃO FINAL DO BOT: " + campo.getPontos());
                    campo = null;
                    System.out.println("******* CAMPO A SER USADO *******");
                    campo = new Campo(20, 20, posInicial);
                    campo.criar_Campo();
                    campo.atualizaCampo();
                    System.out.println("******* CAMPO A SER USADO *******");
                break;

                case 2:

                    while (campo.getPontos() < 151) {

                        try {
                            Thread.sleep(miliseconds);
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                        System.out.println("\n\n\n\n\n\n\n");
                        campo.atualizaCampo();
                        System.out.println(campo.getLixos().size());
                        System.out.println(
                                "Memoria do lixo mais recente: \n" + "X: " + memoria[0] + "| Y :" + memoria[1]);
                        System.out.println("Saiu de casa: " + campo.getSaiudeCasa());
                        memoria = b.agenteSimplesModelo(campo, memoria);
                    }
                    System.out.println("PONTUAÇÃO FINAL DO BOT: " + campo.getPontos());
                    campo = null;
                    System.out.println("******* CAMPO A SER USADO *******");
                    campo = new Campo(20, 20, posInicial);
                    campo.criar_Campo();
                    campo.atualizaCampo();
                    System.out.println("******* CAMPO A SER USADO *******");
                    if (memoria[0] != 0) {
                        miliseconds = 0500;
                    }
                    
                break;

                case 3:
                    while (campo.getPontos() < 150) {

                        try {
                            Thread.sleep(miliseconds);
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                        System.out.println("\n\n\n\n\n\n\n");
                        campo.atualizaCampo();
                        System.out.println("Pontors: " + campo.getPontos());
                        System.out.println("Memoria do lixo mais recente: \n" + "X: " + memoria[0] + "| Y :" + memoria[1]);
                        System.out.println("Saiu de casa: " + campo.getSaiudeCasa());
                        memoria = b.agenteDeObjetivo(campo, memoria);
                        
                    }
                    System.out.println("PONTUAÇÃO FINAL DO BOT: " + campo.getPontos());
                    campo = null;
                    System.out.println("******* CAMPO A SER USADO *******");
                    campo = new Campo(20, 20, posInicial);
                    campo.criar_Campo();
                    campo.atualizaCampo();
                    System.out.println("******* CAMPO A SER USADO *******");
                        if (memoria[0] != 0) {
                            miliseconds = 0500;
                        }
                    
                break; 
                case 4:
                    while (campo.getPontos() < 151) {

                        try {
                            Thread.sleep(miliseconds);
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                        System.out.println("\n\n\n\n\n\n\n");
                        campo.atualizaCampo();
                        System.out.println(campo.getLixos().size());
                        System.out.println("Memoria do lixo mais recente: \n" + "X: " + memoria[0] + "| Y :" + memoria[1]);
                        System.out.println("Saiu de casa: " + campo.getSaiudeCasa());
                        memoria = b.agenteDeUtilidade(campo, memoria);
                    }
                    System.out.println("PONTUAÇÃO FINAL DO BOT: " + campo.getPontos());
                    campo = null;
                    System.out.println("******* CAMPO A SER USADO *******");
                    campo = new Campo(20, 20, posInicial);
                    campo.criar_Campo();
                    campo.atualizaCampo();
                    System.out.println("******* CAMPO A SER USADO *******");
                        if (memoria[0] != 0) {
                            miliseconds = 0500;
                        }
                 
                break;
                case 0 :
					System.out.println("Volte sempre!");
				break;
				default :
					System.out.println("Opcao invalida");


            }

        } while (opcao != 0);
        teclado.close();

    }
}
