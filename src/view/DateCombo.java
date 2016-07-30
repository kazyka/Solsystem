package view;

import model.JulianToGregorian;

/**
 * Has a Julian Date and shows it as a Gregorian date
 */
public class DateCombo extends JulianToGregorian {
	
	private double julianDate;
	
	public DateCombo(double julianDate){
		this.julianDate = julianDate;
	}
	
	public double getValue(){
		return julianDate;
	}
	
	public String toString(){
		return JulianToGregorian.convert(julianDate);
	}

}
