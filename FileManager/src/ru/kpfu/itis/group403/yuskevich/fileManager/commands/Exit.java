package ru.kpfu.itis.group403.yuskevich.fileManager.commands;

import ru.kpfu.itis.group403.yuskevich.fileManager.classes.Helper;
import ru.kpfu.itis.group403.yuskevich.fileManager.interfaces.Command;
import ru.kpfu.itis.group403.yuskevich.fileManager.interfaces.DirChanger;

/**
 * Created by Ian on 01.04.2015.
 */
public class Exit implements Command{
	private String[] commandWords;
	@Override
	public void setCommandString(String command) {
		String[] words=command.split(" ");
		commandWords=new String[words.length-1];
		System.arraycopy(words, 1, commandWords, 0, words.length-1);
	} 
	
    @Override
    public String keyWord() {
        return "/exit";
    }

    @Override
    public boolean check() throws IllegalArgumentException {
    	 return  Helper.checkLength(0, commandWords);
    }

    @Override
    public void execute() {

    }
}
