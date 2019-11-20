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
    public UserProfile GetLoggedInUserProfile() {
        return userProfileDAO.GetLoggedInUserProfile();
    }

    @Override
    public List<UserProfile> ReadUserProfile() {
        return userProfileDAO.ReadUserProfile();
    }
}
