package exercicio62;

public class EstadoEspera implements EstadoAudioPlayer{
    @Override
    public EstadoAudioPlayer play() {
        System.out.println("começou a  tocar musica");
        return new EstadoTocando();
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
