package ru.kpfu.itis.group403.yuskevich.fileManager.commands;

import java.io.File;
import java.nio.file.NoSuchFileException;

import ru.kpfu.itis.group403.yuskevich.fileManager.classes.Tool;
import ru.kpfu.itis.group403.yuskevich.fileManager.interfaces.Command;
import ru.kpfu.itis.group403.yuskevich.fileManager.interfaces.DirChanger;

public class Remove implements Command {
	private String[] commandWords;
	private File file;
	@Override
	public void init(String command) {
		String[] words = Tool.split(command);
		file= Tool.correctPath(words[1], dirChanger.getDir());
		
	} 
	private DirChanger dirChanger;
	public Remove(DirChanger dirChanger) {
		super();
		this.dirChanger = dirChanger;
	}

	@Override
	public String keyWord() {
		return "/remove";
	}

	@Override
	public boolean check(String command) throws IllegalArgumentException {
		String[] words = Tool.split(command);
		return  Tool.checkLength(2, words);

	}
	public void deleteDirectory(File dir) {
		if (dir.isDirectory()) {
			String[] list = dir.list();
			for (int i=0; i<list.length; i++) {
				File f = new File(dir, list[i]);
				deleteDirectory(f);
			}
			dir.delete();
		} else dir.delete();
	}

	@Override
	public boolean  execute() throws NoSuchFileException {
		if (!file.exists()){
			throw new NoSuchFileException(" no such file: "+ file.getPath());
		}
		deleteDirectory(file);
		 return true;
	}

}
