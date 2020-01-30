package hoimsys.bo;

import java.sql.Timestamp;
import java.util.Date;

/*
 * 医生登录后待处理以及已处理病人挂号单信息对象
 */
public class DoctorRegAndPat {

	
	private String pName;	//病人姓名

    private String pSex;	//病人性别

    private Date pBirthday;	//病人身份证号
    
    private String pImg;	//病人照片路径
    
    private Integer rId;	//挂号单编号
    
    private Timestamp rDate;	//挂号日期
    
    private Integer rStatus;	//挂号单状态
    
    private String rInfo;	//挂号病因简介

    private String rRemark;	//挂号病因详情
    
    private Integer psId; //药单编号（为药品管理员新增）
    

	public Integer getPsId() {
		return psId;
	}

	public void setPsId(Integer psId) {
		this.psId = psId;
	}

	public DoctorRegAndPat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DoctorRegAndPat(String pName, String pSex, Date pBirthday, String pImg, Integer rId, Timestamp rDate,
			Integer rStatus, String rInfo, String rRemark) {
		super();
		this.pName = pName;
		this.pSex = pSex;
		this.pBirthday = pBirthday;
		this.pImg = pImg;
		this.rId = rId;
		this.rDate = rDate;
		this.rStatus = rStatus;
		this.rInfo = rInfo;
		this.rRemark = rRemark;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpSex() {
		return pSex;
	}

	public void setpSex(String pSex) {
		this.pSex = pSex;
	}

	public Date getpBirthday() {
		return pBirthday;
	}

	public void setpBirthday(Date pBirthday) {
		this.pBirthday = pBirthday;
	}

	public String getpImg() {
		return pImg;
	}

	public void setpImg(String pImg) {
		this.pImg = pImg;
	}

	public Integer getrId() {
		return rId;
	}

	public void setrId(Integer rId) {
		this.rId = rId;
	}

	public Timestamp getrDate() {
		return rDate;
	}

	public void setrDate(Timestamp rDate) {
		this.rDate = rDate;
	}

	public Integer getrStatus() {
		return rStatus;
	}

	public void setrStatus(Integer rStatus) {
		this.rStatus = rStatus;
	}

	public String getrInfo() {
		return rInfo;
	}

	public void setrInfo(String rInfo) {
		this.rInfo = rInfo;
	}

	public String getrRemark() {
		return rRemark;
	}

	public void setrRemark(String rRemark) {
		this.rRemark = rRemark;
	}

	@Override
	public String toString() {
		return "DoctorRegAndPat [pName=" + pName + ", pSex=" + pSex + ", pBirthday=" + pBirthday + ", pImg=" + pImg
				+ ", rId=" + rId + ", rDate=" + rDate + ", rStatus=" + rStatus + ", rInfo=" + rInfo + ", rRemark="
				+ rRemark + ", psId=" + psId + "]";
	}

	
    
    
}
