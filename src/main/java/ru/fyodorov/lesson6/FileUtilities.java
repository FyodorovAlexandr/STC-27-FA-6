package ru.fyodorov.lesson6;

import java.io.File;

/**
 * Класс получает путь каталога и возвращает его содержимое
 */
public class FileUtilities {
    private FileUtilities(){
    }

    public static String getDirsFiles(String filePath){
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        File[] filePathList = new File(filePath).listFiles();

        if(filePathList != null){
            for(File file : filePathList){
                sb.append(file.getName()).append("\n");
            }
        }
        return sb.toString();
    }
}