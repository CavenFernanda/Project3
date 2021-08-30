package DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import Validate.ObjectValidatorException;



public class DateUtils {
	
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	// ------------------Checks Date Formation
	/*
	 * 1. Format 2. Null
	 */

	public static String formatDate(Calendar cal) {

		if (cal == null) {
			return " ";
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			return sdf.format(cal.getTime());
		}
	}

	// Date is Valid

	/*
	 * 1. If is formated correct
	 * 
	 */

	public static boolean isValidDate(String dob) {
		boolean isFormated = false;

		try {
			sdf.parse(dob);
			sdf.setLenient(false);
			isFormated = true;

		} catch (ParseException e) {
			System.out.println("The date is invalid please enter a valid date according yyyy-mm-dd");
			isFormated = false;

		}
		return isFormated;
	}

	public static Calendar setDates(String string) throws ObjectValidatorException ,ParseException{
		Calendar calDate = Calendar.getInstance();

		try {

			java.util.Date d = sdf.parse(string);
			calDate.setTime(d);
			return calDate;

		} catch (ParseException e) {
			System.out.println("The date is invalid please enter a valid date according yyyy-mm-dd");
			throw new ObjectValidatorException();
		}
	
	}
}

