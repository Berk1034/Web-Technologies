package com.company.service.impl;

import com.company.beans.UserProfile;
import com.company.dao.DAOFactory;
import com.company.dao.UserProfileDAO;
import com.company.service.UserProfileService;

import java.util.List;

public class UserProfileServiceImpl implements UserProfileService {
    DAOFactory daoFactory = DAOFactory.getInstance();
    UserProfileDAO userProfileDAO = daoFactory.getXMLUserProfileDao();

    @Override
    public void AddUserProfile(UserProfile userProfile) {
        userProfileDAO.AddUserProfile(userProfile);
    }

    @Override
    public void UpdateUserProfile(UserProfile userProfile) {
        userProfileDAO.UpdateUserProfile(userProfile);
    }

    @Override
    public void DeleteUserProfile(UserProfile userProfile) {
        userProfileDAO.DeleteUserProfile(userProfile);
    }

    @Override
    public void ChooseUserProfile(UserProfile userProfile) {
        userProfileDAO.ChooseUserProfile(userProfile);
    }

    @Override
    public void SortByName() {
        userProfileDAO.SortByName();
    }

    @Override
    public void SortByAge() {
        userProfileDAO.SortByAge();
    }

    @Override
    public void SortByCreationDate() {
        userProfileDAO.SortByCreationDate();
    }

    @Override
    public UserProfile GetLoggedInUserProfile() {
        return userProfileDAO.GetLoggedInUserProfile();
    }

    @Override
    public UserProfile SearchByName(String name) {
        return userProfileDAO.SearchByName(name);
    }

    @Override
    public UserProfile SearchBySurname(String surname) {
        return userProfileDAO.SearchBySurname(surname);
    }

    @Override
    public List<UserProfile> ReadUserProfile() {
        return userProfileDAO.ReadUserProfile();
    }
}
