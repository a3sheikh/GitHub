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


				
				int trafficRatePerMin=Integer.parseInt(args[0]);
				
				
				smartSpeedCamera Cam = new smartSpeedCamera();
				
				System.out.println("Camera Id:\t"+Cam.getCameraId()+"\t Camera Location : \t"+ Cam.getCityLocation()+"\t Camera Street : \t"+ 
						Cam.getStreetName()+"\t Camera Motoring Speed Limit : \t"+ Cam.getSpeedLimit()+"\t Starting Date : \t"+ Cam.getDate());
						System.out.println("Vehicle Monitoring the following Vehicle :");
						
				for(int i=0; i<trafficRatePerMin ; i++){
					
					
					
					Vehicle veh = new Vehicle();
					
					
					System.out.println("Vehicle :\t"+ veh.getType()+"\t\t Plate No:\t"+ veh.getPlateNo()+"\t Current Speed: \t"+veh.getCurrentSpeed());
										
				}
				
				
				
				/*Cam = new smartSpeedCamera();
				
				
				System.out.println("Camera Id:\t"+Cam.getCameraId()+"\t Camera Location : \t"+ Cam.getCityLocation()+"\t Camera Street : \t"+ 
						Cam.getStreetName()+"\t Camera Motoring Speed Limit : \t"+ Cam.getSpeedLimit()+"\t Starting Date : \t"+ Cam.getDate());
						System.out.println("Vehicle Monitoring the following Vehicle :");
						
				for(int i=0; i<trafficRatePerMin ; i++){
					
					
					
					Vehicle veh = new Vehicle();
					
					
					System.out.println("Vehicle :\t"+ veh.getType()+"\t\t Plate No:\t"+ veh.getPlateNo()+"\t Current Speed: \t"+veh.getCurrentSpeed());
										
				}*/
				
				
				
				
				
				Configuration config = ServiceBusConfiguration.configureWithSASAuthentication(
			      "myserverone",
			      "RootManageSharedAccessKey",
			      "u+VrqpAFoXrISGxmiQClcc+NKLu7eolULJ8nPV3zWnw=",
			      ".servicebus.windows.net"
			      );
				

			ServiceBusContract service = ServiceBusService.create(config);
		  
			service.deleteSubscription("CameraRecord", "Monitoring");
			service.deleteTopic("CameraRecord");
			
			
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
		
			
			SubscriptionInfo subInfo = new SubscriptionInfo("Monitoring");
			CreateSubscriptionResult result1 =  service.createSubscription("CameraRecord", subInfo);
			
			
			// Create message, passing a string message for the body
		    BrokeredMessage message = new BrokeredMessage("cameramessage");

		    // Set some additional custom app-specific property
		   message.setProperty("CameraId", Cam.getCameraId());
			
			
		    message.setProperty("CameraLocation", Cam.getCityLocation());
			
			
		    message.setProperty("CameraStreet", Cam.getStreetName());
			
			
		   message.setProperty("CameraSpeedLimit", Cam.getSpeedLimit());
		  
		   service.sendTopicMessage("CameraRecord", message);		 // Send message to the topic	

			
			
			
			/*SubscriptionInfo subInfo = new SubscriptionInfo("AllMessages");
			try {
				CreateSubscriptionResult result =  service.createSubscription("TestTopic", subInfo);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/				
				
		   
		   try
		   {
		       ReceiveMessageOptions opts = ReceiveMessageOptions.DEFAULT;
		       opts.setReceiveMode(ReceiveMode.PEEK_LOCK);

		       while(true)  {
		           ReceiveSubscriptionMessageResult  resultSubMsg = service.receiveSubscriptionMessage("CameraRecord", "HighMessages", opts);
		           message = resultSubMsg.getValue();
		           if (message != null && message.getMessageId() != null)
		           {
		               System.out.println("MessageID: " + message.getMessageId());
		               // Display the topic message.
		               System.out.print("From topic: ");
		               byte[] b = new byte[200];
		               String s = null;
		               int numRead = message.getBody().read(b);
		               while (-1 != numRead)
		               {
		                   s = new String(b);
		                   s = s.trim();
		                   System.out.print(s);
		                   numRead = message.getBody().read(b);
		               }
		               System.out.println();
		               System.out.println("Custom Property: " +
		                   message.getProperty("MessageNumber"));
		               // Delete message.
		               System.out.println("Deleting this message.");
		               service.deleteMessage(message);
		           }  
		           else  
		           {
		               System.out.println("Finishing up - no more messages.");
		               break;
		               // Added to handle no more messages.
		               // Could instead wait for more messages to be added.
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