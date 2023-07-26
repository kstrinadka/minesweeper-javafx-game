package com.strinadkakirill.javalabs.lab3_minesweeper.lab3.myControllers.guiControllers;

import javafx.scene.image.ImageView;

import java.util.Objects;


/**
 * Ячейка в GridPane (клетка на игровом поле в GUI)
 */
public final class CellOfGridPane {
    private final ImageView image;
    private final Integer x_coord;
    private final Integer y_coord;

    public CellOfGridPane(ImageView image, Integer x_coord, Integer y_coord) {
        this.image = image;
        this.x_coord = x_coord;
        this.y_coord = y_coord;
    }



    public ImageView image() {
        return image;
    }

    public Integer x_coord() {
        return x_coord;
    }

    public Integer y_coord() {
        return y_coord;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (CellOfGridPane) obj;
        return Objects.equals(this.image, that.image) &&
                Objects.equals(this.x_coord, that.x_coord) &&
                Objects.equals(this.y_coord, that.y_coord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(image, x_coord, y_coord);
    }

    @Override
    public String toString() {
        return "CellOfGridPane[" +
                "image=" + image + ", " +
                "x_coord=" + x_coord + ", " +
                "y_coord=" + y_coord + ']';
    }

}
