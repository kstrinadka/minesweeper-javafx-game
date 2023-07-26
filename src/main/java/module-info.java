module com.strinadkakirill.javalabs.lab3_minesweeper.lab3 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.strinadkakirill.javalabs.lab3_minesweeper.lab3 to javafx.fxml;
    exports com.strinadkakirill.javalabs.lab3_minesweeper.lab3;
    exports com.strinadkakirill.javalabs.lab3_minesweeper.lab3.Model.Statistics;
    opens com.strinadkakirill.javalabs.lab3_minesweeper.lab3.Model.Statistics to javafx.fxml;
    exports com.strinadkakirill.javalabs.lab3_minesweeper.lab3.myControllers.guiControllers;
    opens com.strinadkakirill.javalabs.lab3_minesweeper.lab3.myControllers.guiControllers to javafx.fxml;
}