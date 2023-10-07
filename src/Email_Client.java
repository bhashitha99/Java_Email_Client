import java.util.*;
import java.io.File;

public class Email_Client {

      public static void main(String[] args) {
    	   
    	  //Email objects, deserialization and input to a array list
		  InStream in =new InStream();		
		  ArrayList<Email> emailArray = in.inputDetails(); 
    	  
    	  //input Recipients data from saved text file to a array list
    	  ArrayList<Recipients> resipientArray = new ArrayList<Recipients>();
    	  InputRecipients inrecipients = new InputRecipients();
    	  inrecipients.inputrecipients(resipientArray);
    	  
    	  RecipientsFactory factory = new RecipientsFactory();	//create new recipients factory
    	   	  
          
          boolean loop=true;
          while(loop) {
        	  System.out.println("Enter option type: \n"
                      + "1 - Adding a new recipient\n"
                      + "2 - Sending an email\n"
                      + "3 - Printing out all the recipients who have birthdays\n"
                      + "4 - Printing out details of all the emails sent\n"
                      + "5 - Printing out the number of recipient objects in the application\n"
                      + "0 - Save & Exit");
        	  try {
        		  //start inputs
        		  Scanner scanner = new Scanner(System.in);
	              int option = scanner.nextInt();
	              
	              //check whether input value is in correct range or not
	              if(!((0<=option) && (option<6))) {
	            	  System.out.println("Invaid Input");
	            	  continue;
	              }
	
	              switch(option){
	                    case 1:
	                    	while(true) {
	                    		//add a new recipient to program
	                    		//input recipient details (input format - Official: nimal,nimal@gmail.com,ceo)
	                    		Scanner myscanner =new Scanner(System.in);
	                    		String recipient_details = myscanner.nextLine();
	                    		
	                    		//back to main menu
	                    		if(recipient_details.equals("0")) {
	                    			break;
	                    		}
	                    		
	                    		//create recipient object and add to the array list
	                    		Recipients rep=factory.create(recipient_details);                 	  
	                    		resipientArray.add(rep);
	                  	  
	                    		if(rep!=null) {
	                    			//store details in the clientList.txt text file
	                    			Client_Details list =new Client_Details();
	                    			list.append(recipient_details);
	                    			break;
	                    		}
	                    		
	                    	}
	
	                        break;
	                        
	                    case 2:
	                    	while(true) {
	                    		//send an email, input format - email, subject, content
	                    		Scanner myscanner2 = new Scanner(System.in);
	                    		String emailContent = myscanner2.nextLine();
	                    		
	                    		//back to main menu
	                    		if(emailContent.equals("0")) {
	                    			break;
	                    		}
	                    	
	                    		//create an email
	                    		EmailFactory mailfac =new EmailFactory();
	                    		Email mail =mailfac.createMail(emailContent);
	                    	
	                    		//if email is valid, send and save 
	                    		if(mail!=null) {
	                    			SendAndSaveEmail mymail=new SendAndSaveEmail();
	                    			mymail.send(mail);
	                    			mymail.save(mail,emailArray);
	                    			break;
	                    		}
	                    		
	                    	}
	                        break;
	                        
	                    case 3:
	                    	while(true) {
	                    		//print recipients who have birthdays on the given date
	                    		// input format - yyyy/MM/dd
	                    		Scanner myscanner3= new Scanner(System.in);
	                    		String date= myscanner3.nextLine();
	                    		
	                    		//back to main menu
	                    		if(date.equals("0")) {
	                    			break;
	                    		}
	                    		
	                    		//get a array, whose birthday today
	                    		WhoHasBirthday birthday = new WhoHasBirthday();
	                    		ArrayList<Recipients> bdlist=birthday.find(date,resipientArray);
	                    	
	                    	
	                    		//if birthday list not empty,print birthday
	                    		if(bdlist!=null) {
	                    			birthday.send(bdlist);
	                    		}
	                    		if(!birthday.getisDateIncorrect()) {
	                    			break;
	                    		}
	                    	
	                    	}
	                    	
	                        break;
	                        
	                    case 4:
	                    	while(true) {
	                    		// print the details of all the emails sent on the input date
	                    		// input format - yyyy/MM/dd
	                    		Scanner myscanner4= new Scanner(System.in);
	                    		String date2= myscanner4.nextLine();
	                    		
	                    		//back to main menu
	                    		if(date2.equals("0")) {
	                    			break;
	                    		}
	                    	
	                    		//print details
	                    		DetailsOfAllEmails details = new DetailsOfAllEmails();
	                    		details.getDetails(date2,emailArray);
	                    		if(!details.getisDateIncorrect()) {
	                    			break;
	                    		}
	                    	}                     
	                        break;
	                        
	                    case 5:
	                    	//print the number of recipient objects in the application
	                    	System.out.println(factory.getCount());                    
	                        break;
	                        
	                    case 0:
	                    	//terminate loop
	                    	loop=false;
	                    	break;                 
	
	              }
	              
          }catch(InputMismatchException e) {
        	  System.out.println("Invaid Input");}
          }
          
          //if any one has birthday today send Birthday wishes
          BirthdayWishes wish = new BirthdayWishes();
          wish.send(resipientArray,emailArray);
          
          //serialize all mails which has been sent
          OutStream out = new OutStream();
          out.serialize(emailArray);
          
      }
            
}