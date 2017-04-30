
package team1.kcm;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
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
    private String oldpasswordValue; //실제 저장된 패스워드
    @FXML
    private Label warning;
    @FXML
    private ImageView zero;
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnok.setOnAction(event->handleOk());
        zero.setOnMouseClicked(event->handleZero());
        
    }    
    

    private void handleOk() {
        System.out.println("sdf");
        
        passwordValue=password1.getText();
        passwordValue2=password2.getText();
        
        
        if(Root1Controller.secretCount>0){
            
            if(passwordValue.equals(oldpasswordValue)){
                oldpasswordValue=passwordValue2;
                Root1Controller.popup.hide();
            }else{warning.setText("패스워드를 정확히 입력해주세요.");}
        
        }else{
            if(passwordValue.equals(passwordValue2)){
                oldpasswordValue=passwordValue;
                secretCount+=1;
            Root1Controller.popup.hide();
            }else{warning.setText("패스워드를 정확히 입력해주세요.");}
            System.out.println("하잇");
        
        }
       
        System.out.println(passwordValue);
        System.out.println(passwordValue2);
        System.out.println(passwordValue.equals(passwordValue2));
    }

    public String getPasswordValue() {
        return passwordValue;
    }

    public String getPasswordValue2() {
        return passwordValue2;
    }

    private void handleZero() {
        String zeroo="0";
        Scanner scanner= new Scanner(zeroo);
        
        char zeero=80;
       InputStream is=System.in;
      
        try {
            OutputStream os = System.out;
            os.write(48);
            os.flush();
        } catch (IOException ex) {
           
        }
    }


}
