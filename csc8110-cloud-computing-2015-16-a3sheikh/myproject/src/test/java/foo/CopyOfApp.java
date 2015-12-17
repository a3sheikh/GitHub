

// import com.microsoft.azure.storage.util;
import com.microsoft.azure.storage.*;

import java.sql.*;

import com.microsoft.sqlserver.jdbc.*;
import com.microsoft.windowsazure.Configuration;
import com.microsoft.windowsazure.services.servicebus.*;
import com.microsoft.windowsazure.services.servicebus.models.*;
import com.microsoft.windowsazure.core.*;
import com.microsoft.windowsazure.exception.ServiceException;

import javax.xml.datatype.*;
/**
 * Abdullah Sheikh
 *
 */



public class CopyOfApp 
{
    public static void main( String[] args )
    {
        System.out.println( "Abdullah Sheikh!" );
        System.out.println();
        
        
        Configuration config =
        	    ServiceBusConfiguration.configureWithSASAuthentication(
        	      "HowToSample",
        	      "RootManageSharedAccessKey",
        	      "SAS_key_value",
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
        
        
        
        
        // Connection string for your SQL Database server.
        // Change the values assigned to your_server, 
        // your_user@your_server,
        // and your_password.
       
        String connectionString = 
            "jdbc:sqlserver://myserverone.database.windows.net:1433" + ";" +  
                "database=mydatabase" + ";" + 
                "user=a3sheikh@myserverone" + ";" +  
                "password=Newcastle2015" + ";" +
                "encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30";
        

        // The types for the following variables are
        // defined in the java.sql library.
        Connection connection = null;  // For making the connection
        Statement statement = null;    // For the SQL statement
        ResultSet resultSet = null;    // For the result set, if applicable

        try
        {
            // Ensure the SQL Server driver class is available.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Establish the connection.
            connection = DriverManager.getConnection(connectionString);

                    
           String sqlString = "DROP TABLE Customer";

            // Use the connection to create the SQL statement.
            statement = connection.createStatement();

            // Execute the statement.
            statement.executeUpdate(sqlString);
            
            // Provide a message when processing is complete.
            System.out.println("Processing complete.");
            
         
            
            
            // Define the SQL string create tables Customer, orders, location.
         sqlString = 
                "CREATE TABLE Customer (" + 
                    "[CustomerID] [int] IDENTITY(1,1) NOT NULL," +
                    "[LastName] [nvarchar](50) NOT NULL," + 
                    "[FirstName] [nvarchar](50) NOT NULL,"+
                    "[Location] [nvarchar] (10) NOT NULL)";

           // Use the connection to create the SQL statement.
         //  statement = connection.createStatement();

            // Execute the statement.
            statement.executeUpdate(sqlString);

            // Provide a message when processing is complete.
            System.out.println("Processing complete."); 
            
         
          // CREATE TABLE ORDERS.
            
            
            /*     sqlString = 
                    "CREATE TABLE Orders (" + 
                        "[OrdersID] [int] IDENTITY(1,1) NOT NULL," +
                        "[Order_date] [nvarchar](50) NOT NULL," + 
                        "[Order_time] [nvarchar](50) NOT NULL)";
                

               // Use the connection to create the SQL statement.
             
                // Execute the statement.
                statement.executeUpdate(sqlString);

                // Provide a message when processing is complete.
                System.out.println("Processing complete."); 
            
            // CREATE TABLE LOCATION
                
               sqlString = 
                        "CREATE TABLE Location (" + 
                            "[LocationID] [int] IDENTITY(1,1) NOT NULL," +
                            "[Country] [nvarchar](50) NOT NULL," + 
                            "[City] [nvarchar](50) NOT NULL)";
                    

                   // Use the connection to create the SQL statement.
                 
                    // Execute the statement.
                    statement.executeUpdate(sqlString);

                    // Provide a message when processing is complete.
                    System.out.println("Processing complete.");*/
                
    

                        
                                 
 
                        
            				// create cluster.
            				sqlString = "CREATE CLUSTERED INDEX index1 " + "ON Customer (CustomerID)";
                                                 
                            // Execute the statement.
                            statement.executeUpdate(sqlString);

                            // Provide a message when processing is complete.
                            System.out.println("Processing complete.");

     
                                         
                            
                            
                            // Add Info to Customer Table.
                            
                            
                            sqlString = "SET IDENTITY_INSERT Customer ON " + 
                                        "INSERT INTO Customer " + 
                                        "(CustomerID, LastName, FirstName, Location) " + 
                                        "VALUES(2, 'Faris', 'Adel', 'Iraq')," + 
                                              "(3, 'Saeed', 'Nasser', 'Lybia')," + 
                                              "(1, 'Abdullah', 'Sheikh', 'KSA')," + 
                                              "(4, 'Chaouman', 'Abdullah', 'Kurdistan')," + 
                                              "(5, 'Wilson', 'Jim', 'UK')";  
                            
                            System.out.println("Processing complete.");  
                       
                            
                            
                            
                             sqlString = 
                                    "IF EXISTS (SELECT 1 " +
                                        "FROM sysobjects " + 
                                        "WHERE xtype='u' AND name='Customer') " +
                                        "SELECT 'Customer table exists.'" +
                                        "ELSE  " +
                                        "SELECT 'Customer table does not exist.'";

                                
                                // Execute the statement.
                                resultSet = statement.executeQuery(sqlString);

                                // Display the result.
                                while (resultSet.next())
                                {
                                    System.out.println(resultSet.getString(1));
                                }

                                // Provide a message when processing is complete.
                                System.out.println("Processing complete.");

                            
                            
                            
                            
                            
                            
             /*               // Print Customer Info.
                        
                            sqlString = "SELECT * from Customer WHERE CustomerID= 1 ";

                         // Execute the statement.
                        resultSet = statement.executeQuery(sqlString);

                      
                        
                        // Loop through the results
                        while (resultSet.next())
                        {
                            // Print out the row data
                            System.out.println(
                                "Customer with ID " + 
                                resultSet.getString("CustomerID") + 
                                " has name " +
                                resultSet.getString("FirstName") + " " +
                                resultSet.getString("LastName"));
                            }*/

                        // Provide a message when processing is complete.
                       
                        System.out.println(resultSet);
                       
            
           
           
/*            // Define the SQL string.
             sqlString = "DROP TABLE Customer";

            // Use the connection to create the SQL statement.
            statement = connection.createStatement();

            // Execute the statement.
            statement.executeUpdate(sqlString);
            
            // Provide a message when processing is complete.
            System.out.println("Processing complete.");  */
         

        }
       
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        // Exception handling
        catch (ClassNotFoundException cnfe)  
        {

            System.out.println("ClassNotFoundException " +
                               cnfe.getMessage());
        }
        catch (Exception e)
        {
            System.out.println("Exception " + e.getMessage());
            e.printStackTrace();
        }
        
 
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        finally
        {
            try
            {
                // Close resources.
                if (null != connection) connection.close();
                if (null != statement) statement.close();
                if (null != resultSet) resultSet.close();
            }
            catch (SQLException sqlException)
            {
                // No additional action if close() statements fail.
            }
        }

    }


    }

