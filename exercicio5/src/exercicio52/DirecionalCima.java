package exercicio52;

public class DirecionalCima implements Command {

    private JogoReciver jogo;

    public DirecionalCima(JogoReciver jogo) {
        this.jogo = jogo;
    }

    @Override
    public void execute() {
        this.jogo.direcionalCima();
    }
}
