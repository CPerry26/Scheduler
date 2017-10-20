/*
 * This class represents a generic event.
 * Getter methods are used to get attributes of the event.
 * @author Cody Perry (CPerry26)
 */
public class Event {
	// Private data members
	private String event_title;
	private String event_start_time;
	private int event_duration;
	
	/*
	 * This is the constructor for an event object.
	 * 
	 * @args String title - event title
	 * @args String start_time - event start time
	 * 
	 * @return none
	 */
	public Event(String title, String start_time, int duration) {
		event_title = title;
		event_start_time = start_time;
		event_duration = duration;
	}
	
	/*
	 * This method gets and returns the event title.
	 * 
	 * @args none
	 * 
	 * @return none
	 */
	public String get_event_title() {
		return event_title;
	}
	
	/*
	 * This method gets and returns the event start time.
	 * 
	 * @args none
	 * 
	 * @return none
	 */
	public String get_event_start_time() {
		return event_start_time;
	}
	
	/*
	 * This method gets and returns the event duration.
	 * 
	 * @args none
	 * 
	 * @return none
	 */
	public int get_event_duration() {
		return event_duration;
	}

}
