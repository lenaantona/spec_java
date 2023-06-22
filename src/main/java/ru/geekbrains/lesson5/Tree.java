package ru.geekbrains.lesson5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.StandardCopyOption.COPY_ATTRIBUTES;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Tree {

    /**
     * TODO: Доработать метод print, необходимо распечатывать директории и файлы
     *
     * @param file
     * @param indent
     * @param isLast
     */
    public static void print(File file, String indent, boolean isLast) {
        System.out.print(indent); // рисуем отступ
        if (isLast) {
            System.out.print("└─");
            indent += "  ";
        } else {
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(file.getName());

        File[] files = file.listFiles();
        if (files == null)
            return;

        int subDirTotal = 0;
        //File[] filesFile = new File[files.length];
        List<File> filesF = new ArrayList<>(); //список только фалов
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory())
                subDirTotal++;
            else {
                filesF.add(files[i]);
            }
        }
        //распечатываем только файлы
        for (int i = 0; i < filesF.size(); i++) {
            print(filesF.get(i), indent, i < filesF.size() - 1);
        }


        int subDirCounter = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                print(files[i], indent, subDirCounter == subDirTotal - 1);
                subDirCounter++;
            }
        }


    }

    /**
     * @param file   диерктория из которой копируются файлы
     * @param backup директория куда копируются файлы
     */
    public static void Backup(File file, String backup) throws IOException {
        File[] files = file.listFiles();
        Path path = Paths.get(backup);
        if (!Files.exists(path))
            Files.createDirectory(path);

        for (int i = 0; i < files.length; i++) {
            if (!files[i].isDirectory()) {
                Files.copy(files[i].toPath(), Path.of(backup + "/" + files[i].getName()), REPLACE_EXISTING);
            }
        }
    }
}
