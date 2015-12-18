import com.microsoft.azure.storage.table.TableServiceEntity;


public class VehicleTable extends TableServiceEntity {

	private String plateNo;
	private String type;
	private int currentSpeed;
	
	
	
	public VehicleTable(Object object,Object object2, Object object3 ) {
		// TODO Auto-generated constructor stub
		this.plateNo=setPlateNo( object);
		this.type=setType( object2);
		
		this.currentSpeed=setCurrentSpeed(object3);
		
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int getCurrentSpeed() {
		return currentSpeed;
	}

	public int setCurrentSpeed(Object object3) {
		return this.currentSpeed = (int) object3;
	}

	public String getType() {
		return type;
	}

	public String setType(Object object2) {
		return this.type = (String) object2;
	}

	public String getPlateNo() {
		return plateNo;
	}

	public String setPlateNo(Object object) {
		return this.plateNo = (String) object;
	}



}
