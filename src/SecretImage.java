/*
 * Written by Matthew Kersey.
 * 
 * Current flags should be:
 * -a - add
 * -r - read
 * -h - help... more to come later
 * 
 * 
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SecretImage {
	
	public static void main(String args[]) throws Exception{
		parseInput(args);
	}
	
	public static void addComment(String dir, String comment[]) throws IOException {
		File file = new File(dir);
		long fileSize = file.length();
		int size = (int) fileSize;
		byte[] data = new byte[size];
		FileInputStream fis = new FileInputStream(file);
		fis.read(data);
		JPEG jpeg = Parser.createJPEG(data);
//		StringBuilder sb = new StringBuilder(); 
		String com = null;
		for(int i=0; i<comment.length; i++) {
//			sb.append(comment[i]);
//			sb.append(" ");
			System.out.println(com += comment[i] + " ");
			com += comment[i] + " ";
		}
//		String newcomment = sb.toString();
//		newcomment = newcomment.replace('!', ' ');
		jpeg.addComment(com);
		jpeg.writeFile(dir);
	}

	public static void readComments(String dir) throws IOException {
		File file = new File(dir);
		long fileSize = file.length();
		int size = (int) fileSize;
		byte[] data = new byte[size];
		FileInputStream fis = new FileInputStream(file);
		fis.read(data);
		JPEG jpeg = Parser.createJPEG(data);
		jpeg.readComments();
	}
	
	public static void removeComment() {
		
	}
	
	public static void help() {
		
	}
	
	public static void parseInput(String[] args) throws IOException {
		//current flags, a, r, h
		switch(args[0]) {
		
		case "-a": 
			String [] comment = new String[args.length-2];
			
			for(int i=0; i<args.length-2; i++) {
				comment[i] = args[i+2];
			}
			addComment(args[1], comment); break;
		case "-r":
			readComments(args[1]);
			break;
			
		default: System.out.println("invalid flag");break;
		}
	}
}
 
 