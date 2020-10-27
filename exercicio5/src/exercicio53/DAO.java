package exercicio53;

import exercicio51.Observer;
import exercicio52.Invoker;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class  DAO {

    private DataSource dataSource;

    public DAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private InvokerSQL invokerSQL = new InvokerSQL();

    public void insere(Object o, CallBack call) {

    }

    public void update(Object o, CallBack call){

    }

    public void remove(Long id, CallBack call){
        invokerSQL.adicionaComando(new RemoveCommand(call,id));
    }

    public void seleciona(Long id, CallBack call){
        invokerSQL.adicionaComando(new SelecionaCommand(call, id));

    }

    public void executaLote() throws SQLException {
        Connection connection = dataSource.getConnection();
        try {
            invokerSQL.execute(connection);
        }finally {
            connection.close();
        }

        invokerSQL = new InvokerSQL();
    }

}
