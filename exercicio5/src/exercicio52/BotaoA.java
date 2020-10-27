package exercicio52;

public class BotaoA implements Command {
    private JogoReciver jogo;

    public BotaoA(JogoReciver jogo) {
        this.jogo = jogo;
    }

    @Override
    public void execute() {
        this.jogo.botãoA();
    }
}
