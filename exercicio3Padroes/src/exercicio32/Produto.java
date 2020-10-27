package exercicio32;

public class Produto implements Valoravel{

    private String nome;
    private String cor;
    private Boolean fragil;
    private Double valor;

    public Produto(String nome, String cor, Boolean fragil, Double valor) {
        this.nome = nome;
        this.cor = cor;
        this.fragil = fragil;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Boolean getFragil() {
        return fragil;
    }

    public void setFragil(Boolean fragil) {
        this.fragil = fragil;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public Double getValor() {
        return this.valor;
    }
}
