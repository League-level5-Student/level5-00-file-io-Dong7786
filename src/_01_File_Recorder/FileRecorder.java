package _01_File_Recorder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileRecorder {
	// Create a program that takes a message from the user and saves it to a file.
	
	public static void main(String[] args) {
		FileRecorder recorder = new FileRecorder();
		
	}
	
	FileRecorder(){
		
		
		
		
	}
	void recorder(String message) {
		try {
			FileWriter writer = new FileWriter("src/_01_File_Recorder/file");
			
			writer.append(message);
			writer.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	static File createFile(String message) {
		File file;
		if(message.isEmpty()) {
			file = null;
			return file;
			
		}
		if(message.contains(" ") && message.indexOf(" ") < 10) {
			file = new File(message.substring(0, message.indexOf(" ")) + ".txt", message);
			
		}else if(message.length() > 10){
			file = new File(message.substring(0, 10) + ".txt", message);
			
		}else {
			file = new File(message + ".txt", message);
			
		}
		
		return file;
		
		
	}
	
	
}
