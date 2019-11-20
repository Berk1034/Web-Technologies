package com.company.controller.command;

import com.company.service.ServiceFactory;
import com.company.beans.UserProfile;
import com.company.controller.ICommand;

import java.util.List;
import java.util.Scanner;

public class UserProfileChooseCommand implements ICommand {
    @Override
    public boolean execute(String request) {
        List<UserProfile> ListOfUserProfiles = ServiceFactory.getInstance().getUserProfileService().ReadUserProfile();
        int count = ListOfUserProfiles.size();
        if(count != 0) {
            for (int i = 0; i < count; i++) {
                System.out.println("---------------------------------------------------");
                System.out.println("Account #" + i);
                System.out.println("Name: " + ListOfUserProfiles.get(i).getName());
                System.out.println("Surname: " + ListOfUserProfiles.get(i).getSurname());
                System.out.println("Age: " + ListOfUserProfiles.get(i).getAge());
                System.out.println("CreationDate: " + ListOfUserProfiles.get(i).getCreationDate());
//                System.out.println("Coffee Settings: " + ListOfUserProfiles.get(i).getCoffeeSettings());
                System.out.println("---------------------------------------------------");
            }
            System.out.println("Choose an account:");
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();
            try{
                ServiceFactory.getInstance().getUserProfileService().ChooseUserProfile(ListOfUserProfiles.get(number));
                System.out.println("You are successfully logged in!");
            }
            catch (Exception e){
                System.out.println("No such account!");
            }
        }else{
            System.out.println("Add/Load at least 1 UserProfile!");
        }
        return true;
    }
}
