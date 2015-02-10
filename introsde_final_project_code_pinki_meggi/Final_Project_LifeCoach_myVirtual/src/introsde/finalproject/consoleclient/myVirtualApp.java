package introsde.finalproject.consoleclient;

import introsde.finalproject.model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;

import org.glassfish.jersey.client.ClientConfig;


public class myVirtualApp {
	public static void main(String[] args) throws IOException {
		ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);
				
		System.out.println("Introduce the Person ID:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int personId = Integer.parseInt(br.readLine());

		WebTarget service = client.target(getBaseURI("http://localhost:5500/vLifeCoachService"));
		MediaType media=MediaType.valueOf(MediaType.APPLICATION_XML);
		Person1 p= null;
		Response response=service.path("/person/"+personId).request().accept(media).get();
		int status=response.getStatus();
		if (status==200)
		{
			if(response.bufferEntity())
			{
				 p = response.readEntity(new GenericType<Person1>() {});
			}
				
			System.out.println("#########################################################");
			System.out.println("           WELCOME TO MY VIRTUAL COACH (OLD FASHION)     ");
			System.out.println("#########################################################");
			System.out.println("Firstname:"+p.getFirstname());
			System.out.println("Lastname:"+p.getLastname());
			System.out.println("Birthdate:"+p.getBirthdate());
			System.out.println("Email:"+p.getEmail());
			int option;
			do
			{
				System.out.println("Please select one of the option:");
				System.out.println("           1- My Measures     ");
				System.out.println("           2- My Goals        ");
				System.out.println("           3- My Tasks     ");
				System.out.println("           4- Today Messages   ");
				System.out.println("           5- Exit   ");
				option = Integer.parseInt(br.readLine());
				
				if (option==1) showMeasuresMenu(p, service, media);
				else if (option==2) showGoalsMenu(p, service, media);
				else if (option==3) showTasksMenu(p, service, media);
				else if (option==4) showTodayMessages(p, service, media);
			}
			while(option!=5);
				
		}
		else
		{
			System.out.println("ERROR: Person with ID="+personId+" not Found");
		}
		client.close();
	}

	private static URI getBaseURI(String URI) {
		return UriBuilder.fromUri(URI).build();
	}
	
	private static void showMeasuresMenu(Person1 p, WebTarget service,MediaType media ) throws IOException
	{
		String option;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Response response;
		int status;
		do
		{
			System.out.println("1- My Measures:");
			System.out.println("           a- Register new Measure     ");
			System.out.println("           b- List Measure Types        ");
			System.out.println("           c- List Recorded Measure History");
			System.out.println("           d- Back   ");
			option=br.readLine();
			if(option.equals("a"))
			{
				System.out.println("Measure:");
				String measure = br.readLine();
				System.out.println("Value:");
				String value = br.readLine();
				System.out.println("Date:");
				String date = br.readLine();
				
				MeasureHistory1 newM = new MeasureHistory1();
				newM.setMeasure(measure);
				newM.setValue(value);
				newM.setCreated(date);
				response=service.path("/person/"+p.getPersonId()+"/"+measure).request().accept(media).post(Entity.entity(newM, media));
				status=response.getStatus();
				if (status==200 || status==201)
				{
					System.out.println("Created");
					System.out.println(response.readEntity(MeasureHistory1.class).toString());
				}
				else
					System.out.println("ERROR CODE= "+status);
				br.readLine();
				
			}
			else
				if(option.equals("b"))
				{
					response=service.path("/measures").request().accept(media).get();
					status=response.getStatus();
					List<MeasureType> mh = new ArrayList<MeasureType>();

					if(response.bufferEntity())
						mh = response.readEntity(new GenericType<List<MeasureType>>() {});
					
					for(int i=0;i<mh.size();i++)
						System.out.println(mh.get(i).getMeasure());
					br.readLine();
				}
				else if(option.equals("c"))
				{
					response=service.path("/measures").request().accept(media).get();
					status=response.getStatus();
					List<MeasureType> mh = new ArrayList<MeasureType>();

					if(response.bufferEntity())
						mh = response.readEntity(new GenericType<List<MeasureType>>() {});
					
					for(int i=0;i<mh.size();i++)
					{
						response=service.path("/person/"+p.getPersonId()+"/"+mh.get(i).getMeasure()).request().accept(media).get();
						status=response.getStatus();
						List<MeasureHistory1> mhList = new ArrayList<MeasureHistory1>();

						if(response.bufferEntity())
							mhList = response.readEntity(new GenericType<List<MeasureHistory1>>() {});
						
						System.out.println(mh.get(i).getMeasure()+" History:");
						for(int j=0;j<mhList.size();j++)
						{
							System.out.println(mhList.get(j).toString());
						}
						System.out.println("------------------------------------------");
						
					}
					br.readLine();
				}
		}
		while(!option.endsWith("d"));
	}
	
