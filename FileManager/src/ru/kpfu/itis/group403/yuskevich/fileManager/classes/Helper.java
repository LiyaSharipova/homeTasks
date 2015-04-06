package ru.kpfu.itis.group403.yuskevich.fileManager.classes;

import java.io.File;

/**
 * Created by Ian on 01.04.2015.
 */
public class Helper {

    //должен проверять имя файла на знаки \/|*?:<>"
    public static boolean checkName(String a){
        for(int i = 0; i < a.length();i++){
            if(a.charAt(i)=='/'||a.charAt(i)=='|'||a.charAt(i)=='*'||a.charAt(i)=='?'||
                    a.charAt(i)=='"'||a.charAt(i)=='<'||a.charAt(i)=='>'||a.charAt(i)=='\\'||a.charAt(i)==':')
                return false;
        }
        return true;
    }


    //пользователь может ввести либо путь либо конкретное имя файла в текущей директории, этот метод распознает эти 2 случая
   public static File correctPath(String path,File dir ){
        boolean directory = false;
        if(path.substring(0,3).equals("C:\\"))
            return new File(path);
        else
            return new File(dir.getPath()+"/"+path);
    }
    public static boolean checkLength(int length, String command) throws IllegalArgumentException {
    	String[] words = command.split(" ");
    	if(words.length==length){
    		return true;
    	}
    	int subLength=0;
    	for (int i = 0; i < length; i++) {
			subLength+=words[i].length()+1;
		}
    	String options=command.substring(subLength);// лишние опции
            throw new IllegalArgumentException("Extra option(s): "+ options) ;// выводит только лишние слова
    	
	}

}
