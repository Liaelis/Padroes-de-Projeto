package exercicio52;

public class DirecionalBaixo implements Command{

    private JogoReciver jogo;

    public DirecionalBaixo(JogoReciver jogo) {
        this.jogo = jogo;
    }

    @Override
    public void execute() {
        this.jogo.direcionalBaixo();
    }
}