	private static void showGoalsMenu(Person1 p, WebTarget service,MediaType media ) throws IOException
	{
		String option;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Response response;
		int status;
		
		do
		{
			System.out.println("2- My Goals:");
			System.out.println("           a- Register new Goal     ");
			System.out.println("           b- List Goal Types        ");
			System.out.println("           c- List Recorded Goal History");
			System.out.println("           d- Delete Goal");
			System.out.println("           e- Back   ");
			option=br.readLine();
			if(option.equals("a"))
			{
				System.out.println("Measure:");
				String measure = br.readLine();
				System.out.println("Value:");
				String value = br.readLine();
				System.out.println("Type:");
				String type = br.readLine();
				System.out.println("Date:");
				String date = br.readLine();
				
				Goal1 newG = new Goal1();
				newG.setMeasure(measure);
				newG.setValue(value);
				newG.setType(type);
				newG.setCreated(date);
				
				response=service.path("/goal/"+p.getPersonId()).request().accept(media).post(Entity.entity(newG, media));
				status=response.getStatus();
				if (status==200 || status==201)
				{
					System.out.println("Created");
					Goal1 created=response.readEntity(Goal1.class);
					System.out.println("GOAL ID:"+created.getGoalId());
					System.out.println("MEASURE:"+created.getMeasure());
					System.out.println("VALUE:"+created.getValue());
					System.out.println("TYPE:"+created.getType());
					System.out.println("DATE CREATED:"+created.getCreated());
					System.out.println();
				}
				else
					System.out.println("ERROR CODE= "+status);
				br.readLine();
				
			}
			else
				if(option.equals("b"))
				{
					response=service.path("/goal").request().accept(media).get();
					status=response.getStatus();
					List<GoalType1> gList = new ArrayList<GoalType1>();

					if(response.bufferEntity())
						gList = response.readEntity(new GenericType<List<GoalType1>>() {});
					System.out.println();
					for(int i=0;i<gList.size();i++)
					{
						System.out.println("Description:"+gList.get(i).getDescription());
						System.out.println("Measure:"+gList.get(i).getMeasureType());
						System.out.println("Type:"+gList.get(i).getType());
						System.out.println("-------------------------------------------------------------------");
					}
					System.out.println();
					br.readLine();
				}
				else if(option.equals("c"))
				{
					response=service.path("/goal/"+p.getPersonId()).request().accept(media).get();
					status=response.getStatus();
					List<Goal1> gList = new ArrayList<Goal1>();

					if(response.bufferEntity())
							gList = response.readEntity(new GenericType<List<Goal1>>() {});
						
						System.out.println("GOAL History:");
						for(int j=0;j<gList.size();j++)
						{
							System.out.println("GOAL ID:"+gList.get(j).getGoalId());
							System.out.println("MEASURE:"+gList.get(j).getMeasure());
							System.out.println("VALUE:"+gList.get(j).getValue());
							System.out.println("TYPE:"+gList.get(j).getType());
							System.out.println("DATE CREATED:"+gList.get(j).getCreated());
							System.out.println();
						}
						System.out.println("------------------------------------------");
						br.readLine();
				}
				else if(option.equals("d"))
				{
					System.out.println("Introduce GID to delete:");
					String gid = br.readLine();
					
					response=service.path("/goal/"+p.getPersonId()+"/"+gid).request().delete();
					status=response.getStatus();
					if (status==200)
						System.out.println("Deleted.");
					else
						System.out.println("ERROR CODE= "+status);
					br.readLine();
				}
		}
		while(!option.endsWith("e"));		
	}
	
