package imoveis;

import imoveis.Peça;

import java.util.List;

public class Imovel implements Forma3D, FormaGeometrica{
    private String proprietario;
    private String identificação;
    private String endereço;
    private TipoUso tipoUso;
    private List<Peça> peças;


    public TipoUso getTipoUso() {
        return tipoUso;
    }

    public void setTipoUso(TipoUso tipoUso) {
        this.tipoUso = tipoUso;
    }

    public enum TipoUso {
        RESIDENCIAL, COMERCIAL
    }

    @Override
    public Double getVolume() {
        Double volumeTotal =0.0;
        for(Peça peça: peças){
            volumeTotal += peça.getVolume();
        }
        return getArea() * volumeTotal;
    }

    @Override
    public Double getArea() {
        Double areaTotal =0.0;
        for(Peça peça: peças){
            areaTotal += peça.getArea();
        }
        return areaTotal;
    }
}
