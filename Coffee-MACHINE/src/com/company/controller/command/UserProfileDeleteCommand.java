package com.company.controller.command;

import com.company.service.ServiceFactory;
import com.company.beans.UserProfile;
import com.company.controller.ICommand;

import java.util.List;

public class UserProfileDeleteCommand implements ICommand {
    @Override
    public boolean execute(String request) {
//        List<UserProfile> ListOfUserProfiles = ServiceFactory.getInstance().getUserProfileService().ReadUserProfile();
        if(ServiceFactory.getInstance().getUserProfileService().GetLoggedInUserProfile() != null){
            ServiceFactory.getInstance().getUserProfileService().DeleteUserProfile(ServiceFactory.getInstance().getUserProfileService().GetLoggedInUserProfile());
            /*
            ListOfUserProfiles.remove(ServiceFactory.getInstance().getUserProfileService().GetLoggedInUserProfile());
            ServiceFactory.getInstance().getUserProfileService().ChooseUserProfile(null);
            */
            System.out.println("Successfully removed!");
        }
        else{
            System.out.println("Choose UserProfile first!");
        }
        return true;
    }
}
