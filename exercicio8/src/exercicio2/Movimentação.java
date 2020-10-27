package exercicio2;

public class Movimentação {

    private final String descrição;
    private final Double valor;
    private final TipoMovimentação tipoMovimentação;

    public Movimentação(String descrição, Double valor,
                        TipoMovimentação tipoMovimentação) {
        this.descrição = descrição;
        this.valor = valor;
        this.tipoMovimentação = tipoMovimentação;
    }

    public String getDescrição() {
        return descrição;
    }

    public Double getValor() {
        return valor;
    }

    public TipoMovimentação getTipoMovimentação() {
        return tipoMovimentação;
    }

    public enum TipoMovimentação{
        CRÉDITO, DÉBITO, RENDIMENTO;
    }
}
