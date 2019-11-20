package com.company.dao.impl;

import com.company.beans.UserProfile;
import com.company.dao.UserProfileDAO;
import sun.rmi.runtime.Log;

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
                LoadUserProfilesFromFile();
            }
            catch (Exception e){

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
    public UserProfile GetLoggedInUserProfile() {
        return LoggedinUserProfile;
    }

    @Override
    public List<UserProfile> ReadUserProfile() {
        return userProfileList;
    }
 /*
    public UserProfile getLoggedinUserProfile() {
        return LoggedinUserProfile;
    }

 */
}
