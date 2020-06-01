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

public class ViewIssued {
    @FXML
    private TableColumn RegNo;
    @FXML
    private TableColumn StudentName;
    @FXML
    private TableColumn Book;
    @FXML
    private TableView tableView;

    public void View() throws SQLException {
        List<Student> list=new ArrayList<Student>();
        StudentBook studentBook=new StudentBook();
        list=studentBook.getLibrarian();
        RegNo.setCellValueFactory(new PropertyValueFactory<Student,String>("RegNo"));
        StudentName.setCellValueFactory(new PropertyValueFactory<Student,String>("Name"));
        Book.setCellValueFactory(new PropertyValueFactory<Student,String>("Book"));
        final ObservableList<Student> data= FXCollections.observableArrayList();

        int i;
        for(i=0;i<list.size();i++)
        {
            Student student=new Student();
            student=list.get(i);
            data.add(student);
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
