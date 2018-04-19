package Persistence;

import javax.persistence.*;

@Entity
@Table(name = "admin", schema = "opera")
//@NamedQuery({
  //      @NamedQuery(name="Admin.findById", query ="from Admin a where a.username=:username")
//})

public class Admin{
    private int idAdmin;
    private String username;
    private String parola;

    public Admin() {
    }

    @Id
    @Column(name = "id_admin", nullable = false)
    public int getIdAdmin() {
        return idAdmin;
    }

    public Admin(String username, String parola) {
        this.username = username;
        this.parola = parola;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

   // @Basic
    @Column(name = "username", nullable = true, length = 255)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    //@Basic
    @Column(name = "parola", nullable = true, length = 255)
    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Admin admin = (Admin) o;

        if (idAdmin != admin.idAdmin) return false;
        if (username != null ? !username.equals(admin.username) : admin.username != null) return false;
        if (parola != null ? !parola.equals(admin.parola) : admin.parola != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAdmin;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (parola != null ? parola.hashCode() : 0);
        return result;
    }
}
