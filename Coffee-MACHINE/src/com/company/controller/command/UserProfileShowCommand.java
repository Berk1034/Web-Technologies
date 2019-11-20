package com.company.controller.command;

import com.company.service.ServiceFactory;
import com.company.controller.ICommand;

public class UserProfileShowCommand implements ICommand {
    @Override
    public boolean execute(String request) {
        if(ServiceFactory.getInstance().getUserProfileService().GetLoggedInUserProfile() != null) {
            System.out.println("---------------------------------------------------");
            System.out.println("Account #" + ServiceFactory.getInstance().getUserProfileService().ReadUserProfile().indexOf(ServiceFactory.getInstance().getUserProfileService().GetLoggedInUserProfile()));
            System.out.println("Name: " + ServiceFactory.getInstance().getUserProfileService().GetLoggedInUserProfile().getName());
            System.out.println("Surname: " + ServiceFactory.getInstance().getUserProfileService().GetLoggedInUserProfile().getSurname());
            System.out.println("Age: " + ServiceFactory.getInstance().getUserProfileService().GetLoggedInUserProfile().getAge());
            System.out.println("CreationDate: " + ServiceFactory.getInstance().getUserProfileService().GetLoggedInUserProfile().getCreationDate());
//            System.out.println("Coffee Settings: " + ServiceFactory.getInstance().getUserProfileService().GetLoggedInUserProfile().getCoffeeSettings());
            System.out.println("---------------------------------------------------");
        }
        else{
            System.out.println("Choose UserProfile first!");
        }
        return true;
    }
}
