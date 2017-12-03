package Connection;

import javafx.stage.PopupWindow;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Thisun Pathirage on 9/3/2017.
 */


public class GetRequest {

    public static String sendGetRequest(String targetUrl) throws IOException {

        URL myUrl = new URL(targetUrl);
        HttpURLConnection con = (HttpURLConnection) myUrl.openConnection();

        con.setRequestProperty("Method", "GET");

        StringBuilder stringBuilder = new StringBuilder();
        int HttpResult = con.getResponseCode();
        if (HttpResult == HttpURLConnection.HTTP_OK) {
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));

            String line;
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }
            br.close();

        } else {
            //System.out.println(con.getResponseCode());

        }

        /*JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(stringBuilder.toString());
            System.out.println(jsonArray);
        } catch (JSONException e) {
            System.out.println(e.getMessage());
        }
        return jsonArray;*/
        return stringBuilder.toString();
    }

}

