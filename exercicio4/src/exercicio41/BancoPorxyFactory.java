package exercicio41;

import sistema_bancario.Banco;
import sistema_bancario.BancoInterface;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BancoPorxyFactory {

    private static BancoPorxyFactory INSTANCE;
    public  static BancoPorxyFactory getInstance(){
        synchronized (BancoPorxyFactory.class){
            if(INSTANCE == null){
                INSTANCE = new BancoPorxyFactory();

            }
        }

        return INSTANCE;
    }
    private BancoPorxyFactory (){

    }
    public BancoInterface createInstance() throws IOException {

       BancoInterface banco = BancoPorxyFactory.getInstance().createInstance();

           return (BancoInterface) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{BancoInterface.class},
                   new BancoLogInvocationHandler(" arquivoLogBanco",banco));

    }

    private class BancoLogInvocationHandler implements InvocationHandler{

        private Writer writelog;
        private BancoInterface banco;
        private  BancoLogInvocationHandler(String nomeArquivoLog, BancoInterface banco) throws IOException {
            this.writelog = new FileWriter(nomeArquivoLog);
            this.banco = banco;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            long milis = System.currentTimeMillis();
            Object retorno = method.invoke(banco, args);
             milis = System.currentTimeMillis()-milis;
            this.writelog.write(" metodo "+ method.getName() + " invocado. "+ milis +" ms decorridos.");
            return retorno;
        }
    }
}
