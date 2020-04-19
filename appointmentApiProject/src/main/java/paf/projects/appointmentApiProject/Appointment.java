package paf.projects.appointmentApiProject;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Appointment {
	private int AppointmentID;
	private String AppointmentCode;
	private String DoctorName;
	private String PatientName;
	private String AppointmentDate;
	public int getAppointmentID() {
		return AppointmentID;
	}
	public void setAppointmentID(int appointmentID) {
		AppointmentID = appointmentID;
	}
	public String getAppointmentCode() {
		return AppointmentCode;
	}
	public void setAppointmentCode(String appointmentCode) {
		AppointmentCode = appointmentCode;
	}
	public String getDoctorName() {
		return DoctorName;
	}
	public void setDoctorName(String doctorName) {
		DoctorName = doctorName;
	}
	public String getPatientName() {
		return PatientName;
	}
	public void setPatientName(String patientName) {
		PatientName = patientName;
	}
	public String getAppointmentDate() {
		return AppointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		AppointmentDate = appointmentDate;
	}
	
	
}
