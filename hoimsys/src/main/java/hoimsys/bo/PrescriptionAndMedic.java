package hoimsys.bo;

import hoimsys.po.Medicine;
import hoimsys.po.Prescription;

public class PrescriptionAndMedic {
	
	private Prescription prescription;
	
	private Medicine medicine;
	

	public PrescriptionAndMedic() {
		super();
	}

	public PrescriptionAndMedic(Prescription prescription, Medicine medicine) {
		super();
		this.prescription = prescription;
		this.medicine = medicine;
	}

	public Prescription getPrescription() {
		return prescription;
	}

	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}

	public Medicine getMedicine() {
		return medicine;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}

	@Override
	public String toString() {
		return "PrescriptionAndMedic [prescription=" + prescription + ", medicine=" + medicine + "]";
	}
	
	

}
