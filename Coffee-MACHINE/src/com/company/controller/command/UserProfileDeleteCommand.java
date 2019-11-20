package com.company.controller.command;

import com.company.service.ServiceFactory;
import com.company.controller.ICommand;

public class UserProfileDeleteCommand implements ICommand {
    @Override
    public boolean execute(String request) {
        if(ServiceFactory.getInstance().getUserProfileService().GetLoggedInUserProfile() != null){
            ServiceFactory.getInstance().getUserProfileService().DeleteUserProfile(ServiceFactory.getInstance().getUserProfileService().GetLoggedInUserProfile());
            System.out.println("Successfully removed!");
        }
        else{
            System.out.println("Choose UserProfile first!");
        }
        return true;
    }
}
