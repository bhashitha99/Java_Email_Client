import java.util.ArrayList;
import java.io.*;

public class InStream {

	@SuppressWarnings("unchecked")
	public ArrayList<Email> inputDetails() {
		ArrayList<Email> emailDetails = new ArrayList<Email>();
		
		try {
			//check whether file empty or not
			File myfile = new File("clients.ser");	
			if(myfile.length()!=0) {
				//if file is not empty, read the data and input to the array list
				FileInputStream file = new FileInputStream("clients.ser");
				ObjectInputStream obj = new ObjectInputStream(file);;
				Object object = obj.readObject();
				emailDetails = (ArrayList<Email>)object;
			}
		}
		catch(IOException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		
		return emailDetails;	//return entered array list
	}

}
