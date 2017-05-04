package team1.Homvis.interphone;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Popup;
import team1.Homvis.main.mainController;

public class InterPhoneController implements Initializable {

	@FXML
	private ImageView phoneBtn;
	@FXML
	private ImageView openBtn;
	@FXML
	private ImageView closeBtn;
	@FXML
	private Label locationlb;
	@FXML
	private StackPane interphoneRoot;
	@FXML
	private ImageView phoneBtn1;


	@Override
	public void initialize(URL url, ResourceBundle rb) {
		phoneBtn.setOnMouseClicked(e->callNopen(e, "call"));
		openBtn.setOnMouseClicked(e->callNopen(e, "open"));
		closeBtn.setOnMouseClicked(e->exit());
	}	
	private void callNopen(MouseEvent e, String status) {
		
			try {
				//팝업을 설정
				Popup popup = new Popup();
				HBox hbox = (HBox) FXMLLoader.load(getClass().getResource("interPhonePopup.fxml"));
				Label lblMessage = (Label)hbox.lookup("#lbsMessage");
				// 들어오는 값에 따라 팝업의 내용 결정
				if(status.equals("call")){
					lblMessage.setText("통화가 연결되었습니다.");
				}else if(status.equals("open")){
					lblMessage.setText("문이 열렸습니다.");
				}
				popup.getContent().add(hbox);
				popup.setAutoHide(true);
				popup.show(((ImageView)e.getSource()).getScene().getWindow());
				
			} catch (IOException ex) {
				ex.printStackTrace();
			}
	}
	private void exit() {
		mainController.menuicon4.setImage(new Image(getClass().getResource("../main/images/main_interphone_default.png").toString()));
        mainController.stackPane.getChildren().remove(interphoneRoot);
    }
}
