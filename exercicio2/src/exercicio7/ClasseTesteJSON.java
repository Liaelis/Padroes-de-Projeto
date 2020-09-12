package exercicio7;

import java.util.Date;

public class ClasseTesteJSON {

    private Long id;
    private String nome;
    private String texto;
    private Date data;
    private boolean bool;
    private String[] srtArray;
    private SubClasseJSON coordenadas;

    @JSON
    public SubClasseJSON getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(SubClasseJSON coordenadas) {
        this.coordenadas = coordenadas;
    }

    @JSON
    public String[] getSrtArray() {
        return srtArray;
    }

    public void setSrtArray(String[] srtArray) {
        this.srtArray = srtArray;
    }

    @JSON
    public boolean isBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }

    @JSON
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @JSON
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    @JSON(format = "yy-MM-dd")
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    public static class SubClasseJSON {

        private Double x;
        private Double y;

        public SubClasseJSON(Double x, Double y) {
            this.x = x;
            this.y = y;
        }

        @JSON
        public Double getX() {
            return x;
        }

        public void setX(Double x) {
            this.x = x;
        }
        @JSON
        public Double getY() {
            return y;
        }

        public void setY(Double y) {
            this.y = y;
        }
    }
}
