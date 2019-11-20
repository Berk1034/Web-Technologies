package com.company.dao.userprofile;

import com.company.beans.UserProfile;

import java.util.Comparator;

public class UserProfileCreationDateComparator implements Comparator<UserProfile> {
    @Override
    public int compare(UserProfile userProfile1, UserProfile userProfile2) {
        return userProfile1.getCreationDate().compareTo(userProfile2.getCreationDate());
    }
}
