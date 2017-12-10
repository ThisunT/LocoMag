package Connection;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;

/**
 * Created by Thisun Pathirage on 12/10/2017.
 */
public class Synchronising {
    public static int synId=1;
    public void synchronise(){
        Timeline fiveSecondsWonder = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            String targetUrl="http://localhost:3000/api/sync/state";
            @Override
            public void handle(ActionEvent event) {
                try {
                    JSONArray jsonArray = new JSONArray(GetRequest.sendGetRequest(targetUrl));
                    synId=(jsonArray.getJSONObject(0).getInt("state"));


                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }));
        fiveSecondsWonder.setCycleCount(Timeline.INDEFINITE);
        fiveSecondsWonder.play();
    }
}