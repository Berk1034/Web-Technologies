package com.company.controller.command;

import com.company.controller.ICommand;
import com.company.service.ServiceFactory;

public class UserOrderSortByIDCommand implements ICommand {
    @Override
    public boolean execute(String request) {
        ServiceFactory.getInstance().getUserOrderService().SortByID();
        System.out.println("Sorted by ID");
        return true;
    }
}
