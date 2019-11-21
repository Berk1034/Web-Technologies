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
        commands.put(CommandName.SEARCHBYNAME_USERPROFILE_COMMAND, new UserProfileSearchByNameCommand());
        commands.put(CommandName.SEARCHBYSURNAME_USERPROFILE_COMMAND, new UserProfileSearchBySurnameCommand());
        commands.put(CommandName.SORTBYNAME_USERPROFILE_COMMAND, new UserProfileSortByNameCommand());
        commands.put(CommandName.SORTBYAGE_USERPROFILE_COMMAND, new UserProfileSortByAgeCommand());
        commands.put(CommandName.SORTBYCREATIONDATE_USERPROFILE_COMMAND, new UserProfileSortByCreationDateCommand());
        commands.put(CommandName.CREATE_USERORDER_COMMAND, new UserOrderCreateCommand());
        commands.put(CommandName.SHOW_USERORDER_COMMAND, new UserOrderShowCommand());
        commands.put(CommandName.UPDATE_USERORDER_COMMAND, new UserOrderUpdateCommand());
        commands.put(CommandName.DELETE_USERORDER_COMMAND, new UserOrderDeleteCommand());
        commands.put(CommandName.SORTBYCOFFEEAMOUNT_USERORDER_COMMAND, new UserOrderSortByCoffeeAmountCommand());
        commands.put(CommandName.SORTBYDATE_USERORDER_COMMAND, new UserOrderSortByDateCommand());
        commands.put(CommandName.SORTBYID_USERORDER_COMMAND, new UserOrderSortByIDCommand());
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

