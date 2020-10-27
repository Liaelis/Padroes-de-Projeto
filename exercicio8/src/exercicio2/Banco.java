package exercicio2;




import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Banco {


    private Map<Long, Conta> contas = new ConcurrentHashMap<>();


    public void criarConta (Long numero, Double saldoInicial, Conta.TipoConta tipoConta) {
       Conta conta = null;
        if (tipoConta == Conta.TipoConta.CONTA_CORRENTE) {
            conta = new ContaCorrente(numero, false, 0.0);
            conta.adicionaMovimentação(new Movimentação("deposito",
                    saldoInicial, Movimentação.TipoMovimentação.CRÉDITO));
        } else if (tipoConta == Conta.TipoConta.CONTA_POUPANÇA) {
            conta = new ContaPoupança(numero);
            conta.adicionaMovimentação(new Movimentação("deposito incial",
                    saldoInicial, Movimentação.TipoMovimentação.CRÉDITO));
        } else if (tipoConta == Conta.TipoConta.FUNDO_RENDA_FIXA) {
            conta = new FundoRenda(numero, FundoRenda.TipoFundo.FIXA);
            conta.adicionaMovimentação(new Movimentação("deposito incial",
                    saldoInicial, Movimentação.TipoMovimentação.CRÉDITO));
        } else if (tipoConta == Conta.TipoConta.FUNDO_RENDA_VARIAVEL) {
            conta = new FundoRenda(numero, FundoRenda.TipoFundo.VARIAVEL);
            conta.adicionaMovimentação(new Movimentação("deposito incial",
                    saldoInicial, Movimentação.TipoMovimentação.CRÉDITO));
        }
        contas.put(numero, conta);
    }


    public Conta excluirConta (Long numero) {
        return contas.remove(numero);

    }

    public Map<Long, Conta> getContas() {
        return contas;
    }

    public Conta findConta (Long numero) {
        return contas.get(numero);
    }

    public void saque (Double valorSaque, Long numero) {
        Conta conta = contas.get(numero);
        conta.adicionaMovimentação(new Movimentação("saque", valorSaque, Movimentação.TipoMovimentação.DÉBITO));
    }

    public void deposito (Double valorDeposito, Long numero) {
        Conta conta = contas.get(numero);
        conta.adicionaMovimentação(new Movimentação("Deposito", valorDeposito, Movimentação.TipoMovimentação.CRÉDITO));
    }


    public Double verSaldo (Long numeroConta) {

        Conta conta = contas.get(numeroConta);
        return conta.getSaldo();
    }

    public void extrato (Long numero) {
        Conta conta = contas.get(numero);
        for (Movimentação mov : conta.getMovimentaçãos()) {
            System.out.println("Descrição: " + mov.getDescrição());
            System.out.println("Tipo: " + mov.getTipoMovimentação());
            System.out.println("Valor: " + mov.getValor());
        }
    }

    public void tranferencia (Long destinatario, Long remetente, Double valor) {
        Conta contaD = contas.get(destinatario);
        Conta contaR = contas.get(remetente);
        if (contaR != null && contaD != null) {
            if (contaR.getSaldo() > valor) {
                saque(valor, contaR.getNumeroConta());
                deposito(valor, contaD.getNumeroConta());
            }
        } else {
            System.out.println("Dados de contas não constam no sistema");
        }
    }
}
