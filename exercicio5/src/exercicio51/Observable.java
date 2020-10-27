package exercicio51;

public interface Observable {

    void subscribe(Observer observer);
    void unsubstribe(Observer observer);
}
