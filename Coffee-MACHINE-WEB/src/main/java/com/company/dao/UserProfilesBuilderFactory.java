package com.company.dao;

import org.xml.sax.SAXException;

public class UserProfilesBuilderFactory {
    private static UserProfilesBuilderFactory instance;

    private enum ParserType{
        SAX, STAX, DOM
    }

    private UserProfilesBuilderFactory(){}

    public static UserProfilesBuilderFactory getInstance() {
        if(instance == null){
            synchronized (UserProfilesBuilderFactory.class){
                if(instance == null){
                    instance = new UserProfilesBuilderFactory();
                }
            }
        }
        return instance;
    }

    public AbstractUserProfilesBuilder createUserProfilesBuilder(String parserType) throws SAXException {
        ParserType type = ParserType.valueOf(parserType.toUpperCase());
        switch (type){
            case SAX:
            case STAX:
            case DOM:
                return new UserProfilesDOMBuilder();
            default:
                return null;
        }
    }
}
