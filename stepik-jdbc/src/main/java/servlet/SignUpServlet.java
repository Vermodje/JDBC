package servlet;

import userService.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class SignUpServlet extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (login == null || password == null){
            resp.getWriter().println("Please add login or password");
        }
        else {
            try {
                userService.addUser(login,password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            resp.getWriter().println("User was added");
        }
    }
}
