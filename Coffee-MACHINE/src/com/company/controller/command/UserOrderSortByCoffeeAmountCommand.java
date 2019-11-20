package com.company.controller.command;

import com.company.controller.ICommand;
import com.company.service.ServiceFactory;

public class UserOrderSortByCoffeeAmountCommand implements ICommand {
    @Override
    public boolean execute(String request) {
        ServiceFactory.getInstance().getUserOrderService().SortByCoffeeAmount();
        System.out.println("Sorted by Coffee Amount");
        return true;
    }
}
