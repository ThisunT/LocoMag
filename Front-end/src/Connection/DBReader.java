package Connection;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Thisun Pathirage on 12/3/2017.
 */
public class DBReader {
    public static JSONArray returnLocomotives() {
        FileReader fr = null;
        String[] textData = new String[1];
        try {
            fr = new FileReader("localDB/locomotives.txt");
            BufferedReader txt = new BufferedReader(fr);
            textData[0] = txt.readLine();
            txt.close();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(textData[0]);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonArray;
    }
    public static JSONArray returnFailure() {
        FileReader fr = null;
        String[] textData = new String[1];
        try {
            fr = new FileReader("localDB/failuress.txt");
            BufferedReader txt = new BufferedReader(fr);
            textData[0] = txt.readLine();
            txt.close();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(textData[0]);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonArray;
    }
}
