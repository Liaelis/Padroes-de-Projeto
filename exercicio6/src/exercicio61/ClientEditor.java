package exercicio61;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Stack;

public class ClientEditor {

    private JEditorPane editorPane;
    private Stack<EditorMemento> pilhaMementos = new Stack<>();
    private Stack<EditorMemento> pilhaMementoRefazer = new Stack<>();


    public void onLKeyPressed(KeyEvent key) {

        if (key.getKeyCode() == KeyEvent.VK_SPACE) {
            EditorMemento memento = criaMemento();
            if(!pilhaMementos.peek().equals(memento)){
                pilhaMementos.push(memento);
            }
            pilhaMementoRefazer.clear();
        }else if(key.getKeyCode() == KeyEvent.VK_Z && (key.getModifiersEx() & KeyEvent.CTRL_DOWN_MASK) !=0){
            pilhaMementoRefazer.push(pilhaMementos.peek());
            recuperarEstadoEditor(pilhaMementos.pop());


        }else if(key.getKeyCode() == KeyEvent.VK_R && (key.getModifiersEx() & KeyEvent.CTRL_DOWN_MASK) !=0){
            pilhaMementos.push(pilhaMementoRefazer.peek());
            recuperarEstadoEditor(pilhaMementoRefazer.pop());
        }else{
            pilhaMementoRefazer.clear();
        }
    }

    private EditorMemento criaMemento() {
        return new EditorMemento(editorPane.getText(),
                editorPane.getCaretPosition(),
                editorPane.getSelectionStart(),
                editorPane.getSelectionEnd()
        );
    }

    private void recuperarEstadoEditor( EditorMemento memento){
        editorPane.setCaretPosition(memento.getPosicaoCursor());
        editorPane.setText(memento.getText());
        editorPane.setSelectionStart(memento.getInicioTextoSelecionado());
        editorPane.setSelectionEnd(memento.getFimTextoSelecionado());
    }
}
