package exercicio42;

import javax.sql.DataSource;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PoolConexoes {

    private DataSource dataSource;

    private List<Connection> instanciasDisponiveis = new ArrayList<>(20);
    private List<Connection> instanciasCriadas = new ArrayList<>(20);

    public PoolConexoes(DataSource dataSource) throws SQLException {
        this.dataSource =dataSource;
        for(int i=0; i<3; i++){
            Connection con = instanciaConnection();
            instanciasDisponiveis.add(con);
            instanciasCriadas.add(con);
        }
    }
     private Connection  instanciaConnection() throws SQLException {
         Connection target = dataSource.getConnection();
        return (Connection) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{Connection.class},
                new ConnectionProxyInvocationHandler(target));
     }


    public Connection acquire() throws SQLException, InterruptedException {
        synchronized (instanciasDisponiveis){
            if(!instanciasCriadas.isEmpty()){
                return instanciasDisponiveis.remove(0);
            }else if(instanciasCriadas.size() < 20){
                Connection con = instanciaConnection();
                instanciasCriadas.add(con);
                return con;
            }else{
                instanciasDisponiveis.wait();
                return instanciasDisponiveis.remove(0);
            }
        }
    }


    private void release(Connection o) {
        synchronized (instanciasDisponiveis){
            if(!instanciasCriadas.contains(0)){
                return;
            }
            instanciasDisponiveis.add(o);
            if(instanciasDisponiveis.size() == 1){
                instanciasDisponiveis.notify();
            }
        }

    }
    // declarada aqui pq ela só cerve para ser usada pela classe pool
    //encapsulada ela nao pode ser usada fora da classe Pool
    // se ela fosse publica só da pra usar quando a classe pool for instanciada
    // pra ela ser de livre acesso coloca static
    private class ConnectionProxyInvocationHandler implements InvocationHandler {
        private Connection target;
        private ConnectionProxyInvocationHandler(Connection connection){
            target = connection;
        }
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if( method.getName().equals("close")){
                PoolConexoes.this.release((Connection) proxy);
                return null;

            }else {
                Object retorno = method.invoke(target, args);
                return retorno;
            }
        }
    }
}
