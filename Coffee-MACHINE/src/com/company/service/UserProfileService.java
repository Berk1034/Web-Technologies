package com.company.service;

import com.company.beans.UserProfile;

import java.util.List;

public interface UserProfileService {
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
