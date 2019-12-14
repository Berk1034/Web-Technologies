package com.company.dao;

import com.company.model.UserProfile;
import com.company.model.UserProfiles;

public abstract class AbstractUserProfilesBuilder {
    protected UserProfiles userProfiles;

    public AbstractUserProfilesBuilder(){
        userProfiles = new UserProfiles();
    }

    public UserProfiles getUserProfiles(){
        return userProfiles;
    }

    public abstract void buildUserProfiles(String filename);
}
