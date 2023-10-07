import java.io.*;

public class OfficeFriend_recipients extends Official_recipients  implements Serializable{

	private String birthday;
	
	public OfficeFriend_recipients(String name,String email,String des,String birthday) {
		super(name,email,des);
		this.birthday=birthday;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
}
