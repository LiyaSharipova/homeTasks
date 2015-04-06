package ru.kpfu.itis.group403.yuskevich.fileManager.commands;

import ru.kpfu.itis.group403.yuskevich.fileManager.classes.Helper;
import ru.kpfu.itis.group403.yuskevich.fileManager.interfaces.Command;
import ru.kpfu.itis.group403.yuskevich.fileManager.interfaces.DirChanger;

/**
 * Created by Ian on 01.04.2015.
 */
public class Exit implements Command{

    @Override
    public String keyWord() {
        return "/exit";
    }

    @Override
    public boolean check(String command, DirChanger dir) throws IllegalArgumentException {
    	 return  Helper.checkLength(1, command);
    }

    @Override
    public void execute(String command, DirChanger dirChanger) {

    }
}
