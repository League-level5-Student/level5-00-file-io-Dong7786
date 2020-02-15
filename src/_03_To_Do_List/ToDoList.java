package _03_To_Do_List;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements MouseListener{
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 * 
	 * When add task is clicked:
	 * 		ask the user for a  task and save it to an array list
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list.
	 */
	public static void main(String[] args) {
		ToDoList list = new ToDoList();
		
	}
	
	JFrame frame;
	JPanel panel;
	
	ToDoList(){
		frame = new JFrame();
		panel = new JPanel();
		frame.setVisible(true);
		frame.add(panel);
		
		addButtons();
		frame.pack();
		
	}
	
	
	JButton[] button = new JButton[6];
	
	
	void addButtons() {
		button[1] = new JButton("Add Task");
			button[1].addMouseListener(this);
			panel.add(button[1]);
			
		button[2] = new JButton("View Task"); 
			button[2].addMouseListener(this);
			panel.add(button[2]);
			
		button[3] = new JButton("Remove Task");
			button[3].addMouseListener(this);
			panel.add(button[3]);
			
		button[4] = new JButton("Save List");
			button[4].addMouseListener(this);
			panel.add(button[4]);
			
		button[5] = new JButton("Load List");
			button[5].addMouseListener(this);
			panel.add(button[5]);
		
		
	}

	String[] t = new String[9];
	String[] task;
	int taskNumber = 0;
	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(e.getSource() == button[1]) {
			if(taskNumber <= 9) {
			t[taskNumber] = JOptionPane.showInputDialog("Enter a Task:");
			taskNumber ++;
			task = new String[taskNumber];
			for(int i = 0; i < taskNumber; i ++) {
				task[i] = t[i];
				
			}
			}else {
				JOptionPane.showMessageDialog(null, "You have reached the maximum amount of tasks!");
						
				
			}
			
		}else if(e.getSource() == button[2]) {
			String prompt = "";
			for(int i = 0; i < task.length; i ++) {
				prompt = prompt + (i+1) + ". " + task[i] + "\n" ;
				
			}
			System.out.println(prompt);
			JOptionPane.showMessageDialog(null, prompt);
			
		}else if(e.getSource() == button[3]) {
			
			
		}
	}

	public void mousePressed(MouseEvent e) {
		
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
