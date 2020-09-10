package exercicio5;

import sistema_bancario.Banco;
import sistema_bancario.Conta;

import java.util.Map;
import java.util.Random;

public class TesteConcorrencia {
    public static void main(String[] args) {
        Banco banco = new Banco();
        new Thread(new TreadTestBanco(banco)).start();
        new Thread(new TreadTestBanco(banco)).start();
        new Thread(new TreadTestBanco(banco)).start();
        new Thread(new TreadTestBanco(banco)).start();
        new Thread(new TreadTestBanco(banco)).start();

    }

    static class TreadTestBanco implements  Runnable{

        private final Banco banco;
        private long num = new Random().nextInt(100000);

        TreadTestBanco(Banco banco) {
            this.banco = banco;
        }

        @Override
        public void run() {
            long milis = System.currentTimeMillis();
            for (long i=1; i <= num; i++){
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
    }
}
