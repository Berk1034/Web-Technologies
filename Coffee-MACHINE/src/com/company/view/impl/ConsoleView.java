package com.company.view.impl;

import com.company.controller.CommandName;
import com.company.view.View;

public class ConsoleView implements View {

    @Override
    public void showAvailableCommands(){
        System.out.println("Available Commands in COFFEE-MACHINE:");
        CommandName[] commandNames = CommandName.values();
        for(CommandName commandName:commandNames){
            if(commandName!=CommandName.NO_SUCH_COMMAND)
                System.out.println(commandName);
        }
    }

    @Override
    public void showErrorMessage(String message){
        System.out.println("Error occured!");
        System.out.println(message);
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }
}
