package com.company.service;

import com.company.dao.AbstractUserProfilesBuilder;
import com.company.dao.UserProfilesBuilderFactory;
import com.company.model.UserProfiles;
import org.xml.sax.SAXException;

public class ParserService {

    public UserProfiles parseXML(String parserType, String fileXML) throws SAXException {
        AbstractUserProfilesBuilder builder = UserProfilesBuilderFactory.getInstance().createUserProfilesBuilder(parserType);
        builder.buildUserProfiles(fileXML);
        return builder.getUserProfiles();
    }
}
