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

public class LibrarianLogin {
    @FXML
    private TextField Id;
    @FXML
    private TextField Password;

    public void Action(ActionEvent e) throws SQLException {
        List<Librarian> list= new ArrayList<Librarian>();
        LibrarianTable librarianTable=new LibrarianTable();
        list=librarianTable.getLibrarian();
        int i;
        String password = null;
        int flag=0;
        for(i=0;i<list.size();i++)
        {
            Librarian librarian=new Librarian();
            librarian=list.get(i);
            Integer id= Integer.parseInt(Id.getText());
            if(librarian.getId()==id){
                password=librarian.getPassword();
                //System.out.println(id+" "+password);
                flag=1;
                break;
            }
        }
        if(flag==1)
        {

            if(password.equals(Password.getText())){
                //System.out.println(flag);
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
    }


}

