package exercicio2c;

public class ContaBancaria implements Prototype<ContaBancaria>{
    private Long numero;
    private Long numeroAgencia;
    private String tipo;
    private String titularConta;
    private String cpfTitular;
    private Double saldo;

    public ContaBancaria(Long numero, Long numeroAgencia, String tipo, String titularConta, String cpfTitular, Double saldo) {
        this.numero = numero;
        this.numeroAgencia = numeroAgencia;
        this.tipo = tipo;
        this.titularConta = titularConta;
        this.cpfTitular = cpfTitular;
        this.saldo = saldo;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Long getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroAgencia(Long numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTitularConta() {
        return titularConta;
    }

    public void setTitularConta(String titularConta) {
        this.titularConta = titularConta;
    }

    public String getCpfTitular() {
        return cpfTitular;
    }

    public void setCpfTitular(String cpfTitular) {
        this.cpfTitular = cpfTitular;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public ContaBancaria clone() {

        return new ContaBancaria(this.numero, this.numeroAgencia, this.tipo,
                this.titularConta, this.cpfTitular, this.saldo);
    }
}
