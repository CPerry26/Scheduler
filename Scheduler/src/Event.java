/*
 * This class represents a generic event.
 * Getter and setter methods are defined to simplify code across all files.
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
	 * @param String title - Event title.
	 * @param String start_time - Event start time.
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
	 * @param none
	 * 
	 * @return none
	 */
	public String get_event_title() {
		return event_title;
	}
	
	/*
	 * This method gets and returns the event start time.
	 * 
	 * @param none
	 * 
	 * @return none
	 */
	public String get_event_start_time() {
		return event_start_time;
	}
	
	/*
	 * This method gets and returns the event duration.
	 * 
	 * @param none
	 * 
	 * @return none
	 */
	public int get_event_duration() {
		return event_duration;
	}
	
	/*
	 * This method alters the event title. It is only used if the current title
	 * is being changed.
	 * 
	 * @param String new_title - The new title of the event.
	 * 
	 * @return none
	 */
	public void set_event_title(String new_title) {
		event_title = new_title;
	}
	
	/*
	 * This method alters the event start time. It is only used if the current
	 * start time is being changed.
	 * 
	 * @param String new_start_time - The new start time of the event.
	 * 
	 * @return none
	 */
	public void set_event_start_time(String new_start_time) {
		event_start_time = new_start_time;
	}
	
	/*
	 * This method alters the event duration. It is only used if the current
	 * duration is being changed.
	 * 
	 * @param int new_duration - The new duration of the event.
	 * 
	 * @return none
	 */
	public void set_event_duration(int new_duration) {
		event_duration = new_duration;
	}
	
	/*
	 * This method handles the actions necessary to display an event. They
	 * are not unique to any events.
	 * 
	 * @param none
	 * 
	 * @return none
	 */
	public void display_event() {
		System.out.println("Event title: " + event_title);
		System.out.println("Event start time: " + event_start_time);
		System.out.println("Event duration: " + event_duration + "\n");
	}

}
