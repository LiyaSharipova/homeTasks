package ru.kpfu.itis.group403.yuskevich.fileManager.interfaces;

import java.io.File;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

import ru.kpfu.itis.group403.yuskevich.fileManager.classes.NoSuchCommandException;

/**
 * Created by Ian on 30.03.2015.
 */
public interface Command {
	void setCommandString(String command);
    String keyWord();// возвращает ключивое слово типа "/copy"
    boolean check() throws NoSuchFileException,IllegalArgumentException;//проверяет корректность строки
    //проверяет пути до файла, существует ли такой файл

    void execute() throws IOException;//выполняет

}
