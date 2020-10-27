package exercicio2c;

import java.util.concurrent.CopyOnWriteArrayList;

public class ProtoctypeFactory {

     private Prototype<ContaBancaria> prototipoConta;

     public ProtoctypeFactory(){
         this.prototipoConta = new ContaBancaria(0l, 1l,
                 null, null, null,0.0);
     }

     public ContaBancaria createContaBancaria( String nomeTitular, String cpfTitular){
        ContaBancaria contaBancaria =prototipoConta.clone();
        contaBancaria.setCpfTitular(cpfTitular);
        contaBancaria.setTitularConta(nomeTitular);
        return contaBancaria;
     }
}
