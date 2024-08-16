package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HomeScreenController {

    @FXML
    public JFXButton btnDelete;

    @FXML
    public JFXButton btnLogin;

    @FXML
    public JFXButton btnUpdate;

    @FXML
    public JFXButton btnView;

    @FXML
    void btnLogin(ActionEvent ignoredEvent) {
        Stage stage=new Stage();
        try{
            stage.setScene(new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../view/add_customer_form.fxml")))));
            stage.show();
        }catch (IOException e){
            throw  new RuntimeException(e);
        }
    }

    @FXML
    void btnUpdate(ActionEvent ignoredEvent) {
        Stage stage=new Stage();
        try{
            stage.setScene(new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../view/update_customer_form.fxml")))));
            stage.show();
        }catch (IOException e){
            throw  new RuntimeException(e);
        }
    }

    @FXML
    void btnView(ActionEvent ignoredEvent) {
        Stage stage=new Stage();
        try{
            stage.setScene(new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../view/view_customer_form.fxml")))));
            stage.show();
        }catch (IOException e){
            throw  new RuntimeException(e);
        }
    }

    @FXML
    void btnDelete(ActionEvent ignoredEvent) throws RuntimeException {
        Stage stage=new Stage();
        try{
            stage.setScene(new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource
                    ("../view/delete_customer_form.fxml")))));
            stage.show();
        }catch (IOException e){
            throw  new RuntimeException(e);
        }
    }
}
