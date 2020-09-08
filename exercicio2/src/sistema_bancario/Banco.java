package sistema_bancario;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    private List<Conta> contas = new ArrayList<>();

    public void criarConta(Long numero, Double saldoInicial, Conta.TipoConta tipoConta ){
        Conta conta = null;
        if(tipoConta == Conta.TipoConta.CONTA_CORRENTE){
            conta = new ContaCorrente(numero, false, 0.0);
            conta.adicionaMovimentação( new Movimentação("deposito",
                    saldoInicial ,Movimentação.TipoMovimentação.CRÉDITO));
        }else if(tipoConta == Conta.TipoConta.CONTA_POUPANÇA){
            conta = new ContaPoupança(numero);
            conta.adicionaMovimentação(new Movimentação("deposito incial",
                    saldoInicial, Movimentação.TipoMovimentação.CRÉDITO));
        }else if(tipoConta == Conta.TipoConta.FUNDO_RENDA_FIXA){
            conta= new FundoRenda(numero,FundoRenda.TipoFundo.FIXA);
            conta.adicionaMovimentação(new Movimentação("deposito incial",
                    saldoInicial, Movimentação.TipoMovimentação.CRÉDITO));
        }else  if(tipoConta == Conta.TipoConta.FUNDO_RENDA_VARIAVEL) {
            conta = new FundoRenda(numero, FundoRenda.TipoFundo.VARIAVEL);
            conta.adicionaMovimentação(new Movimentação("deposito incial",
                    saldoInicial, Movimentação.TipoMovimentação.CRÉDITO));
        }
        List<Conta> contasCopy = new ArrayList<>(contas.size());
        System.arraycopy(contas, 0, contasCopy, 0, contas.size());
        contasCopy.add(conta);
        this.contas = contasCopy;
    }

    public Boolean excluirConta(Long numero){

        return false;
    }

    public void saque(Double valorSaque, Long numero){
        for(Conta conta: contas){
            if(conta.getNumeroConta() == numero){
                if(conta.getSaldo()> valorSaque){
                    conta.adicionaMovimentação(new Movimentação("saque", valorSaque,
                            Movimentação.TipoMovimentação.DÉBITO));

                }
            }
        }
    }

    public void deposito(Double valorDeposito,  Long numero){
        for(Conta conta: contas){
            if(conta.getNumeroConta() == numero){
                    conta.adicionaMovimentação(new Movimentação("saque", valorDeposito,
                            Movimentação.TipoMovimentação.CRÉDITO));

            }
        }
    }

    public Double verSaldo(Long numeroConta){
        for(Conta conta: contas) {

            if(conta.getNumeroConta() == numeroConta){
                return conta.getSaldo();
            }
        }
        return null;
    }

    public void extrato(Long numero){
        for(Conta contamove : contas){
            if(contamove.getNumeroConta() == numero){
               for(Movimentação mov :contamove.getMovimentaçãos()){
                   System.out.println("Descrição: " +mov.getDescrição());
                   System.out.println("Tipo: " +mov.getTipoMovimentação());
                   System.out.println("Valor: " +mov.getValor());
               }

            }
        }
    }

    public void tranferencia(Long destinatario, Long remetente, Double valor){

        Conta contaD = null;
        Conta contaR = null;
        for (Conta conta : contas){
            if(conta.getNumeroConta() == destinatario){
               contaD = conta;
            }
            if(conta.getNumeroConta() == remetente){
                contaR = conta;
            }
        }
        if(contaR!=null && contaD!= null){
            if(contaR.getSaldo() > valor){
                saque(valor,contaR.getNumeroConta());
                deposito(valor,contaD.getNumeroConta());
            }
        }else{
            System.out.println("Dados de contas não constam no sistema");
        }
    }
}
