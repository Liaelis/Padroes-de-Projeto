package sistema_bancario;

import exercicio51.Observable;
import exercicio51.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements Observable {
    private Long numeroConta;
    private Double saldo;
    private List<Movimentação> movimentaçãos = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    public Conta(Long numeroConta) {
        this.numeroConta = numeroConta;
        this.saldo = 0.0;
    }

    @Override
    public void subscribe(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void unsubstribe(Observer observer) {
        this.observers.remove(observer);
    }

    public Long getNumeroConta() {
        return numeroConta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public abstract Double getIRDevido();

    public List<Movimentação> getMovimentaçãos() {

        return movimentaçãos;
    }

    public void adicionaMovimentação(Movimentação movimentação) {

        this.movimentaçãos.add(movimentação);
        this.saldo += movimentação.getValor();
        for (Observer o : observers) {
            o.notify(this);
        }
    }

    public enum TipoConta {
        CONTA_POUPANÇA, CONTA_CORRENTE, FUNDO_RENDA_FIXA, FUNDO_RENDA_VARIAVEL
    }
}
