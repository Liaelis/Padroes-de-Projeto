package exercicio3;

import sistema_bancario.Banco;
import sistema_bancario.Conta;

import java.util.Map;

public class TesteBanco {

    public static void main(String[] args) {
        Banco banco = new Banco();
        long milis = System.currentTimeMillis();
        for (long i=1; i <= 100000; i++){
            banco.criarConta(i,100.0, Conta.TipoConta.CONTA_CORRENTE);
        }
        milis = System.currentTimeMillis() - milis;
        System.out.println("Criar contas "+milis+ "ms.");

        milis = System.currentTimeMillis();
        for(Map.Entry<Long, Conta> entry : banco.getContas().entrySet()){
            long numero = entry.getKey();
            Conta conta = banco.findConta(numero);
        }
        milis = System.currentTimeMillis() - milis;
        System.out.println("Percorrer contas  "+milis+ "ms.");
    }

    // 61ms pra criar
    //percorrer hasmap 10ms
    //72 pra criar
    //treeMap 13ms

}
