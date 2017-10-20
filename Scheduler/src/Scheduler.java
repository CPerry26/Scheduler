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


import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

public class Scheduler {
	// List of events
	private static ArrayList<Event> event_list = new ArrayList<Event>();
	
	/*
	 * This method creates a new event and adds it to the event list.
	 * 
	 * @args String title - title of event
	 * @args String start_time - starting time of event
	 * @args int duration - length of event
	 * 
	 * @return none
	 */
	public static void new_event(String title, String start_time, int duration) {
		Event new_event = new Event(title, start_time, duration);
		event_list.add(new_event);
	}
	
	//Time sort algorithm
	public void timeSort(ArrayList<Event> events){
		int i, j;
		Event event;
		String[] times;
		for(i = 1; i < events.size(); i++){
			event = events.get(i);
			j = i;
			times = event.startTime.split(":");
			String[] timePrev;
			timePrev = events.get(i-1).startTime.split(":");
			int time = Integer.parseInt(times[0]);
			int timesPrev = Integer.parseInt(timePrev[0]);
			if(time == timesPrev){
				int next = Integer.parseInt(times[1]);
				int nextTime = Integer.parseInt(timePrev[1]);
				if(next > nextTime){
					events.set(j, event);
				}
				events.set(j, events.get(j-1));
			}
			while (j > 0 && timesPrev > time){
				events.set(j, events.get(j-1));
				j--;
			}
			events.set(j, event);
			
		}
	}
	
	/*
	 * This method edits a given event with a set of changes.
	 * 
	 * @args Event event - event to edit
	 * @args String[] changes - array of changes to make
	 * 
	 * @return none
	 */
	public static void editEvent(Event event, String[] changes){
		String title = event.title;
		for(int i = 0; i < events.size(); i++){
			if(title.equals(events.get(i).title)){
				String titleChange = events.get(i).title.replace(events.get(i).title, changes[0]);
				String timeChange = events.get(i).startTime.replace(events.get(i).startTime, changes[1]);
				events.get(i).title = titleChange;
				events.get(i).startTime = timeChange;
				break;
			}
		}
	}
	
	/*
	 * This method removes an event from the event list.
	 * 
	 * @args Event event - event to delete
	 * 
	 * @return none
	 */
	public static void deleteEvent(Event event) {
		for(int i = 0; i < event_list.size(); i++){
			if(event.get_event_title().equals(event_list.get(i).get_event_title())) {
				event_list.remove(i);
				break;
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Scheduler schedule = new Scheduler();
		String newEvent = "1";
		String editEvent = "2";
		String displayEvent = "3";
		String deleteEvent = "4";
		String line = "";
		String exit = "5";
		
		while(true){
			//loop for conditional command line input.
			System.out.println("1. New event\n2. Edit event\n3. Display event\n4. Delete event\n5. Exit\n");
			Scanner sc = new Scanner(System.in);
			line = sc.next();
			//if creating new event
			if(line.equals(newEvent)){
				System.out.println("Event title: ");
				String title = sc.next();
				System.out.println("Event time: ");
				String time = sc.next();
				newEvent(title, time);
			}
			//if editing event
			if(line.equals(editEvent)){
				System.out.println("Enter event title: ");
				String title = sc.next();
				System.out.println("Enter new title: ");
				String newTitle = sc.next();
				System.out.println("Enter new start time: ");
				String newTime = sc.next();
				String [] changes = new String[2];
				changes[0] = newTitle;
				changes[1] = newTime;
				for(int i = 0; i < eventList.size(); i++){
					if(title.equals(eventList.get(i).title)){
						editEvent(eventList.get(i), eventList, changes);
						break;
					}
				}
			}
			//if displaying event
			if(line.equals(displayEvent)){
				System.out.println("Enter event title: ");
				String displayTitle = sc.next();
				for(int i = 0; i < eventList.size(); i++){
					if(eventList.get(i).title.equals(displayTitle)){
						System.out.println("Event name: " + eventList.get(i).title + '\n');
						System.out.println("Event start time: " + eventList.get(i).startTime + '\n');
						break;
					}
				}
			}
			//if deleting event
			if(line.equals(deleteEvent)){
				System.out.println("Enter event title: ");
				String deleteTitle = sc.next();
				for(int i = 0; i < eventList.size(); i++){
					if(eventList.get(i).title.equals(deleteTitle)){
						deleteEvent(eventList.get(i), eventList);
						break;
					}
				}
			}
			//if exiting the program
			if(line.equals(exit)){
				System.exit(0);
				break;
			}
		}
	}

}
