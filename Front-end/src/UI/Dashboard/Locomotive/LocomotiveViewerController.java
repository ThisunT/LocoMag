package UI.Dashboard.Locomotive;

import Connection.GetRequest;
import org.json.JSONArray;

import java.io.IOException;

/**
 * Created by Thisun Pathirage on 10/23/2017.
 */
public class LocomotiveViewerController {

    private static final String targetUrl = "http://localhost:3000/api/locomotive/";

    public static JSONArray response;

    /*public static JSONArray getResponse(){
        try {
            response = GetRequest.sendGetRequest(targetUrl);
            System.out.println(response);
        } catch (IOException e) {
            System.out.println("ads"+e.getMessage());
        }
        return response;
    }

    public static int numberOfObjects(){
        return response.length();
    }*/
}
