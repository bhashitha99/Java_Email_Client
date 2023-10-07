import java.util.ArrayList;

public class DetailsOfAllEmails {
	private boolean isDateIncorrect=false;
	
	public void getDetails(String date, ArrayList<Email> emailArray) {
		try {
			//separate given date
			String correctDate[] = date.split("/",-1);
			//check given date's order is correct or not
			if(correctDate[0].length()==4 && correctDate[1].length()==2 && correctDate[2].length()==2) {
				if(emailArray!=null) {
					Email mail = null;
					boolean sent=false;
					
					//check in email array and print all emails
					for(int i=0 ; i < emailArray.size(); i++) {
						mail=emailArray.get(i);
						if(mail.getDate().equals(date)) {
							sent=true;
							System.out.println("To : "+mail.getTo());
							System.out.println("Subject : "+mail.getSubject());
							System.out.println("Body : "+mail.getBody());
							System.out.println(" \n");
						}
						
					}
					if(!sent)
							System.out.println("No Any Emails");
					
				}
				else
					System.out.println("No Any Emails");
			}
				
			else
				System.out.println("Invalid date type\nInput format :- yyyy/MM/dd"
						+ "\nTry again...");
			isDateIncorrect=true;
			
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid date type\nInput format :- yyyy/MM/dd"
					+ "\nTry again..."
					+"\n-----Press zero to return to the menu-----");
			isDateIncorrect=true;
		}
		
		
		
	}
	public boolean getisDateIncorrect() {
		return isDateIncorrect;
	}

}
