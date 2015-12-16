/**
 * 
 */

/**
 * @author b4026838
 *
 */
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
	
	public String setCityLocation(String cityLocation) {
		return this.location = cityLocation;
	}
	
	public String getStreetName() {
		return streetName;
	}
	
	public String setStreetName(String streetName) {
	return	this.streetName = streetName;
	}
	
	public int getSpeedLimit() {
		return speedLimit;
	}
	
	public int setSpeedLimit(int speedLimit) {
		return this.speedLimit = speedLimit;
	}
	
	public Date getDate() {
		return date;
	}
	
	public Date setDate() {
	return	this.date = new Date();
	}
	
	/**
	 *  Constructor
	 */
	public smartSpeedCamera(String location, String streetName, int speedLimit) {
	
		cameraId = setCameraId() ;
		date= setDate();
		location = setCityLocation(location);
		streetName= setStreetName(streetName);
		speedLimit= setSpeedLimit(speedLimit);
	}
	
	
/**
 * @return cameraId random generator
 */
public String createRandomRegistryId()
	{
	    // syntax we would like to generate is DIA123456-A1B34      
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
	



public static void main( String[] args ){
	smartSpeedCamera CityCam = new smartSpeedCamera("City Centre","City Road",30); 
	smartSpeedCamera Fenham = new smartSpeedCamera("Fenham","West Road",40);
	
	System.out.println("CityCam Id:\t"+CityCam.getCameraId()+"\t Camera Location : \t"+ CityCam.getCityLocation()+"\t Camera Street : \t"+ 
	CityCam.getStreetName()+"\t Camera Motoring Speed Limit : \t"+ CityCam.getSpeedLimit()+"\t Starting Date : \t"+ CityCam.getDate());
	
	System.out.println("Fenham Id:\t"+Fenham.getCameraId()+"\t Camera Location : \t"+ Fenham.getCityLocation()+"\t\t Camera Street : \t"+ 
			Fenham.getStreetName()+"\t Camera Motoring Speed Limit : \t"+ Fenham.getSpeedLimit()+"\t Starting Date : \t"+ Fenham.getDate());
	
}
}
	


