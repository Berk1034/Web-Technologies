package com.company.dao.StAX;

import com.company.dao.AbstractUserProfilesBuilder;
import com.company.dao.UserProfileTag;
import com.company.model.UserProfile;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Date;

public class UserProfilesStAXBuilder extends AbstractUserProfilesBuilder {

    private XMLInputFactory xmlInputFactory;

    public UserProfilesStAXBuilder(){
        xmlInputFactory = XMLInputFactory.newInstance();
    }

    boolean bName = false;
    boolean bSurname = false;
    boolean bAge = false;
    boolean bCreationDate = false;

    @Override
    public void buildUserProfiles(String filename) {
        XMLEventReader xmlEventReader;
        UserProfile userProfile = null;
        try {
            xmlEventReader = xmlInputFactory.createXMLEventReader(new FileReader(filename));

            while (xmlEventReader.hasNext()) {

                XMLEvent xmlEvent = xmlEventReader.nextEvent();
                switch (xmlEvent.getEventType()) {

                    case XMLStreamConstants.START_ELEMENT:
                        StartElement startElement = xmlEvent.asStartElement();
                        String qName = startElement.getName().getLocalPart();
                        if (qName.equalsIgnoreCase(UserProfileTag.USERPROFILE.getValue())) {
                            userProfile = new UserProfile();
                        } else if (qName.equalsIgnoreCase(UserProfileTag.NAME.getValue())) {
                            bName = true;
                        } else if (qName.equalsIgnoreCase(UserProfileTag.SURNAME.getValue())) {
                            bSurname = true;
                        } else if (qName.equalsIgnoreCase(UserProfileTag.AGE.getValue())) {
                            bAge = true;
                        } else if (qName.equalsIgnoreCase(UserProfileTag.CREATIONDATE.getValue())) {
                            bCreationDate = true;
                        }
                        break;

                    case XMLStreamConstants.CHARACTERS:
                        Characters characters = xmlEvent.asCharacters();
                        if (bName) {
                            userProfile.setName(characters.getData());
                            bName = false;
                        }
                        if (bSurname) {
                            userProfile.setSurname(characters.getData());
                            bSurname = false;
                        }
                        if (bAge) {
                            userProfile.setAge(Integer.parseInt(characters.getData()));
                            bAge = false;
                        }
                        if (bCreationDate) {
                            userProfile.setCreationDate(new Date(new Long((characters.getData()))));
                            bCreationDate = false;
                        }
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        EndElement endElement = xmlEvent.asEndElement();
                        if (endElement.getName().getLocalPart().equals(UserProfileTag.USERPROFILE.getValue())) {
                            userProfiles.addUserProfile(userProfile);
                        }
                        break;
                }
            }
        } catch (NullPointerException e){
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
