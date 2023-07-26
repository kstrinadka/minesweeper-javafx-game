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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ChoosingGameController {

    public AnchorPane rootElementChoosing;

    @FXML
    private TextField textFieldHeight;

    @FXML
    private TextField textFieldMines;

    @FXML
    private TextField textFieldWidth;

    @FXML
    private TextField textFieldUserName;

    @FXML
    private Button mainMenu;

    private GameController controller2;

    public ChoosingGameController() {


        // Load the FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Layout1.fxml"));

        // Set this class as the controller
        loader.setController(this);
    }


    @FXML
    void initialize() {
        assert mainMenu != null : "fx:id=\"mainMenu\" was not injected: check your FXML file 'choosing-game-mode.fxml'.";

    }

    /**
     * Запуск игры в режимы "Beginer"
     */
    public void buttonBegginerAction(ActionEvent actionEvent) {

        ((Node) actionEvent.getSource()).getScene().getWindow().hide();

        String userName = this.textFieldUserName.getText();
        if (userName.equals(null) || userName.equals("")) {
            userName = "user";
        }



        try {
            Stage stage = new Stage();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("game.fxml"));
            loader.load();
            Parent root = loader.getRoot();

            GameController gameController = loader.getController();
            gameController.getDataForGame(9, 9, 10, stage, userName);

            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Запуск игры в режимы "Intermediate"
     */
    public void buttonIntermediateAction(ActionEvent actionEvent) {

        ((Node) actionEvent.getSource()).getScene().getWindow().hide();

        String userName = this.textFieldUserName.getText();
        if (userName.equals(null) || userName.equals("")) {
            userName = "user";
        }

        try {
            Stage stage = new Stage();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("game.fxml"));
            loader.load();
            Parent root = loader.getRoot();

            GameController gameController = loader.getController();
            gameController.getDataForGame(16, 16, 40, stage, userName);

            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Запуск игры в режимы "Professional"
     */
    public void buttonProfessionalAction(ActionEvent actionEvent) {

        ((Node) actionEvent.getSource()).getScene().getWindow().hide();

        String userName = this.textFieldUserName.getText();
        if (userName.equals(null) || userName.equals("")) {
            userName = "user";
        }

        try {
            Stage stage = new Stage();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("game.fxml"));
            loader.load();
            Parent root = loader.getRoot();

            GameController gameController = loader.getController();
            gameController.getDataForGame(30, 16, 99, stage, userName);

            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Проверяет данные для создания игрового поля на правильность
     */
    private boolean checkInputData(String width, String height, String mines) {
        if (width == null) {
            return false;
        }
        try {
            int a = Integer.parseInt(width);
            if (a < 9 || a > 30) {
                return false;
            }
        } catch (NumberFormatException nfe) {
            return false;
        }

        if (height == null) {
            return false;
        }
        try {
            int a = Integer.parseInt(height);
            if (a < 9 || a > 24) {
                return false;
            }
        } catch (NumberFormatException nfe) {
            return false;
        }

        if (mines == null) {
            return false;
        }
        try {
            int a = Integer.parseInt(mines);
            if (a < 10 || a > (Integer.parseInt(width) * Integer.parseInt(height))) {
                return false;
            }
        } catch (NumberFormatException nfe) {
            return false;
        }


        return true;
    }

    /**
     * Запуск игры в режимы "Specific"
     */
    public void buttonSpecificAction(ActionEvent actionEvent) {

        String width = textFieldWidth.getText();
        String height = textFieldHeight.getText();
        String numberOfMines = textFieldMines.getText();

        String userName = this.textFieldUserName.getText();
        if (userName.equals(null) || userName.equals("")) {
            userName = "user";
        }


        if (checkInputData(width, height, numberOfMines)) {

            int fieldX = Integer.parseInt(width);
            int fieldY = Integer.parseInt(height);
            int mines = Integer.parseInt(numberOfMines);

            ((Node) actionEvent.getSource()).getScene().getWindow().hide();

            try {
                Stage stage = new Stage();

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("game.fxml"));
                loader.load();
                Parent root = loader.getRoot();

                GameController gameController = loader.getController();
                gameController.getDataForGame(fieldX, fieldY, mines, stage, userName);

                stage.setScene(new Scene(root));
                stage.show();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }
        else {
            try {
                Stage stage = new Stage();

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("bad-choice.fxml"));

                loader.load();

                Parent root = loader.getRoot();

                stage.setTitle("неправильные данные");
                stage.setMinWidth(400);
                stage.setMinHeight(300);
                stage.setResizable(false);
                stage.setScene(new Scene(root));
                stage.initModality(Modality.WINDOW_MODAL);
                stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
                stage.show();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }

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
}
