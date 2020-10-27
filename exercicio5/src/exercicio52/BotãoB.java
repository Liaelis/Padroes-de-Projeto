package exercicio52;

public class BotãoB implements Command {
    private JogoReciver jogo;

    public BotãoB(JogoReciver jogo) {
        this.jogo = jogo;
    }

    @Override
    public void execute() {
        this.jogo.botãoB();
    }
}
