package com.company.controller.command;

import com.company.beans.UserProfile;
import com.company.controller.ICommand;
import com.company.service.ServiceFactory;

import java.util.Scanner;

public class UserProfileSearchBySurnameCommand implements ICommand {
    @Override
    public boolean execute(String request) {
        System.out.println("Enter surname that you want to find:");
        Scanner scanner = new Scanner(System.in);
        String surname = scanner.nextLine();
        UserProfile userProfile = ServiceFactory.getInstance().getUserProfileService().SearchBySurname(surname);
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
