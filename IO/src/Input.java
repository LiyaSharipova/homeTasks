import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;


public class Input {
//	private OutputStream outputStream;
	public static void main(String[] args) {
		DataInputStream inputStream = null;
	try {
		inputStream = new DataInputStream(new FileInputStream("in.txt"));
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	   try {
		DataOutputStream outputStream=new DataOutputStream(new FileOutputStream("in.txt"));
		outputStream.writeInt(5);
				
		outputStream.flush();
		int data =inputStream.readInt();
		outputStream.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	}

}