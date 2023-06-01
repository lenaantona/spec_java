package ru.geekbrains.lesson2;

import java.util.Random;
import java.util.Scanner;

/**
 * Переработать метод проверки победы, логика проверки победы должна работать для поля 5х5 и
 * количества фишек 4.
 */

public class Program {


    private static final  int WIN_COUNT = 4;
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static final char DOT_EMPTY = '•';

    private static final Scanner SCANNER = new Scanner(System.in);

    private static char[][] field; // Двумерный массив хранит текущее состояние игрового поля

    private static final Random random = new Random();

    private static int fieldSizeX; // Размерность игрового поля
    private static int fieldSizeY; // Размерность игрового поля

    private static int x;// координаты активной ячейки
    private static int y;// координаты активной ячейки


    public static void main(String[] args) {
        while (true){
            initialize();
            printField();
            while (true){
                humanTurn();
                printField();
                if (gameCheck(DOT_HUMAN, "Вы победили!", x, y))
                    break;
                aiTurn();
                printField();
                if (gameCheck(DOT_AI, "Компьютер победил!", x, y))
                    break;
            }
            System.out.println("Желаете сыграть еще раз? (Y - да)");
            if (!SCANNER.next().equalsIgnoreCase("Y"))
                break;
        }
    }

    /**
     * Инициализация игрового поля
     */
    private static void initialize(){
        // Установим размерность игрового поля
        fieldSizeX = 5;
        fieldSizeY = 5;


        field = new char[fieldSizeX][fieldSizeY];
        // Пройдем по всем элементам массива
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                // Проинициализируем все элементы массива DOT_EMPTY (признак пустого поля)
                field[i][j] = DOT_EMPTY;
            }
        }
    }

    /**
     * Отрисовка игрового поля
     * //TODO: Поправить отрисовку игрового поля
     */
    private static void printField(){
        System.out.print("+");
        for (int i = 0; i < fieldSizeY * 2 + 1; i++){
            System.out.print((i % 2 == 0) ? "-" : i / 2 + 1);
        }
        System.out.println();

        for (int i = 0; i < fieldSizeX; i++){
            System.out.print(i + 1 + "|");

            for (int j = 0; j <  fieldSizeY; j++)
                System.out.print(field[i][j] + "|");

            System.out.println();
        }

        for (int i = 0; i < fieldSizeY * 2 + 2; i++){
            System.out.print("-");
        }
        System.out.println();

    }

    /**
     * Обработка хода игрока (человек)
     */
    private static void humanTurn(){
        do
        {
            System.out.print("Введите координаты хода X и Y через пробел >>> ");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        }
        while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[x][y] = DOT_HUMAN;
    }

    /**
     * Проверка, ячейка является пустой
     * @param x
     * @param y
     * @return
     */
    static boolean isCellEmpty(int x, int y){
        return field[x][y] == DOT_EMPTY;
    }

    /**
     * Проверка корректности ввода
     * (координаты хода не должны превышать размерность массива, игрового поля)
     * @param x
     * @param y
     * @return
     */
    static boolean isCellValid(int x, int y){
        return x >= 0 &&  x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    /**
     * Ход компьютера
     */
    private static void aiTurn(){
        do
        {
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        }
        while (!isCellEmpty(x, y));
        field[x][y] = DOT_AI;
    }

    /**
     * Проверка победы
     * Изменена проверка победы для разной размерности массива, но по всей вертикали, горизонтали и диоганали
     * @param c
     * @return
     */
    static boolean checkWin(char c, int x, int y){
        int index;
        // Проверка по горизонталям
       for (int i = 0; i < fieldSizeY; i++){
            index = 0;
            if (field[x][i] == c){
                index = 1;
                for (int j = i; j < fieldSizeY-1; j++){
                    if (field[x][j] == field[x][j+1]) index++;
                    else break;
                }
                if (index == WIN_COUNT) return true;
            }
        }

        //координаты  первого элемента массива диагонали возрастающей
        int x0 = x;
        int y0 = y;
        while (x0 != 0 && y0 != 0){
            x0--;
            y0--;
        }
        //проверка по возрастающей диагонали
        index = 1;
        for (int i = 0; x0 +i < fieldSizeX-1 && y0 +i <fieldSizeY-1; i++) {
            if ((field[x0 + i][y0 + i] == c) && (field[x0 + i+1][y0 + i+1]==c )) {
                index++;
                if (index == WIN_COUNT) return true;
            }
        }
        //координаты  первого элемента массива диагонали убывающей
        x0 = x;
        y0 = y;
        while (x0 != fieldSizeX-1 && y0 != 0){
            x0++;
            y0--;
        }
        //проверка по убывающей диагонали
        index = 1;
        for (int i = 0; x0 - i > 0 && y0 + i < fieldSizeY-1; i++) {
            if ((field[x0 - i][y0 + i] == c) && (field[x0 - i - 1][y0 + i + 1]==c )) {
                index++;
                if (index == WIN_COUNT) return true;
            }
        }
        // Проверка по вертикалям

        for (int i = 0; i < fieldSizeX; i++){
            index = 0;
            if (field[i][y] == c){
                index = 1;
                for (int j = i; j < fieldSizeX-1; j++){
                    if (field[j][y] == field[j+1][y]) index++;
                    else break;
                }
                if (index == WIN_COUNT) return true;
            }
        }
        return false;
    }

    /**
     * Проверка на ничью
     * @return
     */
    static boolean checkDraw(){
        for (int i = 0; i < fieldSizeX; i++){
            for (int j = 0; j < fieldSizeY; j++)
                if (isCellEmpty(i, j)) return false;
        }
        return true;
    }

    /**
     * Метод проверки состояния игры
     * @param c
     * @param str
     * @return
     */
    static boolean gameCheck(char c, String str, int x, int y){
        if (checkWin(c, x, y)){
            System.out.println(str);
            return true;
        }
        if (checkDraw()){
            System.out.println("Ничья!");
            return true;
        }

        return false; // Игра продолжается
    }

}
