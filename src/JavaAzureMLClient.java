import java.net.*;
import java.io.*;
import java.util.*;

public class JavaAzureMLClient
{

       String endPointURL; //Azure ML Endpoint
       String key; //API KEY


      public JavaAzureMLClient(String endPointURL,String key)
      {
        this.endPointURL= endPointURL;
        this.key= key;
      }
      /*
       Takes an Azure ML Request Body then Returns the Response String Which Contains Scored Lables etc
      */
      public  String requestResponse( String requestBody ) throws Exception
      {
        URL u = new URL(this.endPointURL);
        HttpURLConnection conn = (HttpURLConnection) u.openConnection();

        conn.setRequestProperty("Authorization","Bearer "+ this.key);
        conn.setRequestProperty("Content-Type","application/json");
        conn.setRequestMethod("POST");
        
        String body= new String(requestBody);
        
        conn.setDoOutput(true);
        OutputStreamWriter wr=new OutputStreamWriter(conn.getOutputStream());

        wr.write(body);
        wr.close();

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        
        String decodedString;
        String responseString="";    

        while ((decodedString = in.readLine()) != null) 
    	  {
              responseString+=decodedString;
        }
    	  return responseString;
     }

  }
 // key :vSV4iSudupVWGcmv4PU82iUm7PTJCuAUhakMDPIx2Tl9UgJVGMMMQamWb6cIXI/oILG1rlLb7CoZJPSKpCpDXA==
 // https://ussouthcentral.services.azureml.net/workspaces/a3fcd41ba3cd468ebb57305e065e4a23/services/e30a5903fdd44733b2789dcb5545bbf8/execute?api-version=2.0&format=swagger
//https://ussouthcentral.services.azureml.net/workspaces/a3fcd41ba3cd468ebb57305e065e4a23/services/654a29198d784e2692e8bb9c7c16a503/execute?api-version=2.0&format=swagger