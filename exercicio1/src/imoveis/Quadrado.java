package imoveis;

public class Quadrado implements FormaGeometrica{

    private Double lado;

    public Quadrado(Double lado) {
        this.lado = lado;
    }

    public Double getLado() {
        return lado;
    }

    public void setLado(Double lado) {
        this.lado = lado;
    }

    @Override
    public Double getArea() {
        return lado*lado;
    }
}
