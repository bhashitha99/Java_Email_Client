
public class RecipientsFactory{
	private static int count;	//static method
	
	public Recipients create(String details) {
		try {
			//separate given details
			String[] separate_details=details.split(":",-1);
			String[] main_details=separate_details[1].split(",",-1);
		
			//create a new recipient
			Recipients person=null;
			if(details.startsWith("official")) { 
				person= new Official_recipients(main_details[0],main_details[1],main_details[2]);
				count+=1;
			}
			else if(details.startsWith("office_friend")) {
				person= new OfficeFriend_recipients(main_details[0],main_details[1],main_details[2],main_details[3]);
				count+=1;
			}
			else if(details.startsWith("personal")) {
				person= new Personal_recipients(main_details[0],main_details[1],main_details[2],main_details[3]);
				count+=1;
			}
			return person;
		
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Invailed Input..."
					+ "\nInput format :- official: name,email,designation"
					+ "\nInput format :- office_friend: name,email,designation,birthday"
					+ "\nInput format :- personal: name,nick name,email,birthday"
					+"\nTry Again..."
					+"\n-----Press zero to return to the menu-----");
		}
		return null;
	}
	
	public int getCount() {
		return count;	//number of all recipients
	}

}
