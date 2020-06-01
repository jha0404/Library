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
import java.util.ArrayList;
import java.util.List;

public class Issue {
    @FXML
    private TextField Reg;
    @FXML
    private TextField StudentName;
    @FXML
    private TextField BookName;

    public void Add() throws SQLException {
        List<Student> list=new ArrayList<Student>();
        StudentBook studentBook=new StudentBook();
        studentBook.CreateTable();
        list=studentBook.getLibrarian();
        String RegNo=Reg.getText();
        int i;
        int flag=0;
        for(i=0;i<list.size();i++){
            Student s=new Student();
            s=list.get(i);
            if(s.getRegNo().equals(RegNo)){
                System.out.println("already taken a book");
                flag=1;
                break;
            }
        }
        if(flag==0){
            studentBook.CreateTable();
            studentBook.Insert(StudentName.getText(),Reg.getText(),BookName.getText());
        }
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
