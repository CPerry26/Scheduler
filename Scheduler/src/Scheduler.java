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

public class Scheduler {
	public boolean addIsOn = false;
	public boolean editIsOn = false;
	public boolean deleteIsOn = false;
	public boolean displayIsOn = false;
	
	
	
	public Scheduler(){
		JFrame outerFrame = new JFrame("Scheduler v1.0");
		JLabel title = new JLabel("Scheduler 1.0!", SwingConstants.CENTER);
		title.setVisible(true);
		outerFrame.setVisible(true);
		outerFrame.setLayout(new BorderLayout());
		outerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		outerFrame.setResizable(true);
		JPanel buttGrid = new JPanel(new GridLayout(1,4));
		outerFrame.add(title, BorderLayout.NORTH);
		
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
		add.addActionListener(new AddEventL(addPanel));
		edit.addActionListener(new EditEventL(editPanel));
		delete.addActionListener(new DeleteEventL(deletePanel));
		display.addActionListener(new DisplayEventL(displayPanel));
		outerFrame.add(buttGrid, BorderLayout.NORTH);
		
		JTextField eventName = new JTextField();
		JTextField eventDD = new JTextField();
		
		JTextField eventNameEdit = new JTextField();
		JTextField eventDDEdit = new JTextField();
		
		JLabel deleteConfirm = new JLabel("Are you sure you want to delete this event?");
		JButton deleteYes = new JButton();
		JButton deleteNo = new JButton();
		
		eventName.setEditable(true);
		eventDD.setEditable(true);
		eventNameEdit.setEditable(true);
		eventDDEdit.setEditable(true);
		
		addPanel.add(eventName);
		addPanel.add(eventDD);
		editPanel.add(eventNameEdit);
		editPanel.add(eventDDEdit);
		deletePanel.add(deleteConfirm);
		deletePanel.add(deleteYes);
		deletePanel.add(deleteNo);
		
		outerFrame.add(addPanel, BorderLayout.CENTER);
		//outerFrame.add(editPanel, BorderLayout.CENTER);
		//outerFrame.add(deletePanel, BorderLayout.CENTER);
		//outerFrame.add(displayPanel, BorderLayout.CENTER);
		
		
	}
	
	private ArrayList<Event> eventList = new ArrayList<Event>();
	
	class Event{
		public String title;
		public String startTime;
		
		public Event(String title1, String startTime1){
			title = title1;
			startTime = startTime1;
		}
	}
	
	public void newEvent(String title, String startTime){
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
		// TODO Auto-generated method stub
		Scheduler schedule = new Scheduler();
	}

}
