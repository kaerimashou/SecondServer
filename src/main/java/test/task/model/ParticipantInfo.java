package test.task.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "participant")
public class ParticipantInfo implements Serializable {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "inn")
    private Long inn;

    @Column(name = "kpp")
    private Long kpp;

    @Column(name = "name")
    private String name;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    public Long getInn() {
        return inn;
    }

    public void setInn(Long inn) {
        this.inn = inn;
    }

    public Long getKpp() {
        return kpp;
    }

    public void setKpp(Long kpp) {
        this.kpp = kpp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ParticipantInfo{" +
                "inn=" + inn +
                ", kpp=" + kpp +
                ", name='" + name + '\'' +
                '}';
    }
}
