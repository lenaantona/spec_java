package org.example;

public class Main {
    public static void main(String[] args) {
        String [][] inputarray = {{"4", "2", "5", "5"},
                {"4", "7", "5", "2"},
                {"4", "2", "5", "6"},
                {"5", "5", "3", "6"}};

        try{
            MyArray myArray = new MyArray(inputarray);
            myArray.SizeArray();
            System.out.printf("Сумма элементов массива равна %d\n", myArray.SumArray());
        }
        catch (MyArraySizeException e) {
            System.out.printf("Ошибка ввода массива, а именно: %s, массив размером %d на %d\n", e.getName(),e.getCountI(),e.getCountJ());
        }
        catch (MyArrayDataException e){
            System.out.printf("%s элемента массива с координатами [%d][%d]",e.getName(),e.getI(),e.getJ());
        }
    }
}