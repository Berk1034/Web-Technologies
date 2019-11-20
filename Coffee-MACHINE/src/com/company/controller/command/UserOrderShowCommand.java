package com.company.controller.command;

import com.company.beans.UserOrder;
import com.company.controller.ICommand;
import com.company.service.ServiceFactory;

import java.util.List;

public class UserOrderShowCommand implements ICommand {
    @Override
    public boolean execute(String request) {
        if(ServiceFactory.getInstance().getUserProfileService().GetLoggedInUserProfile() != null) {
            List<UserOrder> userOrders = ServiceFactory.getInstance().getUserOrderService().ReadUserOrder();
            boolean noOrders = true;
            for(UserOrder userOrder: userOrders ){
                if(userOrder.getUserProfile().getCreationDate().equals(ServiceFactory.getInstance().getUserProfileService().GetLoggedInUserProfile().getCreationDate())){
                    System.out.println("---------------------------------------------------");
                    System.out.println("Order ID" + userOrder.getID());
                    System.out.println(userOrder.toString());
                    System.out.println("---------------------------------------------------");
                    noOrders = false;
                }
            }
            if(noOrders){
                System.out.println("Add Order first!");
            }
        }
        else{
            System.out.println("Choose UserProfile first!");
        }
        return true;
    }
}