	private static void showTasksMenu(Person1 p, WebTarget service,MediaType media ) throws IOException
	{
		String option;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Response response;
		int status;
		
		do
		{
			System.out.println("3- My Tasks:");
			System.out.println("           a- Register new Task     ");
			System.out.println("           b- List Recorded Tasks        ");
			System.out.println("           c- Delete Task");
			System.out.println("           d- Back   ");
			option=br.readLine();
			if(option.equals("a"))
			{
				System.out.println("Description:");
				String description = br.readLine();
				System.out.println("Type:");
				String type = br.readLine();
				System.out.println("WDay:");
				String wDay = br.readLine();
				System.out.println("MDay:");
				String mDay = br.readLine();
				System.out.println("Specif Date:");
				String sDate = br.readLine();
				System.out.println("Date Created:");
				String date = br.readLine();
				
				Reminder1 newR = new Reminder1();
				newR.setDescription(description);
				newR.setType(type);
				newR.setWDay(wDay);
				newR.setMDay(mDay);
				newR.setSDate(sDate);
				newR.setCreated(date);
				
				response=service.path("/reminder/"+p.getPersonId()).request().accept(media).post(Entity.entity(newR, media));
				status=response.getStatus();
				if (status==200 || status==201)
				{
					System.out.println("Created");
					Reminder1 created=response.readEntity(Reminder1.class);
					System.out.println("RID:"+created.getReminderId());
					System.out.println("Description:"+created.getDescription());
					System.out.println("Type:"+created.getType());
					System.out.println("WDay:"+created.getWDay());
					System.out.println("MDay:"+created.getMDay());
					System.out.println("Specif Date:"+created.getSDate());
					System.out.println("Date Created:"+created.getCreated());
					System.out.println();
				}
				else
					System.out.println("ERROR CODE= "+status);
				br.readLine();
				
			}
			else
				if(option.equals("b"))
				{
					response=service.path("/reminder/"+p.getPersonId()).request().accept(media).get();
					status=response.getStatus();
					List<Reminder1> rList = new ArrayList<Reminder1>();

					if(response.bufferEntity())
						rList = response.readEntity(new GenericType<List<Reminder1>>() {});
					System.out.println();
					System.out.println("REMINDERS:");
					for(int i=0;i<rList.size();i++)
					{
						System.out.println("RID:"+rList.get(i).getReminderId());
						System.out.println("Description:"+rList.get(i).getDescription());
						System.out.println("Type:"+rList.get(i).getType());
						System.out.println("WDay:"+rList.get(i).getWDay());
						System.out.println("MDay:"+rList.get(i).getMDay());
						System.out.println("Specif Date:"+rList.get(i).getSDate());
						System.out.println("Date Created:"+rList.get(i).getCreated());
						System.out.println("-------------------------------------------------------------------");
					}
					System.out.println();
					br.readLine();
				}
				else if(option.equals("c"))
				{
					System.out.println("Introduce RID to delete:");
					String rid = br.readLine();
					
					response=service.path("/reminder/"+p.getPersonId()+"/"+rid).request().delete();
					status=response.getStatus();
					if (status==200)
						System.out.println("Deleted.");
					else
						System.out.println("ERROR CODE= "+status);
					br.readLine();
				}
		}
		while(!option.endsWith("d"));
		
	}
	
	private static void showTodayMessages(Person1 p, WebTarget service,MediaType media ) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Response response;
		int status;
		
		System.out.println("#########################################################");
		System.out.println("     TODAY MESSAGES FOR "+p.getFirstname()+"             ");
		System.out.println("#########################################################");
		
		System.out.println();
		System.out.println("---------------------------------------------------------");
		System.out.println("     TODAY'S REMINDERS             ");
		System.out.println("----------------------------------------------------------");
		
		response=service.path("/persontrack/reminders/"+p.getPersonId()).request().accept(media).get();
		status=response.getStatus();
		//System.out.println(status);
		List<Reminder1> rList = new ArrayList<Reminder1>();

		if(response.bufferEntity())
			rList = response.readEntity(new GenericType<List<Reminder1>>() {});
		System.out.println();
		if(rList!=null)
		{
		for(int i=0;i<rList.size();i++)
		{
			System.out.println("RID:"+rList.get(i).getReminderId());
			System.out.println("Description:"+rList.get(i).getDescription());
			System.out.println("Type:"+rList.get(i).getType());
			System.out.println("WDay:"+rList.get(i).getWDay());
			System.out.println("MDay:"+rList.get(i).getMDay());
			System.out.println("Specif Date:"+rList.get(i).getSDate());
			System.out.println("Date Created:"+rList.get(i).getCreated());
			System.out.println("-------------------------------------------------------------------");
		}
		}
		System.out.println();
		System.out.println("Enter to continue.........");
		br.readLine();
	}
	
	public static String Formatted_Print(String content, MediaType media)
	{
		
		if (media.toString().equals("application/xml"))
		{
		try {
		    Transformer transformer = TransformerFactory.newInstance().newTransformer();
		    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		    transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
		 
		    StringWriter stringWriter = new StringWriter();
		    StreamResult streamResult = new StreamResult(stringWriter);
		    Source s = new StreamSource(new StringReader(content));
		    transformer.transform(s, streamResult);
		    return stringWriter.toString();
		}
		catch (Exception e) {
		   // e.printStackTrace();
			return content;
		}
		}
		else
		{
			return content;
			
			/*JSONTokener tokener = new JSONTokener(content); //tokenize the ugly JSON string
			JSONObject finalResult = new JSONObject(tokener); // convert it to JSON object
			System.out.println(finalResult.toString(4)); //
			*/ 
		}
	}
}
