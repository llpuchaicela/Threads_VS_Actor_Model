package ParallelMatriz;

import ParallelMatriz.matriz;

public class TaskCalcElement extends Thread {
    private matriz m1;
    private matriz m2;
    private int rowIndex;
    private int colIndex;
    private int element;

    public TaskCalcElement(matriz m1, matriz m2, int rowIndex, int colIndex) {
        this.m1 = m1;
        this.m2 = m2;
        this.rowIndex = rowIndex;
        this.colIndex = colIndex;
    }

    @Override
    public void run() {
        element = calcValue(m1.getRow(rowIndex), m2.getColumn(colIndex));
    }

    private int calcValue(int[] row, int[] col) {
        int aux = 0;
        for (var i = 0; i < row.length; i++) {
            aux += row[i] * col[i];
        }
        return aux;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public int getColIndex() {
        return colIndex;
    }

    public int getElement() {
        return element;
    }
}


