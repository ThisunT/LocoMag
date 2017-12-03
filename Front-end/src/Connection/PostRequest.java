package Connection;

/**
 * Created by Thisun Pathirage on 9/3/2017.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.io.OutputStream;

import java.net.HttpURLConnection;
import java.net.URL;



public class PostRequest {

    public static void sendPostRequest(String targetUrl, String jsonObject) throws IOException {

        URL myUrl = new URL(targetUrl);
        HttpURLConnection con = (HttpURLConnection) myUrl.openConnection();
        con.setDoOutput(true);
        con.setDoInput(true);

        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Method", "POST");
        OutputStream os = con.getOutputStream();
        os.write(jsonObject.getBytes("UTF-8"));
        os.close();


        StringBuilder sb = new StringBuilder();
        int HttpResult = con.getResponseCode();
        if (HttpResult == HttpURLConnection.HTTP_OK) {
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));

            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            br.close();
            //System.out.println("" + sb.toString());

        } else {
            System.out.println(con.getResponseCode());
            System.out.println(con.getResponseMessage());
        }

    }

    public static void sendPostRequest(String targetUrl, Object jsonObject) throws IOException {

        String newJsonObject = ObjectToJson.converter(jsonObject);

        URL myUrl = new URL(targetUrl);
        HttpURLConnection con = (HttpURLConnection) myUrl.openConnection();
        con.setDoOutput(true);
        con.setDoInput(true);

        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Method", "POST");
        OutputStream os = con.getOutputStream();
        os.write(newJsonObject.getBytes("UTF-8"));
        os.close();


        StringBuilder sb = new StringBuilder();
        int HttpResults = con.getResponseCode();
        if (HttpResults == HttpURLConnection.HTTP_OK) {
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));

            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            br.close();
            //System.out.println("" + sb.toString());

        } else {
            System.out.println(con.getResponseCode());
            System.out.println(con.getResponseMessage());
        }

    }

}
