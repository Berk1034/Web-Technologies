package com.company.dao.SAX;

import com.company.dao.UserProfileTag;
import com.company.model.UserProfile;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SAXParserHandler extends DefaultHandler {

    private List<UserProfile> userProfiles;
    private UserProfile currentUserProfile;
    private StringBuilder data;

    boolean bName = false;
    boolean bSurname = false;
    boolean bAge = false;
    boolean bCreationDate = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equalsIgnoreCase(UserProfileTag.USERPROFILE.getValue())) {
            currentUserProfile = new UserProfile();
            if (userProfiles == null)
                userProfiles = new ArrayList<>();
        } else if (qName.equalsIgnoreCase(UserProfileTag.NAME.getValue())) {
            bName = true;
        } else if (qName.equalsIgnoreCase(UserProfileTag.SURNAME.getValue())) {
            bSurname = true;
        } else if (qName.equalsIgnoreCase(UserProfileTag.AGE.getValue())) {
            bAge = true;
        } else if (qName.equalsIgnoreCase(UserProfileTag.CREATIONDATE.getValue())) {
            bCreationDate = true;
        }
        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
         if (bName) {
            currentUserProfile.setName(data.toString());
            bName = false;
        } else if (bSurname) {
            currentUserProfile.setSurname(data.toString());
            bSurname = false;
        } else if (bAge) {
            currentUserProfile.setAge(Integer.parseInt(data.toString()));
            bAge = false;
        } else if (bCreationDate) {
            currentUserProfile.setCreationDate(new Date(new Long(data.toString())));
            bCreationDate = false;
        }

        if (qName.equalsIgnoreCase(UserProfileTag.USERPROFILE.getValue())) {
            userProfiles.add(currentUserProfile);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        data.append(new String(ch, start, length));
    }

    public List<UserProfile> getUserProfiles() {
        return userProfiles;
    }
}