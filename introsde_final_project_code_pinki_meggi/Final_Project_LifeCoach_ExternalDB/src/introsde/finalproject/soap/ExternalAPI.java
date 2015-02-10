package introsde.finalproject.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL) //optional
public interface ExternalAPI {
	
	
	@WebMethod(operationName="sendEmail")
	@WebResult(name="result") 
	public int sendEmail(@WebParam(name="email") String email,@WebParam(name="subject") String subject, @WebParam(name="content") String content);

	@WebMethod(operationName="getRandomQuote")
	@WebResult(name="quote") 
	public String getRandomQuote();

}
