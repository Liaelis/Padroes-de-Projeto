package exercicio2ab;

public class ContaCorrente extends Conta{

    private boolean especial;
    private Double limite;

    public ContaCorrente(Long numeroConta, boolean especial, Double limite) {
        super(numeroConta);
        this.especial = especial;
        this.limite = limite;
    }

    public boolean isEspecial() {
        return especial;
    }

    public void setEspecial(boolean especial) {
        this.especial = especial;
    }

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }

    @Override
    public Double getIRDevido() {
        return 0.0;
    }
}
