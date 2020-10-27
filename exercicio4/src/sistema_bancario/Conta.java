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

        return movimentaçãos;
    }

    public void adicionaMovimentação( Movimentação movimentação){

        this.movimentaçãos.add(movimentação);
        this.saldo += movimentação.getValor();
    }

    public enum TipoConta{
        CONTA_POUPANÇA, CONTA_CORRENTE, FUNDO_RENDA_FIXA, FUNDO_RENDA_VARIAVEL
    }
}
