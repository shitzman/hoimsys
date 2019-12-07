package hoimsys.po;

import java.util.Date;

public class Patient {
    private Integer pId;

    private String pMobile;

    private String pPassword;

    private String pName;

    private String pSex;

    private Date pBirthday;

    private String pIdCard;

    private String pAddress;

    private Integer pStatus;

    private String pImg;

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getpMobile() {
        return pMobile;
    }

    public void setpMobile(String pMobile) {
        this.pMobile = pMobile == null ? null : pMobile.trim();
    }

    public String getpPassword() {
        return pPassword;
    }

    public void setpPassword(String pPassword) {
        this.pPassword = pPassword == null ? null : pPassword.trim();
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    public String getpSex() {
        return pSex;
    }

    public void setpSex(String pSex) {
        this.pSex = pSex == null ? null : pSex.trim();
    }

    public Date getpBirthday() {
        return pBirthday;
    }

    public void setpBirthday(Date pBirthday) {
        this.pBirthday = pBirthday;
    }

    public String getpIdCard() {
        return pIdCard;
    }

    public void setpIdCard(String pIdCard) {
        this.pIdCard = pIdCard == null ? null : pIdCard.trim();
    }

    public String getpAddress() {
        return pAddress;
    }

    public void setpAddress(String pAddress) {
        this.pAddress = pAddress == null ? null : pAddress.trim();
    }

    public Integer getpStatus() {
        return pStatus;
    }

    public void setpStatus(Integer pStatus) {
        this.pStatus = pStatus;
    }

    public String getpImg() {
        return pImg;
    }

    public void setpImg(String pImg) {
        this.pImg = pImg == null ? null : pImg.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pId=").append(pId);
        sb.append(", pMobile=").append(pMobile);
        sb.append(", pPassword=").append(pPassword);
        sb.append(", pName=").append(pName);
        sb.append(", pSex=").append(pSex);
        sb.append(", pBirthday=").append(pBirthday);
        sb.append(", pIdCard=").append(pIdCard);
        sb.append(", pAddress=").append(pAddress);
        sb.append(", pStatus=").append(pStatus);
        sb.append(", pImg=").append(pImg);
        sb.append("]");
        return sb.toString();
    }
}