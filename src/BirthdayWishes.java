import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class BirthdayWishes {
	
	public void send(ArrayList<Recipients> array,ArrayList<Email> emailArray) {
		//send birthday wishes , who has birthday today
		//check arrays are empty or not
		if(emailArray!=null && array!=null) {
			//get today date, (yyyy/MM/dd) format
			LocalDate today = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			String formatedToday = today.format(formatter);
			
			//check how has birthday today and get Birthday list
			WhoHasBirthday whbd = new WhoHasBirthday();
			ArrayList<Recipients> bdArray =whbd.find(formatedToday, array);
			
			String sub="Birthday Wishes";
			String body1="Wish you a Happy Birthday. \nBhashitha Viduranga.";
			String body2="Hugs and love on your birthday. \nBhashitha Viduranga.";
				
			//send and save mails, who has birthday today
			SendAndSaveEmail mymail = new SendAndSaveEmail();
			
			if(0<bdArray.size()) {
				Email wish = null;
				for(int i=0 ; i<bdArray.size() ; i++) {
					//create email for birthday wish
					if(bdArray.get(i) instanceof OfficeFriend_recipients) 
						wish =new Email(bdArray.get(i).getEmail(),sub,body1,formatedToday);
					if(bdArray.get(i) instanceof Personal_recipients) { 
						wish = new Email(bdArray.get(i).getEmail(),sub,body2,formatedToday);
					}
					boolean sent=false;
					//check whether we sent the Birthday wish earlier
					for(int j=0; j<emailArray.size();j++) {
						if(emailArray.get(j).getDate().equals(wish.getDate()) 
								&& emailArray.get(j).getTo().equals(wish.getTo()) 
								&& emailArray.get(j).getSubject().equals(wish.getSubject()) 
								&& emailArray.get(j).getBody().equals(wish.getBody())){
							sent=true;
						}
					}
					//if we did not send birthday wish earlier send and save now
					if(!sent) {
						mymail.send(wish);
						mymail.save(wish, emailArray);
					}
				}
			}
		}
		
	}
				
}
