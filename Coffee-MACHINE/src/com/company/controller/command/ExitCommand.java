package com.company.controller.command;

import com.company.controller.ICommand;

public class ExitCommand implements ICommand {
    @Override
    public boolean execute(String request) {
        System.out.println("See you, Bye!");
        return false;
    }
}
