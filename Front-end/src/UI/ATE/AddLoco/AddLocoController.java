package UI.ATE.AddLoco;

import Connection.GetImage;
import Connection.ObjectToJson;
import Connection.PostImage;
import Connection.PostRequest;
import Models.Locomotive;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * Created by Thisun Pathirage on 10/10/2017.
 */
public class AddLocoController {

    @FXML
    private ChoiceBox engineType;
    @FXML
    private TextField engineNo;
    @FXML
    private DatePicker dateToday;
    @FXML
    private TextArea manufacturer;
    @FXML
    private TextArea topSpeed;
    @FXML
    private ComboBox currentState;
    @FXML
    private DatePicker dateManufactured;
    @FXML
    private TextArea shedAllocated;
    @FXML
    private JFXButton imgSelect;

    private File imgFile;

        private String addLocoUrl = "http://localhost:3000/api/locomotive/";


    public void imgSelect(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image");
        File toUpload = fileChooser.showOpenDialog(null);
        setImgFile(toUpload);

    }


    public void submitClicked(){

        Locomotive loco = new Locomotive();
        loco.setEngineNumber(Integer.parseInt(engineNo.getText()));
        loco.setEngineType(engineType.getValue().toString());
        loco.setManufacturedDay(dateManufactured.getValue());
        loco.setManufacturer(manufacturer.getText());
        loco.setShed(shedAllocated.getText());
        loco.setToday(dateToday.getValue());
        loco.setTopSpeed(Integer.parseInt(topSpeed.getText()));
        loco.setState((String) currentState.getValue());

        PostImage.upload(engineNo.getText(), getImgFile());

        String locoObject = ObjectToJson.converter(loco);
        System.out.println(locoObject);

        try {
            PostRequest.sendPostRequest(addLocoUrl,locoObject);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public File getImgFile() {
        return imgFile;
    }

    public void setImgFile(File imgFile) {
        this.imgFile = imgFile;
    }
}
