package hoimsys.po;

import java.util.Date;

public class Storage {
    private Integer sId;

    private Integer mId;

    private Long sInPrice;

    private Integer sNumber;

    private String sLocation;

    private Date sInTime;

    private Integer sLastDays;

    private Integer dId;

    private Long sOutPrice;

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public Long getsInPrice() {
        return sInPrice;
    }

    public void setsInPrice(Long sInPrice) {
        this.sInPrice = sInPrice;
    }

    public Integer getsNumber() {
        return sNumber;
    }

    public void setsNumber(Integer sNumber) {
        this.sNumber = sNumber;
    }

    public String getsLocation() {
        return sLocation;
    }

    public void setsLocation(String sLocation) {
        this.sLocation = sLocation == null ? null : sLocation.trim();
    }

    public Date getsInTime() {
        return sInTime;
    }

    public void setsInTime(Date sInTime) {
        this.sInTime = sInTime;
    }

    public Integer getsLastDays() {
        return sLastDays;
    }

    public void setsLastDays(Integer sLastDays) {
        this.sLastDays = sLastDays;
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public Long getsOutPrice() {
        return sOutPrice;
    }

    public void setsOutPrice(Long sOutPrice) {
        this.sOutPrice = sOutPrice;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sId=").append(sId);
        sb.append(", mId=").append(mId);
        sb.append(", sInPrice=").append(sInPrice);
        sb.append(", sNumber=").append(sNumber);
        sb.append(", sLocation=").append(sLocation);
        sb.append(", sInTime=").append(sInTime);
        sb.append(", sLastDays=").append(sLastDays);
        sb.append(", dId=").append(dId);
        sb.append(", sOutPrice=").append(sOutPrice);
        sb.append("]");
        return sb.toString();
    }
}