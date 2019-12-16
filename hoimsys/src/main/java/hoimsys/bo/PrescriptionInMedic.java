package hoimsys.bo;

import hoimsys.po.Medicine;

/*
 * 	废弃
 */
public class PrescriptionInMedic {

	 	private Integer psId;

	    private Integer mId;

	    private Long psPrice;

	    private Integer psNumber;

	    private String psPayNumber;

	    private String psRemark;

	    private String psStatus;

	    private Integer pId;
	    
	    private Medicine medicine;

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
			this.psPayNumber = psPayNumber;
		}

		public String getPsRemark() {
			return psRemark;
		}

		public void setPsRemark(String psRemark) {
			this.psRemark = psRemark;
		}

		public String getPsStatus() {
			return psStatus;
		}

		public void setPsStatus(String psStatus) {
			this.psStatus = psStatus;
		}

		public Integer getpId() {
			return pId;
		}

		public void setpId(Integer pId) {
			this.pId = pId;
		}

		public Medicine getMedicine() {
			return medicine;
		}

		public void setMedicine(Medicine medicine) {
			this.medicine = medicine;
		}

		@Override
		public String toString() {
			return "PrescriptionInMedic [psId=" + psId + ", mId=" + mId + ", psPrice=" + psPrice + ", psNumber="
					+ psNumber + ", psPayNumber=" + psPayNumber + ", psRemark=" + psRemark + ", psStatus=" + psStatus
					+ ", pId=" + pId + ", medicine=" + medicine + "]";
		}
	    
	    
}
