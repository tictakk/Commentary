import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SecretImage {
	
	public static void main(String args[]) throws Exception{
		if(args[0].equals("add")) {
			StringBuilder sb = new StringBuilder();
			for(int i=2; i<args.length; i++) {
				sb.append(args[i]);
			}
			String dir = args[1];
			String comment = sb.toString();
			addComment(dir,comment);
		}
		else if(args[0].equals("read")){
			readComments(args[1]);
		}
		
	}
	
	public static void addComment(String dir, String comment) throws IOException {
		File file = new File(dir);
		long fileSize = file.length();
		int size = (int) fileSize;
		byte[] data = new byte[size];
		FileInputStream fis = new FileInputStream(file);
		fis.read(data);
		JPEG jpeg = Parser.createJPEG(data);
		jpeg.addComment(comment);
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
}
 