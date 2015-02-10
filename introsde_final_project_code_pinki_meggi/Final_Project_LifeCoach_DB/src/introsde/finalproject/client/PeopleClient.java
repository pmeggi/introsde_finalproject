package introsde.finalproject.client;

import introsde.finalproject.model.MeasureHistory;
import introsde.finalproject.model.Person;
import introsde.finalproject.model.MeasureType;
import introsde.finalproject.soap.People;

import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class PeopleClient{
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:777/soap/people?wsdl");
        //1st argument service URI, refer to wsdl document above
        //2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://soap.finalproject.introsde/", "PeopleService");
        Service service = Service.create(url, qname);
        People people = service.getPort(People.class);
        
    	System.out.println("******************** METHOD #1 - LIST ALL PEOPLE ********************");
    	System.out.println("Method #1: readPersonList() => List");
    	System.out.println("Data Sent: people.readPersonList()");
    	System.out.println("Data Received:");
    	List<Person> pList = people.readPersonList();
    	listAllPeople(pList);
    	System.out.println();
    
    	System.out.println("******************** METHOD #2 - READ PERSON ********************");
    	Long firstId = pList.get(0).getIdPerson();
    	Long lastId = pList.get(pList.size()-1).getIdPerson();
    	System.out.println("Method #2: readPerson(Long id) => Person");
    	System.out.println("Data Sent: request for First Person => people.readPerson("+firstId+")");
    	System.out.println("Data Received:");
    	Person firstPerson = people.readPerson(firstId);
    	printPersonInfo(firstPerson);
    	System.out.println("Data Sent: request for Last Person => people.readPerson("+lastId+")");
    	System.out.println("Data Received:");
    	Person lastPerson = people.readPerson(lastId);
    	printPersonInfo(lastPerson);
    	System.out.println();
    
    	System.out.println("******************** METHOD #3 - UPDATE PERSON ********************");
    	String newName="Pinki";
    	firstPerson.setFirstname(newName);
    	System.out.println("Method #3: updatePerson(Person p) => Person");
    	System.out.println("Data Sent: update the First Person firstname with Pinki => people.updatePerson("+firstPerson+")");
    	System.out.println("Data Received:");
    	Person firstPersonUpdated = people.updatePerson(firstPerson);
    	printPersonInfo(firstPersonUpdated);
    	System.out.println();
    
    	System.out.println("******************** METHOD #4 - CREATE PERSON ********************");
    	Person newPerson = new Person();
    	newPerson.setFirstname("Pritesh");
    	newPerson.setLastname("Kotecha");
    	newPerson.setUsername("pkotecha");
    	newPerson.setPassword("777777");
    	newPerson.setEmail("pvkk@email.com");
    	
    	
    	DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate = df.parse("1975-10-04"); 
    	newPerson.setBirthdate("1975-10-04");
	
    	System.out.println("Method #4: createPerson(Person p) => Person");
    	System.out.println("Data Sent: people.createPerson("+newPerson+")");
    	System.out.println("Data Received:");
    	Person newPersonCreated = people.createPerson(newPerson);
    	printPersonInfo(newPersonCreated);
    	System.out.println();
    
    	System.out.println("******************** METHOD #5 - DELETE PERSON ********************");
    	System.out.println("Method #5: deletePerson(Long id) => int");
    	System.out.println("Data Sent: people.deletePerson("+newPersonCreated.getIdPerson()+")");
    	System.out.println("Data Received:");
    	System.out.println(people.deletePerson(newPersonCreated.getIdPerson()));
    	System.out.println("Checking if deleted:");
    	System.out.println("Data Sent: people.readPerson("+ newPersonCreated.getIdPerson()+")");
    	Person deletedPerson = people.readPerson(newPersonCreated.getIdPerson());
    	System.out.println("Data Received:");
    	System.out.println(deletedPerson);
    	System.out.println();
       
    	
    	System.out.println("******************** METHOD #8 - SAVE PERSON MEASUREMENT ********************");
        MeasureHistory mh = new MeasureHistory();
        MeasureType newMT = new MeasureType();
        newMT.setMeasureType("weight");
        mh.setDateRegistered("2014-11-28");
        mh.setMeasureType(newMT);
        mh.setMeasureValue("80");
        
        System.out.println("Method #8: savePersonMeasurement(Long id, Measure m) => mid");
        System.out.println("Data Sent: Update the weigth measure of first person => people.savePersonMeasurement("+firstId+","+mh+")");
        System.out.println("Data Received:");
        MeasureHistory newMH = people.createPersonMeasurement(firstId,"weight", mh); 
        Long newMid=newMH.getMid();
        System.out.println(newMid);
        System.out.println();
       
        System.out.println("******************** METHOD #6 - READ PERSON MEASURE HISTORY ********************");
        System.out.println("Method #6: readPersonHistory(Long id, String measureType) => List");
        System.out.println("Data Sent: first person weight history => people.readPersonHistory("+firstId+", weight)");
        System.out.println("Data Received:");
        List<MeasureHistory> mhList = people.readPersonMeasureHistory(firstId, "weight"); 
        listAllMeasureHistory(mhList);
        System.out.println();
        
        System.out.println("******************** METHOD #7 - READ PERSON MEASUREMENT ********************");
        Long firstMid = new Long(0);
        if (mhList.get(0)!= null)
        	firstMid= mhList.get(0).getMid();
        System.out.println("Method #7: readPersonMeasurement(Long id, String measureType, Long mid)");
        System.out.println("Data Sent: first person first weight measure => people.readPersonMeasurement("+firstId+", weight,"+firstMid+")");
        System.out.println("Data Received:");
        MeasureHistory m = people.readPersonMeasurement(firstId, "weight", firstMid); 
        if (m!=null) printMeasureInfo(m);
        else System.out.println(m);
        System.out.println();

        
        System.out.println("******************** METHOD #9 - READ MEASUERETYPES ********************");
    	System.out.println("Method #9: readMeasureTypes() => List");
    	System.out.println("Data Sent: people.readMesureTypes()");
    	System.out.println("Data Received:");
    	List<String> mList = people.readMeasureTypes();
    	System.out.println(mList);
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
     	System.out.println("	Measure Type:"+ t.getMeasureType());
     	System.out.println("	Measure Value:"+ m.getMeasureValue());
    }
 
	public static void listAllPeople(List<Person> pList) throws ParseException{
    	for (int i=0; i<pList.size();i++){
    		printPersonInfo(pList.get(i));
        	System.out.println();
    	}
    }
 
    public static void listAllMeasureHistory(List<MeasureHistory> mhList){
    	for (int i=0; i<mhList.size();i++){
        	printMeasureInfo(mhList.get(i));
        	System.out.println();
    	}
    }   
}