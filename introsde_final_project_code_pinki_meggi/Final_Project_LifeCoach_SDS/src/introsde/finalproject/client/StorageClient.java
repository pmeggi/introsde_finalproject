package introsde.finalproject.client;

import introsde.finalproject.soap.Reminder;
import introsde.finalproject.soap.Goal;
import introsde.finalproject.soap.GoalType;
import introsde.finalproject.soap.MeasureHistory;
import introsde.finalproject.soap.MeasureType;
import introsde.finalproject.soap.Person;
import introsde.finalproject.storage.soap.Storage;

import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class StorageClient{
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:666/soap/storage?wsdl");
        //1st argument service URI, refer to wsdl document above
        //2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://soap.storage.finalproject.introsde/", "StorageService");
        Service service = Service.create(url, qname);
        Storage s = service.getPort(Storage.class);
        
        
    	System.out.println("******************** METHOD #4 - CREATE PERSON ********************");
    	
    	//int result=s.registerPerson("Pritesh", "Kotecha", "1975-10-04", "pkotecha", "777777");
    	
        //System.out.println ("Create Person Result="+result);
    	
    	Person newPerson = new Person();
    	newPerson.setFirstname("Pritesh");
    	newPerson.setLastname("Kotecha");
    	newPerson.setUsername("pkotecha");
    	newPerson.setPassword("66666666");
    	newPerson.setEmail("pvkk@email.com");
    	newPerson.setBirthdate("1975-10-04");
    	Person newPersonCreated = s.registerPerson(newPerson);
    	printPersonInfo(newPersonCreated);
    	
    	
    	System.out.println("******************** METHOD #8 - SAVE PERSON MEASUREMENT ********************");
        MeasureHistory mh1 = new MeasureHistory();
        MeasureType newMT1 = new MeasureType();
        newMT1.setMeasure("weight");
        mh1.setDateRegistered("2015-01-25");
        mh1.setMeasureType(newMT1);
        mh1.setMeasureValue("80");
        MeasureHistory newMH1 = s.registerPersonMeasurement(newPersonCreated.getIdPerson(), "weight",mh1); 
        Long newMid1=newMH1.getMid();
        System.out.println(newMid1);
        System.out.println();
       
        MeasureHistory mh2 = new MeasureHistory();
        MeasureType newMT2 = new MeasureType();
        newMT2.setMeasure("bloodpressure");
        mh2.setDateRegistered("2015-01-25");
        mh2.setMeasureType(newMT2);
        mh2.setMeasureValue("100");
        MeasureHistory newMH2 = s.registerPersonMeasurement(newPersonCreated.getIdPerson(),"bloodpressure", mh2); 
        Long newMid2=newMH2.getMid();
        System.out.println(newMid2);
        System.out.println();
        
        
        MeasureHistory mh3 = new MeasureHistory();
        MeasureType newMT3 = new MeasureType();
        newMT3.setMeasure("walkingsteps");
        mh3.setDateRegistered("2015-01-25");
        mh3.setMeasureType(newMT3);
        mh3.setMeasureValue("500");
        MeasureHistory newMH3 = s.registerPersonMeasurement(newPersonCreated.getIdPerson(),"walkingsteps", mh3); 
        Long newMid3=newMH3.getMid();
        System.out.println(newMid3);
        System.out.println();
        
        MeasureHistory mh4 = new MeasureHistory();
        MeasureType newMT4 = new MeasureType();
        newMT4.setMeasure("sleepinghours");
        mh4.setDateRegistered("2015-01-25");
        mh4.setMeasureType(newMT4);
        mh4.setMeasureValue("10");
        MeasureHistory newMH4 = s.registerPersonMeasurement(newPersonCreated.getIdPerson(),"sleepinghours", mh4); 
        Long newMid4=newMH4.getMid();
        System.out.println(newMid4);
        System.out.println();
        
        System.out.println("******************** METHOD #6 - READ PERSON MEASURE HISTORY ********************");
        List<MeasureHistory> mhList = s.readPersonMeasureHistory(newPersonCreated.getIdPerson(), "weight"); 
        listAllMeasureHistory(mhList);
        System.out.println();
        mhList = s.readPersonMeasureHistory(newPersonCreated.getIdPerson(), "bloodpressure"); 
        listAllMeasureHistory(mhList);
        System.out.println();
        mhList = s.readPersonMeasureHistory(newPersonCreated.getIdPerson(), "walkingsteps"); 
        listAllMeasureHistory(mhList);
        System.out.println();
        mhList = s.readPersonMeasureHistory(newPersonCreated.getIdPerson(), "sleepinghours"); 
        listAllMeasureHistory(mhList);
        System.out.println();
                
        System.out.println("******************** METHOD #8 - SAVE PERSON GOALS ********************");
        Goal g1 = new Goal();
        g1.setDateRegistered("2015-01-25");
        g1.setGoalValue("0.5");
        Goal newG1 = s.registerPersonGoal(newPersonCreated.getIdPerson(),"weight","weekly", g1); 
        Long newGID1=newG1.getIdGoal();
        System.out.println(newGID1);
        System.out.println();
        
        Goal g3 = new Goal();
        g3.setDateRegistered("2015-01-25");
        g3.setGoalValue("2000");
        Goal newG3 = s.registerPersonGoal(newPersonCreated.getIdPerson(),"walkingsteps","daily", g3); 
        Long newGID3=newG3.getIdGoal();
        System.out.println(newGID3);
        System.out.println();
        
        Goal g4 = new Goal();
        g4.setDateRegistered("2015-01-25");
        g4.setGoalValue("10");
        Goal newG4 = s.registerPersonGoal(newPersonCreated.getIdPerson(),"sleepinghours","daily", g4); 
        Long newGID4 = newG4.getIdGoal();
        System.out.println(newGID4);
        System.out.println();
       
        System.out.println("******************** METHOD #6 - READ PERSON GOALs ********************");
        List<Goal> gList = s.readPersonGoalHistory(newPersonCreated.getIdPerson()); 
        listAllGoalHistory(gList);
        
        System.out.println("******************** METHOD #8 - SAVE PERSON REMINDERS ********************");
        Reminder r1 = new Reminder();
        r1.setDescription(" Go to walk at 7pm");
        r1.setTypeReminder("daily");
        r1.setDateRegistered("25-01-2015");
        
        Reminder newR1 = s.registerPersonReminder(newPersonCreated.getIdPerson(), r1); 
        Long newrid1=newR1.getIdReminder();
        System.out.println(newrid1);
        System.out.println();
       
        Reminder r3 = new Reminder();
        r3.setDescription("Measure weight before sleep");
        r3.setTypeReminder("weekly");
        r3.setWDay("Monday");
        r3.setDateRegistered("25-01-2015");
        Reminder newR3 = s.registerPersonReminder(newPersonCreated.getIdPerson(), r3); 
        Long newrid3=newR3.getIdReminder();
        System.out.println(newrid3);
        System.out.println();
        
        Reminder r4 = new Reminder();
        r4.setDescription("Go to doctor appointment");
        r4.setTypeReminder("specific_date");
        r4.setSDate("27-02-2015");
        r4.setDateRegistered("30-01-2015");
        Reminder newR4 = s.registerPersonReminder(newPersonCreated.getIdPerson(), r4); 
        Long newrid4=newR4.getIdReminder();
        System.out.println(newrid4);
        System.out.println();
        

        System.out.println("******************** METHOD #6 - READ PERSON MEASURE HISTORY ********************");
        List<Reminder> rList = s.readPersonReminders(newPersonCreated.getIdPerson()); 
        
        for (int i=0; i<rList.size();i++){
        	Reminder r= rList.get(i);
        	System.out.println("	RID:"+ r.getIdReminder());
         	System.out.println("	Date Registerd:"+ r.getDateRegistered());
         	System.out.println("	Description:"+ r.getDescription());
         	System.out.println("	Type:"+ r.getTypeReminder());
         	System.out.println("	WDay:"+ r.getWDay());
         	System.out.println("	MDay:"+ r.getMDay());
         	System.out.println("	SDate:"+ r.getSDate());
         	System.out.println();
        }
        System.out.println();
 	    	  
    }
    
	public static void printPersonInfo(Person p) throws ParseException{
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		
		System.out.println("ID:"+ p.getIdPerson());
   	 	System.out.println("Full Name: "+p.getFirstname()+" "+p.getLastname());
     	//System.out.println("BirthDate: "+df.format(p.getBirthdate()));
   	 	System.out.println("BirthDate: "+p.getBirthdate());
   	 	System.out.println("Email: "+p.getEmail());
	 	System.out.println("Username: "+p.getUsername());
     	System.out.println("Password: "+p.getPassword());
     	
    }
	
	public static void printMeasureInfo(MeasureHistory m){
		System.out.println("	MID:"+ m.getMid());
     	MeasureType t = m.getMeasureType();
     	System.out.println("	Date Registerd:"+ m.getDateRegistered());
     	System.out.println("	Measure Type:"+ t.getMeasure());
     	System.out.println("	Measure Value:"+ m.getMeasureValue());
    }
 
	public static void printGoalInfo(Goal g){
		System.out.println("	GID:"+ g.getIdGoal());
     	GoalType t = g.getGoalType();
     	System.out.println("	Date Registerd:"+ g.getDateRegistered());
     	System.out.println("	Measure Type:"+ t.getMeasureType().getMeasure());
     	System.out.println("	Description:"+ t.getDescription());
     	System.out.println("	Goal Type:"+ t.getType());
     	System.out.println("	Goal Value:"+ g.getGoalValue());
    }
 
	public static void listAllMeasureHistory(List<MeasureHistory> mhList){
	    	for (int i=0; i<mhList.size();i++){
	        	printMeasureInfo(mhList.get(i));
	        	System.out.println();
	    	}
	}
	    
	public static void listAllGoalHistory(List<Goal> mhList){
	  	for (int i=0; i<mhList.size();i++){
	        	printGoalInfo(mhList.get(i));
	        	System.out.println();
	    	}
	    }
}