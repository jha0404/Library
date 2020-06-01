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

public class Admin {
    @FXML
    private Pane Admin_pane;






    public void AddLibrarian() throws IOException, SQLException {

        Dialog<ButtonType> dialog=new Dialog<>();
        dialog.initOwner(Admin_pane.getScene().getWindow());
        FXMLLoader fxmlLoader=new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("Add_librarian_dailog.fxml"));
        dialog.getDialogPane().setContent(fxmlLoader.load());
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        Optional<ButtonType> result=dialog.showAndWait();
        if(result.isPresent() && result.get()==ButtonType.OK)
        {
            AddLibrarianDailog addLibrarianDailog=fxmlLoader.getController();
            addLibrarianDailog.Submit();
        }

    }


    public void DeleteLibrarian() throws IOException, SQLException {
        Dialog<ButtonType> dialog=new Dialog<>();
        dialog.initOwner(Admin_pane.getScene().getWindow());
        FXMLLoader fxmlLoader=new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("DeleteLibrarianDailog.fxml"));
        dialog.getDialogPane().setContent(fxmlLoader.load());
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        Optional<ButtonType> result=dialog.showAndWait();
        if(result.isPresent() && result.get()==ButtonType.OK)
        {
            DeleteLibrarianDailog deleteLibrarianDailog=fxmlLoader.getController();
            deleteLibrarianDailog.Submit();
        }

    }


    public void Logout(ActionEvent e){
        try {
            Parent root1= FXMLLoader.load(getClass().getResource("sample.fxml"));
            Scene s=new Scene(root1);
            Stage s1=(Stage) ((Node)e.getSource()).getScene().getWindow();
            s1.setScene(s);
            s1.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void ViewLibrarian(ActionEvent e){
        try {
            Parent root1= FXMLLoader.load(getClass().getResource("ViewLibrarian.fxml"));
            Scene s=new Scene(root1);
            Stage s1=(Stage) ((Node)e.getSource()).getScene().getWindow();
            s1.setScene(s);
            s1.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
