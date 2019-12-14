package com.company.model;

import java.util.ArrayList;
import java.util.List;

public class UserProfiles {
    private List<UserProfile> userProfiles;

    public UserProfiles(){
        userProfiles = new ArrayList<UserProfile>();
    }


    public List<UserProfile> getUserProfiles() {
        return userProfiles;
    }

    public void setUserProfiles(List<UserProfile> userProfiles) {
        this.userProfiles = userProfiles;
    }

    public void addUserProfile(UserProfile userProfile){
        userProfiles.add(userProfile);
    }

    @Override
    public String toString(){
        final StringBuilder userProfilesToStr = new StringBuilder();
        userProfiles.forEach(userProfile -> userProfilesToStr.append(userProfile).append("\n"));
        return "UserProfiles{\n" + userProfilesToStr + "}";
    }
}
