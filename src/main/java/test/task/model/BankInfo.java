package test.task.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Table(name = "bank")
public class BankInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", unique = true, nullable = false, insertable = true, updatable = false)
    private Long id;

    @Column(name = "bank_account")
    private BigInteger BAcc;

    @Column(name = "bic")
    private Long bic;

    @Column(name = "treasury_account")
    private BigInteger TAcc;

    public BigInteger getBAcc() {
        return BAcc;
    }

    public void setBAcc(BigInteger BAcc) {
        this.BAcc = BAcc;
    }

    public Long getBic() {
        return bic;
    }

    public void setBic(Long bic) {
        this.bic = bic;
    }

    public BigInteger getTAcc() {
        return TAcc;
    }

    public void setTAcc(BigInteger TAcc) {
        this.TAcc = TAcc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BankInfo{" +
                "BAcc=" + BAcc +
                ", bic=" + bic +
                ", TAcc=" + TAcc +
                '}';
    }
}

