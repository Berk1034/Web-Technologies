package com.company.controller.command;

import com.company.controller.ICommand;
import com.company.service.ServiceFactory;

public class UserOrderSortByDateCommand implements ICommand {
    @Override
    public boolean execute(String request) {
        ServiceFactory.getInstance().getUserOrderService().SortByDate();
        System.out.println("Sorted by Date");
        return true;
    }
}
