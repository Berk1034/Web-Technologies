package com.company.controller.command;

import com.company.service.ServiceFactory;
import com.company.controller.ICommand;

public class UserProfileShowCommand implements ICommand {
    @Override
    public boolean execute(String request) {
        if(ServiceFactory.getInstance().getUserProfileService().GetLoggedInUserProfile() != null) {
            System.out.println("---------------------------------------------------");
            System.out.println("Account #" + ServiceFactory.getInstance().getUserProfileService().ReadUserProfile().indexOf(ServiceFactory.getInstance().getUserProfileService().GetLoggedInUserProfile()));
            System.out.println(ServiceFactory.getInstance().getUserProfileService().GetLoggedInUserProfile().toString());
            System.out.println("---------------------------------------------------");
        }
        else{
            System.out.println("Choose UserProfile first!");
        }
        return true;
    }
}
