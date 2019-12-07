package com.company.dao.impl;

import com.company.beans.UserProfile;
import com.company.dao.UserProfileDAO;
import com.company.dao.comparator.userprofile.UserProfileAgeComparator;
import com.company.dao.comparator.userprofile.UserProfileCreationDateComparator;
import com.company.dao.comparator.userprofile.UserProfileNameComparator;
import com.company.service.XSDValidator;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XMLUserProfileDAO implements UserProfileDAO {

    private static String filepath = "UserProfiles.xml";
    private List<UserProfile> userProfileList;
    private UserProfile LoggedinUserProfile;

    public  XMLUserProfileDAO(){
        userProfileList = new ArrayList<UserProfile>();
        if(new File(filepath).exists()){
            try{
                if(new XSDValidator().ValidateXMLByXSD(new File(filepath), new File("UserProfiles.xsd"))){
                    LoadUserProfilesFromFile();
                }
                else{
                    System.out.println("Error Loading User Profiles");
                }
            }
            catch (Exception e){
                System.out.println("Error Loading User Profiles");
            }
        }
    }

    private void LoadUserProfilesFromFile(){
        try{
            XMLDecoder in = new XMLDecoder(new BufferedInputStream(new FileInputStream(filepath)));
            userProfileList = (ArrayList<UserProfile>)in.readObject();
        }
        catch (IOException e) {

        }
    }

    private void SaveUserProfilesToFile(){
        try{
            File file = new File(filepath);
            if(!file.exists()){
                if(!file.createNewFile())
                    throw new IOException();
            }
            XMLEncoder out = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filepath)));
            out.writeObject(userProfileList);
            out.flush();
            out.close();
        }
        catch(IOException e){

        }
    }

    @Override
    public void AddUserProfile(UserProfile userProfile) {
        userProfileList.add(userProfile);
        SaveUserProfilesToFile();
    }

    @Override
    public void UpdateUserProfile(UserProfile userProfile) {
        userProfileList.set(userProfileList.indexOf(LoggedinUserProfile), userProfile);
        ChooseUserProfile(userProfile);
        SaveUserProfilesToFile();
    }

    @Override
    public void DeleteUserProfile(UserProfile userProfile) {
        userProfileList.remove(userProfile);
        ChooseUserProfile(null);
        SaveUserProfilesToFile();
    }

    @Override
    public void ChooseUserProfile(UserProfile userProfile) {
        LoggedinUserProfile = userProfile;
    }

    @Override
    public void SortByName() {
        userProfileList.sort(new UserProfileNameComparator());
    }

    @Override
    public void SortByAge() {
        userProfileList.sort(new UserProfileAgeComparator());
    }

    @Override
    public void SortByCreationDate() {
        userProfileList.sort(new UserProfileCreationDateComparator());
    }

    @Override
    public UserProfile GetLoggedInUserProfile() {
        return LoggedinUserProfile;
    }

    @Override
    public UserProfile SearchByName(String name) {
        for(UserProfile userProfile: userProfileList){
            if(userProfile.getName().equals(name)){
                return userProfile;
            }
        }
        return null;
    }

    @Override
    public UserProfile SearchBySurname(String surname) {
        for(UserProfile userProfile: userProfileList){
            if(userProfile.getSurname().equals(surname)){
                return userProfile;
            }
        }
        return null;
    }

    @Override
    public List<UserProfile> ReadUserProfile() {
        return userProfileList;
    }
}
