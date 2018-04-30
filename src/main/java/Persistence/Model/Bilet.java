package Persistence.Model;

import javax.persistence.*;

@Entity
@Table(name="bilet", schema = "opera")
public class Bilet {
    private int idBilet;
    private Integer rand;
    private Integer numar;
    private Integer id_spectacol;
    public Bilet()
    {

    }
    @Basic
    @Column(name ="id_spectacol", nullable=false)
    public Integer getId_spectacol() {
        return id_spectacol;
    }

    public void setId_spectacol(Integer id_spectacol) {
        this.id_spectacol = id_spectacol;
    }

    @Id
    @Column(name = "id_bilet", nullable = false)
    public int getIdBilet() {
        return idBilet;
    }

    public void setIdBilet(int idBilet) {
        this.idBilet = idBilet;
    }

    public Bilet(Integer rand, Integer numar, Integer id_spectacol) {
        this.rand = rand;
        this.numar = numar;
        this.id_spectacol = id_spectacol;
    }

    @Basic

    @Column(name = "rand", nullable = false)
    public Integer getRand() {
        return rand;
    }

    public void setRand(Integer rand) {
        this.rand = rand;
    }

    @Basic
    @Column(name = "numar", nullable = false)
    public Integer getNumar() {
        return numar;
    }

    public void setNumar(Integer numar) {
        this.numar = numar;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bilet bilet = (Bilet) o;

        if (idBilet != bilet.idBilet) return false;
        if (rand != null ? !rand.equals(bilet.rand) : bilet.rand != null) return false;
        if (numar != null ? !numar.equals(bilet.numar) : bilet.numar != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idBilet;
        result = 31 * result + (rand != null ? rand.hashCode() : 0);
        result = 31 * result + (numar != null ? numar.hashCode() : 0);
        return result;
    }
}
