import java.io.*;
public class Official_recipients extends Recipients implements Serializable{ 

	private String designation;
	
	public Official_recipients(String name,String email,String des) {
		super(name,email);
		this.designation=des;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	

}
