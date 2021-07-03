package test.task.model;

import java.util.Date;

public class DocumentPOJO {
    private String docGUID;

    private Long docNum;

    private Date docDate;

    private Integer operType;

    private Double amountOut;

    private ParticipantInfo payerInfo;

    private BankInfo bankPayerInfo;

    private ParticipantInfo receiverInfo;

    private BankInfo bankReceiverInfo;

    private String purpose;

    public String getDocGUID() {
        return docGUID;
    }

    public void setDocGUID(String docGUID) {
        this.docGUID = docGUID;
    }

    public Long getDocNum() {
        return docNum;
    }

    public void setDocNum(Long docNum) {
        this.docNum = docNum;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public Integer getOperType() {
        return operType;
    }

    public void setOperType(Integer operType) {
        this.operType = operType;
    }

    public Double getAmountOut() {
        return amountOut;
    }

    public void setAmountOut(Double amountOut) {
        this.amountOut = amountOut;
    }

    public ParticipantInfo getPayerInfo() {
        return payerInfo;
    }

    public void setPayerInfo(ParticipantInfo payerInfo) {
        this.payerInfo = payerInfo;
    }

    public BankInfo getBankPayerInfo() {
        return bankPayerInfo;
    }

    public void setBankPayerInfo(BankInfo bankPayerInfo) {
        this.bankPayerInfo = bankPayerInfo;
    }

    public ParticipantInfo getReceiverInfo() {
        return receiverInfo;
    }

    public void setReceiverInfo(ParticipantInfo receiverInfo) {
        this.receiverInfo = receiverInfo;
    }

    public BankInfo getBankReceiverInfo() {
        return bankReceiverInfo;
    }

    public void setBankReceiverInfo(BankInfo bankReceiverInfo) {
        this.bankReceiverInfo = bankReceiverInfo;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}
