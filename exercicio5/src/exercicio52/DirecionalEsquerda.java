package exercicio52;

public class DirecionalEsquerda implements Command {

    private JogoReciver jogo;

    public DirecionalEsquerda(JogoReciver jogo) {
        this.jogo = jogo;
    }

    @Override
    public void execute() {
        this.jogo.direcionalEsquerda();
    }
}
