package team1.kcm;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Popup;
import javafx.util.Duration;
import static team1.kcm.Root1Controller.secretCount;

public class NewpasswordController implements Initializable {

    @FXML
    private Button btnok;

    @FXML
    private PasswordField password1;
    @FXML
    private PasswordField password2;

    private String passwordValue; //임시
    private String passwordValue2; //임시
    private String password;

    @FXML
    private Label warning;
    @FXML
    private ImageView zero;

    private String input = "";

    @FXML
    private AnchorPane secret;

    public static Popup popup;
    @FXML
    private AnchorPane keypadroot;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        keypadroot.setTranslateX(200);
        keypadroot.setTranslateY(0);
        
        
        btnok.setOnAction(event -> handleOk());
        //zero.setOnMouseClicked(event->handleZero());
        password1.focusedProperty().addListener((observable) -> {
            keypad();
        });
        password2.focusedProperty().addListener((observable) -> {
            keypad2();
        });
    }

    private void handleOk() {
        System.out.println("sdf");

        passwordValue = password1.getText();
        passwordValue2 = password2.getText();

        if (Root1Controller.secretCount > 0) {
            if (passwordValue.equals(Root1Controller.password)) {
                Root1Controller.password = passwordValue2;
                //Root1Controller.popup.hide();
                secret.setOpacity(1);
                secret.setTranslateX(0);
                KeyValue keyValue = new KeyValue(secret.opacityProperty(), 0);
                //KeyValue keyValue = new KeyValue(login.translateXProperty(),200);//무엇을 x를 0으로
                KeyFrame keyFrame = new KeyFrame(Duration.millis(1000),
                        (event) -> {
                            Root1Controller.stackPane.getChildren().remove(secret);
                        },
                        keyValue);
                Timeline timeline = new Timeline();
                timeline.getKeyFrames().add(keyFrame);
                timeline.play();
            } else {
                warning.setText("패스워드를 정확히 입력해주세요.");
            }

        } else {
            if (passwordValue.equals(passwordValue2)) {
                Root1Controller.password = passwordValue;
                secretCount += 1;

                secret.setOpacity(1);
                secret.setTranslateX(0);
                KeyValue keyValue = new KeyValue(secret.opacityProperty(), 0);
                KeyFrame keyFrame = new KeyFrame(Duration.millis(1000),
                        (event) -> {
                            Root1Controller.stackPane.getChildren().remove(secret);
                        },
                        keyValue);
                Timeline timeline = new Timeline();
                timeline.getKeyFrames().add(keyFrame);
                timeline.play();
            } else {
                warning.setText("패스워드를 정확히 입력해주세요.");
            }

        }

        System.out.println(passwordValue);
        System.out.println(passwordValue2);
        System.out.println(passwordValue.equals(passwordValue2));
        System.out.println(Root1Controller.password);
    }

    public String getPasswordValue() {
        return passwordValue;
    }

    public String getPasswordValue2() {
        return passwordValue2;
    }

    private void handleZero() {

        input += zero.getUserData().toString();

        System.out.println(input);
        // password1.setText(input.getValue());
        System.out.println("KEYPAD1 마우스ZERO");
    }

    private void keypad() {

         KeyValue keyValue = new KeyValue(keypadroot.translateXProperty(),-100);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(1000), keyValue);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
       zero.setOnMouseClicked(event->handleZero());

    }

    private void keypad2() {
        
        System.out.println("keypad2");
        zero.setOnMouseClicked(event->handleZero1());
    }

    private void handleZero1() {
       System.out.println("KEYPAD2 마우스ZERO");
    }

}
