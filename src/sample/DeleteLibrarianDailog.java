package sample;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class DeleteLibrarianDailog {
    @FXML
    private TextField Id;
    @FXML
    private PasswordField Password;
    @FXML
    private TextField Name;

    public void Submit() throws SQLException {
        //System.out.println(Id.getText()+" "+Name.getText()+" "+Password.getText());
        LibrarianTable librarianTable=new LibrarianTable();
        librarianTable.delete(Integer.valueOf(Id.getText()));
    }
}
