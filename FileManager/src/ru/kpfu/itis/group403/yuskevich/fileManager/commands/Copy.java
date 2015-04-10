package ru.kpfu.itis.group403.yuskevich.fileManager.commands;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.Scanner;

import ru.kpfu.itis.group403.yuskevich.fileManager.classes.Helper;
import ru.kpfu.itis.group403.yuskevich.fileManager.interfaces.Command;
import ru.kpfu.itis.group403.yuskevich.fileManager.interfaces.DirChanger;

public class Copy implements Command {
	private Scanner sc;
	private DirChanger dirChanger;

	public Copy( DirChanger dir, Scanner sc) {
		super();
		this.sc = sc;
		this.dirChanger = dir;
	}

	private String[] commandWords;
	@Override
	public void init(String command) {
		String[] words=command.split(" ");
		commandWords=new String[words.length-1];
		System.arraycopy(words, 1, commandWords, 0, words.length-1);
	}

	@Override
	public String keyWord() {
		return "/copy";
	}

	@Override
	public boolean check(String command) throws NoSuchFileException, IllegalArgumentException {
		String[] words=command.split(" ");
		return  Helper.checkLength(3, words);
	}

	@Override
	public boolean  execute() throws IOException {
		File file = Helper.correctPath(commandWords[0], dirChanger.getDir());
		String path=file.getPath();
		StringBuffer copyFileName= new StringBuffer(path);
		File fileDir=new File(file.getPath().substring(0, path.lastIndexOf(File.separatorChar)));
		File copyDir=Helper.correctPath(commandWords[1], dirChanger.getDir());
		int i=2;

		if (fileDir.equals(copyDir)){
			copyFileName=copyFileName.insert(path.lastIndexOf('.'),"_copy");
			if(new File(copyFileName.toString()).exists()){
				copyFileName=copyFileName.insert(copyFileName.toString().lastIndexOf('.'),"(1)");
			}
			if(new File(copyFileName.toString()).exists()){
				while(new File(copyFileName.toString()).exists()){
					copyFileName=copyFileName.replace(copyFileName.toString().lastIndexOf('(')+1,
							copyFileName.toString().lastIndexOf(')') , Integer.toString(i));
					i++;
				}
			}
		}
	
	else 
		System.out.println("false");
	try(FileOutputStream in=new FileOutputStream(copyFileName.toString())){

	}
}

}
