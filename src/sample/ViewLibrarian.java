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

public class ViewLibrarian {
    @FXML
    TableView tableView=new TableView();
    @FXML
    TableColumn ID=new TableColumn();
    @FXML
    TableColumn Name=new TableColumn();
    @FXML
    TableColumn Password=new TableColumn();


    public void view() throws SQLException {
        List<Librarian> list=new ArrayList<Librarian>();
        LibrarianTable librarianTable=new LibrarianTable();
        list=librarianTable.getLibrarian();
        ID.setCellValueFactory(new PropertyValueFactory<Librarian,Integer>("id"));
        Name.setCellValueFactory(new PropertyValueFactory<Librarian,String>("name"));
        Password.setCellValueFactory(new PropertyValueFactory<Librarian,String>("Password"));
        final ObservableList<Librarian> data= FXCollections.observableArrayList();

        int i;
        for(i=0;i<list.size();i++)
        {
            Librarian librarian=new Librarian();
            librarian=list.get(i);
            data.add(librarian);
            //System.out.println(librarian.getId());
        }
        tableView.setItems(data);
    }


    public void back(ActionEvent e){
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
