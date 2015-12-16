/**
 * 
 */

/**
 * @author b4026838
 *
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;



public class smartSpeedCamera {

	private String location;
	private String streetName;
	private int speedLimit;
	private Date date;	
	private String cameraId;
	
	
	
	
	public String getCameraId() {
		return cameraId;
	}
	
	public String setCameraId() {
		return this.cameraId = createRandomRegistryId();
	}
	
	public String getCityLocation() {
		return location;
	}
	
	public String setCityLocation() {
		
		return createRandomLocation();
	}
	
	public String getStreetName() {
		return streetName;
	}
	
	public String setStreetName() {
		ArrayList<String> StreetNames = new ArrayList<String>();
		StreetNames.add("City Road");
		StreetNames.add("Mill Road");
		StreetNames.add("Westgate Road");
		
		if(this.location=="City centre"){ 
			return StreetNames.get(0);
		}
		else if(this.location=="Gateshead"){return StreetNames.get(1); }
		else{ return StreetNames.get(2);}
		
			
	}
	
	public int getSpeedLimit() {
		return speedLimit;
	}
	
	public int setSpeedLimit() {
		return createRandomSpeedLimit();
	}
	
	public Date getDate() {
		return date;
	}
	
	public Date setDate() {
	return	this.date = new Date();
	}
	
	public int createRandomSpeedLimit(){
		
		ArrayList<Integer> SpeedLimit = new ArrayList<Integer>();
		SpeedLimit.add(20);
		SpeedLimit.add(30);
		SpeedLimit.add(40);
		
		
		
		
		Random random = new Random();
		int index= random.nextInt(SpeedLimit.size());

			return SpeedLimit.get(index);
		}
	
	
/**
 * @return cameraId random generator
 */
public String createRandomRegistryId()
	{
	    // syntax  would like to generate is DIA123456-A1B34      
	    String val = "DI";      

	    // char (1), random A-Z
	    int ranChar = 65 + (new Random()).nextInt(90-65);
	    char ch = (char)ranChar;        
	    val += ch;      

	    // numbers (6), random 0-9
	    Random r = new Random();
	    int numbers = 100000 + (int)(r.nextFloat() * 899900);
	    val += String.valueOf(numbers);

	    val += "-";
	    // char or numbers (5), random 0-9 A-Z
	    for(int i = 0; i<6;){
	        int ranAny = 48 + (new Random()).nextInt(90-65);

	        if(!(57 < ranAny && ranAny<= 65)){
	        char c = (char)ranAny;      
	        val += c;
	        i++;
	        }

	    }

	    return val;
	}

public String createRandomLocation(){
	
	ArrayList<String> CameraInfo = new ArrayList<String>();
	CameraInfo.add("City Centre");
	CameraInfo.add("Fenham");
	CameraInfo.add("Gateshead");
	
	Random random = new Random();
	int index= random.nextInt(CameraInfo.size());
	
	
	return CameraInfo.get(index);
}







	
/**
 *  Constructor
 */
public smartSpeedCamera() {

	cameraId = setCameraId() ;
	date= setDate();
	location = setCityLocation();
	streetName= setStreetName();
	speedLimit= setSpeedLimit();
}


public static void main( String[] args ){
	smartSpeedCamera CityCam = new smartSpeedCamera(); 
	smartSpeedCamera Fenham = new smartSpeedCamera();
	
	System.out.println("CityCam Id:\t"+CityCam.getCameraId()+"\t Camera Location : \t"+ CityCam.getCityLocation()+"\t Camera Street : \t"+ 
	CityCam.getStreetName()+"\t Camera Motoring Speed Limit : \t"+ CityCam.getSpeedLimit()+"\t Starting Date : \t"+ CityCam.getDate());
	
	System.out.println("Fenham Id:\t"+Fenham.getCameraId()+"\t Camera Location : \t"+ Fenham.getCityLocation()+"\t\t Camera Street : \t"+ 
			Fenham.getStreetName()+"\t Camera Motoring Speed Limit : \t"+ Fenham.getSpeedLimit()+"\t Starting Date : \t"+ Fenham.getDate());
		
}
}
	


