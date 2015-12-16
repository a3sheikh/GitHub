import java.util.ArrayList;
import java.util.Random;

import com.microsoft.windowsazure.Configuration;
import com.microsoft.windowsazure.services.servicebus.*;
import com.microsoft.windowsazure.services.servicebus.models.*;
import com.microsoft.windowsazure.core.*;
import com.microsoft.windowsazure.exception.ServiceException;

import javax.xml.datatype.*;



public class App
{
	
	 
	
	
	public static void main( String[] args ){

		
				
		
			/*Configuration config = ServiceBusConfiguration.configureWithSASAuthentication(
				      "myserverone",
				      "RootManageSharedAccessKey",
				      "u+VrqpAFoXrISGxmiQClcc+NKLu7eolULJ8nPV3zWnw=",
				      ".servicebus.windows.net"
				      );

				ServiceBusContract service = ServiceBusService.create(config);
				TopicInfo topicInfo = new TopicInfo("TestTopic");
				try  
				{
				    CreateTopicResult result = service.createTopic(topicInfo);
				}
				catch (ServiceException e) {
				    System.out.print("ServiceException encountered: ");
				    System.out.println(e.getMessage());
				    System.exit(-1);
				}
			
				
				
				SubscriptionInfo subInfo = new SubscriptionInfo("AllMessages");
				try {
					CreateSubscriptionResult result =
					    service.createSubscription("TestTopic", subInfo);
				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
			
				
				int trafficRatePerMin=Integer.parseInt(args[0]);
				
				smartSpeedCamera CityCam = new smartSpeedCamera();
				
				
				System.out.println("CityCam Id:\t"+CityCam.getCameraId()+"\t Camera Location : \t"+ CityCam.getCityLocation()+"\t Camera Street : \t"+ 
						CityCam.getStreetName()+"\t Camera Motoring Speed Limit : \t"+ CityCam.getSpeedLimit()+"\t Starting Date : \t"+ CityCam.getDate());
						System.out.println("Vehicle Monotored :");
						
				for(int i=0; i<trafficRatePerMin ; i++){
					
					
					
					Vehicle veh = new Vehicle();
					
					
					System.out.println("Vehicle :\t"+ veh.getType()+"\t\t Plate No:\t"+ veh.getPlateNo()+"\t Current Speed: \t"+veh.getCurrentSpeed());
										
				}
				
		

					



}}