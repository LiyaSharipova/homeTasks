package ru.kpfu.itis.group403.yuskevich.fileManager.commands;

import java.io.File;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

import ru.kpfu.itis.group403.yuskevich.fileManager.classes.Helper;
import ru.kpfu.itis.group403.yuskevich.fileManager.interfaces.Command;
import ru.kpfu.itis.group403.yuskevich.fileManager.interfaces.DirChanger;

/**
 * Created by Ian on 01.04.2015.
 */
public class Open implements Command{
	private String[] commandWords;
	@Override
	public void setCommandString(String command) {
		String[] words=command.split(" ");
		commandWords=new String[words.length-1];
		System.arraycopy(words, 1, commandWords, 0, words.length-1);
	} 
	public Open(DirChanger dirChanger) {
		super();
		this.dirChanger = dirChanger;
	}
	
	private DirChanger dirChanger;
    @Override
    public String keyWord() {
        return "/open";
    }
  

    @Override
    public boolean check() throws NoSuchFileException, IllegalArgumentException {
        

        return  Helper.checkLength(1, commandWords);
        
        	
    }

    @Override
    public void execute() throws IOException {
        File file = Helper.correctPath(commandWords[0], dirChanger.getDir());
        if (!file.exists()){
        	throw new NoSuchFileException(" no such file: "+ commandWords[0]);
        }
        if(file.isDirectory())
            dirChanger.setDir(file);

    }



}
//String[] words = command.split(" ");
//if((words.length==2)&&(Helper.correctPath(words[1], dirChanger.getDir()).exists()))
//      return true;
//if (words.length!=2){
//	String options=command.substring(words[0].length()+words[1].length()+2);// лишние опции
//	if ((Helper.correctPath(words[1], dirChanger.getDir()).exists())){// файл есть, но слов больше 2х        		
//      throw new IllegalArgumentException("wrong options: "+ options) ;// выводит только лишние слова
//	}
//	// файла тоже нет, 
//  throw new IllegalArgumentException("  no such file: "+ words[1]+"\n" + "  wrong options: "+ options);
//  	
//}
//
//	throw new NoSuchFileException(" no such file: "+ words[1]);