package Domain;

public class Maze {

    //atributos 
    public static int[][] matrixGeneral;
    int rows, columns, exit, input,exit1,e1, dona;
    int rowInput, columnsInput, rowExit, colmnsExit, rowInput1, columnsInput1, rowExit1, columnsExit1;
    int x, y, end;
    int f;
    int radioButtons;

    //constructor
    public Maze(int[][] matrixGeneral, int row, int dona,int columns, int s, int e, int s1, int e1, int fil_entrada, int col_entrada, int filasalida, int columnaSalisa, int fil_entrada1, int col_entrada1, int filasalida1, int columnaSalisa1, int x, int y, int termino, int f, int radioBotones) {
        this.matrixGeneral = matrixGeneral;
        this.rows = row;
        this.columns = columns;
        this.dona= dona;
        this.exit = s;
        this.input = e;
        this.exit1 = s1;
        this.e1 = e1;
        this.rowInput = fil_entrada;
        this.columnsInput = col_entrada;
        this.rowExit = filasalida;
        this.colmnsExit = columnaSalisa;
        this.rowInput1 = fil_entrada1;
        this.columnsInput1 = col_entrada1;
        this.rowExit1 = filasalida1;
        this.columnsExit1 = columnaSalisa1;
        this.x = x;
        this.y = y;
        this.end = termino;
        this.f = f;
        this.radioButtons = radioBotones;
    }

  

    public Maze(int[][] matrixGeneral) {
        this.matrixGeneral = matrixGeneral;
        rows = 0;
        columns = 0;
        exit = 0;
        dona=0;
        input = 0;
        rowInput = 0;
        columnsInput = 0;
        rowExit = 0;
        colmnsExit = 0;
        x = 0;
        y = 0;
        end = 0;
        f = 0;
        radioButtons = 0;
        exit1=0;
        e1=0;
        rowInput1=0;
        columnsInput1=0;
        rowExit1=0;
        columnsExit1=0;
    }
    
    public static int[][] getMatrixGeneral() {
        return matrixGeneral;
    }

    public static void setMatrixGeneral(int[][] matrixGeneral) {
        Maze.matrixGeneral = matrixGeneral;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getExit() {
        return exit;
    }

    public void setExit(int exit) {
        this.exit = exit;
    }

    public int getInput() {
        return input;
    }

    public void setInput(int input) {
        this.input = input;
    }

    public int getExit1() {
        return exit1;
    }

    public void setExit1(int exit1) {
        this.exit1 = exit1;
    }

    public int getE1() {
        return e1;
    }

    public void setE1(int e1) {
        this.e1 = e1;
    }

    public int getDona() {
        return dona;
    }

    public void setDona(int dona) {
        this.dona = dona;
    }

    public int getRowInput() {
        return rowInput;
    }

    public void setRowInput(int rowInput) {
        this.rowInput = rowInput;
    }

    public int getColumnsInput() {
        return columnsInput;
    }

    public void setColumnsInput(int columnsInput) {
        this.columnsInput = columnsInput;
    }

    public int getRowExit() {
        return rowExit;
    }

    public void setRowExit(int rowExit) {
        this.rowExit = rowExit;
    }

    public int getColmnsExit() {
        return colmnsExit;
    }

    public void setColmnsExit(int colmnsExit) {
        this.colmnsExit = colmnsExit;
    }

    public int getRowInput1() {
        return rowInput1;
    }

    public void setRowInput1(int rowInput1) {
        this.rowInput1 = rowInput1;
    }

    public int getColumnsInput1() {
        return columnsInput1;
    }

    public void setColumnsInput1(int columnsInput1) {
        this.columnsInput1 = columnsInput1;
    }

    public int getRowExit1() {
        return rowExit1;
    }

    public void setRowExit1(int rowExit1) {
        this.rowExit1 = rowExit1;
    }

    public int getColumnsExit1() {
        return columnsExit1;
    }

    public void setColumnsExit1(int columnsExit1) {
        this.columnsExit1 = columnsExit1;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }

    public int getRadioButtons() {
        return radioButtons;
    }

    //getters and setters
    public void setRadioButtons(int radioButtons) {    
        this.radioButtons = radioButtons;
    }

    public int getRadioBotones() {
        return radioButtons;
    }

    public void setRadioBotones(int radioBotones) {
        this.radioButtons = radioBotones;
    }

    public boolean getPlayer(int x, int y) {
        int cell = this.matrixGeneral[x][y];
        // 2 es para jugador y  1 para pared
        if(cell != 1 && cell != 2){
            matrixGeneral[x][y] = 2;
            return true;
        }
        else{
            return false;
        }
    }

    public boolean esta_chocando(int x, int y) {
        int cell = this.matrixGeneral[x][y];
        return (cell != 1 && cell != 2);
    }

}
