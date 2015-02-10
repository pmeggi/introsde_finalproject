package introsde.finalproject.model; 

public class PostmarkEmail {
	String From;
	String To;
	String Subject;
	String HtmlBody;
	
	public PostmarkEmail(String from, String To, String Subject, String body)
	{
		this.From=from;
		this.To=To;
		this.Subject=Subject;
		this.HtmlBody=body;
	}
	
	public String getFrom()	{ return this.From; }
	public String getTo()	{ return this.To; }
	public String getSubject()	{ return this.Subject; }
	public String getHtmlBody()	{ return this.HtmlBody; }
	
	public void setFrom(String f)	{ this.From=f; }
	public void setTo(String t)	{ this.To=t; }
	public void setSubject(String s)	{ this.Subject=s; }
	public void setHtmlBody(String b)	{ this.HtmlBody=b; }
	
	
}
