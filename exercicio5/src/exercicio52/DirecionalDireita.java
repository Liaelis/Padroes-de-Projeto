package exercicio52;

public class DirecionalDireita implements Command {

    private JogoReciver jogo;

    public DirecionalDireita(JogoReciver jogo) {
        this.jogo = jogo;
    }

    @Override
    public void execute() {
        this.jogo.direcionalDireita();
    }
}
