package dao;

import executor.Executor;
import users.Users;

import java.sql.SQLException;

public class UsersDao {
    private Executor executor = new Executor();

    public UsersDao() {

    }

    public void createTable() throws SQLException {
        executor.execUpdate("create table if not exists users (id bigint auto_increment, login varchar(256), password varchar(256), primary key (id))");
    }

    public void insertUser(String login, String password) throws SQLException {
        executor.execUpdate("insert into users (login,password) values ('" + login + "','" + password + "')");
    }

    public Users getUser(String login) throws SQLException {
        return executor.execQuery("select * from users where login='" + login + "'", result -> {
            result.next();
            return new Users(result.getLong(1), result.getString(2), result.getString(3));
        });
    }
}
