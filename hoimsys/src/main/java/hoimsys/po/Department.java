package hoimsys.po;

public class Department {
    private Integer dtId;

    private String dtName;

    private String dtMobile;

    private String dtRoomNumber;

    private String dtInfo;

    private String dtImg;

    public Integer getDtId() {
        return dtId;
    }

    public void setDtId(Integer dtId) {
        this.dtId = dtId;
    }

    public String getDtName() {
        return dtName;
    }

    public void setDtName(String dtName) {
        this.dtName = dtName == null ? null : dtName.trim();
    }

    public String getDtMobile() {
        return dtMobile;
    }

    public void setDtMobile(String dtMobile) {
        this.dtMobile = dtMobile == null ? null : dtMobile.trim();
    }

    public String getDtRoomNumber() {
        return dtRoomNumber;
    }

    public void setDtRoomNumber(String dtRoomNumber) {
        this.dtRoomNumber = dtRoomNumber == null ? null : dtRoomNumber.trim();
    }

    public String getDtInfo() {
        return dtInfo;
    }

    public void setDtInfo(String dtInfo) {
        this.dtInfo = dtInfo == null ? null : dtInfo.trim();
    }

    public String getDtImg() {
        return dtImg;
    }

    public void setDtImg(String dtImg) {
        this.dtImg = dtImg == null ? null : dtImg.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dtId=").append(dtId);
        sb.append(", dtName=").append(dtName);
        sb.append(", dtMobile=").append(dtMobile);
        sb.append(", dtRoomNumber=").append(dtRoomNumber);
        sb.append(", dtInfo=").append(dtInfo);
        sb.append(", dtImg=").append(dtImg);
        sb.append("]");
        return sb.toString();
    }
}