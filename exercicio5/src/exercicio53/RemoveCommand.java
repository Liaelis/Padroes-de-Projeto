package exercicio53;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RemoveCommand implements ComandoSQL {


    private CallBack callBack;
    private Long id;

    public RemoveCommand(CallBack callBack, Long id) {

        this.callBack = callBack;
        this.id = id;
    }

    @Override
    public void executa(Connection connection) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(" delete  x from xuxu x where id=?");
            ps.setLong(1, id);
            Integer num  = ps.executeUpdate();

            callBack.callBack(num);
        } finally {

            try {
                ps.close();
            } catch (Exception e) {
            }

        }
    }
}
