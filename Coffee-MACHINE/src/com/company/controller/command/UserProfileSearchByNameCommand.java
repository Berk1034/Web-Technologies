package com.company.controller.command;

import com.company.beans.UserProfile;
import com.company.controller.ICommand;
import com.company.service.ServiceFactory;

import java.util.Scanner;

public class UserProfileSearchByNameCommand implements ICommand {
    @Override
    public boolean execute(String request) {
        System.out.println("Enter name that you want to find:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        UserProfile userProfile = ServiceFactory.getInstance().getUserProfileService().SearchByName(name);
        if(userProfile != null){
            System.out.println("---------------------------------------------------");
            System.out.println(userProfile.toString());
            System.out.println("---------------------------------------------------");
        }
        else{
            System.out.println("Nothing found.");
        }
        return true;
    }
}
