import java.io.*;
import java.util.ArrayList;
public class OutStream {
	
	public void serialize(ArrayList<Email> array) {
		try {
			//serialize array list
			FileOutputStream file = new FileOutputStream("clients.ser");
			ObjectOutputStream obj = new ObjectOutputStream(file);
			
			obj.writeObject(array);
			obj.close();
			
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	

}
