import java.util.ArrayList;
import java.util.Random;

/**
 * 
 */

/**
 * @author b4026838
 *
 */
public class Vehicle {
	
	
	private String plateNo;
	private String type;
	private int currentSpeed;
	
	
	public String getPlateNo() {
		return plateNo;
	}

	public void setPlateNo(String plateNo) {
		this.plateNo = plateNo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCurrentSpeed() {
		return currentSpeed;
	}

	public void setCurrentSpeed(int currentSpeed) {
		this.currentSpeed = currentSpeed;
	}
	
	/**
	 * @return PlateNo random generator
	 */
	public String createRandomPlate()
		{
		    // syntax we would like to generate is DIA1-A34      
		    String val = "";      

		    // char (1), random A-Z
		    int ranChar = 65 + (new Random()).nextInt(90-65);
		    char ch = (char)ranChar;        
		    val += ch;      

		    // numbers (3), random 0-9
		    Random r = new Random();
		    int numbers = 100 + (int)(r.nextFloat() * 89);
		    val += String.valueOf(numbers);

		    val += "-";
		    // char or numbers (5), random 0-9 A-Z
		    for(int i = 0; i<3;){
		        int ranAny = 48 + (new Random()).nextInt(90-65);

		        if(!(57 < ranAny && ranAny<= 65)){
		        char c = (char)ranAny;      
		        val += c;
		        i++;
		        }

		    }

		    return val;
		}
	
	
	public String createRandomType(){
		
		ArrayList<String> vehiclelType = new ArrayList<String>();
		vehiclelType.add("Car");
		vehiclelType.add("Truck");
		vehiclelType.add("Motorcycle");
		
		Random random = new Random();
		int index= random.nextInt(vehiclelType.size());
		
		
		return vehiclelType.get(index);
	}
	
public int createRandomSpeed(){
		
	ArrayList<Integer> vehiclelSpeed = new ArrayList<Integer>();
	vehiclelSpeed.add(30);
	vehiclelSpeed.add(40);
	vehiclelSpeed.add(50);
	vehiclelSpeed.add(60);
	vehiclelSpeed.add(70);
	vehiclelSpeed.add(80);
	
	
	
	Random random = new Random();
	int index= random.nextInt(vehiclelSpeed.size());

		return vehiclelSpeed.get(index);
	}
	
	
	
	/**
	 * Constructor for Vehiacle
	 */
	public Vehicle() {
		plateNo= createRandomPlate();
		type = createRandomType();
		currentSpeed = createRandomSpeed();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Vehicle veh = new Vehicle();
		System.out.println("Type : \t"+veh.getType()+"\t Plate = "+ veh.getPlateNo()+"\t Current Speed : \t"+veh.getCurrentSpeed());
	}

}
