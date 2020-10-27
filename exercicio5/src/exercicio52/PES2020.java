package exercicio52;

public class PES2020 implements JogoReciver {
    @Override
    public void botãoA() {
        System.out.println("chute");
    }

    @Override
    public void botãoB() {
        System.out.println("passe");
    }

    @Override
    public void direcionalCima() {
        System.out.println("corre para cima");
    }

    @Override
    public void direcionalBaixo() {

        System.out.println("corre para baixo");
    }

    @Override
    public void direcionalEsquerda() {

        System.out.println("corre para esquerda");
    }

    @Override
    public void direcionalDireita() {
        System.out.println(" corre para direita");

    }
}
