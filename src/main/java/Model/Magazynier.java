package Model;


public class Magazynier{
    private Integer ID;
    private String Login;
    private String Haslo;


    //constructors


    public Magazynier(Integer ID, String login, String haslo) {
        this.ID = ID;
        Login = login;
        Haslo = haslo;
    }


    //getters & setters
    public Integer getID() {
        return ID;
    }
    public void setID(Integer ID) {
        this.ID = ID;
    }
    public String getLogin() {
        return Login;
    }
    public void setLogin(String login) {
        Login = login;
    }
    public String getHaslo() {
        return Haslo;
    }
    public void setHaslo(String haslo) {
        Haslo = haslo;
    }
}