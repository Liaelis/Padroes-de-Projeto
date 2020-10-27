package exercicio62;

import javax.print.attribute.SetOfIntegerSyntax;
import javax.sound.midi.Soundbank;

public class EstadoBloqueado implements EstadoAudioPlayer{
    @Override
    public EstadoAudioPlayer play() {
        System.out.println("Não faz nada");
        return this;
    }

    @Override
    public EstadoAudioPlayer next() {
        System.out.println(" não faz nada");
        return this;
    }

    @Override
    public EstadoAudioPlayer previous() {
        System.out.println("Não faz nada");
        return this;
    }

    @Override
    public EstadoAudioPlayer lock() {
        System.out.println("desbloqueia");
        return new EstadoEspera();

    }
}
