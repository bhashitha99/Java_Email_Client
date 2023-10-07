import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Client_Details {
	public void append(String details){
	  	try {
	  		//write entered data to clientList.txt file
	  		//if clientList.txt does not exist, create automatically
	  		FileWriter myWriter= new FileWriter("clientList.txt",true);
	  		myWriter.write(details);
	  		myWriter.write("\n");
	  		myWriter.close();
	  	}

	  	catch(IOException e) {
	  		System.out.println("Error occured");
	  		e.printStackTrace();
	  	}


	}

}
