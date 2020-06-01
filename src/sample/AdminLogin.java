package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminLogin {
    @FXML
    private TextField ID;
    @FXML
    private PasswordField password;
    public void Action(ActionEvent e)
    {
        /* Matching admin id and password and then if matched passing to new scene */

        if(ID.getText().equals("Admin") && password.getText().equals("1234"))
        {

            try {
                Parent root1= FXMLLoader.load(getClass().getResource("Admin.fxml"));
                Scene s=new Scene(root1);
                Stage s1=(Stage) ((Node)e.getSource()).getScene().getWindow();
                s1.setScene(s);
                s1.show();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
