import java.util.ArrayList;
import java.util.Scanner;

/*
 * Java scheduling program.
 * Provides the following functionality:
 * - Add event
 * - Edit event
 * - Display event
 * - Delete event
 * 
 * @author Cody Perry (CPerry26)
 */
public class Scheduler {
	// List of events
	private static ArrayList<Event> event_list = new ArrayList<Event>();
	
	/*
	 * This method creates a new event and adds it to the event list.
	 * 
	 * @param String title - title of event
	 * @param String start_time - starting time of event
	 * @param int duration - length of event
	 * 
	 * @return none
	 */
	public static void new_event(String title, String start_time, int duration) {
		Event new_event = new Event(title, start_time, duration);
		event_list.add(new_event);
		event_list.sort(new TimeComparator());
	}
	
	/*
	 * This method edits a given event with a set of changes.
	 * 
	 * @param Event event - event to edit
	 * @param String[] changes - array of changes to make
	 * 
	 * @return none
	 */
	public static void edit_event(Event event, String new_title, 
								String new_start_time, int new_duration) {
		
		String title = event.get_event_title();
		
		for(int i = 0; i < event_list.size(); i++) {
			
			if(title.equals(event_list.get(i).get_event_title())) {
				event_list.get(i).set_event_title(new_title);
				event_list.get(i).set_event_start_time(new_start_time);
				event_list.get(i).set_event_duration(new_duration);
				break;
			}
		}
	}
	
	/*
	 * This method removes an event from the event list.
	 * 
	 * @param Event event - Event to delete
	 * 
	 * @return none
	 */
	public static void delete_event(Event event) {
		String title = event.get_event_title();
		
		for(int i = 0; i < event_list.size(); i++){
			if(title.equals(event_list.get(i).get_event_title())) {
				event_list.remove(i);
				break;
			}
		}
	}

	/**
	 * This is the entry point for the Scheduler application. It handles all
	 * logic for running the application.
	 * 
	 * @param String[] args - Command line arguments.
	 * 
	 * @return none
	 */
	public static void main(String[] args) {
		
		while(true) {
			// Loop indefinitely for command line input unless exit option is
			// entered.
			System.out.println("1. New event\n2. Edit event\n3. Display event\n4. Delete event\n5. Exit\n");
			Scanner scanner = new Scanner(System.in);
			String line = scanner.next();
			System.out.println(line.length());
			
			// Creating a new event.
			if(line.equals("1")) {
				System.out.println("Event title: ");
				String title = scanner.nextLine();
				
				System.out.println("Event time: ");
				String time = scanner.nextLine();
				
				System.out.println("Event duration: ");
				String duration = scanner.next();
				
				new_event(title, time, Integer.parseInt(duration));
			}
			
			// Editing an existing event.
			if(line.equals("2")) {
				System.out.println("Enter event title: ");
				String title = scanner.next();
				
				System.out.println("Enter new title: ");
				String new_title = scanner.next();
				if (new_title == "N/A") {
					new_title = title;
				}
				
				System.out.println("Enter new start time: ");
				String new_time = scanner.next();
				
				System.out.println("Enter new event duration: ");
				String new_duration = scanner.next();
				
				for(int i = 0; i < event_list.size(); i++){
					if(title.equals(event_list.get(i).get_event_title())) {
						
						if (new_time == "N/A") {
							new_time = event_list.get(i).get_event_start_time();
						}
						
						if (new_duration == "N/A") {
							new_duration = Integer.toString(
										event_list.get(i).get_event_duration());
						}
						
						edit_event(event_list.get(i), new_title, 
								new_time, Integer.parseInt(new_duration));
						
						break;
					}
				}
			}
			
			// Display event(s).
			if(line.equals("3")) {
				String display_opts = "Display options: \n1. Display all\n2. ";
				display_opts += "Display event\n";
				System.out.println(display_opts);
				String display_choice = scanner.next();
				
				if (display_choice  == "1") {
					System.out.println(
							"Total number events: " + event_list.size());
					
					for(Event event : event_list) {
						event.display_event();
					}
				} else if (display_choice == "2") {
					System.out.println("Enter event title: ");
					String display_title = scanner.next();
					
					for(int i = 0; i < event_list.size(); i++){
						if(event_list.get(i).get_event_title() == display_title) {
							event_list.get(i).display_event();
							break;
						}
					}
				}
			}
			
			// Deleting an event.
			if(line.equals("4")) {
				System.out.println("Enter event title: ");
				String delete_title = scanner.next();
				
				for(int i = 0; i < event_list.size(); i++){
					if(event_list.get(i).get_event_title() == delete_title) {
						delete_event(event_list.get(i));
						break;
					}
				}
			}
			
			// Exit the application.
			if(line.equals("5")) {
				scanner.close();
				System.exit(0);
			}
		}
	}

}
