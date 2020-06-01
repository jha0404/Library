package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ViewBooks {
    @FXML
    private TableView tableView;
    @FXML
    private TableColumn BookName;
    @FXML
    private TableColumn Author;
    @FXML
    private TableColumn Amount;

    public void view() throws SQLException {

        List<Books>list=new ArrayList<Books>();
        BookTable bookTable=new BookTable();
        list=bookTable.getLibrarian();
        BookName.setCellValueFactory(new PropertyValueFactory<Books,String>("BookName"));
        Author.setCellValueFactory(new PropertyValueFactory<Books,String>("BookAuthor"));
        Amount.setCellValueFactory(new PropertyValueFactory<Books,String>("BookAmount"));
        final ObservableList<Books> data= FXCollections.observableArrayList();

        int i;
        for(i=0;i<list.size();i++)
        {
            Books books=new Books();
            books=list.get(i);
            data.add(books);
            //System.out.println(librarian.getId());
        }
        tableView.setItems(data);
    }

    public void Back(ActionEvent e){
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
