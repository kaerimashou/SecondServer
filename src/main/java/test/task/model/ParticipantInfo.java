package test.task.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ParticipantInfo implements Serializable {

    private Long inn;

    private Long kpp;

    private String name;

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
