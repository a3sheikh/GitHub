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
	
	 
	
	
	public static void main( String[] args ) throws ServiceException{

		// create config to connect with service Bus
		Configuration config = ServiceBusConfiguration.configureWithSASAuthentication(
	      "myserverone",
	      "RootManageSharedAccessKey",
	      "u+VrqpAFoXrISGxmiQClcc+NKLu7eolULJ8nPV3zWnw=",
	      ".servicebus.windows.net"
	      );
		
		ServiceBusContract service = ServiceBusService.create(config);
		// this code to delete any topcs and subscription exist for testing 
		service.deleteSubscription("CameraRecord", "Monitoring");
		service.deleteTopic("CameraRecord");
		
		//to create topic with size 5GB
		long maxSizeInMegabytes = 5120;
		TopicInfo topicInfo = new TopicInfo("CameraRecord");
		topicInfo.setMaxSizeInMegabytes(maxSizeInMegabytes);
		try  
		{
		    CreateTopicResult result = service.createTopic(topicInfo);
		}
		catch (ServiceException e) {
		   System.out.print("ServiceException encountered: ");
		    System.out.println(e.getMessage());
		    System.exit(-1);
		}
	
		//crate subscription 
		SubscriptionInfo subInfo = new SubscriptionInfo("Monitoring");
		CreateSubscriptionResult result1 =  service.createSubscription("CameraRecord", subInfo);
		
		//define traffic Rate Per Min reads from arsg[0] 		
		int trafficRatePerMin=Integer.parseInt(args[0]);
				
				
		//crate Speed Camera with random information 
				smartSpeedCamera Cam = new smartSpeedCamera();
			// print camera information 
				System.out.println("Camera Id:\t"+Cam.getCameraId()+"\t Camera Location : \t"+ Cam.getCityLocation()+"\t Camera Street : \t"+ 
						Cam.getStreetName()+"\t Camera Motoring Speed Limit : \t"+ Cam.getSpeedLimit()+"\t Starting Date : \t"+ Cam.getDate());
						System.out.println("Vehicle Monitoring the following Vehicle :");
						
						
						// submitting camera information to the topic 
						// Create message, passing a string message for the body
					    BrokeredMessage message = new BrokeredMessage("cameramessage");

					    // Set some additional custom app-specific property
					   message.setProperty("CameraId", Cam.getCameraId());
						
						
					    message.setProperty("CameraLocation", Cam.getCityLocation());
						
						
					    message.setProperty("CameraStreet", Cam.getStreetName());
						
						
					   message.setProperty("CameraSpeedLimit", Cam.getSpeedLimit());
					  
					   service.sendTopicMessage("CameraRecord", message);		 // Send message to the topic	

					   
					   
					   
					   
				// create Vehicles Monitored by speed camera depends on the traffic rate reads from args.
					   for(int i=0; i<trafficRatePerMin ; i++){
					
					
					
					Vehicle veh = new Vehicle();
					
					
					System.out.println("Vehicle :\t"+ veh.getType()+"\t\t Plate No:\t"+ veh.getPlateNo()+"\t Current Speed: \t"+veh.getCurrentSpeed());
					//adding vehicle information to current speed camera of the same topic
					 message.setProperty("VehicleType", veh.getType());
					 message.setProperty("VehiclePlateNo", veh.getPlateNo());
					 message.setProperty("VehicleCurrentSpeed", veh.getCurrentSpeed());
					 service.sendTopicMessage("CameraRecord", message);
					
				}
				
				
				
				
		   // This code will print all Vehicle monitored by a speed camera and the camera information from the messages 
		   //that sent to the topic and from the subscription adopted from practical materials and modified 
					   try
					   {
					       ReceiveMessageOptions opts = ReceiveMessageOptions.DEFAULT;
					       opts.setReceiveMode(ReceiveMode.PEEK_LOCK);

					       while(true)  {
					           ReceiveSubscriptionMessageResult  resultSubMsg = service.receiveSubscriptionMessage("CameraRecord", "Monitoring", opts);
					           message = resultSubMsg.getValue();
					           if (message != null && message.getProperty("CameraId") != null)
					           {
					               
					               // Display the topic message.
					               System.out.print("From topic: "+"CameraRecord");
					               byte[] b = new byte[200];
					               String s = null;
					               int numRead = message.getBody().read(b);
					               while (-1 != numRead)
					               {
					                   s = new String(b);
					                   s = s.trim();
					                  
					                   numRead = message.getBody().read(b);
					               }
					             
					              
					               System.out.println();
					               System.out.println("CameraId: " + message.getProperty("CameraId"));
					               System.out.println("CameraLocation: " + message.getProperty("CameraLocation"));
					               System.out.println("CameraStreet: " + message.getProperty("CameraStreet"));
					               System.out.println("CameraSpeedLimit: " + message.getProperty("CameraSpeedLimit"));
					           					            	  					              
					               System.out.println();
					               System.out.println("VehicleType: " + message.getProperty("VehicleType"));
					               System.out.println("VehiclePlateNo: " + message.getProperty("VehiclePlateNo"));
					               System.out.println("VehicleCurrentSpeed: " + message.getProperty("VehicleCurrentSpeed"));
					               // Delete message.
					               System.out.println("Deleting this message.");
					               service.deleteMessage(message);
					           }  
					           
					           
					          
					           else  
					           {
					               System.out.println("Finishing up - no more messages.");
					               break;
					              
					           }
					       }
					   }
					   catch (ServiceException e) {
					       System.out.print("ServiceException encountered: ");
					       System.out.println(e.getMessage());
					       System.exit(-1);
					   }
					   catch (Exception e) {
					       System.out.print("Generic exception encountered: ");
					       System.out.println(e.getMessage());
					       System.exit(-1);
					   }
		   
		   
		   
		   

		   
		   
				
					
}}