package hoimsys.po;

public class Doctor {
    private Integer dId;

    private Integer dtId;

    private Integer tId;

    private String dName;

    private String dSex;

    private String dMobile;

    private String dPassword;

    private Integer dLimitsNumber;

    private String dImg;

    private String dInfo;

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public Integer getDtId() {
        return dtId;
    }

    public void setDtId(Integer dtId) {
        this.dtId = dtId;
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName == null ? null : dName.trim();
    }

    public String getdSex() {
        return dSex;
    }

    public void setdSex(String dSex) {
        this.dSex = dSex == null ? null : dSex.trim();
    }

    public String getdMobile() {
        return dMobile;
    }

    public void setdMobile(String dMobile) {
        this.dMobile = dMobile == null ? null : dMobile.trim();
    }

    public String getdPassword() {
        return dPassword;
    }

    public void setdPassword(String dPassword) {
        this.dPassword = dPassword == null ? null : dPassword.trim();
    }

    public Integer getdLimitsNumber() {
        return dLimitsNumber;
    }

    public void setdLimitsNumber(Integer dLimitsNumber) {
        this.dLimitsNumber = dLimitsNumber;
    }

    public String getdImg() {
        return dImg;
    }

    public void setdImg(String dImg) {
        this.dImg = dImg == null ? null : dImg.trim();
    }

    public String getdInfo() {
        return dInfo;
    }

    public void setdInfo(String dInfo) {
        this.dInfo = dInfo == null ? null : dInfo.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dId=").append(dId);
        sb.append(", dtId=").append(dtId);
        sb.append(", tId=").append(tId);
        sb.append(", dName=").append(dName);
        sb.append(", dSex=").append(dSex);
        sb.append(", dMobile=").append(dMobile);
        sb.append(", dPassword=").append(dPassword);
        sb.append(", dLimitsNumber=").append(dLimitsNumber);
        sb.append(", dImg=").append(dImg);
        sb.append(", dInfo=").append(dInfo);
        sb.append("]");
        return sb.toString();
    }
}