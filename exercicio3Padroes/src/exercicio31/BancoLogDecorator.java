package exercicio31;

import sistema_bancario.BancoInterface;
import sistema_bancario.Conta;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

public class BancoLogDecorator implements BancoInterface {

    //usa pela interface nao pela classe Banco
    private BancoInterface bancoDecorado;
    // escrever log
    private Writer writerLog;

    public BancoLogDecorator(BancoInterface banco, String  nomeArquivoLog) throws IOException {
        this.bancoDecorado = banco;
        this.writerLog = new FileWriter(nomeArquivoLog);
    }

    @Override
    public void criarConta(Long numero, Double saldoInicial, Conta.TipoConta tipoConta) {
        try {
            this.writerLog.write("Método cria(" + numero +" ,"+ saldoInicial+", "+tipoConta+") conta invocado ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        bancoDecorado.criarConta(numero, saldoInicial,tipoConta);
    }

    @Override
    public Conta excluirConta(Long numero) {
        try {
            this.writerLog.write("Método exclui  conta (" + numero +" )invocado ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bancoDecorado.excluirConta(numero);
    }

    @Override
    public Map<Long, Conta> getContas() {
        try {
            this.writerLog.write("Método get contas invocado ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bancoDecorado.getContas();
    }

    @Override
    public Conta findConta(Long numero) {
        try {
            this.writerLog.write("Método find  conta (" + numero +" )invocado ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bancoDecorado.findConta(numero);
    }

    @Override
    public void saque(Double valorSaque, Long numero) {

    }

    @Override
    public void deposito(Double valorDeposito, Long numero) {

    }

    @Override
    public void setContas(Map<Long, Conta> contas) {
        try {
            this.writerLog.write("Método set contas invocado ");
        } catch (IOException e) {
            e.printStackTrace();
        }
         bancoDecorado.setContas(contas);
    }

    @Override
    public Double verSaldo(Long numeroConta) {
        return null;
    }

    @Override
    public void extrato(Long numero) {

    }

    @Override
    public void tranferencia(Long destinatario, Long remetente, Double valor) {

    }
}
