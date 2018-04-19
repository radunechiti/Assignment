package Persistence;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Casier{
    private int idCasier;
    private String username;
    private String parola;
    private String nume;

    @Id
    @Column(name = "id_casier", nullable = false)
    public int getIdCasier() {
        return idCasier;
    }

    public void setIdCasier(int idCasier) {
        this.idCasier = idCasier;
    }

    @Basic
    @Column(name = "username", nullable = true, length = 255)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "parola", nullable = true, length = 255)
    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    @Basic
    @Column(name = "nume", nullable = true, length = 255)
    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Casier casier = (Casier) o;

        if (idCasier != casier.idCasier) return false;
        if (username != null ? !username.equals(casier.username) : casier.username != null) return false;
        if (parola != null ? !parola.equals(casier.parola) : casier.parola != null) return false;
        if (nume != null ? !nume.equals(casier.nume) : casier.nume != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCasier;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (parola != null ? parola.hashCode() : 0);
        result = 31 * result + (nume != null ? nume.hashCode() : 0);
        return result;
    }
}
