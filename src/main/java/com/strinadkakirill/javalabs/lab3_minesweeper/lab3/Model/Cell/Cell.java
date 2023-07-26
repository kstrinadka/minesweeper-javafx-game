package com.strinadkakirill.javalabs.lab3_minesweeper.lab3.Model.Cell;


//будет хранить разные состояния ячейки и ее координаты


public class Cell {


    private int x_coordinate;
    private int y_coordinate;



    //мб сделать enum для возможных состояний ячейки
    private CellConditions condition;

    //показывает цифру в этой клетке (если 0, то это мина или пустая)
    private int cellNumber;

    boolean hasMine;


    public Cell(CellConditions condition, boolean hasMine) {
        //this.condition = condition;
        this.hasMine = hasMine;
        this.condition = CellConditions.CLOSED;

    }

    public Cell() {
        this.condition = CellConditions.CLOSED;
        this.hasMine = false;
        this.cellNumber = 0;
    }

    public Cell(int x_coordinate, int y_coordinate, CellConditions condition, boolean hasMine) {
        this.x_coordinate = x_coordinate;
        this.y_coordinate = y_coordinate;
        //this.condition = condition;
        this.hasMine = hasMine;
        this.condition = CellConditions.CLOSED;
    }

    public void plusOneToCell () {
        //System.out.println("сделали +1");
        this.cellNumber++;
    }




    /**
     * @return Есть ли внутри этой клетки цифра
     */
    public boolean hasNumber () {
        if (this.cellNumber > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public int getCellNumber () {
        return this.cellNumber;
    }

    @Override
    public String toString() {

        if (this.hasMine) {
            return "9";
        }
        if (this.cellNumber > 0) {
            Integer a = this.cellNumber;
            return a.toString();
        }
        else return "0";
    }

    public int getX_coordinate() {
        return x_coordinate;
    }

    public int getY_coordinate() {
        return y_coordinate;
    }


    /**
     * @return - есть мина в этой клетке или нет
     */
    public boolean cellHasMine() {

        return this.hasMine;
    }

    public boolean isClosed() {

        if (this.condition.equals(CellConditions.CLOSED)) {
            return true;
        }
        else return false;
    }

    public CellConditions getState(){
        return this.condition;
    }

    public void openThisCell() {
        this.condition = CellConditions.OPENED;

    }

    public void setClosed() {
        this.condition = CellConditions.CLOSED;

    }

    public void changeFlagState() {

        if (this.condition.equals(CellConditions.CLOSED)) {
            this.condition = CellConditions.FLAG;
        }
        else if (this.condition.equals(CellConditions.FLAG)) {
            this.condition = CellConditions.CLOSED;
        }
    }

    public boolean isFlagged() {
        if (this.condition.equals(CellConditions.FLAG)) {
            return true;
        }
        else
            return false;

    }

    public void setFlag() {
        this.condition = CellConditions.FLAG;
    }

    public void deleteFlag() {
        this.condition = CellConditions.CLOSED;
    }

}
