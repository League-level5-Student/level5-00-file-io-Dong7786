package _02_File_Encrypt_Decrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileEncryptor {
	// Create a program that takes a message from the user.
	// Use the methods in the String and Character classes to save
	// an encrypted form of the message to a file
	
	public static void main(String[] args) {
		FileEncryptor e = new FileEncryptor();
		
		
	}
	
	FileEncryptor(){
		record(encrypt("This is a message"));
		
	}
	
	String encrypt(String message) {
		String code = "";
		
		String[] letters = new String[message.length()];
		for(int i = 0; i < message.length(); i ++) {
			letters[i] = message.substring(i, i+1);
		}
		
		for(int i = 0; i < letters.length -1; i += 2) {
			String flip = letters[i];
			letters[i] = letters[i+1];
			letters[i +1] = flip;
			
		}
		
		for(int i = 0; i < letters.length; i ++) {
			code = code + letters[i];
			
		}
		System.out.println(code);
		return code;
	}
	
	void record(String message) {
		try {
			FileWriter writer = new FileWriter("src/_02_File_Encrypt_Decrypt/file");
			
			writer.append(message);
			writer.close();
			
		} catch(IOException e)	{ 
			
			
		}
		
	}


}
