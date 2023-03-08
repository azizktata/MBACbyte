package Admin;

import java.util.ArrayList;

public class ListeAdmins {

    private ArrayList<Admin> LAdmin = new ArrayList<>();

    public ListeAdmins() {
    }

    public ListeAdmins(ArrayList<Admin> LAdmin) {
        this.LAdmin = LAdmin;
    }

    public void AddAdmin(Admin A,Admin B, Admin C,Admin D)
    {
        LAdmin.add(A);
        LAdmin.add(B);
        LAdmin.add(C);
        LAdmin.add(D);

    }

    public ArrayList<Admin> getLAdmin() {
        return LAdmin;
    }

    public void setLAdmin(ArrayList<Admin> LAdmin) {
        this.LAdmin = LAdmin;
    }

    @Override
    public String toString() {
        return "ListeAdmins{" +
                "LAdmin=" + LAdmin +
                '}';
    }
}
