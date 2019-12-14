package hoimsys.bo;

import hoimsys.po.Department;
import hoimsys.po.Title;

public class DtDoctor {
	
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
	    
	    private Title title;//医生职称信息
	    
	    private Department department;//医生科室信息
	    
	    private Integer regNumbers;

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

		public Title getTitle() {
			return title;
		}

		public void setTitle(Title title) {
			this.title = title;
		}

		public Department getDepartment() {
			return department;
		}

		public void setDepartment(Department department) {
			this.department = department;
		}
		
		

		public Integer getRegNumbers() {
			return regNumbers;
		}

		public void setRegNumbers(Integer regNumbers) {
			this.regNumbers = regNumbers;
		}

		@Override
		public String toString() {
			return "DtDoctor [dId=" + dId + ", dtId=" + dtId + ", tId=" + tId + ", dName=" + dName + ", dSex=" + dSex
					+ ", dMobile=" + dMobile + ", dPassword=" + dPassword + ", dLimitsNumber=" + dLimitsNumber
					+ ", dImg=" + dImg + ", dInfo=" + dInfo + ", title=" + title + ", department=" + department
					+ ", regNumbers=" + regNumbers + "]";
		}

}
