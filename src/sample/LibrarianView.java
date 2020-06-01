package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

public class LibrarianView {


    public void AddBooks(ActionEvent e)  {
        try {
            Parent root1= FXMLLoader.load(getClass().getResource("AddBook.fxml"));
            Scene s=new Scene(root1);
            Stage s1=(Stage) ((Node)e.getSource()).getScene().getWindow();
            s1.setScene(s);
            s1.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }

    public void ViewBooks(ActionEvent e){
        try {
            Parent root1= FXMLLoader.load(getClass().getResource("ViewBooks.fxml"));
            Scene s=new Scene(root1);
            Stage s1=(Stage) ((Node)e.getSource()).getScene().getWindow();
            s1.setScene(s);
            s1.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    public void issue(ActionEvent e){
        try {
            Parent root1= FXMLLoader.load(getClass().getResource("Issue.fxml"));
            Scene s=new Scene(root1);
            Stage s1=(Stage) ((Node)e.getSource()).getScene().getWindow();
            s1.setScene(s);
            s1.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    public void issued(ActionEvent e){
        try {
            Parent root1= FXMLLoader.load(getClass().getResource("ViewissuedBooks.fxml"));
            Scene s=new Scene(root1);
            Stage s1=(Stage) ((Node)e.getSource()).getScene().getWindow();
            s1.setScene(s);
            s1.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
