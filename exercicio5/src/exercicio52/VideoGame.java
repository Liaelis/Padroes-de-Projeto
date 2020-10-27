package exercicio52;

public class VideoGame {

    private JogoReciver jogo;
    private Invoker invoker = new Invoker();
    public void insereJogo(JogoReciver jogo){

    }

    public void botaoA(){
        invoker.addCommand(new BotaoA(jogo));
    }
    public void botaoB(){
        invoker.addCommand(new BotãoB(jogo));
    }

    public  void direcionaCima(){
        invoker.addCommand(new DirecionalCima(jogo));
    }
    public  void direcionaBaixo(){
        invoker.addCommand(new DirecionalBaixo(jogo));
    }
    public void direcionaEsquerda(){
        invoker.addCommand(new DirecionalEsquerda(jogo));
    }
    public void direcionaDireita(){
        invoker.addCommand(new DirecionalDireita(jogo));
    }
    public void enviaComandosEmLote(){
        this.invoker.execut();
    }

}
