package com.company.controller.command;

import com.company.beans.UserOrder;
import com.company.controller.CoffeeHelper;
import com.company.controller.CoffeeName;
import com.company.controller.ICommand;
import com.company.service.ServiceFactory;
import com.company.service.UserOrderService;

import java.util.Date;
import java.util.Scanner;

public class UserOrderCreateCommand implements ICommand {
    @Override
    public boolean execute(String request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserOrderService userOrderService = serviceFactory.getUserOrderService();
        if(serviceFactory.getUserProfileService().GetLoggedInUserProfile() != null){
            try{
                Scanner scanner = new Scanner(System.in);
                System.out.println("Choose coffee you would like to order:");
                CoffeeName[] coffeeNames = CoffeeName.values();
                for(CoffeeName coffeeName:coffeeNames){
                    System.out.println(coffeeName);
                }
                String coffee = scanner.nextLine();
                if(CoffeeHelper.getInstance().getCoffee(coffee) != null){
                    int id = userOrderService.GetMaxID() + 1;
                    UserOrder order = new UserOrder(id, new Date(), CoffeeHelper.getInstance().getCoffee(coffee), serviceFactory.getUserProfileService().GetLoggedInUserProfile());
                    userOrderService.AddUserOrder(order);
                    System.out.println("Success!");
                }
                else{
                    System.out.println("No such coffee!");
                }
            } catch(Exception e){
                System.out.println("Failed");
            }
        }
        else{
            System.out.println("Choose UserProfile first!");
        }
        return true;
    }
}
