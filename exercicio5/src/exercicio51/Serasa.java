package exercicio51;

import sistema_bancario.Conta;


import java.util.ArrayList;
import java.util.List;


public class Serasa implements Observer{

    private List<Conta> negativados = new ArrayList<Conta>();

    @Override
    public void notify(Observable observable) {
        if(observable instanceof Conta &&  ((Conta) observable).getSaldo()<0.0 ){
            this.negativados.add((Conta) observable);
        }else if(observable instanceof Conta && ((Conta) observable).getSaldo()>=0.0){
            this.negativados.remove(observable);
        }

    }
}
