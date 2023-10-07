import java.time.LocalDate;	
import java.time.format.DateTimeFormatter;

public class EmailFactory {
	public Email createMail(String content) {
		try {
			//separate entered data
			String[] separeteEmail = content.split(",",-1);
			Email mail=null;
			
			//get today date, yyyy/MM/dd format
			LocalDate mydate = LocalDate.now();
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			String date = mydate.format(format);
			
			//create a new email
			mail =new Email(separeteEmail[0],separeteEmail[1],separeteEmail[2],date);
			return mail;
		}
		//Exception handling
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid order...\n"
					+ "Input format :- email, subject, content"
					+"\nTry Again..."
					+"\n-----Press zero to return to the menu-----");
		}
		return null;
		
		
	}


}
