package UI.Foreman.Schedule;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * Created by piumiindeevari on 10/20/2017.
 */
public class ScheduleController implements Initializable {

@FXML
public WebView web;
@FXML
public ScrollPane scrollPane;

        @Override
        public void initialize(URL location, ResourceBundle resources) {
            final WebEngine webEngine = web.getEngine();
            scrollPane.setContent(web);

            webEngine.getLoadWorker().stateProperty();
                    /*.addListener(new ChangeListener<Worker.State>() {
                        @Override
                        public void changed(ObservableValue ov, Worker.State oldState, Worker.State newState) {

                            if (newState == Worker.State.SUCCEEDED) {
                                stage.setTitle(webEngine.getLocation());
                            }

                        }
                    });*/
            webEngine.load("http://colombofort.com/train.schedule.htm");


        }





}
