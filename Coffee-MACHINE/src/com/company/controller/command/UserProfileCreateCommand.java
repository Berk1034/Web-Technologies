package com.company.controller.command;

import com.company.service.ServiceFactory;
import com.company.beans.UserProfile;
import com.company.service.UserProfileService;
import com.company.controller.ICommand;

import java.util.Date;
import java.util.Scanner;

public class UserProfileCreateCommand implements ICommand {
    @Override
    public boolean execute(String request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserProfileService userProfileService = serviceFactory.getUserProfileService();
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your name:");
            String name = scanner.nextLine();
            System.out.println("Enter your surname:");
            String surname = scanner.nextLine();
            System.out.println("Enter your age:");
            int age = scanner.nextInt();
            UserProfile user = new UserProfile(name, surname, age, new Date());
            userProfileService.AddUserProfile(user);
            System.out.println("Success!");
        } catch(Exception e){
            System.out.println("Failed");
        }

        return true;
    }
}
