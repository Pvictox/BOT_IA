public class Lixo {
    private int x,y, quantPontos;
    private String letra;

    public Lixo(int x,int y,int quantPontos, String letra){
        this.quantPontos = quantPontos;
        this.x = x;
        this.y = y;
        this.letra = letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public String getLetra() {
        return letra;
    }

    public int getQuantPontos() {
        return quantPontos;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
