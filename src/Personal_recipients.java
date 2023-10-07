import java.io.*;

public class Personal_recipients extends Recipients implements Serializable{ 

	private String nickName;
	private String birthday;
	
	public Personal_recipients(String name,String nk,String email,String birthday) {
		super(name,email);
		this.nickName=nk;
		this.birthday=birthday;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	

}
