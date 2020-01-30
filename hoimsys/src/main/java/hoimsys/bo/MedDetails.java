package hoimsys.bo;
/*
 * 	 药品详情对象
 *	药品管理员根据药单id获取此对象列表
 *	底层对象，Prescription与Medicine对象字段的组合；
 */
public class MedDetails {
	
	private Integer psId;	//药单编号

    private Integer mId;	//药品id

    private Long psPrice;	//药品单价

    private Integer psNumber;	//数量
    
    private String mName;	//药品名称

    private String mBrand;	//品牌

    private String mSpecifications;	//规格

    private String mType;	//类别

    private String mImg;	//图片路径

	public MedDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MedDetails(Integer psId, Integer mId, Long psPrice, Integer psNumber, String mName, String mBrand,
			String mSpecifications, String mType, String mImg) {
		super();
		this.psId = psId;
		this.mId = mId;
		this.psPrice = psPrice;
		this.psNumber = psNumber;
		this.mName = mName;
		this.mBrand = mBrand;
		this.mSpecifications = mSpecifications;
		this.mType = mType;
		this.mImg = mImg;
	}

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

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmBrand() {
		return mBrand;
	}

	public void setmBrand(String mBrand) {
		this.mBrand = mBrand;
	}

	public String getmSpecifications() {
		return mSpecifications;
	}

	public void setmSpecifications(String mSpecifications) {
		this.mSpecifications = mSpecifications;
	}

	public String getmType() {
		return mType;
	}

	public void setmType(String mType) {
		this.mType = mType;
	}

	public String getmImg() {
		return mImg;
	}

	public void setmImg(String mImg) {
		this.mImg = mImg;
	}

	@Override
	public String toString() {
		return "MedDetails [psId=" + psId + ", mId=" + mId + ", psPrice=" + psPrice + ", psNumber=" + psNumber
				+ ", mName=" + mName + ", mBrand=" + mBrand + ", mSpecifications=" + mSpecifications + ", mType="
				+ mType + ", mImg=" + mImg + "]";
	}
    

}
