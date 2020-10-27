package exercicio52;

public class StreetFighterII implements JogoReciver {
    @Override
    public void botãoA() {
        System.out.println("soco");
    }

    @Override
    public void botãoB() {
        System.out.println("chute");
    }

    @Override
    public void direcionalCima() {
        System.out.println("pulo");
    }

    @Override
    public void direcionalBaixo() {
        System.out.println("abaixa");
    }

    @Override
    public void direcionalEsquerda() {
        System.out.println("anda para esquerda");
    }

    @Override
    public void direcionalDireita() {
        System.out.println("anda para direita");
    }
}
