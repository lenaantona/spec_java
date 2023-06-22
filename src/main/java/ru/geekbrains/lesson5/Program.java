package ru.geekbrains.lesson5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Program {

    /**
     * 1.  Написать функцию, создающую резервную копию всех файлов в директории(без поддиректорий) во вновь созданную папку ./backup
     * 2.  Доработайте класс Tree и метод print который мы разработали на семинаре. Ваш метод должен распечатать полноценное дерево директорий и файлов относительно корневой директории.
     */

      public static void main(String[] args) throws IOException {

        Tree.print(new File("."), "", true);

        Tree.Backup(new File("."), "./backup");

    }
}
