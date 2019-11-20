package com.company.controller.command;

import com.company.beans.UserOrder;
import com.company.controller.CoffeeHelper;
import com.company.controller.CoffeeName;
import com.company.controller.ICommand;
import com.company.service.ServiceFactory;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class UserOrderUpdateCommand implements ICommand {
    @Override
    public boolean execute(String request) {
        if(ServiceFactory.getInstance().getUserProfileService().GetLoggedInUserProfile() != null){
            List<UserOrder> userOrders = ServiceFactory.getInstance().getUserOrderService().ReadUserOrder();
            System.out.println("Choose order that you want to update:");
            Scanner scanner = new Scanner(System.in);
            int updateordernumber = scanner.nextInt();
            for(UserOrder userOrder: userOrders){
                if(userOrder.getUserProfile().getCreationDate().equals(ServiceFactory.getInstance().getUserProfileService().GetLoggedInUserProfile().getCreationDate())){
                    if(userOrder.getID() == updateordernumber){
                        System.out.println("Choose coffee you would like to order:");
                        CoffeeName[] coffeeNames = CoffeeName.values();
                        for(CoffeeName coffeeName:coffeeNames){
                            System.out.println(coffeeName);
                        }
                        Scanner coffeescanner = new Scanner(System.in);
                        String coffee = coffeescanner.nextLine();
                        if(CoffeeHelper.getInstance().getCoffee(coffee) != null) {
                            int id = userOrder.getID();
                            UserOrder updateOrder = new UserOrder(id, new Date(), CoffeeHelper.getInstance().getCoffee(coffee), ServiceFactory.getInstance().getUserProfileService().GetLoggedInUserProfile());
                            ServiceFactory.getInstance().getUserOrderService().UpdateUserOrder(updateOrder);
                            System.out.println("Success!");
                        }
                        else{
                            System.out.println("No such coffee!");
                        }
                        break;
                    }
                }
            }
        }
        else{
            System.out.println("Choose UserProfile first!");
        }
        return true;
    }
}
