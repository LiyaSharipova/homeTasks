package ru.kpfu.itis.group403.yuskevich.fileManager.interfaces;

import java.io.File;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

import ru.kpfu.itis.group403.yuskevich.fileManager.classes.NoSuchCommandException;

/**
 * Created by Ian on 30.03.2015.
 */
public interface Command {
    String keyWord();// возвращает ключивое слово типа "/copy"
    boolean check(String command, DirChanger dir) throws NoSuchFileException,IllegalArgumentException;//проверяет корректность строки
    //проверяет пути до файла, существует ли такой файл

    void execute(String command, DirChanger dirChanger) throws IOException;//выполняет

}
