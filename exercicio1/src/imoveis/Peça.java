package imoveis;

import java.util.List;

public class Peça implements FormaGeometrica,Forma3D {

    private List<FormaGeometrica> formaGeometricas;
    private String identificação;
    private Double peDireito;

    public List<FormaGeometrica> getFormaGeometricas() {
        return formaGeometricas;
    }

    public void setFormaGeometricas(List<FormaGeometrica> formaGeometricas) {
        this.formaGeometricas = formaGeometricas;
    }

    public String getIdentificação() {
        return identificação;
    }

    public void setIdentificação(String identificação) {
        this.identificação = identificação;
    }

    public Double getPeDireito() {
        return peDireito;
    }

    public void setPeDireito(Double peDireito) {
        this.peDireito = peDireito;
    }

    @Override
    public Double getArea() {
        Double areaTotal =0.0;
        for(FormaGeometrica formaGeometrica: formaGeometricas){
            areaTotal += formaGeometrica.getArea();
        }
        return areaTotal;
    }

    @Override
    public Double getVolume() {
        return getArea()*peDireito;
    }
}
