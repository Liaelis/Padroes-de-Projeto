package exercicio61;

import java.util.Objects;

public class EditorMemento {

    private String text;
    private int posicaoCursor;
    private int inicioTextoSelecionado;
    private int fimTextoSelecionado;

    public EditorMemento(String text, int posicaoCursor, int inicioTextoSelecionado, int fimTextoSelecionado) {
        this.text = text;
        this.posicaoCursor = posicaoCursor;
        this.inicioTextoSelecionado = inicioTextoSelecionado;
        this.fimTextoSelecionado = fimTextoSelecionado;
    }

    public String getText() {
        return text;
    }

    public int getPosicaoCursor() {
        return posicaoCursor;
    }


    public int getInicioTextoSelecionado() {
        return inicioTextoSelecionado;
    }

    public int getFimTextoSelecionado() {
        return fimTextoSelecionado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EditorMemento memento = (EditorMemento) o;
        return posicaoCursor == memento.posicaoCursor &&
                inicioTextoSelecionado == memento.inicioTextoSelecionado &&
                fimTextoSelecionado == memento.fimTextoSelecionado &&
                Objects.equals(text, memento.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, posicaoCursor, inicioTextoSelecionado, fimTextoSelecionado);
    }
}
