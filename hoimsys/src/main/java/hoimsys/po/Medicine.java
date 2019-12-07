package hoimsys.po;

public class Medicine {
    private Integer mId;

    private String mName;

    private String mBrand;

    private String mSpecifications;

    private String mType;

    private Long mPrice;

    private String mRemark;

    private String mImg;

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName == null ? null : mName.trim();
    }

    public String getmBrand() {
        return mBrand;
    }

    public void setmBrand(String mBrand) {
        this.mBrand = mBrand == null ? null : mBrand.trim();
    }

    public String getmSpecifications() {
        return mSpecifications;
    }

    public void setmSpecifications(String mSpecifications) {
        this.mSpecifications = mSpecifications == null ? null : mSpecifications.trim();
    }

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType == null ? null : mType.trim();
    }

    public Long getmPrice() {
        return mPrice;
    }

    public void setmPrice(Long mPrice) {
        this.mPrice = mPrice;
    }

    public String getmRemark() {
        return mRemark;
    }

    public void setmRemark(String mRemark) {
        this.mRemark = mRemark == null ? null : mRemark.trim();
    }

    public String getmImg() {
        return mImg;
    }

    public void setmImg(String mImg) {
        this.mImg = mImg == null ? null : mImg.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", mId=").append(mId);
        sb.append(", mName=").append(mName);
        sb.append(", mBrand=").append(mBrand);
        sb.append(", mSpecifications=").append(mSpecifications);
        sb.append(", mType=").append(mType);
        sb.append(", mPrice=").append(mPrice);
        sb.append(", mRemark=").append(mRemark);
        sb.append(", mImg=").append(mImg);
        sb.append("]");
        return sb.toString();
    }
}