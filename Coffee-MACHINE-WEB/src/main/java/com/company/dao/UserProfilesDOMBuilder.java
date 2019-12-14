package com.company.dao;

import com.company.model.UserProfile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserProfilesDOMBuilder extends AbstractUserProfilesBuilder {

    private String XSDSchema = "data/UserProfiles.xsd";
    private DocumentBuilder documentBuilder;

    public UserProfilesDOMBuilder() throws SAXException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setSchema(SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI).newSchema(new File(XSDSchema)));
        documentBuilderFactory.setNamespaceAware(true);
        documentBuilderFactory.setValidating(false);
        try{
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void buildUserProfiles(String filename){
        Document document;
        try{
            document = documentBuilder.parse(filename);
            Element root = document.getDocumentElement();
            NodeList userprofiles = root.getElementsByTagName(UserProfileTag.USERPROFILE.getValue());
            for(int i = 0; i < userprofiles.getLength(); i++){
                Element userProfileElement = (Element)userprofiles.item(i);
                UserProfile userProfile = buildUserProfile(userProfileElement);
                userProfiles.addUserProfile(userProfile);
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public UserProfile buildUserProfile(Element element){
        UserProfile userProfile = new UserProfile();
        userProfile.setName(getElementTextContext(element, UserProfileTag.NAME));
        userProfile.setSurname(getElementTextContext(element, UserProfileTag.SURNAME));
        userProfile.setAge(new Integer(getElementTextContext(element, UserProfileTag.AGE)));
        userProfile.setCreationDate(new Date(new Long(getElementTextContext(element, UserProfileTag.CREATIONDATE))));
        return userProfile;
    }

    private String getElementTextContext(Element element, UserProfileTag tag){
        NodeList nodeList = element.getElementsByTagName(tag.getValue());
        Node node = nodeList.item(0);
        return node.getTextContent();
    }
}
