package exercicio32;

import java.util.ArrayList;
import java.util.Collection;

public class Caixa implements Valoravel {

    private Double custoCaixa;
    private Collection<Valoravel> valoraveis = new ArrayList<>();

    public void addValor(Valoravel valoravel){
        this.valoraveis.add(valoravel);
    }

    public Caixa(Double custoCaixa) {
        this.custoCaixa = custoCaixa;
    }

    public boolean remove(Valoravel valoravel){
        return this. valoraveis.remove(valoravel);
    }
    @Override
    public Double getValor() {
        Double valorTotal = custoCaixa;
        for(Valoravel valoravel : valoraveis){
           valorTotal+= valoravel.getValor();
        }
        return valorTotal;
    }
}
