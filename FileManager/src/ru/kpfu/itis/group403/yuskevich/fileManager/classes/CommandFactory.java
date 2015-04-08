package ru.kpfu.itis.group403.yuskevich.fileManager.classes;

import java.nio.file.NoSuchFileException;

import ru.kpfu.itis.group403.yuskevich.fileManager.commands.*;
import ru.kpfu.itis.group403.yuskevich.fileManager.interfaces.Command;
import ru.kpfu.itis.group403.yuskevich.fileManager.interfaces.DirChanger;


public class CommandFactory {
    private Command[] allCommands;

    public CommandFactory(DirChanger dirChanger){
        allCommands = new Command[5];
        allCommands[0] = new Exit();
        allCommands[1] = new Open(dirChanger);
        allCommands[2] = new Back(dirChanger);
        allCommands[3]= new Remove(dirChanger);
        allCommands[4]= new ChangeEncoding(dirChanger);
    }
    public Command create(String commandString) throws NoSuchFileException, NoSuchCommandException{
    	commandString=commandString.trim();
        for(Command command: allCommands){
            if(commandString.split(" ")[0].equals(command.keyWord())){
            	command.setCommandString(commandString);
            	if(command.check())
                    return command;

            }
                
        }
        throw new NoSuchCommandException("wrong command name: "+  commandString.split(" ")[0] );
        
    }

}


