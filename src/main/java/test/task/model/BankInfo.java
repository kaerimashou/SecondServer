package test.task.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.math.BigInteger;

@Embeddable
public class BankInfo implements Serializable {

    private BigInteger BAcc;

    private Long bic;

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

    @Override
    public String toString() {
        return "BankInfo{" +
                "BAcc=" + BAcc +
                ", bic=" + bic +
                ", TAcc=" + TAcc +
                '}';
    }
}

