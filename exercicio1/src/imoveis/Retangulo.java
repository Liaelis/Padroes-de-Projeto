package imoveis;

public class Retangulo implements  FormaGeometrica{
    private Double comprimento;
    private  Double largura;

    public Retangulo(Double comprimento, Double largura) {
        this.comprimento = comprimento;
        this.largura = largura;
    }

    public Double getComprimento() {
        return comprimento;
    }

    public void setComprimento(Double comprimento) {
        this.comprimento = comprimento;
    }

    public Double getLargura() {
        return largura;
    }

    public void setLargura(Double largura) {
        this.largura = largura;
    }

    @Override
    public Double getArea() {
        return comprimento*largura;
    }
}
