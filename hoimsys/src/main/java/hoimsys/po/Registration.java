package hoimsys.po;

import java.math.BigDecimal;
import java.util.Date;

public class Registration {
    private Integer rId;

    private Integer pId;

    private Integer dtId;

    private Integer dId;

    private Date rDate;

    private BigDecimal rFee;

    private Integer psId;

    private String rInfo;

    private String rRemark;

    private String rPayNumber;

    private Integer rStatus;

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getDtId() {
        return dtId;
    }

    public void setDtId(Integer dtId) {
        this.dtId = dtId;
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public Date getrDate() {
        return rDate;
    }

    public void setrDate(Date rDate) {
        this.rDate = rDate;
    }

    public BigDecimal getrFee() {
        return rFee;
    }

    public void setrFee(BigDecimal rFee) {
        this.rFee = rFee;
    }

    public Integer getPsId() {
        return psId;
    }

    public void setPsId(Integer psId) {
        this.psId = psId;
    }

    public String getrInfo() {
        return rInfo;
    }

    public void setrInfo(String rInfo) {
        this.rInfo = rInfo == null ? null : rInfo.trim();
    }

    public String getrRemark() {
        return rRemark;
    }

    public void setrRemark(String rRemark) {
        this.rRemark = rRemark == null ? null : rRemark.trim();
    }

    public String getrPayNumber() {
        return rPayNumber;
    }

    public void setrPayNumber(String rPayNumber) {
        this.rPayNumber = rPayNumber == null ? null : rPayNumber.trim();
    }

    public Integer getrStatus() {
        return rStatus;
    }

    public void setrStatus(Integer rStatus) {
        this.rStatus = rStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", rId=").append(rId);
        sb.append(", pId=").append(pId);
        sb.append(", dtId=").append(dtId);
        sb.append(", dId=").append(dId);
        sb.append(", rDate=").append(rDate);
        sb.append(", rFee=").append(rFee);
        sb.append(", psId=").append(psId);
        sb.append(", rInfo=").append(rInfo);
        sb.append(", rRemark=").append(rRemark);
        sb.append(", rPayNumber=").append(rPayNumber);
        sb.append(", rStatus=").append(rStatus);
        sb.append("]");
        return sb.toString();
    }
}