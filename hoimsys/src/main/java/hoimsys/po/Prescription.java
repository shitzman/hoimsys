package hoimsys.po;

public class Prescription {
    private Integer psId;

    private Integer mId;

    private Long psPrice;

    private Integer psNumber;

    private String psPayNumber;

    private String psRemark;

    private String psStatus;

    private Integer pId;

    public Integer getPsId() {
        return psId;
    }

    public void setPsId(Integer psId) {
        this.psId = psId;
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public Long getPsPrice() {
        return psPrice;
    }

    public void setPsPrice(Long psPrice) {
        this.psPrice = psPrice;
    }

    public Integer getPsNumber() {
        return psNumber;
    }

    public void setPsNumber(Integer psNumber) {
        this.psNumber = psNumber;
    }

    public String getPsPayNumber() {
        return psPayNumber;
    }

    public void setPsPayNumber(String psPayNumber) {
        this.psPayNumber = psPayNumber == null ? null : psPayNumber.trim();
    }

    public String getPsRemark() {
        return psRemark;
    }

    public void setPsRemark(String psRemark) {
        this.psRemark = psRemark == null ? null : psRemark.trim();
    }

    public String getPsStatus() {
        return psStatus;
    }

    public void setPsStatus(String psStatus) {
        this.psStatus = psStatus == null ? null : psStatus.trim();
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", psId=").append(psId);
        sb.append(", mId=").append(mId);
        sb.append(", psPrice=").append(psPrice);
        sb.append(", psNumber=").append(psNumber);
        sb.append(", psPayNumber=").append(psPayNumber);
        sb.append(", psRemark=").append(psRemark);
        sb.append(", psStatus=").append(psStatus);
        sb.append(", pId=").append(pId);
        sb.append("]");
        return sb.toString();
    }
}