package Connection;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.codehaus.jackson.util.DefaultPrettyPrinter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Thisun Pathirage on 12/3/2017.
 */
public class Update {

    public static void updateLocomotiveImages(){
        final String targetUrlLocoImgs = "http://localhost:3000/api/locomotive/id";

        try {
            String response = GetRequest.sendGetRequest(targetUrlLocoImgs);

            JSONArray jsonArray = null;
            try {
                jsonArray = new JSONArray(response);

                for(int i=0;i<jsonArray.length();i++){
                    try {
                        GetImage.download(String.valueOf(jsonArray.getJSONObject(i).getInt("EngineNumber")));
                    } catch (Exception e) {
                        continue;
                    }
                }
            } catch (JSONException e) {
                System.out.println(e.getMessage());
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateLocomotives(){
        final String targetUrlLocos = "http://localhost:3000/api/locomotive/";

        try {
            String response = GetRequest.sendGetRequest(targetUrlLocos);
            try{
                FileWriter fw=new FileWriter("localDB/locomotives.json");
                fw.write(response);
                fw.close();
            }catch(Exception e){
                System.out.println(e.getMessage());
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateFailures(){
        final String targetUrlFailures = "http://localhost:3000/api/failure/";

        try {
            String response = GetRequest.sendGetRequest(targetUrlFailures);
            try{
                FileWriter fw=new FileWriter("localDB/failures.json");
                fw.write(response);
                fw.close();
            }catch(Exception e){
                System.out.println(e.getMessage());
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateTrips(){
        final String targetUrlTrips = "http://localhost:3000/api/trip/";

        try {
            String response = GetRequest.sendGetRequest(targetUrlTrips);
            try{
                FileWriter fw=new FileWriter("localDB/trips.json");
                fw.write(response);
                fw.close();
            }catch(Exception e){
                System.out.println(e.getMessage());
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateEmployees(){
        final String targetUrlEmployees = "http://localhost:3000/api/employee/";

        try {
            String response = GetRequest.sendGetRequest(targetUrlEmployees);
            try{
                FileWriter fw=new FileWriter("localDB/employees.json");
                fw.write(response);
                fw.close();
            }catch(Exception e){
                System.out.println(e.getMessage());
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateUser(){
        final String targetUrlUser = "http://localhost:3000/api/user/";

        try {
            String response = GetRequest.sendGetRequest(targetUrlUser);
            System.out.println(response);
            try{
                FileWriter fw=new FileWriter("localDB/User.json");
                fw.write(response);
                fw.close();
            }catch(Exception e){
                System.out.println(e.getMessage());
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
