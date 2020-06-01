package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class AddBook {

    @FXML
    private TextField Amount;

    public void add() throws SQLException {
        BookTable bookTable=new BookTable();
        boolean k=bookTable.CreateTable();
        System.out.println(k);
       // String Author1=Author.getText();

        String Amount1=Amount.getText();
        System.out.println(Amount1);
        //bookTable.Insert(Author1,BookName1,Amount1);

    }
}
