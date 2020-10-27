package exercicio53;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelecionaCommand implements ComandoSQL {

    private CallBack callBack;
    private Long id;

    public SelecionaCommand( CallBack callBack, Long id) {
        this.callBack = callBack;
        this.id = id;
    }


    @Override
    public void executa(Connection connection) throws SQLException {
        PreparedStatement ps = null;
        ResultSet res = null;
        try {
            ps = connection.prepareStatement(" select  x from xuxu x where id=?");
            ps.setLong(1, id);
            res = ps.executeQuery();
            Object o = new Object();
            if (res.next()) {
                res.getInt(1);
            }
            callBack.callBack(o);
        } finally {
            try {
                res.close();
            } catch (Exception e) {
            }
            try {
                ps.close();
            } catch (Exception e) {
            }

        }

    }
}
