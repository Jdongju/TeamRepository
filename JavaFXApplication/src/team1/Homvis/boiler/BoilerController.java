package team1.Homvis.boiler;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import team1.Homvis.main.MainController;

public class BoilerController implements Initializable {

    @FXML
    private AnchorPane boilerRoot;
    @FXML
    private ImageView exit;
    @FXML
    private AnchorPane displayPane;
    @FXML
    private ImageView graph;
    @FXML
    private ImageView bar1;
    @FXML
    private ImageView bar2;
    @FXML
    private ImageView bar3;
    @FXML
    private ImageView bar4;
    @FXML
    private ImageView bar5;
    @FXML
    private ImageView bar6;
    @FXML
    private ImageView bar7;
    @FXML
    private ImageView bar8;
    @FXML
    private ImageView bar9;
    @FXML
    private ImageView bar10;
    @FXML
    private ImageView bar11;
    @FXML
    private ImageView bar12;
    @FXML
    private ImageView bar13;
    @FXML
    private ImageView bar15;
    @FXML
    private ImageView bar16;
    @FXML
    private ImageView bar17;
    @FXML
    private ImageView bar18;
    @FXML
    private ImageView bar19;
    @FXML
    private ImageView bar20;
    @FXML
    private ImageView bar21;
    @FXML
    private ImageView bar22;
    @FXML
    private ImageView bar23;
    @FXML
    private ImageView bar24;
    @FXML
    private ImageView gasDisplay;
    @FXML
    private ImageView heatDisplay;
    @FXML
    private ImageView modeDisplay;
    @FXML
    private ImageView waterDisplay;
    @FXML
    private Label txtnowHeat;
    @FXML
    private Label txthopeHeat;
    @FXML
    private Label txtWater;
    @FXML
    private ImageView heatUp;
    @FXML
    private ImageView wifi;
    @FXML
    private ImageView heatOn;
    @FXML
    private ImageView heatDown;
    @FXML
    private ImageView modeOn;
    @FXML
    private ImageView waterUp;
    @FXML
    private ImageView waterOn;
    @FXML
    private ImageView waterDown;
    @FXML
    private ImageView goOut;

    private Boolean wifiState = false;
    private Boolean goOutState = false;
    private int hopeWater = 14;
    private int hopeHeat = 24;

    private boolean heatOnState = false;
    private boolean waterOnState = false;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        heatDisplay.setOpacity(0);
        txthopeHeat.setOpacity(0);
        waterDisplay.setOpacity(0);
        txtWater.setOpacity(0);
        exit.setOnMouseClicked(event -> exit());
        wifi.setOnMouseClicked(event -> wifi());
        heatUp.setOnMousePressed(event -> heatUp());
        heatDown.setOnMousePressed(event -> heatDown());
        waterUp.setOnMouseClicked(event -> waterUp());
        waterDown.setOnMouseClicked(event -> waterDown());

        heatOn.setOnMouseClicked(event -> heatOn());
        waterOn.setOnMouseClicked(event -> waterOn());
        goOut.setOnMouseClicked(event -> goOut());

    }

    private void exit() {
        MainController.menuicon2.setImage(new Image(getClass().getResource("images/main_boiler_default.png").toString()));
        MainController.stackPane.getChildren().remove(boilerRoot);
        /*     boilerRoot.setOpacity(1);
        boilerRoot.setTranslateX(0);
        KeyValue keyValue = new KeyValue(boilerRoot.opacityProperty(), 0);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(1000),
                (event) -> {
                    Root1Controller.stackPane.getChildren().remove(boilerRoot);
                },
                keyValue);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
        Root1Controller.menuicon2.setImage(new Image(getClass().getResource("images/main_boiler_default.png").toString()));
         */

    }

    private void wifi() {
        if (wifiState == false) {
            wifi.setImage(new Image(getClass().getResource("images/wifi.PNG").toString()));   //WIFi On됬을때 사진넣기
            wifiState = true;
        } else {
            wifi.setImage(new Image(getClass().getResource("images/wifi_1.png").toString()));//WIFi off됬을때 사진넣기
            wifiState = false;
        }
    }

    private void heatOn() {

        if (heatDisplay.getOpacity() == 0) {
            heatDisplay.setOpacity(1);
            txthopeHeat.setOpacity(1);
            heatOnState = true;
        } else {
            heatDisplay.setOpacity(0);
            heatOnState = false;
            txthopeHeat.setOpacity(0);
        }

    }

    private void waterOn() {
        if (waterDisplay.getOpacity() == 0) {
            waterDisplay.setOpacity(1);
            txtWater.setOpacity(1);
            waterOnState = true;
        } else {
            waterDisplay.setOpacity(0);
            txtWater.setOpacity(0);
            waterOnState = false;
        }
    }

    private void goOut() {
        if (goOutState == false) {
            goOut.setImage(new Image(getClass().getResource("images/gooutOn.png").toString()));   //외출 On됬을때 사진넣기
            goOutState = true;
        } else {
            goOut.setImage(new Image(getClass().getResource("images/goout.png").toString()));//외출 off됬을때 사진넣기
            goOutState = false;
        }

    }

    private void heatUp() {
        if (heatOnState == true) {
        hopeHeat += 1;
        txthopeHeat.setText(String.valueOf(hopeHeat));
    }
    }

    private void heatDown() {
        if (heatOnState == true) {
        hopeHeat += -1;
        txthopeHeat.setText(String.valueOf(hopeHeat));
        }

    }

    private void waterUp() {
        if (waterOnState == true) {
            hopeWater += 1;
            txtWater.setText(String.valueOf(hopeWater));
        }
    }

    private void waterDown() {
        if (waterOnState == true) {
            hopeWater -= 1;
            txtWater.setText(String.valueOf(hopeWater));
        }
    }

}
