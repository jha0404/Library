package sample;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class AddLibrarianDailog {
    @FXML
    private TextField Id;
    @FXML
    private PasswordField Password;
    @FXML
    private TextField Name;

    public void Submit() throws SQLException {
        //System.out.println(Id.getText()+" "+Name.getText()+" "+Password.getText());
        LibrarianTable librarianTable=new LibrarianTable();
        librarianTable.CreateTable();
        int ID= Integer.parseInt(Id.getText());
        librarianTable.Insert(Name.getText(),ID,Password.getText());
    }
}
