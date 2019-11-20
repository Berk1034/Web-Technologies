package com.company.dao;

import com.company.beans.UserProfile;

import java.util.List;

public interface UserProfileDAO {
    void AddUserProfile(UserProfile userProfile);
    void UpdateUserProfile(UserProfile userProfile);
    void DeleteUserProfile(UserProfile userProfile);
    void ChooseUserProfile(UserProfile userProfile);
    void SortByName();
    void SortByAge();
    void SortByCreationDate();
    UserProfile GetLoggedInUserProfile();
    UserProfile SearchByName(String name);
    UserProfile SearchBySurname(String surname);
    List<UserProfile> ReadUserProfile();
}
