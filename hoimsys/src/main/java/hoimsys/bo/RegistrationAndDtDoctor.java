package hoimsys.bo;

import hoimsys.po.Registration;

public class RegistrationAndDtDoctor {
	
		//订单信息
	 	private Registration registration;
	    //该订单负责医生详情信息，包含有医生信息以及医生职称和医生科室对象；
	    private DtDoctor dtDoctor;
		public RegistrationAndDtDoctor(Registration registration, DtDoctor dtDoctor) {
			super();
			this.registration = registration;
			this.dtDoctor = dtDoctor;
		}
		public RegistrationAndDtDoctor() {
			super();
		}
		public Registration getRegistration() {
			return registration;
		}
		public void setRegistration(Registration registration) {
			this.registration = registration;
		}
		public DtDoctor getDtDoctor() {
			return dtDoctor;
		}
		public void setDtDoctor(DtDoctor dtDoctor) {
			this.dtDoctor = dtDoctor;
		}
		@Override
		public String toString() {
			return "RegistrationAndDtDoctor [registration=" + registration + ", dtDoctor=" + dtDoctor + "]";
		}
	    
	    

}
