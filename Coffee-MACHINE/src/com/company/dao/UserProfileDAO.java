package com.company.dao;

import com.company.beans.UserProfile;

import java.util.List;

public interface UserProfileDAO {
    void AddUserProfile(UserProfile userProfile);
    void UpdateUserProfile(UserProfile userProfile);
    void DeleteUserProfile(UserProfile userProfile);
    void ChooseUserProfile(UserProfile userProfile);
    UserProfile GetLoggedInUserProfile();
    List<UserProfile> ReadUserProfile();
}
