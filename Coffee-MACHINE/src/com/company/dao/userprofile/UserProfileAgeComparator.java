package com.company.dao.userprofile;

import com.company.beans.UserProfile;

import java.util.Comparator;

public class UserProfileAgeComparator implements Comparator<UserProfile> {
    @Override
    public int compare(UserProfile userProfile1, UserProfile userProfile2) {
        return userProfile1.getAge() - userProfile2.getAge();
    }
}
