package com.company.dao.userprofile;

import com.company.beans.UserProfile;

import java.util.Comparator;

public class UserProfileNameComparator implements Comparator<UserProfile> {
    @Override
    public int compare(UserProfile userProfile1, UserProfile userProfile2) {
        return userProfile1.getName().compareTo(userProfile2.getName());
    }
}
