package test.task.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "document")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id",unique = true, nullable = false,insertable = true,updatable = false)
    private Long id;

    @Column(name = "doc_guid")
    private String docGUID;

    @NotNull
    @Column(name = "doc_num")
    private Long docNum;

    @NotNull
    @Column(name = "doc_date")
    private Date docDate;

    @NotNull
    @Column(name = "oper_type")
    private Integer operType;

    @NotNull
    @Column(name = "amount_out")
    private Double amountOut;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="payer_id",referencedColumnName = "id",nullable = false)
    private ParticipantInfo payerInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="payer_bank_id",referencedColumnName = "id",nullable = false)
    private BankInfo bankPayerInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="receiver_id",referencedColumnName = "id",nullable = false)
    private ParticipantInfo receiverInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="receiver_bank_id",referencedColumnName = "id",nullable = false)
    private BankInfo bankReceiverInfo;

    @NotNull
    @Column(name = "purpose")
    private String purpose;

    public Document(String docGUID,Long docNum,Date docDate,Integer operType,Double amountOut,ParticipantInfo payerInfo,BankInfo bankPayerInfo,ParticipantInfo receiverInfo,BankInfo bankReceiverInfo,String purpose) {
        this.docGUID=docGUID;
        this.docNum=docNum;
        this.docDate=docDate;
        this.operType=operType;
        this.amountOut=amountOut;
        this.payerInfo=payerInfo;
        this.bankPayerInfo=bankPayerInfo;
        this.receiverInfo=receiverInfo;
        this.bankReceiverInfo=bankReceiverInfo;
    }

    public Document() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
