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

    public static JSONArray returnFailures() {
        FileReader fr = null;
        String[] textData = new String[1];
        try {
            fr = new FileReader("localDB/failures.txt");
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

    public static JSONArray returnTrips() {
        FileReader fr = null;
        String[] textData = new String[1];
        try {
            fr = new FileReader("localDB/trips.txt");
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

    public static JSONArray returnEmployees() {
        FileReader fr = null;
        String[] textData = new String[1];
        try {
            fr = new FileReader("localDB/employees.txt");
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

    public static JSONArray returnUser() {
        FileReader fr = null;
        String[] textData = new String[1];
        try {
            fr = new FileReader("localDB/User.txt");
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

    public static String readByValues(String file, String knownField, String valueKnown, String filedWanted) {
        FileReader fr = null;
        String[] textData = new String[1];
        String result=null;
        try {
            fr = new FileReader("localDB/"+file+".txt");
            BufferedReader txt = new BufferedReader(fr);
            textData[0] = txt.readLine();
            txt.close();

            JSONArray jsonArray = null;
            try {
                jsonArray = new JSONArray(textData[0]);

                for (int i=0;i<jsonArray.length();i++){
                    if (valueKnown.equals(jsonArray.getJSONObject(i).get(knownField))){
                        result= String.valueOf(jsonArray.getJSONObject(i).get(filedWanted));
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            System.out.print("as"+e.getMessage());
        } catch (IOException e) {
            System.out.println("asa"+e.getMessage());
        }
        return result;
    }

    public static String readByValues(String file, String knownField, int valueKnown, String fieldWanted) {
        FileReader fr = null;
        String[] textData = new String[1];
        String result=null;
        try {
            fr = new FileReader("localDB/"+file+".txt");
            BufferedReader txt = new BufferedReader(fr);
            textData[0] = txt.readLine();
            txt.close();

            JSONArray jsonArray = null;
            try {
                jsonArray = new JSONArray(textData[0]);

                for (int i=0;i<jsonArray.length();i++){
                    if (valueKnown==jsonArray.getJSONObject(i).getInt(knownField)){
                        result= String.valueOf(jsonArray.getJSONObject(i).get(fieldWanted));
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            System.out.print(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}
