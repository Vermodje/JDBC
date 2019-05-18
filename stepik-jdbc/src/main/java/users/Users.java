package users;


public class Users {


    private long id;


    private String login;


    private String password;


    public Users() {
    }


    public Users(long id, String login, String password) {
        this.setId(id);
        this.setLogin(login);
        this.setPassword(password);
    }

    public Users(String login, String password) {
        this.setId(-1);
        this.setLogin(login);
        this.setPassword(password);
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users { id = " + id + ", login = " + login + ", password = " + password + "}";
    }

}

