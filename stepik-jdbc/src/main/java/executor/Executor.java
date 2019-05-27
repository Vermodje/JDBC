package executor;

import util.Util;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Executor {
    private final Connection connection;

    public Executor() {
        Util util = new Util();
        this.connection = util.getConnection();
    }

    public void execUpdate(String update) {
        try {
            connection.setAutoCommit(false);
            Statement stmt = connection.createStatement();
            stmt.execute(update);
            stmt.close();
            connection.commit();
        }catch (SQLException e){
            try {
                connection.rollback();
            } catch (SQLException ignore) {
            }
            finally {
                try {
                    connection.setAutoCommit(true);
                } catch (SQLException ignore) {
                }
            }
        }

    }

    public <T> T execQuery(String query,
                           ResultHandler<T> handler)
            throws SQLException {
        Statement stmt = connection.createStatement();

        stmt.execute(query);
        ResultSet result = stmt.getResultSet();
        T value = handler.handle(result);
        result.close();
        stmt.close();
        return value;
    }
}
