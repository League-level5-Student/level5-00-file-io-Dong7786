package _03_To_Do_List;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements MouseListener {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save
	 * list, and load list.
	 * 
	 * When add task is clicked: ask the user for a task and save it to an array
	 * list
	 * 
	 * When the view tasks button is clicked: show all the tasks in the list
	 * 
	 * When the remove task button is clicked: prompt the user for which task to
	 * remove and take it off of the list.
	 * 
	 * When the save list button is clicked: Save the list to a file
	 * 
	 * When the load list button is clicked: Prompt the user for the location of the
	 * file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file
	 * into the list.
	 */
	public static void main(String[] args) {
		ToDoList list = new ToDoList();

	}

	JFrame frame;
	JPanel panel;
	ArrayList<String> tasks = new ArrayList<String>();

	ToDoList() {
		frame = new JFrame();
		panel = new JPanel();
		frame.setVisible(true);
		frame.add(panel);

		addButtons();
		frame.pack();

		loadFile("AutomaticallySavedFile");
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

	@Override
	public void mouseClicked(MouseEvent e) {

		if (e.getSource() == button[1]) {
			String createTask = JOptionPane.showInputDialog("Create Task:");
			if (createTask == null || createTask.isEmpty()) {

			} else {
				tasks.add(createTask);
				saveTasks("AutomaticallySavedFile");
			}

		} else if (e.getSource() == button[2]) {
			String show = "";
			for (int i = 0; i < tasks.size(); i++) {
				show = show + (i + 1) + ". " + tasks.get(i) + "\n";

			}
			JOptionPane.showMessageDialog(null, show);
		} else if (e.getSource() == button[3]) {
			String remove = JOptionPane.showInputDialog("Enter Task to Remove:");
			if (remove == null || remove.isEmpty()) {

			} else if (remove.equalsIgnoreCase("override.removeall")) {
				tasks.clear();
			} else {

				try {
					tasks.remove(Integer.parseInt(remove) - 1);
					System.out.println(remove + "Integer");
				} catch (Exception ex) {
					tasks.remove(match(remove, tasks) +1);
					System.out.println(remove + " Match " + ex);
				}

				saveTasks("AutomaticallySavedFile");
			}
		} else if (e.getSource() == button[4]) {
			saveTasks(JOptionPane.showInputDialog("Enter file name:"));

		} else if (e.getSource() == button[5]) {
			loadFile(JOptionPane.showInputDialog("Enter File name:"));

		}

	}

	void saveTasks(String fileName) {
		if (fileName == null) {

		} else if (fileName.isEmpty()) {
			Random rand = new Random();
			int random = rand.nextInt(1000);
			fileName = "Untitled" + random;

		}
		String message = "";
		for (int i = 0; i < tasks.size(); i++) {
			message = message + tasks.get(i) + "\n";

		}
		try {
			FileWriter writer = new FileWriter(fileName);
			writer.append(message);
			writer.close();
			System.out.println("File written");

		} catch (Exception ioe) {

		}

	}

	void loadFile(String fileName) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));

			String line = br.readLine();
			tasks.clear();
			while (line != null) {
				tasks.add(line);
				line = br.readLine();
			}

			br.close();
			System.out.println("File Read");
		} catch (IOException ioexception) {

		}

	}

	int match(String str, ArrayList<String> list) {
		int indexNum = 0;
		int matches = 0;
		
		String[] strWords = str.split(" ");
		
		for(int i = 0; i < list.size(); i ++) {
			String[] listWords = list.get(i).split(" ");
			if(compare(strWords, listWords) > matches) {
				indexNum = i;
				matches = compare(strWords, listWords);
			}		
		}
		
		return indexNum;
	}
	
	int compare(String[] first, String[] second) {
		int numMatches = 0;
		
		for(int one = 0; one < first.length; one ++) {
			for(int two = 0; two < second.length; two ++) {
				if(first[one] == second[two]) {
					numMatches++;
					break;
				}
				
			}
			
		}
	
		
		return numMatches;
		
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
