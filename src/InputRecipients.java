import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class InputRecipients {
	public void inputrecipients(ArrayList<Recipients> array) {
		try {
			//open and read the text file
			File myfile = new File("clientList.txt");
			RecipientsFactory factory =new RecipientsFactory();
			
			//check whether file is empty or not
			if(myfile.length()!=0) {
				Scanner reader = new Scanner(myfile);
				while(reader.hasNextLine()) {
					String data = reader.nextLine();
					Recipients person = factory.create(data);
					array.add(person);	//add to the array list as recipient objects
				}
				reader.close();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
