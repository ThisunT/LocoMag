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

//Reads from the local file system
public class DBReader {
    public static JSONArray returnLocomotives() {
        FileReader fr = null;
        String[] textData = new String[1];
        try {
            fr = new FileReader("localDB/Locomotives.json");
            BufferedReader text = new BufferedReader(fr);
            textData[0] = text.readLine();
            text.close();

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
            fr = new FileReader("localDB/Failures.json");
            BufferedReader text = new BufferedReader(fr);
            textData[0] = text.readLine();
            text.close();

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
            fr = new FileReader("localDB/Trips.json");
            BufferedReader text = new BufferedReader(fr);
            textData[0] = text.readLine();
            text.close();

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
            fr = new FileReader("localDB/Employees.json");
            BufferedReader text = new BufferedReader(fr);
            textData[0] = text.readLine();
            text.close();

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

    public static JSONArray returnMaintenance() {
        FileReader fr = null;
        String[] textData = new String[1];
        try {
            fr = new FileReader("localDB/Maintenance.json");
            BufferedReader text = new BufferedReader(fr);
            textData[0] = text.readLine();
            text.close();

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
            fr = new FileReader("localDB/User.json");
            BufferedReader text = new BufferedReader(fr);
            textData[0] = text.readLine();
            text.close();

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

    //Querying from file system by file, the field and depending on the value we know we can get another field value which jad the same previous record
    public static String readByValues(String file, String knownField, String valueKnown, String filedWanted) {
        FileReader fr = null;
        String[] textData = new String[1];
        String result=null;
        try {
            fr = new FileReader("localDB/"+file+".json");
            BufferedReader text = new BufferedReader(fr);
            textData[0] = text.readLine();
            text.close();

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

    //Querying the file based on the known field name and the values
    public static String readByValues(String file, String knownField, int valueKnown, String fieldWanted) {
        FileReader fr = null;
        String[] textData = new String[1];
        String result=null;
        try {
            fr = new FileReader("localDB/"+file+".json");
            BufferedReader text = new BufferedReader(fr);
            textData[0] = text.readLine();
            text.close();

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

    public static JSONArray readByFields(String file, String field, String valueKnown) {
        FileReader fr = null;
        String[] textData = new String[1];
        JSONArray results = null;
        try {
            fr = new FileReader("localDB/" + file + ".json");
            BufferedReader text = new BufferedReader(fr);
            textData[0] = text.readLine();
            text.close();

            JSONArray jsonArray = null;
            results = new JSONArray();
            try {
                jsonArray = new JSONArray(textData[0]);

                for (int i = 0; i < jsonArray.length(); i++) {
                    try {
                        if (Integer.parseInt(valueKnown)==(jsonArray.getJSONObject(i).getInt(field))) {
                            results.put(jsonArray.getJSONObject(i));
                        }
                        else if (valueKnown.equals(jsonArray.getJSONObject(i).get(field))) {
                            results.put(jsonArray.getJSONObject(i));
                        }
                    } catch (Exception e) {
                        if (valueKnown.equals(jsonArray.getJSONObject(i).get(field))) {
                            results.put(jsonArray.getJSONObject(i));
                        }
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
        return results;
    }

    public static String syncState(){
        FileReader fr = null;
        String[] textData = new String[1];
        try {
            fr = new FileReader("localDB/Sync.json");
            BufferedReader text = new BufferedReader(fr);
            textData[0] = text.readLine();
            text.close();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        JSONArray jsonArray = null;
        String state = null;
        try {
            jsonArray = new JSONArray(textData[0]);
            state = jsonArray.getJSONObject(0).get("state").toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return state;
    }
}
