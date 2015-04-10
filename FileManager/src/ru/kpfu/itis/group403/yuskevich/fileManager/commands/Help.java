package ru.kpfu.itis.group403.yuskevich.fileManager.commands;

import java.io.IOException;
import java.nio.file.NoSuchFileException;

import ru.kpfu.itis.group403.yuskevich.fileManager.classes.Helper;
import ru.kpfu.itis.group403.yuskevich.fileManager.interfaces.Command;
import ru.kpfu.itis.group403.yuskevich.fileManager.interfaces.DirChanger;

public class Help implements Command {
	private String[] commandWords;
	@Override
	public void init(String command) {
		String[] words=command.split(" ");
		commandWords=new String[words.length-1];
		System.arraycopy(words, 1, commandWords, 0, words.length-1);
	} 

	@Override
	public String keyWord() {
		return "/help";
	}

	@Override
	public boolean check(String command)
			throws NoSuchFileException, IllegalArgumentException {
		String[] words=command.split(" ");
		return  Helper.checkLength(1, words);
	}

	@Override
	public boolean  execute()
			throws IOException {
		System.out.println("/search 'folder name of path to folder' 'tag' ('-folder') "
				+ "- search file or folder if directory");
		System.out.println("/copy 'filename of path to file' 'directory for copy' - create copy of file");
		System.out.println("/mkdir 'name' - create directory in current directory");
		System.out.println("/mkfile 'name' - create file in current directory");
		System.out.println("/remove 'filename of path to file' - delete file or folder");
		System.out.println("/open 'filename of path to file' - open txt file or directory");
		System.out.println("/rename 'filename of path to file' 'new name' - rename file or folder");
		System.out.println("/encode 'filename of path to file' 'initial encoding' 'result encoding'"
				+ "- change encoding of the file "  );
		System.out.println("/exit - stop file manager");
		 return true;
	}

}
