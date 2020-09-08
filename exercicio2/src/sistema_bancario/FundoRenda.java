package sistema_bancario;

public class FundoRenda extends Conta {

    private TipoFundo tipoFundo;

    public FundoRenda(Long numeroConta, TipoFundo tipoFundo) {
        super(numeroConta);
        this.tipoFundo = tipoFundo;
    }

    public TipoFundo getTipoFundo() {
        return tipoFundo;
    }

    public void setTipoFundo(TipoFundo tipoFundo) {
        this.tipoFundo = tipoFundo;
    }



    @Override
    public Double getIRDevido() {
        double  IR = 0.0;
        for(Movimentação mov: super.getMovimentaçãos()){
            if(mov.getTipoMovimentação() == Movimentação.TipoMovimentação.RENDIMENTO ){
                IR += mov.getValor()*0.275;
            }
        }
        return IR;
    }

    public enum TipoFundo{
        FIXA,VARIAVEL
    }
}
