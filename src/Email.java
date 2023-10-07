import java.io.Serializable;

public class Email implements Serializable{
	private String to;
	private String subject;
	private String body;
	private String date;
	
	//constructor
	public Email(String to, String subject, String body, String date) {
		this.to=to;
		this.subject=subject;
		this.body=body;
		this.date=date;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	
}
