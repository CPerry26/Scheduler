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

public class Scheduler {
	
	public Scheduler(){
		JFrame outerFrame = new JFrame("Scheduler v1.0");
		JLabel title = new JLabel("Scheduler 1.0!", SwingConstants.CENTER);
		outerFrame.setVisible(true);
		outerFrame.setLayout(new BorderLayout());
		outerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		outerFrame.setResizable(true);
		JPanel buttGrid = new JPanel(new GridLayout(1,4));
		outerFrame.add(title, BorderLayout.NORTH);
		outerFrame.add(buttGrid, BorderLayout.NORTH);
		
		JButton add = new JButton();
		JButton edit = new JButton();
		JButton delete = new JButton();
		JButton display = new JButton();
		buttGrid.add(add);
		buttGrid.add(edit);
		buttGrid.add(delete);
		buttGrid.add(display);
		
		
		JPanel midOptions = new JPanel();
		outerFrame.add(midOptions, BorderLayout.CENTER);
		
		
	}

	class addEventL implements ActionListener{

		
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
