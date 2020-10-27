package exercicio62;

public class EstadoTocando implements EstadoAudioPlayer{


    @Override
    public EstadoAudioPlayer play() {
        System.out.println("esta pausado");
        return new EstadoEspera();
    }

    @Override
    public EstadoAudioPlayer next() {

        System.out.println("proxima musica");
        return this;
    }

    @Override
    public EstadoAudioPlayer previous() {

        System.out.println("musica anterior");
        return this;
    }

    @Override
    public EstadoAudioPlayer lock() {
        System.out.println("bloqueou");
        return new EstadoBloqueado();
    }
}
