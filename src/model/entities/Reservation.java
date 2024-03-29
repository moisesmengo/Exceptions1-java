package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private Integer roonNumber;
	private Date checkIn;
	private Date CheckOut;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roonNumber, Date checkIn, Date checkOut) {
		this.roonNumber = roonNumber;
		this.checkIn = checkIn;
		CheckOut = checkOut;
	}
	
	public Integer getRoonNumber() {
		return roonNumber;
	}
	
	public void setRoonNumber(Integer roonNumber) {
		this.roonNumber = roonNumber;
	}
	
	public Date getCheckIn() {
		return checkIn;
	}
	
	public Date getCheckOut() {
		return CheckOut;
	}
	
	public long duration() {
		long diff = CheckOut.getTime() - checkIn.getTime(); //diferenša entre as datas em milesegundos
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public String updateDates(Date checkIn, Date checkOut) {	
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			return "Reservation dates for update must be future dates";
		}if (!checkOut.after(checkIn)) {
			return "Check-out date must be after check-in date";
		} 

		this.checkIn = checkIn;
		this.CheckOut = checkOut;
		return null;
	}
	
	@Override
	public String toString() {
		return "Roon "
			+ roonNumber
			+ ", check-in: "
			+ sdf.format(checkIn)
			+ ", check-out: "
			+ sdf.format(CheckOut)
			+ ", "
			+ duration()
			+ " nights";
	}
}
