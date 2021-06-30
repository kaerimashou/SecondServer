package test.task.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "document")
public class Document {
    @Id
    @NotNull
    @Column(name = "docguid")
    private String docGUID;

    @NotNull
    @Column(name = "docnum")
    private Long docNum;

    @NotNull
    @Column(name = "docdate")
    private Date docDate;

    @NotNull
    @Column(name = "opertype")
    private Integer operType;

    @NotNull
    @Column(name = "amountout")
    private Double amountOut;

    @NotNull
    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "inn", column = @Column(name = "payer_inn")),
            @AttributeOverride(name = "kpp", column = @Column(name = "payer_kpp")),
            @AttributeOverride(name = "name", column = @Column(name = "payer_name"))
    })
    private ParticipantInfo payerInfo;

    @NotNull
    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "BAcc", column = @Column(name = "payer_bank_account")),
            @AttributeOverride(name = "bic", column = @Column(name = "payer_bic")),
            @AttributeOverride(name = "TAcc", column = @Column(name = "payer_treasury_account"))
    })
    private BankInfo bankPayerInfo;

    @NotNull
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "inn", column = @Column(name = "receiver_inn")),
            @AttributeOverride(name = "kpp", column = @Column(name = "receiver_kpp")),
            @AttributeOverride(name = "name", column = @Column(name = "receiver_name"))
    })
    private ParticipantInfo receiverInfo;

    @NotNull
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "BAcc", column = @Column(name = "receiver_bank_account")),
            @AttributeOverride(name = "bic", column = @Column(name = "receiver_bic")),
            @AttributeOverride(name = "TAcc", column = @Column(name = "receiver_treasury_account"))
    })
    private BankInfo bankReceiverInfo;

    @NotNull
    @Column(name = "purpose")
    private String purpose;

    public Document() {

    }

    public String getPurpose() {
        return purpose;
    }

    public Long getDocNum() {
        return docNum;
    }

    public Date getDocDate() {
        return docDate;
    }

    public String getDocGUID() {
        return docGUID;
    }

    public Integer getOperType() {
        return operType;
    }

    public Double getAmountOut() {
        return amountOut;
    }

    public ParticipantInfo getPayerInfo() {
        return payerInfo;
    }

    public BankInfo getBankPayerInfo() {
        return bankPayerInfo;
    }

    public ParticipantInfo getReceiverInfo() {
        return receiverInfo;
    }

    public BankInfo getBankReceiverInfo() {
        return bankReceiverInfo;
    }

    public void setDocNum(Long docNum) {
        this.docNum = docNum;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public void setDocGUID(String docGUID) {
        this.docGUID = docGUID;
    }

    public void setOperType(Integer operType) {
        this.operType = operType;
    }

    public void setAmountOut(Double amountOut) {
        this.amountOut = amountOut;
    }

    public void setPayerInfo(ParticipantInfo payerInfo) {
        this.payerInfo = payerInfo;
    }

    public void setBankPayerInfo(BankInfo bankPayerInfo) {
        this.bankPayerInfo = bankPayerInfo;
    }

    public void setReceiverInfo(ParticipantInfo receiverInfo) {
        this.receiverInfo = receiverInfo;
    }

    public void setBankReceiverInfo(BankInfo bankReceiverInfo) {
        this.bankReceiverInfo = bankReceiverInfo;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    @Override
    public String toString() {
        return "Document{" +
                "docNum=" + docNum +
                ", docDate=" + docDate +
                ", docGUID='" + docGUID + '\'' +
                ", operType=" + operType +
                ", amountOut=" + amountOut +
                ", payerInfo=" + payerInfo +
                ", bankPayerInfo=" + bankPayerInfo +
                ", receiverInfo=" + receiverInfo +
                ", bankReceiverInfo=" + bankReceiverInfo +
                ", purpose='" + purpose + '\'' +
                '}';
    }
}
