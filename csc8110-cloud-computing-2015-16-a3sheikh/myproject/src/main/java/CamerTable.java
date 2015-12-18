import com.microsoft.azure.storage.table.TableServiceEntity;


public class CamerTable extends TableServiceEntity {

	private String location;
	private String street;
	private String cameraId;
	private int speedLimit;
	
	
	
	public CamerTable(Object object,Object object2, Object object3,Object object4 ) {
		// TODO Auto-generated constructor stub
		this.location= this.setLocation(object);
		this.street= this.setStreet(object2);
		this.cameraId=this.setCameraId(object3);
		this.speedLimit=this.setSpeedLimit(object4);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int getSpeedLimit() {
		return speedLimit;
	}

	public int setSpeedLimit(Object object4) {
		return this.speedLimit = (int) object4;
	}

	public String getCameraId() {
		return cameraId;
	}

	public String setCameraId(Object object3) {
		return this.cameraId = (String) object3;
	}

	public String getStreet() {
		return street;
	}

	public String setStreet(Object object2) {
		return this.street = (String) object2;
	}

	public String getLocation() {
		return location;
	}

	public String setLocation(Object object) {
		return this.location = (String) object;
	}

}
