package com.company;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.ArrayList;
import java.io.*;
import java.beans.XMLEncoder;
import java.beans.XMLDecoder;

public class ListOfUserProfiles {
    private ArrayList<UserProfile> ListOfUserProfiles;
    private UserProfile LoggedinUserProfile = null;

    public ListOfUserProfiles(){
        ListOfUserProfiles = new ArrayList<UserProfile>();
    }
    public void AddUserProfile(UserProfile userProfile){
        ListOfUserProfiles.add(userProfile);
    }
    public void RemoveUserProfile(UserProfile userProfile){
        ListOfUserProfiles.remove(userProfile);
    }
    public void SaveToFile(String path) throws IOException{
        File file = new File(path);
        file.createNewFile();
        XMLEncoder out = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(path)));
        out.writeObject(ListOfUserProfiles);
        out.flush();
        out.close();
    }
    public void LoadFromFile(String path) throws IOException{
        XMLDecoder in = new XMLDecoder(new BufferedInputStream(new FileInputStream(path)));
        ListOfUserProfiles = (ArrayList<UserProfile>) in.readObject();
        in.close();
    }
    public void ChooseUserProfile(UserProfile userProfile){
        LoggedinUserProfile = userProfile;
    }

    public ArrayList<UserProfile> getListOfUserProfiles() {
        return ListOfUserProfiles;
    }

    public UserProfile getLoggedinUserProfile() {
        return LoggedinUserProfile;
    }

}
