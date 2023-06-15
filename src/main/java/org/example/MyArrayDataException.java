package org.example;

public class MyArrayDataException extends MyArrayException{
    private int i; //координаты строки
    private int j; //координаты столбца

    public MyArrayDataException(String name, int i, int j) {
        super(name);
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}
