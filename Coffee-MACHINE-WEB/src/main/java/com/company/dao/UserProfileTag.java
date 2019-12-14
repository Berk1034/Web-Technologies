package com.company.dao;

public enum UserProfileTag {
    USERPROFILES("UserProfiles"),
    USERPROFILE("UserProfile"),
    NAME("Name"),
    SURNAME("Surname"),
    AGE("Age"),
    CREATIONDATE("CreationDate");
    private final String value;

    UserProfileTag(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static UserProfileTag fromValue(String value){
        for(UserProfileTag type : UserProfileTag.values()){
            if(type.value.equals(value)){
                return type;
            }
        }
        return null;
    }
}
