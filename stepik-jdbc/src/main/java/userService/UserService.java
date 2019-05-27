package userService;

import dao.UsersDao;
import user.User;

import java.sql.SQLException;

public class UserService {
    private UsersDao usersDao = new UsersDao();

    public void addUser(String login, String password) throws SQLException {
        usersDao.createTable();
        usersDao.insertUser(login, password);
        usersDao.getUser(login);
    }

    public User getUser(String login) throws SQLException {
        return usersDao.getUser(login);
    }

}
