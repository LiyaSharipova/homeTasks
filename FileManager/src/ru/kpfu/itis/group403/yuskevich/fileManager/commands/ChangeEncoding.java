package ru.kpfu.itis.group403.yuskevich.fileManager.commands;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.NoSuchFileException;

import ru.kpfu.itis.group403.yuskevich.fileManager.classes.Helper;
import ru.kpfu.itis.group403.yuskevich.fileManager.interfaces.Command;
import ru.kpfu.itis.group403.yuskevich.fileManager.interfaces.DirChanger;

public class ChangeEncoding implements Command {
	private String[] commandWords;
	@Override
	public void setCommandString(String command) {
		String[] words=command.split(" ");
		commandWords=new String[words.length-1];
		System.arraycopy(words, 1, commandWords, 0, words.length-1);
	} 

	private DirChanger dirChanger;

	@Override
	public String keyWord() {
		// TODO Auto-generated method stub
		return "/encode";
	}

	@Override
	public boolean check(){
	    return Helper.checkLength(3, commandWords);
	}

	
	@Override
	public void execute() throws IOException {
		File file = Helper.correctPath(commandWords[0], dirChanger.getDir());
		File dir=new File(file.getPath().substring(0, file.getPath().lastIndexOf(File.separatorChar)));
		File temp = File.createTempFile("temp", ".txt", dir);
        String from= commandWords[1];
        String to= commandWords[2];
		char[] buffer=new char[4096];
		int len;
		try (   InputStream in=new FileInputStream(file);
				Reader r=new BufferedReader(new InputStreamReader(in, from));
				OutputStream out=new FileOutputStream(temp);
				Writer w=new BufferedWriter(new OutputStreamWriter(out, to));){
			
			while((len=r.read(buffer)) != -1)
				w.write(buffer, 0, len);
		}
		catch(IOException e){
			throw e;
		}
		file.delete();
		temp.renameTo(Helper.correctPath(commandWords[0], dirChanger.getDir()));
	}

	public ChangeEncoding(DirChanger dirChanger) {
		super();
		this.dirChanger = dirChanger;
	}

}
