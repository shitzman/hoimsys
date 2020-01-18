package hoimsys.bo;

import java.util.Map;

/*
 *	医生填写挂号单信息对象
 */
public class DoctorUpdateReg {
	
	private Integer rId; 	//药单编号；
	private Integer psId;	//药单编号
	private String rInfo;	//简要概述
	private String rRemarks;	//详情
	private Map<Integer,Integer> pres; //药品列表，<药品id,药品数量>;
	public Integer getrId() {
		return rId;
	}
	public void setrId(Integer rId) {
		this.rId = rId;
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
		this.rInfo = rInfo;
	}
	public String getrRemarks() {
		return rRemarks;
	}
	public void setrRemarks(String rRemarks) {
		this.rRemarks = rRemarks;
	}
	public Map<Integer, Integer> getPres() {
		return pres;
	}
	public void setPres(Map<Integer, Integer> pres) {
		this.pres = pres;
	}
	public DoctorUpdateReg(Integer rId, Integer psId, String rInfo, String rRemarks, Map<Integer, Integer> pres) {
		super();
		this.rId = rId;
		this.psId = psId;
		this.rInfo = rInfo;
		this.rRemarks = rRemarks;
		this.pres = pres;
	}
	public DoctorUpdateReg() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "DoctorUpdateReg [rId=" + rId + ", psId=" + psId + ", rInfo=" + rInfo + ", rRemarks=" + rRemarks
				+ ", pres=" + pres + "]";
	}
	
	
	

}
