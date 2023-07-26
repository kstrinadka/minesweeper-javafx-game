package com.strinadkakirill.javalabs.lab3_minesweeper.lab3.myControllers.guiControllers;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.strinadkakirill.javalabs.lab3_minesweeper.lab3.Model.Statistics.GameModes;
import com.strinadkakirill.javalabs.lab3_minesweeper.lab3.Model.Statistics.Statistic;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class IntermediateStatisticController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label labelFifthStatisticRecord;

    @FXML
    private Label labelFirstStatisticRecord;

    @FXML
    private Label labelFourthStatisticRecord;

    @FXML
    private Label labelSecondStatisticRecord;

    @FXML
    private Label labelThirdStatisticRecord;

    @FXML
    private AnchorPane rootElementChoosing;

    @FXML
    void initialize() {
        GameModes gameMode = GameModes.INTERMEDIATE;
        String fileName = "intermediateStatistic.txt";

        Statistic statistic = new Statistic(fileName, gameMode);

        ArrayList<String> list = statistic.getStatisticList();

        while (list.size() < 5) {
            list.add("no game recording");
        }

        this.labelFirstStatisticRecord.setText(list.get(0));
        this.labelSecondStatisticRecord.setText(list.get(1));
        this.labelThirdStatisticRecord.setText(list.get(2));
        this.labelFourthStatisticRecord.setText(list.get(3));
        this.labelFifthStatisticRecord.setText(list.get(4));

    }

}

