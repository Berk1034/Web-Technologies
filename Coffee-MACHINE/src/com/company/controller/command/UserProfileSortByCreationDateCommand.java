package com.company.controller.command;

import com.company.beans.UserProfile;
import com.company.controller.ICommand;
import com.company.service.ServiceFactory;

import java.util.List;

public class UserProfileSortByCreationDateCommand implements ICommand {
    @Override
    public boolean execute(String request) {
        ServiceFactory.getInstance().getUserProfileService().SortByCreationDate();
        List<UserProfile> ListOfUserProfiles = ServiceFactory.getInstance().getUserProfileService().ReadUserProfile();
        int count = ListOfUserProfiles.size();
        if(count != 0) {
            for (int i = 0; i < count; i++) {
                System.out.println("---------------------------------------------------");
                System.out.println("Account #" + i);
                System.out.println(ListOfUserProfiles.get(i).toString());
                System.out.println("---------------------------------------------------");
            }
        }
        System.out.println("Sorted by Age");
        return true;
    }
}
