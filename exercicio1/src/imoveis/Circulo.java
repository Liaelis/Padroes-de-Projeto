package imoveis;

public class Circulo implements FormaGeometrica {

    private Double raio;
    private Double grausCirculo;

    public Circulo(Double raio, Double grausCirculo) {
        this.raio = raio;
        this.grausCirculo = grausCirculo;
    }

    public Circulo(Double raio) {
        this.raio = raio;
        this.grausCirculo =360.0;
    }

    public Double getRaio() {
        return raio;
    }

    public void setRaio(Double raio) {
        this.raio = raio;
    }

    @Override
    public Double getArea() {
        return Math.PI *raio * raio *(grausCirculo/360.0);
    }
}
