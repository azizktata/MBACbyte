package Admin;

public class Admin {
    private String usename;
    private String Password;

    public Admin() {
    }

    public Admin(String usename, String password) {
        this.usename = usename;
        Password = password;
    }

    public String getUsename() {
        return usename;
    }

    public void setUsename(String usename) {
        this.usename = usename;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "usename='" + usename + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
