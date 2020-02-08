package _02_File_Encrypt_Decrypt;

import java.io.FileReader;
import java.io.IOException;

public class FileDecryptor {
	// Create a program that opens the file created by FileEncryptor and display
	// the decrypted message to the user in a JOptionPane.
	public static void main(String[] args) {
		FileDecryptor file = new FileDecryptor();
		
	}
	
	FileDecryptor()	{
		read();		
		
	}
	
	String decrypt(String str) {
		String[] letters = new String[str.length()];
		String decrypted = "";
		
		for(int i = 0; i < str.length(); i ++) {
			letters[i] = str.substring(i, i +1);
			
		}
		for(int i = str.length(); i > 0; i --) {
			String flip = letters[i];
			letters[i]	= letters[i +1];
			letters[i -1] = flip;
			
		}
		for(int i = 0; i < letters.length; i ++) {
			decrypted = decrypted + letters[i];
			
		}
		
		
		return decrypted;
	}
	
	void read() {
		String message = "";
		try {
			FileReader reader = new FileReader("src/_02_File)Encrypt_Decrypt/file");
			
			int c = reader.read();
			while(c != -1){
				message = message + c;
				c = reader.read();
			}
			reader.close();
		}
		catch(Exception IOException){ 
			
		}
		System.out.println(message);
		
	}

	
	
	
	
	
}
