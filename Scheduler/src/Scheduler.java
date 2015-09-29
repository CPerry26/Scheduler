/**
 * Scheduling program with GUI
 * Simple functionality, such as:
 * Add event, edit event, etc.
 */

/**
 * @author Cody Perry
 *
 */
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

public class Scheduler {
	public boolean addIsOn = false;
	public boolean editIsOn = false;
	public boolean deleteIsOn = false;
	public boolean displayIsOn = false;
	
	
	/**
	public Scheduler(){
		JFrame outerFrame = new JFrame("Scheduler v1.0");
		outerFrame.setLayout(new BorderLayout());
		outerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		outerFrame.setSize(1000, 1000);
		outerFrame.setResizable(false);
		JPanel buttGrid = new JPanel(new GridLayout(1,4));
		
		
		JButton add = new JButton("Add Event");
		JButton edit = new JButton("Edit Event");
		JButton delete = new JButton("Delete Event");
		JButton display = new JButton("Display Event");
		buttGrid.add(add);
		buttGrid.add(edit);
		buttGrid.add(delete);
		buttGrid.add(display);
		
		
		final JPanel addPanel = new JPanel();
		final JPanel editPanel = new JPanel();
		final JPanel deletePanel = new JPanel();
		final JPanel displayPanel = new JPanel();
		
		addPanel.setVisible(true);
		editPanel.setVisible(false);
		deletePanel.setVisible(false);
		displayPanel.setVisible(false);
		//add.addActionListener(new AddEventL(addPanel));
		//edit.addActionListener(new EditEventL(editPanel));
		//delete.addActionListener(new DeleteEventL(deletePanel));
		//display.addActionListener(new DisplayEventL(displayPanel));
		outerFrame.add(buttGrid, BorderLayout.NORTH);
		
		JLabel eventLabel = new JLabel("Event name:");
		JLabel eventTime = new JLabel("Event start time:");
		JTextField eventName = new JTextField(20);
		JTextField eventDD = new JTextField(20);
		eventLabel.setVisible(true);
		eventTime.setVisible(true);
		eventName.setVisible(true);
		eventDD.setVisible(true);
		
		JTextField eventNameEdit = new JTextField();
		JTextField eventDDEdit = new JTextField();
		
		JLabel deleteConfirm = new JLabel("Are you sure you want to delete this event?");
		JButton deleteYes = new JButton();
		JButton deleteNo = new JButton();
		
		eventName.setEditable(true);
		eventDD.setEditable(true);
		eventNameEdit.setEditable(true);
		eventDDEdit.setEditable(true);
		
		addPanel.add(eventLabel);
		addPanel.add(eventName);
		addPanel.add(eventTime);
		addPanel.add(eventDD);
		editPanel.add(eventNameEdit);
		editPanel.add(eventDDEdit);
		deletePanel.add(deleteConfirm);
		deletePanel.add(deleteYes);
		deletePanel.add(deleteNo);
		
		outerFrame.add(addPanel, BorderLayout.CENTER);
		outerFrame.setVisible(true);
		//outerFrame.add(editPanel, BorderLayout.CENTER);
		//outerFrame.add(deletePanel, BorderLayout.CENTER);
		//outerFrame.add(displayPanel, BorderLayout.CENTER);
		
		
	}
	**/
	
	private static ArrayList<Event> eventList = new ArrayList<Event>();
	
	static class Event{
		public String title;
		public String startTime;
		
		public Event(String title1, String startTime1){
			title = title1;
			startTime = startTime1;
		}
	}
	
	public static void newEvent(String title, String startTime){
		Event newE = new Event(title, startTime);
		eventList.add(newE);
	}
	
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
	
	public static void editEvent(Event event, ArrayList<Event> events, String[] changes){
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
	
	public static void deleteEvent(Event event, ArrayList<Event> events){
		String title = event.title;
		for(int i = 0; i < events.size(); i++){
			if(title.equals(events.get(i).title)){
				events.remove(i);
				break;
			}
		}
	}

	class AddEventL implements ActionListener{
		private JPanel b;
		
		public AddEventL(JPanel a){
			b = a;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(addIsOn){
				b.setVisible(false);
			}
			else{
				b.setVisible(true);
			}
		}
		
	}

	class EditEventL implements ActionListener{
		private JPanel ed;
		
		public EditEventL(JPanel c){
			ed = c;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(editIsOn){
				ed.setVisible(false);
			}
			else{
				ed.setVisible(true);
			}
		}
		
	}
	
	class DeleteEventL implements ActionListener{
		private JPanel d;
		
		public DeleteEventL(JPanel c){
			d = c;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(deleteIsOn){
				d.setVisible(false);
			}
			else{
				d.setVisible(true);
			}
		}
		
	}
	
	class DisplayEventL implements ActionListener{
		private JPanel di;
		
		public DisplayEventL(JPanel al){
			di = al;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(displayIsOn){
				di.setVisible(false);
			}
			else{
				di.setVisible(true);
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
			System.out.println("1. New event\n2. Edit event\n3. Display event\n4. Delete event\n5. Exit\n");
			Scanner sc = new Scanner(System.in);
			line = sc.next();
			if(line.equals(newEvent)){
				System.out.println("Event title: ");
				String title = sc.next();
				System.out.println("Event time: ");
				String time = sc.next();
				newEvent(title, time);
			}
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
			if(line.equals(exit)){
				System.exit(0);
				break;
			}
		}
	}

}
