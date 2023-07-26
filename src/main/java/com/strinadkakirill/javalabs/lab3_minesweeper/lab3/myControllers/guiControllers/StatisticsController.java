package com.strinadkakirill.javalabs.lab3_minesweeper.lab3.myControllers.guiControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class StatisticsController {


    public void buttonMainMenuAction(ActionEvent actionEvent) {
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();

        try {
            Stage stage = new Stage();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("main-menu.fxml"));

            loader.load();

            Parent root = loader.getRoot();

            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void buttonIntermediateAction(ActionEvent actionEvent) {
        try {
            Stage stage = new Stage();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("intermediateStatistic.fxml"));

            loader.load();

            Parent root = loader.getRoot();

            stage.setTitle("Beginner statistic");
            stage.setMinWidth(600);
            stage.setMinHeight(400);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void buttonBegginerAction(ActionEvent actionEvent) {

        try {
            Stage stage = new Stage();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("beginnerStatistic.fxml"));

            loader.load();

            Parent root = loader.getRoot();

            stage.setTitle("Beginner statistic");
            stage.setMinWidth(600);
            stage.setMinHeight(400);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void buttonProfessionalAction(ActionEvent actionEvent) {
        try {
            Stage stage = new Stage();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("professionalStatistic.fxml"));

            loader.load();

            Parent root = loader.getRoot();

            stage.setTitle("Beginner statistic");
            stage.setMinWidth(600);
            stage.setMinHeight(400);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void buttonSpecificAction(ActionEvent actionEvent) {
    }
}
