package com.company.controller;

import com.company.controller.command.*;

import java.util.HashMap;
import java.util.Map;

public class CommandHelper {
    private static final CommandHelper instance = new CommandHelper();
    private Map<CommandName, ICommand> commands = new HashMap<>();

    public CommandHelper(){
        commands.put(CommandName.CREATE_USERPROFILE_COMMAND, new UserProfileCreateCommand());
        commands.put(CommandName.CHOOSE_USERPROFILE_COMMAND, new UserProfileChooseCommand());
        commands.put(CommandName.SHOW_USERPROFILE_COMMAND, new UserProfileShowCommand());
        commands.put(CommandName.UPDATE_USERPROFILE_COMMAND, new UserProfileUpdateCommand());
        commands.put(CommandName.DELETE_USERPROFILE_COMMAND, new UserProfileDeleteCommand());
        commands.put(CommandName.EXIT_COMMAND, new ExitCommand());
        commands.put(CommandName.NO_SUCH_COMMAND, new NoSuchCommand());
    }

    public static CommandHelper getInstance(){
        return instance;
    }

    public ICommand getCommand(String commandName){
        ICommand command;
        try{
            CommandName name = CommandName.valueOf(commandName.toUpperCase());
            if(name != null){
                command = commands.get(name);
            }
            else{
                command = commands.get(CommandName.NO_SUCH_COMMAND);
            }
        }
        catch (IllegalArgumentException | NullPointerException exception){
            command = commands.get(CommandName.NO_SUCH_COMMAND);
        }

        return command;
    }
}

