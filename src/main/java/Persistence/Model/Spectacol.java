package Persistence.Model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "spectacol", schema ="opera")
public class Spectacol {
    private int idSpectacol;
    private String titlu;
    private String gen;
    private String regia;
    private String distributia;
    private Timestamp dataPremiera;
    private Integer nrBilete;

    public Spectacol()
    {

    }

    public Spectacol(int idSpectacol, String titlu, String gen, String regia, String distributia, Timestamp dataPremiera, Integer nrBilete) {
        this.idSpectacol = idSpectacol;
        this.titlu = titlu;
        this.gen = gen;
        this.regia = regia;
        this.distributia = distributia;
        this.dataPremiera = dataPremiera;
        this.nrBilete = nrBilete;
    }

    @Id
    @Column(name = "id_spectacol", nullable = false)
    public int getIdSpectacol() {
        return idSpectacol;
    }

    public void setIdSpectacol(int idSpectacol) {
        this.idSpectacol = idSpectacol;
    }

    public Spectacol(String titlu, String gen, String regia, String distributia, Timestamp dataPremiera, Integer nrBilete) {
        this.titlu = titlu;
        this.gen = gen;
        this.regia = regia;
        this.distributia = distributia;
        this.dataPremiera = dataPremiera;
        this.nrBilete = nrBilete;
    }

    @Basic
    @Column(name = "titlu", nullable = true, length = 255)

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    @Basic
    @Column(name = "gen", nullable = true, length = 255)
    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    @Basic
    @Column(name = "regia", nullable = true, length = 255)
    public String getRegia() {
        return regia;
    }

    public void setRegia(String regia) {
        this.regia = regia;
    }

    @Basic
    @Column(name = "distributia", nullable = true, length = 255)
    public String getDistributia() {
        return distributia;
    }

    public void setDistributia(String distributia) {
        this.distributia = distributia;
    }

    @Basic
    @Column(name = "data_premiera", nullable = false)
    public Timestamp getDataPremiera() {
        return dataPremiera;
    }

    public void setDataPremiera(Timestamp dataPremiera) {
        this.dataPremiera = dataPremiera;
    }

    @Basic
    @Column(name = "nr_bilete", nullable = true)
    public Integer getNrBilete() {
        return nrBilete;
    }

    public void setNrBilete(Integer nrBilete) {
        this.nrBilete = nrBilete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Spectacol spectacol = (Spectacol) o;

        if (idSpectacol != spectacol.idSpectacol) return false;
        if (titlu != null ? !titlu.equals(spectacol.titlu) : spectacol.titlu != null) return false;
        if (gen != null ? !gen.equals(spectacol.gen) : spectacol.gen != null) return false;
        if (regia != null ? !regia.equals(spectacol.regia) : spectacol.regia != null) return false;
        if (distributia != null ? !distributia.equals(spectacol.distributia) : spectacol.distributia != null)
            return false;
        if (dataPremiera != null ? !dataPremiera.equals(spectacol.dataPremiera) : spectacol.dataPremiera != null)
            return false;
        if (nrBilete != null ? !nrBilete.equals(spectacol.nrBilete) : spectacol.nrBilete != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSpectacol;
        result = 31 * result + (titlu != null ? titlu.hashCode() : 0);
        result = 31 * result + (gen != null ? gen.hashCode() : 0);
        result = 31 * result + (regia != null ? regia.hashCode() : 0);
        result = 31 * result + (distributia != null ? distributia.hashCode() : 0);
        result = 31 * result + (dataPremiera != null ? dataPremiera.hashCode() : 0);
        result = 31 * result + (nrBilete != null ? nrBilete.hashCode() : 0);
        return result;
    }
}
