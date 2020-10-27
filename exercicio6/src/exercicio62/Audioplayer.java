package exercicio62;

public class Audioplayer {

    private EstadoAudioPlayer estado;

    public Audioplayer() {
        this.estado = new EstadoEspera();
    }

    public void play(){

        this.estado=estado.play();
    }
    public void next(){
        this.estado=estado.next();
    }
    public void previuos(){
        this.estado=estado.previous();
    }
    public void lock(){

        this.estado=estado.lock();
    }
}
