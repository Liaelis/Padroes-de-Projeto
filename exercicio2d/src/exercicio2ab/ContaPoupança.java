package exercicio2ab;

public class ContaPoupança extends Conta{

    public ContaPoupança(Long numeroConta) {
        super(numeroConta);
    }

    @Override
    public Double getIRDevido() {
        return 0.0;
    }
}
