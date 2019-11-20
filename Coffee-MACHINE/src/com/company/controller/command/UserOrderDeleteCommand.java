package com.company.controller.command;

import com.company.beans.UserOrder;
import com.company.controller.ICommand;
import com.company.service.ServiceFactory;

import java.util.List;
import java.util.Scanner;

public class UserOrderDeleteCommand implements ICommand {
    @Override
    public boolean execute(String request) {
        if(ServiceFactory.getInstance().getUserProfileService().GetLoggedInUserProfile() != null){
            List<UserOrder> userOrders = ServiceFactory.getInstance().getUserOrderService().ReadUserOrder();
            int TotalOrders = userOrders.size();
            boolean noOrders = true;
            for(UserOrder userOrder: userOrders ){
                if(userOrder.getUserProfile().getCreationDate().equals(ServiceFactory.getInstance().getUserProfileService().GetLoggedInUserProfile().getCreationDate())){
                    noOrders = false;
                }
            }
            if(noOrders){
                System.out.println("Add Order first!");
            }
            else {
                System.out.println("Enter order number that you want to delete:");
                Scanner scanner = new Scanner(System.in);
                int deleteordernumber = scanner.nextInt();
                ServiceFactory.getInstance().getUserOrderService().DeleteUserOrder(deleteordernumber);
                if(TotalOrders>ServiceFactory.getInstance().getUserProfileService().ReadUserProfile().size()){
                    System.out.println("Successfully removed!");
                }
                else{
                    System.out.println("No order with number " + deleteordernumber + "found.");
                }
            }
        }
        else{
            System.out.println("Choose UserProfile first!");
        }
        return true;
    }
}
