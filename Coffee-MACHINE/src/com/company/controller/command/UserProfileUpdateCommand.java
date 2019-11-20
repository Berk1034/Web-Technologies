package com.company.controller.command;

import com.company.beans.UserProfile;
import com.company.service.ServiceFactory;
import com.company.controller.ICommand;

import java.util.Date;
import java.util.Scanner;

public class UserProfileUpdateCommand implements ICommand {
    @Override
    public boolean execute(String request) {
        if(ServiceFactory.getInstance().getUserProfileService().GetLoggedInUserProfile() != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter new name:");
            String name = scanner.nextLine();
            System.out.println("Enter new surname:");
            String surname = scanner.nextLine();
            System.out.println("Enter new age:");
            int age = scanner.nextInt();
            UserProfile updatedUserProfile = new UserProfile(name, surname, age, new Date());
            ServiceFactory.getInstance().getUserProfileService().UpdateUserProfile(updatedUserProfile);
        }
        else{
            System.out.println("Choose UserProfile first!");
        }
        return true;
    }
}
