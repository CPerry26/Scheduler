import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

/*
 * Custom time comparator object to sort event list.
 * 
 * @author Cody Perry (CPerry26)
 */
public class TimeComparator implements Comparator<Event> {

	/*
	 * This is a custom compare method for two given events.
	 * It sorts on whichever event occurs the earliest.
	 * @param Event first_event - The first event in the comparison.
	 * @param Event second_event - The second event in the comparison.
	 * 
	 * @return int - 0 if dates are the same, 1 if the first is later and < 0
	 * otherwise
	 * 
	 * (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(Event first_event, Event second_event) {
		// Generic initialization to avoid errors if neither variable gets
		// initialized in the try block and no error is thrown.
		Date first_date = new Date();
		Date second_date = new Date();
		
		// Setup date format.
		DateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		
		// Try to format the dates for comparison.
		try {
			first_date = format.parse(first_event.get_event_start_time()); 
			second_date = format.parse(second_event.get_event_start_time());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		// Return which occurs earlier.
		return first_date.compareTo(second_date);
	}

}
