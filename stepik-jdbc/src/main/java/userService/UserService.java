package userService;

import dao.UsersDao;
import users.Users;

import java.sql.SQLException;

public class UserService {
    private UsersDao usersDao = new UsersDao();

    public UserService() {

    }

    public long addUser(String login, String password) throws SQLException {
            usersDao.createTable();
            usersDao.insertUser(login, password);
            return usersDao.getUser(login).getId();
    }
    public Users getUser(String login) throws SQLException {
            return usersDao.getUser(login);
    }

}
