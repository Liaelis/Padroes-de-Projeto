package exercicio53;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InvokerSQL {


    private List<ComandoSQL> comandos = new ArrayList<>();

    public void adicionaComando(ComandoSQL comandoSQL){
        this.comandos.add(comandoSQL);
    }



    public void execute(Connection connection) throws SQLException {

        try {
            for (ComandoSQL c : comandos) {
                c.executa(connection);
            }
            connection.commit();
        }catch (SQLException throwables){
            connection.rollback();
        }
    }

}
