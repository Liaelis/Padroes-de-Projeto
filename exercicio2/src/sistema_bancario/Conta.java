package sistema_bancario;

import java.util.ArrayList;
import java.util.List;

public abstract class Conta {
    private Long numeroConta;
    private Double saldo;
    private List<Movimentação> movimentaçãos = new ArrayList<>();

    public Conta(Long numeroConta) {
        this.numeroConta = numeroConta;
        this.saldo = 0.0;
    }

    public Long getNumeroConta() {
        return numeroConta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public abstract Double getIRDevido();

    public List<Movimentação> getMovimentaçãos() {
        List<Movimentação> movCopy = new ArrayList<>(movimentaçãos.size());
        System.arraycopy(movimentaçãos,0,movCopy,0,movimentaçãos.size());
        return movCopy;
    }

    public void adicionaMovimentação( Movimentação movimentação){
        List<Movimentação> movCopy = new ArrayList<>(movimentaçãos.size());
        System.arraycopy(movimentaçãos,0,movCopy,0,movimentaçãos.size());
        movCopy.add(movimentação);
        this.movimentaçãos = movCopy;
        this.saldo += movimentação.getValor();
    }

    public enum TipoConta{
        CONTA_POUPANÇA, CONTA_CORRENTE, FUNDO_RENDA_FIXA, FUNDO_RENDA_VARIAVEL
    }
}
