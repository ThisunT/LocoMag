package UI;/**
 * Created by Thisun Pathirage on 9/7/2017.
 */

import Connection.Update;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Index/index.fxml"));
        primaryStage.setTitle("Railway");
        primaryStage.setScene(new Scene(root, 1280, 800));
        primaryStage.show();

    }


    public static void main(String[] args) {
        Update.updateLocomotiveImages();
        Update.updateLocomotives();
        launch(args);
    }
}
