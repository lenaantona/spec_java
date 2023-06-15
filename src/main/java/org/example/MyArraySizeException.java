package org.example;

public class MyArraySizeException extends MyArrayException{
    private int countI; //кол-во строк
    private int countJ; //кол-во столбцов
    public MyArraySizeException(String name, int countI, int countJ) {
        super(name);
        this.countI = countI;
        this.countJ = countJ;
    }

    public int getCountI() {
        return countI;
    }

    public int getCountJ() {
        return countJ;
    }
}
