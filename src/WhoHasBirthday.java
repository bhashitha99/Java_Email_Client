import java.util.*;
public class WhoHasBirthday {
	private boolean isDateIncorrect=false;

	public ArrayList<Recipients> find(String date, ArrayList<Recipients> resipientArray) {
		try {
			//separate given date
			String sepdate[] = date.split("/",2);
			ArrayList<Recipients> bdlist = new ArrayList<Recipients>();
			Recipients res=null;			
			
			//separate given date
			String correctDate[] = date.split("/",-1);
			//check input date is correct
			if(correctDate[0].length()==4 && correctDate[1].length()==2 && correctDate[2].length()==2) {
				
				for(int i=0 ; i<resipientArray.size() ; i++) {
					
					if((res=resipientArray.get(i)) instanceof OfficeFriend_recipients) {
						//if this recipient office friend, check his birthday
						OfficeFriend_recipients friend = (OfficeFriend_recipients)res;
						if(friend.getBirthday().endsWith(sepdate[1])) {
							res=friend;
							bdlist.add(friend);
						}						
					}
					
					if((res=resipientArray.get(i)) instanceof Personal_recipients) {
						Personal_recipients person = (Personal_recipients)res;
						//if this recipient personal, check his birthday
						if(person.getBirthday().endsWith(sepdate[1])) {
							res=person;
							bdlist.add(res);
						}						
					}
					
				}	
				return bdlist;
				
			}
			else {
				System.out.println("Invalid date type\nInput format :- yyyy/MM/dd"
						+ "\nTry again..."
						+"\n-----Press zero to return to the menu-----");
				isDateIncorrect=true;
			}
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Invalid date type\nInput format :- yyyy/MM/dd"
					+ "\nTry again..."
					+"\n-----Press zero to return to the menu-----");
			isDateIncorrect=true;
		}
		return null;
				
	}
	
	public void send(ArrayList<Recipients> array) {
		//check whether array is empty or not
		//if not empty print names
		if(0<array.size()) {
			for (int j=0 ; j<array.size() ; j++) {
				System.out.println(array.get(j).getName());
			}
		}
		else
			System.out.println("No Birthdays");

	}
	public boolean getisDateIncorrect() {
		return isDateIncorrect;
	}

}
