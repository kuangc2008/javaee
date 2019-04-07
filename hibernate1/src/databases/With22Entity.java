package databases;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "with22", schema = "stu", catalog = "")
public class With22Entity {
    private int id;
    private String baba;
    private String haha;
    private String gaga;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "baba")
    public String getBaba() {
        return baba;
    }

    public void setBaba(String baba) {
        this.baba = baba;
    }

    @Basic
    @Column(name = "haha")
    public String getHaha() {
        return haha;
    }

    public void setHaha(String haha) {
        this.haha = haha;
    }

    @Basic
    @Column(name = "gaga")
    public String getGaga() {
        return gaga;
    }

    public void setGaga(String gaga) {
        this.gaga = gaga;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        With22Entity that = (With22Entity) o;
        return id == that.id &&
                Objects.equals(baba, that.baba) &&
                Objects.equals(haha, that.haha) &&
                Objects.equals(gaga, that.gaga);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, baba, haha, gaga);
    }

    @Override
    public String toString() {
        return "With22Entity{" +
                "id=" + id +
                ", baba='" + baba + '\'' +
                ", haha='" + haha + '\'' +
                ", gaga='" + gaga + '\'' +
                '}';
    }
}
