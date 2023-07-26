package com.strinadkakirill.javalabs.lab3_minesweeper.lab3.myControllers.guiControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


    public void buttonAboutAction(ActionEvent actionEvent) {
    }

    public void buttonQuitAction(ActionEvent actionEvent) {

        ((Node) actionEvent.getSource()).getScene().getWindow().hide();

    }

    public void buttonStatisticsAction(ActionEvent actionEvent) {

        ((Node) actionEvent.getSource()).getScene().getWindow().hide();

        try {
            Stage stage = new Stage();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("statistics.fxml"));

            loader.load();

            Parent root = loader.getRoot();

            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void buttonPlayAction(ActionEvent actionEvent) {


        ((Node) actionEvent.getSource()).getScene().getWindow().hide();

        try {
            Stage stage = new Stage();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("choosing-game-mode.fxml"));

            loader.load();

            Parent root = loader.getRoot();

            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
