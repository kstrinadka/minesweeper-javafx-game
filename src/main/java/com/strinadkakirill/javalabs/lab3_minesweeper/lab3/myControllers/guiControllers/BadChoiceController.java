package com.strinadkakirill.javalabs.lab3_minesweeper.lab3.myControllers.guiControllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;

public class BadChoiceController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void closeModalWindow(ActionEvent event) {

        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    void initialize() {

    }

}
