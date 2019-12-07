package com.company;

import com.company.beans.UserOrder;
import com.company.beans.UserProfile;
import org.apache.log4j.Logger;

import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class XMLMigrator {
    private String db_name;
    private Connection establishedConnection;

    private final String insertUserProfileQuery = "INSERT INTO userprofiles (Name, Surname, Age, CreationDate) values(?,?,?,?);";
    private final String insertUserOrderQuery = "INSERT INTO userorders (ID, CoffeeType, UserProfile, Date) values(?,?,?,?);";

    public XMLMigrator(String db_name, Connection connection){
        this.db_name = db_name;
        this.establishedConnection = connection;
    }

    public void MigrateXML(String directoryPath){
        Logger logger = Logger.getLogger(XMLMigrator.class);
        String[] innerDirectories = new File(directoryPath).list();
        XMLValidator xmlValidator = new XMLValidator();
        try{
            for(String dirPath : innerDirectories){
                File directory = new File(directoryPath + "\\" + dirPath);
                if(directory.isDirectory()) {

                    String xsdFilePath = getFilePath(directory.getPath(), "xsd");
                    if(xsdFilePath == null){
                        throw new NullPointerException();
                    }

                    String[] innerXMLFiles = new File(directory.getPath() + "\\xml\\").list();
                    for(String innerXMLFile : innerXMLFiles){
                        if(xmlValidator.ValidateXMLByXSD(new File(directory.getPath() + "\\xml\\" + innerXMLFile), new File(xsdFilePath))){
                            logger.info("Successful validated!");
                            migrate(directory.getPath() + "\\xml\\" + innerXMLFile);
                        }else{
                            System.out.println("XML is not VALID!");
                            logger.info("XML is not VALID!");
                        }
                    }
                }
            }
        }catch (NullPointerException e){
            System.out.println("Exception occured!");
            return;
        }
    }

    private String getFilePath(String path, String toCompare){
        String[] innerDirs = new File(path).list();
        String XSDDirectory = null;

        for(int i = 0; i < innerDirs.length; i++){
            if(innerDirs[i].compareTo(toCompare) == 0){
                XSDDirectory = innerDirs[i];
                break;
            }
        }
        if(XSDDirectory != null){
            String XSDName = new File(path + "\\" + XSDDirectory).list()[0];
            return path + "\\" + XSDDirectory + "\\" + XSDName;
        }
        return null;
    }

    public boolean migrate(String filePath){
        XMLDeserializer xmlDeserializer = new XMLDeserializer();
        Object deserializedObj = null;
        deserializedObj = xmlDeserializer.Deserialize(filePath);
        deserializedObj.getClass();
        if(deserializedObj instanceof UserProfile){
            return migrateUserProfile((UserProfile)deserializedObj);
        }else if(deserializedObj instanceof UserOrder){
            return migrateUserOrder((UserOrder)deserializedObj);
        }

        return  false;
    }

    private boolean migrateUserProfile(UserProfile userProfile) {
        PreparedStatement preparedStatement;
        try{
            preparedStatement = establishedConnection.prepareStatement(insertUserProfileQuery);
            preparedStatement.setString(1, userProfile.getName());
            preparedStatement.setString(2, userProfile.getSurname());
            preparedStatement.setInt(3, userProfile.getAge());
            preparedStatement.setDate(4, new java.sql.Date(userProfile.getCreationDate().getTime()));

            if(preparedStatement.executeUpdate() != 1){
                return false;
            }
        }catch (SQLException e){
            return false;
        }
        return true;
    }

    private boolean migrateUserOrder(UserOrder userOrder) {
        PreparedStatement preparedStatement;
        try{
            preparedStatement = establishedConnection.prepareStatement(insertUserOrderQuery);
            preparedStatement.setInt(1, userOrder.getID());
            preparedStatement.setString(2, userOrder.getCoffeeType().toString());
            preparedStatement.setString(3, userOrder.getUserProfile().toString());
            preparedStatement.setDate(4, new java.sql.Date(userOrder.getDate().getTime()));

            if(preparedStatement.executeUpdate() != 1){
                return false;
            }
        }catch (SQLException e){
            return false;
        }
        return true;

    }
}
