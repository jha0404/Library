package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class LibrarianController {
    @FXML
    private TextField Book;
    @FXML
    private TextField Author;
    @FXML
    private  TextField Amount;

    public void Add() throws SQLException {
        //System.out.println(Book.getText()+" "+Author.getText()+" "+Amount.getText());
        Books book=new Books();
        BookTable bookTable=new BookTable();
        bookTable.CreateTable();
        bookTable.Insert(Author.getText(),Book.getText(),Amount.getText());

    }

    public void Finish(ActionEvent e){
        try {
            Parent root1= FXMLLoader.load(getClass().getResource("Librarian.fxml"));
            Scene s=new Scene(root1);
            Stage s1=(Stage) ((Node)e.getSource()).getScene().getWindow();
            s1.setScene(s);
            s1.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
