package org.example;

import static org.apache.commons.lang3.StringUtils.isNumeric;
public class MyArray {
    private String [][] array;

    public MyArray(String[][] array) {
        this.array = array;
    }

    public void SizeArray() throws MyArraySizeException {
        if (this.array.length != 4 || this.array[0].length != 4){
            throw new MyArraySizeException("массив раземрностью не 4*4", this.array.length, this.array[0].length);
        }
        System.out.printf("Разер массива %d на %d\n", this.array.length, this.array[0].length);
    }

    public int SumArray() throws MyArrayDataException {
        int sum = 0;
        for (int i = 0; i< this.array.length; i++){
            for (int j = 0; j< array[0].length; j++){
                if (isNumeric(array[i][j])) {
                    sum = sum + Integer.parseInt(array[i][j]);
                } else {
                    throw new MyArrayDataException("Ошибка преобразования в число", i, j);
                }
            }
        }
        return sum;
    }
}
